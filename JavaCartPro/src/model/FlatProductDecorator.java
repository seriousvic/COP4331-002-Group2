package JavaCartPro.src.model;

/**
 * decorator for a flat discount applied to an individual product
 */
public class FlatProductDecorator extends ProductDecorator{
    /**
     * constructor
     * @param product product to be discounted
     * @param discount discount to be applied
     */
    public FlatProductDecorator(ProductInterface product, double discount) {
        super(product);
        this.flatDiscount = discount;
    }

    /**
     * get function for price
     * @return discounted price
     */
    public double getPrice() {
        if (super.getPrice() - flatDiscount < 0) {
            return 0;
        }
        return super.getPrice() - flatDiscount;
    }

    /**
     * get function for description
     * @return discount description
     */
    public String getDescription() {
        return super.getDescription() + " - $" + flatDiscount + " off each";
    }

    private final double flatDiscount;
    private static final long serialVersionUID = 1234567L;
}