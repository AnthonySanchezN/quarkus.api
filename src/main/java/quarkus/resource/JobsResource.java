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
import quarkus.model.Job;
import quarkus.service.JobService;

/**
 *
 * @author pc
 */
@Path("/jobs")
public class JobsResource {
    
    @Inject
    JobService jobService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobs() {
        List<Job> jobs = jobService.listAll();
        return Response.ok(jobs).build();
    }
            
}
