public class OffshoreSixPayment extends PaymentMethodSix {
    private double offshoreRate;

    public OffshoreSixPayment(double offshoreRate) {
        this.offshoreRate = offshoreRate;
    }

    @Override
    public double calculatePayment() {
        return offshoreRate;
    }

    @Override
    public double getTaxRate() {
        return 0.0;
    }
}