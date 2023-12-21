import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private PaymentMethod paymentMethod;

    public Employee(String name, PaymentMethod paymentMethod) {
        this.name = name;
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}

abstract class PaymentMethod {
    public abstract double calculatePayment();
    public abstract double getTaxRate();
}

class FixedRatePayment extends PaymentMethod {
    private double dailyRate;

    public FixedRatePayment(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculatePayment() {
        return dailyRate;
    }

    @Override
    public double getTaxRate() {
        return 0.2;
    }
}

class HourlyPayment extends PaymentMethod {
    private double hourlyRate;

    public HourlyPayment(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePayment() {
        return hourlyRate;
    }

    @Override
    public double getTaxRate() {
        return 0.2;
    }
}

class PieceworkPayment extends PaymentMethod {
    private double paymentPerPiece;

    public PieceworkPayment(double paymentPerPiece) {
        this.paymentPerPiece = paymentPerPiece;
    }

    @Override
    public double calculatePayment() {
        return paymentPerPiece;
    }

    @Override
    public double getTaxRate() {
        return 0.15;
    }
}
class ZeroTaxPayment extends PaymentMethod {
    private double paymentMethod;

    public ZeroTaxPayment(double paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public double calculatePayment() {
        return paymentMethod;
    }

    @Override
    public double getTaxRate() {
        return 0.0;
    }
}

public class Task05 {
    public static void main(String[] args) {
        // Создание сотрудников и определение их способов оплаты
        Employee ivanov = new Employee("Иванов", new FixedRatePayment(3000));
        Employee sidorov = new Employee("Сидоров", new HourlyPayment(800));
        Employee pticin = new Employee("Птицин", new ZeroTaxPayment(1800));
        Employee petrov = new Employee("Петров", new PieceworkPayment(5500));

        // Создание списка сотрудников
        List<Employee> employees = new ArrayList<>();
        employees.add(ivanov);
        employees.add(sidorov);
        employees.add(pticin);
        employees.add(petrov);

        // Вывод отчета о заработной плате
        System.out.println("ФИО\t\tНалог, %\tСумма (грн)\tК оплате (грн)");
        for (Employee employee : employees) {
            double payment = employee.getPaymentMethod().calculatePayment();
            double taxRate = employee.getPaymentMethod().getTaxRate();
            double taxAmount = payment * taxRate;
            double amountToPay = payment - taxAmount;
            System.out.println(employee.getName() + "\t\t" + (taxRate * 100) + "\t\t" + payment + "\t\t" + amountToPay);
        }
    }
}