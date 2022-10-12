package Long.JPLLA202.entities;

import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> listOfEmployeeList;

    public Department() {
    }

    public Department(String departmentName, List<Employee> listOfEmployeeList) {
        this.departmentName = departmentName;
        this.listOfEmployeeList = listOfEmployeeList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getListOfEmployeeList() {
        return listOfEmployeeList;
    }

    public void setListOfEmployeeList(List<Employee> listOfEmployeeList) {
        this.listOfEmployeeList = listOfEmployeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", listOfEmployeeList=" + listOfEmployeeList +
                '}';
    }
}
