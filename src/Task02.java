public class Task02 {
    public static void main(String[] args) {
        SalaryCalculator salaryCalculator = new SalaryCalculator();

        Sotrudnik sotrudnik1 = new Sotrudnik("Иванов", PaymentType.STAVKA, 3000);
        Sotrudnik sotrudnik2 = new Sotrudnik("Сидоров", PaymentType.POCHASOVAYA, 800);
        Sotrudnik sotrudnik3 = new Sotrudnik("Петров", PaymentType.SDELNAYA, 5500);

        salaryCalculator.addSotrudnik(sotrudnik1);
        salaryCalculator.addSotrudnik(sotrudnik2);
        salaryCalculator.addSotrudnik(sotrudnik3);

        salaryCalculator.generateReport();
    }
}