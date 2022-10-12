package Long.JPLLA202.Dao;

import Long.JPLLA202.entities.Department;
import Long.JPLLA202.entities.Employee;

import java.util.List;

public interface DepartmentDaoInterface {
    Department findByIndex(int index, List<Department> departments);
    Department searchByDepartmentName(String deptName, List<Department> departments);
}
