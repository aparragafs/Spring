package Ejercicio4;
public class Employee4 {

    private double yearlySalary;
    private double awards;

    public Employee4(double yearlySalary, double awards) {
        this.yearlySalary = yearlySalary;
        this.awards = awards;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double getAwards() {
        return awards;
    }

    public double getMonthlySalary() {
        return (yearlySalary + awards) / 12;
    }
    
}
