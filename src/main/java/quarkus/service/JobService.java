/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.service;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import quarkus.model.Job;

/**
 *
 * @author pc
 */
@ApplicationScoped
public class JobService {
    public List<Job> listAll(){
        return Job.listAll();
    }
}
