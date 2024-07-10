/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quarkus.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.jboss.logging.Logger;
import quarkus.model.Worked;

/**
 *
 * @author pc
 */
@ApplicationScoped
public class WorkedRepositoryImpl implements WorkedRepository {
    
    private static final Logger LOG = Logger.getLogger(WorkedRepositoryImpl.class);
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Inject
    WorkedRepository workedRepository;
    
    @Override
    public List<Worked> listAllWorked() {
        return workedRepository.listAll();
    }
    
     @Override
    public Long findTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return find("employee.id = ?1 and workedDate between ?2 and ?3", employeeId, startDate, endDate).stream()
                .mapToLong(Worked::getWorkedHours).sum();
    }
    
     @Override
    public Double findTotalPayment(Long employeeId, LocalDate startDate, LocalDate endDate) {
        try {
            String queryStr = "SELECT SUM(w.workedHours * j.salary) FROM Worked w JOIN w.employee e JOIN e.job j WHERE e.id = :employeeId AND w.workedDate BETWEEN :startDate AND :endDate";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("employeeId", employeeId);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            BigDecimal result = (BigDecimal) query.getSingleResult();
            LOG.info("Total Payment Query Result: " + result);
            return result != null ? result.doubleValue() : 0.0;
        } catch (Exception e) {
            LOG.error("Error in findTotalPayment: " + e.getMessage(), e);
            throw new RuntimeException("Error retrieving total payment", e);
        }
    }
    
 
    
}
