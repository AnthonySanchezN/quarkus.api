/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.service;

import quarkus.response.AddEmployeeResponse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import quarkus.DTO.EmployeeDTO;
import quarkus.DTO.PaymentRequestDTO;
import quarkus.DTO.PaymentResponseDTO;
import quarkus.DTO.TotalWorkedHoursRequestDTO;
import quarkus.DTO.TotalWorkedHoursResponseDTO;
import quarkus.model.Employee;
import quarkus.model.Gender;
import quarkus.model.Job;
import quarkus.repository.EmployeeRepository;
import quarkus.repository.GenderRepository;
import quarkus.repository.JobRepository;
import quarkus.repository.WorkedRepositoryImpl;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import quarkus.repository.WorkedRepository;


/**
 *
 * @author pc
 */
@ApplicationScoped
public class EmployeeService {
    
    @Inject
    EmployeeRepository employeeRepository;

    @Inject
    GenderRepository genderRepository;

    @Inject
    JobRepository jobRepository;
    
    @Inject
    EntityManager entityManager;
    
    @Inject
    WorkedRepository workedRepository;
    
    @Inject
    EmployeeService employeeService;

    public List<Employee> listAll() {
        return employeeRepository.listAll();
    }
    
    public Gender findGenderById(Long id){
        return genderRepository.findById(id);
    }
    
    public Job findJobById(Long id){
        return jobRepository.findById(id);
    }
    
    
    @Transactional
    public PaymentResponseDTO getTotalPayment(PaymentRequestDTO request) {
        PaymentResponseDTO response = new PaymentResponseDTO();
        try {
            Double totalPayment = workedRepository.findTotalPayment(request.getEmployeeId(), request.getStartDate(), request.getEndDate());
            if (totalPayment != null) {
                response.setTotalPayment(totalPayment);
                response.setSuccess(true);
            } else {
                response.setTotalPayment(0.0);
                response.setSuccess(false);
                response.setMessage("No se encontraron pagos para el rango de fechas especificado.");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error retrieving total payment: " + e.getMessage());
        }
        return response;
    }

    @Transactional
    public Long getTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return workedRepository.findTotalWorkedHours(employeeId, startDate, endDate);
    }
    
    @Transactional
    public EmployeeDTO findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id);
        if (employee != null) {
            return mapToDTO(employee);
        }
        return null;
    }
    
    public List<EmployeeDTO> getEmployeesByJob(Long jobId) {
        return employeeRepository.listAll().stream()
                .filter(employee -> employee.getJob().id.equals(jobId))
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    
    
    @Transactional
    public AddEmployeeResponse addEmployee(Employee employee) {
     AddEmployeeResponse response = new AddEmployeeResponse();

     // Verificar si el nombre y apellido ya existen en la base de datos
     if (employeeRepository.findByNameAndLastName(employee.getName(), employee.getLastName()) != null) {
         response.setId(null);
         response.setSuccess(false);
         return response;
     }

     // Verificar si el empleado es mayor de edad
     if (!isAdult(employee.getBirthdate())) {
         response.setId(null);
         response.setSuccess(false);
         return response;
     }

     // Verificar si el puesto asignado existe
     if (!isJobExists(employee.getJob())) {
         response.setId(null);
         response.setSuccess(false);
         return response;
     }

     // Verificar que el género exista
     if (!isGenderExists(employee.getGender())){
         response.setId(null);
         response.setSuccess(false);
         return response;
     }

     // Guardar el empleado en la base de datos
     employeeRepository.persist(employee);
     response.setId(employee.id);
     response.setSuccess(true);
     return response;
 }
    
    
    public Employee findById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
    
    
    private boolean isAdult(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears() >= 18;
    }
    
    
   private boolean isGenderExists(Gender gender){
       return gender != null && genderRepository.findById(gender.id) != null;
   }

    private boolean isJobExists(Job job) {
        return job != null && jobRepository.findById(job.id) != null;
    }
    
    private EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.id); // Ensure this line maps the ID
        dto.setName(employee.getName());
        dto.setLastName(employee.getLastName());
        dto.setBirthdate(employee.getBirthdate());
        dto.setGenderId(employee.getGender().id);
        dto.setJobId(employee.getJob().id);
        return dto;
    }
}
