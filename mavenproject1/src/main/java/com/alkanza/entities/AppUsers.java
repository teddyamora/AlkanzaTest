/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teddy
 */
@Entity
@Table(name = "APP_USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUsers.findAll", query = "SELECT a FROM AppUsers a"),
    @NamedQuery(name = "AppUsers.findByUserId", query = "SELECT a FROM AppUsers a WHERE a.userId = :userId"),
    @NamedQuery(name = "AppUsers.findByDescription", query = "SELECT a FROM AppUsers a WHERE a.description = :description"),
    @NamedQuery(name = "AppUsers.findByPassword", query = "SELECT a FROM AppUsers a WHERE a.password = :password") })
public class AppUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_ID")
    private String userId;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "PROFILE_ID")
    @ManyToOne(optional = false)
    private UserProfile profileId;

    public AppUsers() {
    }

    public AppUsers(String userId) {
        this.userId = userId;
    }

    public AppUsers(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getProfileId() {
        return profileId;
    }

    public void setProfileId(UserProfile profileId) {
        this.profileId = profileId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUsers)) {
            return false;
        }
        AppUsers other = (AppUsers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alkanza.entities.AppUsers[ userId=" + userId + " ]";
    }
    
}
