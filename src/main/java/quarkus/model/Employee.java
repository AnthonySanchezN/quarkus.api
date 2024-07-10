/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends PanacheEntity{
    
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    
    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;
    
    @ManyToOne
    @JoinColumn(name = "GENDER_ID")
    private Gender gender;
    
    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;
    
    
    
    // Getters and Setters
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
    
    public Gender getGender(){
        return gender;
    }
    
    public void setGender(Gender gender){
        this.gender = gender;
    }
    
    public Job getJob(){
        return job;
    }
    
    public void setJob(Job job){
        this.job = job;
    }
}
