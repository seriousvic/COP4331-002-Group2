package JavaCartPro.src.model;

/**
 * class representing a percentage-based discount
 */
public class PercentDiscount implements Discount{
    /**
     * applies a discount to a purchase
     * @param shoppingCart the shopping cart to apply the discount to
     * @param amount amount to discount
     */
    @Override
    public void applyDiscount(ShoppingCart shoppingCart, double amount) {
        double newRevenue = shoppingCart.getTotal() * (1 - (amount/100));
        shoppingCart.setTotal(newRevenue);
    }
}