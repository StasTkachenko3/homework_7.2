public class Employee {
    private String name;
    private Task01.PaymentType paymentType;
    private double amount;

    public Employee(String name, Task01.PaymentType paymentType, double amount) {
        this.name = name;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Task01.PaymentType getPaymentType() {
        return paymentType;
    }

    public double getAmount() {
        return amount;
    }
}