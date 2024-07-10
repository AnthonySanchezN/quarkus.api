/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.DTO;

/**
 *
 * @author pc
 */
public class TotalWorkedHoursResponseDTO {
    
    private Long totalWorkedHours;
    private boolean success;
    
    
    public TotalWorkedHoursResponseDTO(Long totalWorkedHours, boolean success) {
    this.totalWorkedHours = totalWorkedHours;
    this.success = success;
}
    
    //Getter & Setter
    
    public Long getTotalWorkedHours(){
        return totalWorkedHours;
    }
    
    public void setTotalWorkedHours(Long totalWorkedHours){
        this.totalWorkedHours = totalWorkedHours;
    }
    
    public boolean getSuccess(){
        return success;
    }
    
    public void setSuccess(boolean success){
        this.success = success;
    }
}
