package Long.JPLLA202.service;

import Long.JPLLA202.Dao.DepartmentDao;
import Long.JPLLA202.Dao.EmployeeDao;
import Long.JPLLA202.Dao.HourlyEmployeeDao;
import Long.JPLLA202.entities.Department;
import Long.JPLLA202.entities.Employee;
import Long.JPLLA202.entities.HourlyEmployee;
import Long.JPLLA202.entities.SalariedEmployee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeService {
    EmployeeDao employeeDao= new EmployeeDao();
    DepartmentDao departmentDao = new DepartmentDao();
    HourlyEmployeeService hourlyEmployeeService= new HourlyEmployeeService();
    SalariedEmployeeService salariedEmployeeService= new SalariedEmployeeService();
    public void searchByDepartmentName (String departmentName, List<Department> departments){
        Department department=departmentDao.searchByDepartmentName(departmentName,departments);
        department.getListOfEmployeeList().forEach(employee -> System.out.println(employee.toString()));
    }
    public void searchByEmployee(String firstName, String lastName,List<Employee> employees){
        List<Employee> employeeList = employeeDao.searchByName(firstName,lastName, employees);
        employeeList.forEach(employee -> System.out.println(employee.toString()));
    }
    public <T> void addNewEmployee(T employee, List<Employee> employees,Department department){
        if(employee instanceof HourlyEmployee hourlyEmployee){
            hourlyEmployeeService.add(hourlyEmployee,employees);
            department.getListOfEmployeeList().add(hourlyEmployee);
        }
        else if(employee instanceof SalariedEmployee salariedEmployee){
            salariedEmployeeService.add(salariedEmployee,employees);
            department.getListOfEmployeeList().add(salariedEmployee);
        }
    }
    public void classifyEmployee(List<Employee> employees){
        Map<String,List<Employee>> employeeClassify;
        employeeClassify = employees.stream().collect(Collectors.groupingBy(employee -> {
            if(employee instanceof HourlyEmployee hourlyEmployee){
                return hourlyEmployee.getClass().getSimpleName();
            }
            if(employee instanceof SalariedEmployee salariedEmployee){
                return salariedEmployee.getClass().getSimpleName();
            }
            return null;
        }));
        System.out.println(employeeClassify);
    }
    public void displayEmployees(List<Employee> employees){
        employees.forEach(employee -> {
            if(employee instanceof SalariedEmployee salariedEmployee){
                System.out.println(salariedEmployee.toString());
            }
            else if (employee instanceof HourlyEmployee hourlyEmployee){
                System.out.println(hourlyEmployee.toString());
            }
        });
    }
}
