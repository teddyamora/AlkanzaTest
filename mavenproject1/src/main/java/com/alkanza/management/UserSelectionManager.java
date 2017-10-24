/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.management;

import com.alkanza.entities.UserSelectionHistory;
import com.alkanza.facade.UserSelectionHistoryFacade;
import com.alkanza.utils.ServiceResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Teddy
 */
@Stateless
@LocalBean
public class UserSelectionManager {

    @EJB
    UserSelectionHistoryFacade userHistoryFacade;

    public List<UserSelectionHistory> findByUserId(String userId) throws Exception {
        List<UserSelectionHistory> find = new ArrayList();
        try {
            find = userHistoryFacade.findByUserId(userId);
        } catch (Exception e) {
            throw e;
        }
        return find;
    }

    public ServiceResponse save(UserSelectionHistory history) throws Exception {
        ServiceResponse result = new ServiceResponse();
        try {
            if (history.getHistoryDate() == null) {
                history.setHistoryDate(new Date());
            }
            userHistoryFacade.create(history);
            return result;
        } catch (Exception e) {
            result.setCode(ServiceResponse.ERROR);
            result.setMessage(e.getMessage());
            throw e;
        }
    }

}
