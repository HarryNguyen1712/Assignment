package Long.JPLLA202.Dao;

import Long.JPLLA202.entities.Department;
import Long.JPLLA202.entities.Employee;

import java.util.List;
import java.util.Optional;

public class DepartmentDao implements  DepartmentDaoInterface {

    @Override
    public Department findByIndex(int index, List<Department> departments) {
        return departments.get(index);
    }

    @Override
    public Department searchByDepartmentName(String deptName, List<Department> departments) {
        Optional<Department> department1=departments.stream().filter(department -> department.getDepartmentName().equalsIgnoreCase(deptName)).findAny();
        return department1.orElse(null);
    }
}
