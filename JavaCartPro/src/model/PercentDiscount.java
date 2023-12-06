package JavaCartPro.src.model;

public class PercentDiscount implements Discount{
    double amount;

    /**
     * constructs a PercentDiscount object
     * @param percentage the amount of dollars to be removed from the transaction's revenue
     */
    public PercentDiscount(double percentage) {
        amount = percentage;
    }

    /**
     * applies a discount to a purchase
     * @param purchase the transaction to apply the discount to
     */
    @Override
    public void applyDiscount(Transaction purchase) {
        double newRevenue = purchase.getRevenue() * (1 - amount);
        purchase.setRevenue(newRevenue);
    }
}
