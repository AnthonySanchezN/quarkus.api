/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.resource;

import quarkus.response.AddEmployeeResponse;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import quarkus.DTO.EmployeeDTO;
import quarkus.DTO.EmployeeInfoRequestDTO;
import quarkus.DTO.JobRequestDTO;
import quarkus.DTO.PaymentRequestDTO;
import quarkus.DTO.PaymentResponseDTO;
import quarkus.DTO.TotalWorkedHoursRequestDTO;
import quarkus.DTO.TotalWorkedHoursResponseDTO;
import quarkus.model.Employee;
import quarkus.model.Gender;
import quarkus.model.Job;
import quarkus.service.EmployeeService;

/**
 *
 * @author pc
 */
@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    
    @Inject
    EmployeeService employeeService;

    @GET
    public Response getAllEmployees() {
        List<Employee> employees = employeeService.listAll();
        return Response.ok(employees).build();
    }

    @POST
    @Transactional
    public Response addEmployeeResponse(EmployeeDTO employeeDTO) {
        try {
            Employee newEmployee = new Employee();
            newEmployee.setName(employeeDTO.getName());
            newEmployee.setLastName(employeeDTO.getLastName());
            newEmployee.setBirthdate(employeeDTO.getBirthdate());
            
            newEmployee.setGender(employeeService.findGenderById(employeeDTO.getGenderId()));
            newEmployee.setJob(employeeService.findJobById(employeeDTO.getJobId()));
            
            employeeService.addEmployee(newEmployee);
            
            return Response.ok(newEmployee).build();
        } catch (Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error creating employee: " + e.getMessage()).build();
        }
    }
    
    
    @POST
    @Path("/by-job")
    public Response getEmployeesByJob(JobRequestDTO jobRequestDTO) {
        try {
            List<Employee> employees = employeeService.listAll();
            List<EmployeeDTO> filteredEmployees = employees.stream()
                    .filter(employee -> employee.getJob().id.equals(jobRequestDTO.getJobId()))
                    .map(this::mapToDTO)
                    .sorted(Comparator.comparing(EmployeeDTO::getLastName))  // Ordenar por apellido
                    .collect(Collectors.toList());

            Map<String, List<EmployeeDTO>> groupedByLastName = filteredEmployees.stream()
                    .collect(Collectors.groupingBy(EmployeeDTO::getLastName));

            return Response.ok().entity(groupedByLastName).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving employees: " + e.getMessage()).build();
        }
    }
    
    @POST
    @Path("/info")
    @Transactional
    public Response getEmployeesInfo(EmployeeInfoRequestDTO request) {
        try {
            List<CompletableFuture<EmployeeDTO>> futures = request.getEmployeeIds().stream()
                    .map(id -> CompletableFuture.supplyAsync(() -> employeeService.findEmployeeById(id)))
                    .collect(Collectors.toList());

            List<EmployeeDTO> employees = futures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());

            return Response.ok().entity(Map.of("employees", employees, "success", true)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving employee info: " + e.getMessage()).build();
        }
    }
   
    
    @POST
    @Path("/total-worked-hours")
    @Transactional
    public Response getTotalWorkedHours(TotalWorkedHoursRequestDTO request) {
        try {
            Long totalWorkedHours = employeeService.getTotalWorkedHours(request.getEmployeeId(), request.getStartDate(), request.getEndDate());

            TotalWorkedHoursResponseDTO response = new TotalWorkedHoursResponseDTO(totalWorkedHours, true);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error retrieving total worked hours: " + e.getMessage())
                           .build();
        }
    }
    
    @POST
    @Path("/payment")
    public Response getTotalPayment(PaymentRequestDTO request) {
        try{
            PaymentResponseDTO response = employeeService.getTotalPayment(request);
            return Response.ok(response).build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving total payment: " + e.getMessage()).build();
        }
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
