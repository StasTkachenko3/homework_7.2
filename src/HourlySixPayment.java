public class HourlySixPayment extends PaymentMethodSix {
    private double hourlyRate;

    public HourlySixPayment(double hourlyRate) {
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