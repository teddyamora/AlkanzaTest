/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.managedbeans;

import com.alkanza.entities.Image;
import com.alkanza.entities.UserSelectionHistory;
import com.alkanza.rest.client.RestClient;
import com.alkanza.session.SessionBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Teddy
 */
@ManagedBean(name = "selection")
@ViewScoped
public class Selection implements Serializable {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private RestClient restClient;
    private String firstImageURL;
    private String secondImageURL;

    public Selection() {
        restClient = new RestClient();

    }

    @PostConstruct
    public void init() {
        this.loadImages();

    }

    public void firstEventOption() {
        UserSelectionHistory selection = new UserSelectionHistory();
        try {
            selection.setUserId(this.sessionBean.getSessionUser().getUserId());
            selection.setSelection(this.firstImageURL);
            this.restClient.executeHistoryPostMethod(selection);
            this.loadImages();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
        }

    }

    public void secondEventOption() {
        UserSelectionHistory selection = new UserSelectionHistory();
        try {
            selection.setUserId(this.sessionBean.getSessionUser().getUserId());
            selection.setSelection(this.secondImageURL);
            this.restClient.executeHistoryPostMethod(selection);
            this.loadImages();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
        }

    }

    public void loadImages() {
        this.firstImageURL = this.generateURL();
        this.secondImageURL = this.generateURL();
    }

    public String generateURL() {
        String imageURL = "";
        Image image = new Image();
        try {
            image = restClient.executeGetMethodForRandomImg();
            if (image != null) {
                imageURL = image.getLarge_url();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
            return null;
        }
        return (imageURL);
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String getFirstImageURL() {
        return firstImageURL;
    }

    public void setFirstImageURL(String firstImageURL) {
        this.firstImageURL = firstImageURL;
    }

    public String getSecondImageURL() {
        return secondImageURL;
    }

    public void setSecondImageURL(String secondImageURL) {
        this.secondImageURL = secondImageURL;
    }

}
