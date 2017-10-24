/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.management;

import com.alkanza.entities.AppUsers;
import com.alkanza.facade.AppUsersFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class UsersManager {

    @EJB
    AppUsersFacade appUsersFacade;

    public List<AppUsers> findAll() throws Exception {
        List<AppUsers> findAll = new ArrayList();
        try {
            findAll = appUsersFacade.findAll();
        } catch (Exception e) {
            throw e;
        }
        return findAll;
    }

    public AppUsers findById(String userId) throws Exception {
        AppUsers find = new AppUsers();
        try {
            find = appUsersFacade.find(userId);
        } catch (Exception e) {
            throw e;
        }
        return find;
    }

}
