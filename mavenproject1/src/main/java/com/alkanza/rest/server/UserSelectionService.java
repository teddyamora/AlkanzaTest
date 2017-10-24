/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.rest.server;

import com.alkanza.entities.UserSelectionHistory;
import com.alkanza.management.UserSelectionManager;
import com.alkanza.utils.ServiceResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Teddy
 */
@Stateless
@Path(value = "/History")
@Consumes(value = {"application/json"})
@Produces(value = {"application/json"})
public class UserSelectionService {

    @EJB
    UserSelectionManager manager;

    @GET
    @Path("/find/userId/{userId}")
    public List<UserSelectionHistory> findByType(@PathParam("userId") String userId) {
        ServiceResponse response = new ServiceResponse();
        List<UserSelectionHistory> history = new ArrayList();
        try {
            history = manager.findByUserId(userId);
        } catch (Exception e) {
            return new ArrayList();
        }
        return history;
    }

    @POST
    @Path("/")
    public ServiceResponse insert(UserSelectionHistory history) {
        ServiceResponse result = new ServiceResponse();
        try {
            if (history == null) {
                result.setCode(ServiceResponse.MISSING_INFO);
                result.setMessage("Missing Data. error Inserting");
            } else {
                result = manager.save(history);
            }

        } catch (Exception e) {
            result = new ServiceResponse(ServiceResponse.ERROR, e.getMessage());
            return result;
        }
        return result;
    }

}
