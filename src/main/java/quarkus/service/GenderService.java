/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import quarkus.model.Employee;
import quarkus.model.Gender;

/**
 *
 * @author pc
 */
@ApplicationScoped
public class GenderService {
    
    public List<Gender> listAll() {
        return Gender.listAll();
    }
}
