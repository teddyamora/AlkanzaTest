/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Teddy
 */
@Entity
@Table(name = "USER_SELECTION_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserSelectionHistory.findAll", query = "SELECT u FROM UserSelectionHistory u"),
    @NamedQuery(name = "UserSelectionHistory.findByUserId", query = "SELECT u FROM UserSelectionHistory u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserSelectionHistory.findBySelection", query = "SELECT u FROM UserSelectionHistory u WHERE u.selection = :selection"),
    @NamedQuery(name = "UserSelectionHistory.findByHistoryDate", query = "SELECT u FROM UserSelectionHistory u WHERE u.historyDate = :historyDate")})
public class UserSelectionHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "SELECTION")
    private String selection;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HISTORY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date historyDate;

    public UserSelectionHistory() {
    }

    public UserSelectionHistory(Date historyDate) {
        this.historyDate = historyDate;
    }

    public UserSelectionHistory(Date historyDate, String userId, String selection) {
        this.historyDate = historyDate;
        this.userId = userId;
        this.selection = selection;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public Date getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(Date historyDate) {
        this.historyDate = historyDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historyDate != null ? historyDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSelectionHistory)) {
            return false;
        }
        UserSelectionHistory other = (UserSelectionHistory) object;
        if ((this.historyDate == null && other.historyDate != null) || (this.historyDate != null && !this.historyDate.equals(other.historyDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.alkanza.entities.UserSelectionHistory[ historyDate=" + historyDate + " ]";
    }
    
}
