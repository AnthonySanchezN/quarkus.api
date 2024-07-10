/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.DTO;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author pc
 */
public class EmployeeInfoRequestDTO {
    private List<Long> employeeIds;
    private LocalDate startDate;
    private LocalDate endDate;
    
    //Getter & Setter
    public List<Long> getEmployeeIds(){
        return employeeIds;
    }
    
    public void setEmployeeIds(List<Long> employeeIds){
        this.employeeIds = employeeIds;
    }
    
    public LocalDate getStartDate(){
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate(){
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }
}
