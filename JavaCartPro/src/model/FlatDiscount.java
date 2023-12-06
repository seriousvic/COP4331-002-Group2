package JavaCartPro.src.model;

public class FlatDiscount implements Discount{

    double amount;

    /**
     * constructs a FlatDiscount object
     * @param dollarAmount the amount of dollars to be removed from the transaction's revenue
     */
    public FlatDiscount(double dollarAmount) {
        amount = dollarAmount;
    }

    /**
     * applies a discount to a purchase
     * @param purchase the transaction to apply the discount to
     */
    @Override
    public void applyDiscount(Transaction purchase) {
        if (purchase.getRevenue() - amount >= 0) {
            double newRevenue = purchase.getRevenue() - amount;
            purchase.setRevenue(newRevenue);
        }
        else {
            purchase.setRevenue(0);
        }
    }
}
