package Long.JPLLA202.Dao;

import Long.JPLLA202.entities.Employee;

import java.util.List;

public interface EmployeeDaoInterface {
    List<Employee> searchByName(String firstName, String lastName, List<Employee> employees);
}
