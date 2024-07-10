/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.time.LocalDate;
import java.util.List;
import quarkus.model.Worked;

/**
 *
 * @author pc
 */
public interface WorkedRepository extends PanacheRepository<Worked>{
    
    List<Worked> listAllWorked();
    
    Long findTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate);
    
    Double findTotalPayment(Long employeeId, LocalDate startDate, LocalDate endDate);
    
}
