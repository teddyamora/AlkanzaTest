/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.managedbeans;

import com.alkanza.entities.AppUsers;
import com.alkanza.entities.UserSelectionHistory;
import com.alkanza.rest.client.RestClient;
import com.alkanza.session.SessionBean;
import com.alkanza.utils.AppUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Teddy
 */
@ManagedBean(name = "admin")
@ViewScoped
public class Admin implements Serializable {

    private List users = new ArrayList();
    private String selectedUser;
    List<UserSelectionHistory> selectionByUser;
    List<AppUsers> appUsers;

    private final RestClient restClient = new RestClient();
    private static final String EMPTY_SELECTION = "Seleccione...";

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    public Admin() {
        this.selectionByUser = new ArrayList();
        this.appUsers = new ArrayList();
    }

    @PostConstruct
    public void initMethod() {

        try {
            AppUtils.setGrowlInfo(FacesMessage.SEVERITY_INFO, "Bienvenido.", this.sessionBean.getSessionUser().getUserId());
            appUsers = new ArrayList();
            appUsers.add(new AppUsers(EMPTY_SELECTION));
            appUsers.addAll(restClient.executeAllUsersGetMethod());
            for (AppUsers appUser : appUsers) {
//                this.users.add(appUser.getUserId());
                if (appUser.getProfileId().getProfileId().equals("ADMIN")) {
                    this.users.add(appUser.getUserId());
                }
            }
            if (this.users.size() > 0) {
                this.appUsers.clear();
                this.appUsers.addAll(this.users);

            }
            //Prueba con dataTable
            this.selectionByUser = this.restClient.executeHistoryGetMethodByUserId(this.selectedUser);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
        }
    }

    public void listChangeListener() {
        try {
            if (!this.selectedUser.equals(EMPTY_SELECTION) && !this.selectedUser.isEmpty()) {
                this.selectionByUser = this.restClient.executeHistoryGetMethodByUserId(this.selectedUser);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
        }
    }


    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    public String getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<UserSelectionHistory> getSelectionByUser() {
        return selectionByUser;
    }

    public void setSelectionByUser(List<UserSelectionHistory> selectionByUser) {
        this.selectionByUser = selectionByUser;
    }

    public List<AppUsers> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUsers> appUsers) {
        this.appUsers = appUsers;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

}
