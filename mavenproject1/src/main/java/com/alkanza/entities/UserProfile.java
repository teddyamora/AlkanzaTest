/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Teddy
 */
@Entity
@Table(name = "USER_PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u"),
    @NamedQuery(name = "UserProfile.findByProfileId", query = "SELECT u FROM UserProfile u WHERE u.profileId = :profileId"),
    @NamedQuery(name = "UserProfile.findByDescription", query = "SELECT u FROM UserProfile u WHERE u.description = :description")})
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PROFILE_ID")
    private String profileId;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileId")
    private Collection<AppUsers> appUsersCollection;

    public UserProfile() {
    }

    public UserProfile(String profileId) {
        this.profileId = profileId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AppUsers> getAppUsersCollection() {
        return appUsersCollection;
    }

    public void setAppUsersCollection(Collection<AppUsers> appUsersCollection) {
        this.appUsersCollection = appUsersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileId != null ? profileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alkanza.entities.UserProfile[ profileId=" + profileId + " ]";
    }
    
}
