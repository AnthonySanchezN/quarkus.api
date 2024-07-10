/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.DTO;

/**
 *
 * @author pc
 */
public class PaymentResponseDTO {
    private Double totalPayment;
    private boolean success;
    private String message;
    
    public PaymentResponseDTO(){}
    
    public PaymentResponseDTO(Double totalPayment, boolean success){
        this.totalPayment = totalPayment;
        this.success = success;
    }
    
    public Double getTotalPayment(){
        return totalPayment;
    }
    
    public void setTotalPayment(Double totalPayment){
        this.totalPayment = totalPayment;
    }
    
    public boolean isSuccess(){
        return success;
    }
    
    public void setSuccess(boolean success){
        this.success = success;
    }
    
    public String getMessage(){
        return message;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
}
