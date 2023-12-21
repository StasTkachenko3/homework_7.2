import java.util.ArrayList;
import java.util.List;

public class Task03 {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();

        Worker worker1 = new Worker("Иванов", "Ставка");
        worker1.setRate(100);
        worker1.setHours(20);
        workers.add(worker1);

        Worker worker2 = new Worker("Сидоров", "Почасовая");
        worker2.setRate(50);
        worker2.setHours(40);
        workers.add(worker2);

        Worker worker3 = new Worker("Петров", "Сдельная");
        worker3.addWorkAmount(500);
        worker3.addWorkAmount(1000);
        workers.add(worker3);

        List<Salary> salaries = new ArrayList<>();

        for (Worker worker : workers) {
            double taxPercentage = 20;
            if (worker.getPaymentType().equals("Ставка") || worker.getPaymentType().equals("Почасовая")) {
                taxPercentage += 5;
            }
            double amount = worker.calculateAmount();
            double netAmount = amount - (amount * (taxPercentage / 100));

            Salary salary = new Salary(worker.getName(), amount, taxPercentage);
            salaries.add(salary);
        }

        System.out.println("ФИО\t\tНалог, %\tСумма (грн)\tК оплате (грн)");
        System.out.println("----------------------------------------------");

        for (Salary salary : salaries) {
            System.out.println(salary.getName() + "\t" + salary.getTaxPercentage() + "\t\t" + salary.getAmount() + "\t\t" + salary.getNetAmount());
        }
    }
}