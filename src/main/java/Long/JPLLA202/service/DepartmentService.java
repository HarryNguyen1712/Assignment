package Long.JPLLA202.service;

import Long.JPLLA202.entities.Department;

import java.util.List;

public class DepartmentService {
    public void reports(List<Department> departments){
        departments.forEach(department -> {
            System.out.println(department.getDepartmentName()+"\nNumber of employee:"+department.getListOfEmployeeList().size());
        });
    }
}
