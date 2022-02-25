package dao;

import model.Employee;
import java.util.List;

public interface EmployeeDAO {
   public List<Employee> getAllEmployees();
   void addEmployee(Employee employee);
   void deleteEmployee(int id);
   void editEmployee(Employee employee);
   Employee getEmployeeById(int id);

}
