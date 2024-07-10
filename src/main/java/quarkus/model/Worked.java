/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "WORKED")
public class Worked extends PanacheEntity {
   
    @Column(name = "WORKED_HOURS")
    private int workedHours;
    
    @Column(name = "WORKED_DATE")
    private LocalDate workedDate;
    
    @ManyToOne
    private Employee employee;
    
    private Double payment;
    
    //Getter & Setter
    public int getWorkedHours(){
        return workedHours;
    }
    
    public void setWorkedHours(int workedHours){
        this.workedHours = workedHours;
    }
    
    public LocalDate getWorkedDate(){
        return workedDate;
    }
    
    public void setWorkedDate(LocalDate workedDate){
        this.workedDate = workedDate;
    }
    
    public Employee getEmployee(){
        return employee;
    }
    
    public void setEmployee(Employee employee){
        this.employee = employee;
    }
    
    public Double getPayment(){
        return payment;
    }
    
    public void setPayment(Double payment){
        this.payment = payment;
    }
}
