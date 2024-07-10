/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import quarkus.model.Employee;

/**
 *
 * @author pc
 */
@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {
    
    //Metodo para buscar por nombre y apellido
     public Employee findByNameAndLastName(String name, String lastName)       {
         return find("name = ?1 and lastName = ?2", name, lastName).firstResult();
     }
     
      //Metodo para buscar por ID
     public Employee findById(Long id) {
        return find("id", id).firstResult();
    }
}
