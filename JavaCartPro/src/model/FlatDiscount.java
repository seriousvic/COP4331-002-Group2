package JavaCartPro.src.model;

public class FlatDiscount implements Discount{

//    double amount;

    /**
     * constructs a FlatDiscount object
     * @param dollarAmount the amount of dollars to be removed from the transaction's revenue
     */
//    public FlatDiscount(double dollarAmount) {
//        amount = dollarAmount;
//    }

    /**
     * applies a discount to a purchase
     * @param purchase the transaction to apply the discount to
     */
    @Override
    public void applyDiscount(ShoppingCart shoppingCart, double amount) {
        if (shoppingCart.getTotal() - amount >= 0) {
            double newRevenue = shoppingCart.getTotal() - amount;
            shoppingCart.setTotal(newRevenue);
        }
        else {
            shoppingCart.setTotal(0);
        }
    }
}
