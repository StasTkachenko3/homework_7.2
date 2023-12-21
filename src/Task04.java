import java.util.ArrayList;
import java.util.List;

public class Task04 {
    public static void main(String[] args) {
        PayrollCalculator payrollCalculator = new PayrollCalculator();

        Employee employee1 = new Employee("Иванов", PaymentType.STAVKA, 3000);
        Employee employee2 = new Employee("Сидоров", PaymentType.POCHASOVAYA, 800);
        Employee employee3 = new Employee("Петров", PaymentType.SDELNAYA, 5500);

        payrollCalculator.addEmployee(employee1);
        payrollCalculator.addEmployee(employee2);
        payrollCalculator.addEmployee(employee3);

        payrollCalculator.generateReport();
    }
}

class Employee {
    private String name;
    private PaymentType paymentType;
    private double amount;

    public Employee(String name, PaymentType paymentType, double amount) {
        this.name = name;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public double getAmount() {
        return amount;
    }
}

enum PaymentType {
    STAVKA, POCHASOVAYA, SDELNAYA
}

class PayrollCalculator {
    private List<Employee> employees;

    public PayrollCalculator() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void generateReport() {
        System.out.println("ФИО\t\tНалог, %\tСумма (грн)\t\tК оплате (грн/тугрики)\tКурс 1/8");
        System.out.println("---------------------------------------------------------------");

        for (Employee employee : employees) {
            double taxPercentage = getTaxPercentage(employee.getPaymentType());
            double taxAmount = employee.getAmount() * (taxPercentage / 100);
            double amountToPay = employee.getAmount() - taxAmount;

            System.out.print(employee.getName() + "\t\t" + taxPercentage + "\t\t" + employee.getAmount() + "\t\t" + amountToPay);

            if (employee.getPaymentType() == PaymentType.POCHASOVAYA) {
                double currencyAmount = amountToPay/ 8;
                System.out.print("\t\t" + currencyAmount);
            }

            System.out.println();
        }

        System.out.println("---------------------------------------------------------------");
    }

    private double getTaxPercentage(PaymentType paymentType) {
        switch (paymentType) {
            case STAVKA:
            case POCHASOVAYA:
                return 20;
            case SDELNAYA:
                return 15;
            default:
                return 0;
        }
    }
}