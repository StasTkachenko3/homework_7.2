import java.util.ArrayList;
import java.util.List;

public class SalaryCalculator {
    private List<Sotrudnik> sotrudnikList;

    public SalaryCalculator() {
        sotrudnikList = new ArrayList<>();
    }

    public void addSotrudnik(Sotrudnik sotrudnik) {
        sotrudnikList.add(sotrudnik);
    }

    public void generateReport() {
        System.out.println("ФИО\t\tНалог, %\tСумма (грн)\tК оплате (грн)");
        System.out.println("----------------------------------------------");

        for (Sotrudnik sotrudnik : sotrudnikList) {
            double taxPercentage = getTaxPercentage(sotrudnik.getPaymentType());
            double taxAmount = sotrudnik.getAmount() * (taxPercentage / 100);
            double amountToPay = sotrudnik.getAmount() - taxAmount;

            System.out.println(sotrudnik.getName() + "\t" + taxPercentage + "\t\t" + sotrudnik.getAmount() + "\t\t" + amountToPay);
        }
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