import java.util.ArrayList;
import java.util.List;

public class PayrollCalculator {
    private List<Employee> employees;

    public PayrollCalculator() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void generateReport() {
        double totalAmount = 0;

        System.out.println("ФИО\t\tВид оплаты\t\tСумма");
        System.out.println("-------------------------------------");

        for (Employee employee : employees) {
            System.out.println(employee.getName() + "\t\t" + getPaymentTypeString(employee.getPaymentType()) + "\t\t" + employee.getAmount() + " грн");
            totalAmount += employee.getAmount();
        }

        System.out.println("-------------------------------------");
        System.out.println("Итого\t\t\t\t\t" + totalAmount + " грн");
    }

    private String getPaymentTypeString(Task01.PaymentType paymentType) {
        switch (paymentType) {
            case STAVKA:
                return "ставка";
            case POCHASOVAYA:
                return "почасовая";
            case SDELNAYA:
                return "сдельная";
            default:
                return "";
        }
    }
}