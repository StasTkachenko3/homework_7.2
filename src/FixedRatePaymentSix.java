public class FixedRatePaymentSix extends PaymentMethodSix {
    private double fixedRate;

    public FixedRatePaymentSix(double fixedRate) {
        this.fixedRate = fixedRate;
    }

    @Override
    public double calculatePayment() {
        return fixedRate;
    }

    @Override
    public double getTaxRate() {
        return 0.2;
    }
}