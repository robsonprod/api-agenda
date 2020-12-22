package br.com.mobitbrasil.interview.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("/app")
@Produces({APPLICATION_XML, APPLICATION_JSON})
public class AppService {

    @GET
    @Path("/version")
    @Produces(APPLICATION_JSON)
    public Response status() {
        return Response.ok("{version: \"1.0-SNAPSHOT\", name: \"Rest API - V1\"}").build();
    }
}
