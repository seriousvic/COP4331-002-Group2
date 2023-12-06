package JavaCartPro.src.model;

public class PercentDiscount implements Discount{
    double amount;

    public PercentDiscount(double percentage) {
        amount = percentage;
    }
    @Override
    public void applyDiscount(Transaction purchase) {
        double newRevenue = purchase.getRevenue() * (1 - amount);
        purchase.setRevenue(newRevenue);
    }
}
