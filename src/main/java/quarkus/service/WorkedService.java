/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import quarkus.model.Worked;
import quarkus.repository.WorkedRepositoryImpl;

/**
 *
 * @author pc
 */
@ApplicationScoped
public class WorkedService {
    
    @Inject
    WorkedRepositoryImpl repo;
    
    public List<Worked> listAllWorked(){
        return repo.listAllWorked();
    }

    
   
     
}
