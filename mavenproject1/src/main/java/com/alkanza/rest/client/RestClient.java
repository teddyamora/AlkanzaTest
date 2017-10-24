/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alkanza.rest.client;

import com.alkanza.entities.AppUsers;
import com.alkanza.entities.Image;
import com.alkanza.entities.UserProfile;
import com.alkanza.entities.UserSelectionHistory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

/**
 *
 * @author Teddy
 */
public class RestClient {

    ClientConfig config;
    Client client;
    WebResource webResource;

    public RestClient() {

        config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        client = Client.create(config);
    }

    public List<UserSelectionHistory> executeHistoryGetMethodByUserId(String userId) throws RuntimeException, Exception {
        List<UserSelectionHistory> output = new ArrayList();
        try {
            webResource = client.resource("http://localhost:8080/ALKANZA_APP/usersData/History/find/userId/" + userId);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            output = response.getEntity(new GenericType<List<UserSelectionHistory>>() {
            });

        } catch (Exception e) {
            throw e;
        }
        return output;
    }

    public String executeHistoryPostMethod(UserSelectionHistory userSelectionHistory) throws RuntimeException, Exception {
        String response = "";
        try {
            webResource = client.resource("http://localhost:8080/ALKANZA_APP/usersData/History/");
//            ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
//            String json = objectWriter.writeValueAsString(userSelectionHistory);
            ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, userSelectionHistory);
            if (clientResponse.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + clientResponse.getStatus());
            }

            response = clientResponse.getEntity(String.class);
        } catch (Exception e) {
            throw e;
        }
        return response;
    }

    public List<UserProfile> executeProfileGetMethod() throws RuntimeException, Exception {
        List<UserProfile> output = new ArrayList();
        try {
            webResource = client.resource("http://localhost:8080/ALKANZA_APP/usersData/AppProfiles/findAll/");
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            output = response.getEntity(new GenericType<List<UserProfile>>() {
            });

        } catch (Exception e) {
            throw e;
        }
        return output;
    }

    public AppUsers executeUsersGetMethodById(String userId) {
        AppUsers output = new AppUsers();
        try {
            webResource = client.resource("http://localhost:8080/ALKANZA_APP/usersData/AppUsers/find/" + userId);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                return null;
            }
            output = response.getEntity(new GenericType<AppUsers>() {
            });

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
            return null;
        }
        return output;
    }

    public List<AppUsers> executeAllUsersGetMethod() {
        List<AppUsers> usersList = new ArrayList();
        try {
            webResource = client.resource("http://localhost:8080/ALKANZA_APP/usersData/AppUsers/findAll/");
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                return null;
            }
            usersList = response.getEntity(new GenericType<List<AppUsers>>() {
            });

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
            return null;
        }
        return (usersList);
    }

    public Image executeGetMethodForRandomImg() {
        Image image = new Image();
        try {
            webResource = client.resource("http://www.splashbase.co/api/v1/images/random");
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            image = response.getEntity(new GenericType<Image>() {
            });

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e);
            return (null);
        }
        return (image);
    }

}
