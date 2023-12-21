public class Salary {
    private String name;
    private double amount;
    private double taxPercentage;

    public Salary(String name, double amount, double taxPercentage) {
        this.name = name;
        this.amount = amount;
        this.taxPercentage = taxPercentage;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public double getNetAmount() {
        double taxAmount = amount * (taxPercentage / 100);
        return amount - taxAmount;
    }
}