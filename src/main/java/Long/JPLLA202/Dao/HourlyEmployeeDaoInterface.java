package Long.JPLLA202.Dao;

import Long.JPLLA202.entities.Employee;
import Long.JPLLA202.entities.HourlyEmployee;

import java.util.List;

public interface HourlyEmployeeDaoInterface {
    void add(List<Employee> employees, HourlyEmployee hourlyEmployee);

}
