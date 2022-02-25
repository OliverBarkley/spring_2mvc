package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {
  void addEmployee(Employee employee);
  void deleteEmployee(int id);
  void editEmployee(Employee employee);
  Employee getEmployeeById(int id);
  List<Employee> getAllEmployees();
}
