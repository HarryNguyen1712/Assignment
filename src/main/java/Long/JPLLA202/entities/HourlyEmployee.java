package Long.JPLLA202.entities;

public class HourlyEmployee extends Employee{
    private double wage;
    private double workingHours;

    public HourlyEmployee() {
    }

    public HourlyEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email, double wage, double workingHours) {
        super(ssn, firstName, lastName, birthDate, phone, email);
        this.wage = wage;
        this.workingHours = workingHours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }


    @Override
    public String toString() {
        return super.toString()+"\n"+
                ", wage=" + wage +
                ", workingHours=" + workingHours +
                '}'+"\n";
    }

    @Override
    public double getPaymentAmount() {
        return wage*workingHours;
    }
}
