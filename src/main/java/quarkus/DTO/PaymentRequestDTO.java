/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.DTO;

import java.time.LocalDate;

/**
 *
 * @author pc
 */
public class PaymentRequestDTO {
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public Long getEmployeeId(){
        return employeeId;
    }
    
    public void setEmployeeId(Long employeeId){
        this.employeeId = employeeId;
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
