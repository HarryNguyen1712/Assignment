package Long.JPLLA202.service;

import AssignmentPart2.exception.EmailException;
import Long.JPLLA202.entities.Employee;
import Long.JPLLA202.entities.HourlyEmployee;
import Long.JPLLA202.entities.SalariedEmployee;
import Long.JPLLA202.utilis.Validate;

import java.util.List;
import java.util.Scanner;

public class SalariedEmployeeService {
    Scanner scanner= new Scanner(System.in);
    public void add(SalariedEmployee salariedEmployee, List<Employee> employees){
        System.out.println( "input ssn");
        String ssn= scanner.nextLine();
        System.out.println("input first name");
        String firstName= scanner.nextLine();
        System.out.println("input last name");
        String lastName= scanner.nextLine();
        String birthDate;
        String phone;
        String email = null;
        do {
            System.out.println("input birthday");
            birthDate = scanner.nextLine();

        } while (!Validate.validateDate(birthDate));
        do {
            System.out.println("input phone");
            phone = scanner.nextLine();

        } while (!Validate.validatePhone(phone));
        boolean booleanEmail=true;
        while(booleanEmail){
            try{
                System.out.println("input email");
                email = scanner.nextLine();
                Validate.validateEmail2(email);
            }
            catch (EmailException e) {
                throw new RuntimeException(e);
            }
            booleanEmail=false;
        }
        System.out.println("input commission rate");
        double commissionRate= Double.parseDouble(scanner.nextLine());
        System.out.println("input gross sales");
        double grossSales= Double.parseDouble(scanner.nextLine());
        System.out.println("input basic salary");
        double basicSalary= Double.parseDouble(scanner.nextLine());
        salariedEmployee.setSsn(ssn);
        salariedEmployee.setFirstName(firstName);
        salariedEmployee.setLastName(lastName);
        salariedEmployee.setBasicSalary(basicSalary);
        salariedEmployee.setBirthDate(birthDate);
        salariedEmployee.setEmail(email);
        salariedEmployee.setPhone(phone);
        salariedEmployee.setGrossSales(grossSales);
        salariedEmployee.setCommissionRate(commissionRate);
        employees.add(salariedEmployee);
    }
}
