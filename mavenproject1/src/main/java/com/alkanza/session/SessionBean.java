/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.session;

import com.alkanza.entities.AppUsers;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Teddy
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private AppUsers sessionUser;

    public SessionBean() {
    }

    public AppUsers getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(AppUsers sessionUser) {
        this.sessionUser = sessionUser;
    }

}
