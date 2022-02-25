package service;

import dao.EmployeeDAO;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void addEmployee(Employee employee) {
     employeeDAO.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
      employeeDAO.deleteEmployee(id);
    }

    @Override
    public void editEmployee(Employee employee) {
        employeeDAO.editEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
}
