package Long.JPLLA202;

import Long.JPLLA101.entities.Book;
import Long.JPLLA101.entities.Magazine;
import Long.JPLLA101.entities.Publications;
import Long.JPLLA202.entities.Department;
import Long.JPLLA202.entities.Employee;
import Long.JPLLA202.entities.HourlyEmployee;
import Long.JPLLA202.entities.SalariedEmployee;
import Long.JPLLA202.service.DepartmentService;
import Long.JPLLA202.service.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args){
        EmployeeService employeeService= new EmployeeService();
        DepartmentService departmentService= new DepartmentService();
        List<Department> departments= new ArrayList<>();
        List<Employee> employeeList= new ArrayList<>();
        Department department1= new Department("IT", new ArrayList<>());
        Department department2= new Department("Marketing", new ArrayList<>());
        Department department3= new Department("HR", new ArrayList<>());
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        SalariedEmployee salariedEmployee1= new SalariedEmployee("SE0001","huy","nguyen", "11/02/1999","0123467","a@gmail.com",2.5,200,1000);
        SalariedEmployee salariedEmployee2= new SalariedEmployee("SE0002","anh","nguyen", "11/02/2000","0123468","b@gmail.com",3,250,1500);
        HourlyEmployee hourlyEmployee1= new HourlyEmployee("HE0001","anh","le", "09/02/2001","0123468","d@gmail.com",200,8);
        HourlyEmployee hourlyEmployee2= new HourlyEmployee("HE0002","duc","le", "16/02/1966","0123788","c@gmail.com",250,7.8);
        employeeList.add(salariedEmployee1);
        employeeList.add(salariedEmployee2);
        employeeList.add(hourlyEmployee1);
        employeeList.add(hourlyEmployee2);
        employeeService.classifyEmployee(employeeList);
        boolean start = true;
        while (start) {
            System.out.println("Choose what function you want to process:");
            System.out.println("1.Add employee ");
            System.out.println("2.Display employees");
            System.out.println("3.Classify employees ");
            System.out.println("4.Search employees by (department, emp’s name)");
            System.out.println("5.Reports");
            System.out.println("6.Exit ");
            System.out.println("_________________________");
            sc=new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            boolean inner = true;
            while (inner) {
                switch (choice) {
                    case 1 -> {
                        inner = false;
                        System.out.println("choose type of employee");
                        System.out.println("1.Hourly Employee");
                        System.out.println("2.Salaried Employee");
                        int type= Integer.parseInt(sc.nextLine());
                        System.out.println("choose department");
                        System.out.println("1.IT");
                        System.out.println("2.Marketing");
                        System.out.println("3.HR");
                        int department =Integer.parseInt(sc.nextLine());

                        Department department4= departments.get(department-1);

                        if(type==1){
                            HourlyEmployee employee= new HourlyEmployee();
                            employeeService.addNewEmployee(employee,employeeList,department4);
                        }
                        else{
                            SalariedEmployee employee= new SalariedEmployee();
                            employeeService.addNewEmployee(employee,employeeList,department4);
                        }
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 2 -> {
                        inner = false;
                        employeeService.displayEmployees(employeeList);
                        System.out.println("_________________________");
                    }
                    case 3 -> {
                        inner = false;
                        employeeService.classifyEmployee(employeeList);
                        System.out.println("\n");
                        System.out.println("_________________________");
                    }
                    case 4 -> {
                        System.out.println("choose which type of search");
                        System.out.println("1.Search employee by department name");
                        System.out.println("2.Search employee by employee name");
                        int choiceinner=Integer.parseInt(sc.nextLine());
                        if(choiceinner==1){
                            System.out.println("input depart name");
                            String deptname= sc.nextLine();
                            employeeService.searchByDepartmentName(deptname,departments);
                        }
                        else if(choiceinner==2){
//
                            System.out.println("input first name");
                            String firstname= sc.nextLine();
                            System.out.println("input last name");
                            String lastname=sc.nextLine();
                            employeeService.searchByEmployee(firstname,lastname,employeeList);
                        }
                        inner = false;
                        System.out.println("-----------------------");
                    }
                    case 5 -> {
                        inner = false;
                        departmentService.reports(departments);
                    }

                    case 6 -> {
                        inner = false;
                        start = false;
                    }
                    default -> {
                        System.out.println("_________________________");
                        System.out.println("Wrong choice");
                        System.out.println("Try again please");
                        choice = Integer.parseInt(sc.nextLine());
                        System.out.println("_________________________");
                    }
                }
            }
        }
    }
}
