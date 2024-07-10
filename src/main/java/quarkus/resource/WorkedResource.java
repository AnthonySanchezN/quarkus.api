/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import quarkus.model.Worked;
import quarkus.service.WorkedService;

/**
 *
 * @author pc
 */

@Path("/worked")
@Produces(MediaType.APPLICATION_JSON)
public class WorkedResource {
    
    @Inject
    WorkedService workedService;

    @GET
    public List<Worked> getAllWorkedHours(){
        return workedService.listAllWorked();
    }
    
}
