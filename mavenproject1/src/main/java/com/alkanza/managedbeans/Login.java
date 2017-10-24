/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.managedbeans;

import com.alkanza.entities.AppUsers;
import com.alkanza.rest.client.RestClient;
import com.alkanza.session.SessionBean;
import com.alkanza.utils.AppUtils;
import com.alkanza.utils.NavigationRules;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "Login")
@ViewScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    private String password;
    private String user;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Login(String password, String user) {
        this.password = password;
        this.user = user;
    }

    public Login() {

    }

    @PostConstruct
    public void init() {
        this.password = "";
        this.user = "";

    }

    public String logInButtonAction() {
        RestClient restClient = new RestClient();
        AppUsers appUser = new AppUsers();
        try {
            appUser = restClient.executeUsersGetMethodById(this.user);
            if (appUser == null) {
                AppUtils.setGrowlInfo(FacesMessage.SEVERITY_WARN, "Usuario no existente.", this.user);
            } else if (appUser.getPassword().equals(this.password)) {
                this.sessionBean.setSessionUser(appUser);
                switch (appUser.getProfileId().getProfileId()) {
                    case "ADMIN":
                        return (NavigationRules.ADMIN);
                    case "USER":
                        return (NavigationRules.SELECTION);
                    default:

                }
            } else {
                AppUtils.setGrowlInfo(FacesMessage.SEVERITY_WARN, "Datos de usuario errados.", "Por favor verifique la información.");
                return NavigationRules.LOGIN;

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
            return NavigationRules.LOGIN;
        }
        return NavigationRules.LOGIN;

    }

    //logout event, invalidate session
    public String logout() {
        AppUtils.setGrowlInfo(FacesMessage.SEVERITY_INFO, this.sessionBean.getSessionUser().getUserId(), "Ha cerrado sesión.");
        this.sessionBean.setSessionUser(null);
        this.password = "";
        this.user = "";
        ((HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false)).invalidate();

        return NavigationRules.LOGIN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
