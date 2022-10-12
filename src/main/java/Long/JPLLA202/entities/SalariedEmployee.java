package Long.JPLLA202.entities;

public class SalariedEmployee extends Employee{
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String ssn, String firstName, String lastName, String birthDate, String phone, String email, double commissionRate, double grossSales, double basicSalary) {
        super(ssn, firstName, lastName, birthDate, phone, email);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
        this.basicSalary = basicSalary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double getPaymentAmount() {
        return (commissionRate*grossSales)+basicSalary;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+
                "commissionRate=" + commissionRate +
                ", grossSales=" + grossSales +
                ", basicSalary=" + basicSalary +
                '}'+"\n";
    }
}
