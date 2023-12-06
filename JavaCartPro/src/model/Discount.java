package JavaCartPro.src.model;

public interface Discount {

    /**
     * applies a discount to a purchase
     * @param purchase transaction to apply a discount to
     */
    void applyDiscount(Transaction purchase);
}
