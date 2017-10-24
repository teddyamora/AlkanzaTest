/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.facade;

import com.alkanza.entities.UserProfile;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author Teddy
 */
@Stateless
@LocalBean
public class UserProfileFacade extends AbstractFacade<UserProfile> {

    @PersistenceContext(unitName = "ALKANZA_APP", type = PersistenceContextType.TRANSACTION)

    private EntityManager entityManager;

    public UserProfileFacade() {
        super(UserProfile.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        try {
            return entityManager;

        } catch (Exception e) {
            throw e;
        }

    }

}
