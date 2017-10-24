/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.facade;

import com.alkanza.entities.UserSelectionHistory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

/**
 *
 * @author Teddy
 */
@Stateless
@LocalBean
public class UserSelectionHistoryFacade extends AbstractFacade<UserSelectionHistory> {

    @PersistenceContext(unitName = "ALKANZA_APP", type = PersistenceContextType.TRANSACTION)

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public List<UserSelectionHistory> findByUserId(String userId) throws Exception {
        List<UserSelectionHistory> results = new ArrayList();
        try {
            Query query = entityManager.createNamedQuery("UserSelectionHistory.findByUserId");
            query.setParameter("userId", userId);
            results = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return results;
    }

    public UserSelectionHistoryFacade() {
        super(UserSelectionHistory.class);
    }

}
