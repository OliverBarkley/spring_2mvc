package dao;

import model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository

public class EmployeeDaoImpl implements EmployeeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void addEmployee(Employee employee) {
      getEntityManager().persist(employee);
    }

    @Override
    public void deleteEmployee(int id) {
      getEntityManager().createQuery("delete from Employee where id=: id")
                        .setParameter("id",id)
                        .executeUpdate();
    }

    @Override
    public void editEmployee(Employee employee) {
      getEntityManager().merge(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return getEntityManager().find(Employee.class,id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return getEntityManager().createQuery("From Employee").getResultList();
    }


}
