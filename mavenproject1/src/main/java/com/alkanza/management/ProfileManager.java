/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.management;

import com.alkanza.entities.UserProfile;
import com.alkanza.facade.UserProfileFacade;
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
public class ProfileManager {

    @EJB
    UserProfileFacade profileFacade;

    public List<UserProfile> findAll() throws Exception {
        List<UserProfile> findAll = new ArrayList();
        try {
            findAll = profileFacade.findAll();
        } catch (Exception e) {
            throw e;
        }
        return findAll;
    }

    public UserProfile findById(String profileId) throws Exception {
        UserProfile find = new UserProfile();
        try {
            find = profileFacade.find(profileId);
        } catch (Exception e) {
            throw e;
        }
        return find;
    }

}
