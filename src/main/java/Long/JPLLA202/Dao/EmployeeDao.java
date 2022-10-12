package Long.JPLLA202.Dao;

import Long.JPLLA202.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDao  implements  EmployeeDaoInterface{

    @Override
    public List<Employee> searchByName(String firstName, String lastName, List<Employee> employees) {
        return employees.stream().filter(employee ->
                employee.getFirstName().equalsIgnoreCase(firstName) &&
                        employee.getLastName().equalsIgnoreCase(lastName)
        ).toList();
    }
}
