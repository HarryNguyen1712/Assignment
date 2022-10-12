package Long.JPLLA202.service;

import AssignmentPart2.exception.EmailException;
import Long.JPLLA202.entities.Department;
import Long.JPLLA202.entities.Employee;
import Long.JPLLA202.entities.HourlyEmployee;
import Long.JPLLA202.utilis.Validate;

import java.util.List;
import java.util.Scanner;

public class HourlyEmployeeService {
    Scanner scanner= new Scanner(System.in);
    public void add(HourlyEmployee hourlyEmployee, List<Employee> employees){
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
        System.out.println("input wage");
        int wage= Integer.parseInt(scanner.nextLine());
        System.out.println("input working hours");
        int workingHours= Integer.parseInt(scanner.nextLine());
        hourlyEmployee.setSsn(ssn);
        hourlyEmployee.setFirstName(firstName);
        hourlyEmployee.setLastName(lastName);
        hourlyEmployee.setWage(wage);
        hourlyEmployee.setBirthDate(birthDate);
        hourlyEmployee.setEmail(email);
        hourlyEmployee.setPhone(phone);
        hourlyEmployee.setWorkingHours(workingHours);
        employees.add(hourlyEmployee);
    }
}
