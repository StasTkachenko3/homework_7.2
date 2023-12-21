public class EmployeeSix {
    private String name;
    private PaymentMethodSix paymentMethodSix;
    private int hoursWorked;

    public EmployeeSix(String name, PaymentMethodSix paymentMethodSix, int hoursWorked) {
        this.name = name;
        this.paymentMethodSix = paymentMethodSix;
        this.hoursWorked = hoursWorked;
    }

    public String getName() {
        return name;
    }

    public PaymentMethodSix getPaymentMethod() {
        return paymentMethodSix;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}