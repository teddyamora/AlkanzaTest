/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.rest.server;

import com.alkanza.entities.UserProfile;
import com.alkanza.management.ProfileManager;
import com.alkanza.utils.ServiceResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Teddy
 */
@Stateless
@Path(value = "/AppProfiles")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class ProfileService {

    @EJB
    ProfileManager manager;

    @GET
    @Path("/findAll")
    public List<UserProfile> findAll() {
        ServiceResponse response = new ServiceResponse();
        List<UserProfile> find = new ArrayList();
        try {
            find = manager.findAll();
        } catch (Exception e) {
            find = new ArrayList();
            return find;
        }
        return find;
    }

}
