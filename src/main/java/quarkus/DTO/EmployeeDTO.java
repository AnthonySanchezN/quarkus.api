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
public class EmployeeDTO {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    public Long genderId;
    public Long jobId;
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public LocalDate getBirthdate(){
        return birthdate;
    }
    
    public void setBirthdate(LocalDate birthdate){
        this.birthdate = birthdate;
    }
    
    public Long getGenderId(){
        return genderId;
    }
    
    public void setGenderId(Long genderId){
        this.genderId = genderId;
    }
    
    public Long getJobId(){
        return jobId;
    }
    
    public void setJobId(Long jobId){
        this.jobId = jobId;
    }
    
}
