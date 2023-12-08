package JavaCartPro.src.model;

/**
 * class representing a flat discount
 */
public class FlatDiscount implements Discount{

    /**
     * applies a discount to a purchase
     * @param shoppingCart the shopping cart to discount
     * @param amount amount to discount
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
