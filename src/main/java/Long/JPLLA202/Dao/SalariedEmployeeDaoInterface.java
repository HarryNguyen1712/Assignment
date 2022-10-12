package Long.JPLLA202.Dao;

import Long.JPLLA202.entities.Employee;
import Long.JPLLA202.entities.SalariedEmployee;

import java.util.List;

public interface SalariedEmployeeDaoInterface {
    void add(List<Employee> employees, SalariedEmployee salariedEmployee);
}
