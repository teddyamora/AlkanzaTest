/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.facade;

import com.alkanza.entities.AppUsers;
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
public class AppUsersFacade extends AbstractFacade<AppUsers> {

    @PersistenceContext(unitName = "ALKANZA_APP", type = PersistenceContextType.TRANSACTION)

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public AppUsersFacade() {
        super(AppUsers.class);
    }

}
