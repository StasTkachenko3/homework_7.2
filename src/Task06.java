import java.util.ArrayList;
import java.util.List;

public class Task06 {
    public static void main(String[] args) {
        // Создание сотрудников и определение их способов оплаты
        EmployeeSix ivanov = new EmployeeSix("Иванов", new FixedRatePaymentSix(3000), 160);
        EmployeeSix sidorov = new EmployeeSix("Сидоров", new HourlySixPayment(800), 250);
        EmployeeSix pticin = new EmployeeSix("Птицин", new OffshoreSixPayment(1800), 160);
        EmployeeSix petrov = new EmployeeSix("Петров", new PieceworkSixPayment(5500), 160);

        // Создание списка сотрудников
        List<EmployeeSix> employeeSixes = new ArrayList<>();
        employeeSixes.add(ivanov);
        employeeSixes.add(sidorov);
        employeeSixes.add(pticin);
        employeeSixes.add(petrov);

        // Вывод отчета о заработной плате
        System.out.println("ФИО\t\tНалог, %\tСумма (грн)\tК оплате (грн)");
        for (EmployeeSix employeeSix : employeeSixes) {
            double payment = employeeSix.getPaymentMethod().calculatePayment();
            double taxRate = employeeSix.getPaymentMethod().getTaxRate();
            double taxAmount = payment * taxRate;

            // Проверка на премию
            if (!(employeeSix.getPaymentMethod() instanceof OffshoreSixPayment) && employeeSix.getHoursWorked() > 200) {
                payment += 500; // Премия в размере 500 грн
            }

            double amountToPay = payment - taxAmount;
            System.out.println(employeeSix.getName() + "\t\t" + (taxRate * 100) + "\t\t" + payment + "\t\t" + amountToPay);
        }
    }
}