/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.response;

/**
 *
 * @author pc
 */

public class AddEmployeeResponse {
    public Long id;
    public boolean success;

    public Long getId(){
       return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public boolean getSuccess(){
        return success;
    }
    
    public void setSuccess(boolean success){
        this.success = success;
    }
}

