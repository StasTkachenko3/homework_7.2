public class PieceworkSixPayment extends PaymentMethodSix {
    private double paymentPerPiece;

    public PieceworkSixPayment(double paymentPerPiece) {
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