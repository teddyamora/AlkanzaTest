/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.rest.server;

import com.alkanza.entities.AppUsers;
import com.alkanza.management.UsersManager;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Teddy
 */
@Stateless
@Path(value = "/AppUsers")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class AppUsersService {

    @EJB
    UsersManager manager;

    @GET
    @Path("/findAll")
    public List<AppUsers> findAll() {
        List<AppUsers> find = new ArrayList();
        try {
            find = manager.findAll();

        } catch (Exception e) {
            find = new ArrayList();
            return find;
        }
        return find;
    }

    @GET
    @Path("/find/{userId}")
    public AppUsers find(@PathParam("userId") String userId) {
        AppUsers user = new AppUsers();
        try {
            user = manager.findById(userId);

        } catch (Exception e) {
            user = new AppUsers();

        }
        return user;
    }

}
