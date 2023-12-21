import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private String paymentType;
    private double rate;
    private double hours;
    private List<Double> workAmounts;

    public Worker(String name, String paymentType) {
        this.name = name;
        this.paymentType = paymentType;
        this.workAmounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void addWorkAmount(double workAmount) {
        workAmounts.add(workAmount);
    }

    public double calculateAmount() {
        double amount = 0;
        if (paymentType.equals("Ставка")) {
            amount = rate * hours;
        } else if (paymentType.equals("Почасовая")) {
            amount = rate * hours;
        } else if (paymentType.equals("Сдельная")) {
            for (double workAmount : workAmounts) {
                amount += workAmount;
            }
        }
        return amount;
    }
}