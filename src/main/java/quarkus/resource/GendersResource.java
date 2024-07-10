/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import quarkus.model.Gender;
import quarkus.service.GenderService;

/**
 *
 * @author pc
 */
@Path("/genders")
public class GendersResource {
    
    @Inject
    GenderService genderService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGenders(){
        List<Gender> genders = genderService.listAll();
        return Response.ok(genders).build();
    }
}
