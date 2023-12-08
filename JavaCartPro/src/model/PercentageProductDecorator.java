package JavaCartPro.src.model;

/**
 * decorator for percentage-based discount
 */
public class PercentageProductDecorator extends ProductDecorator {
    /**
     * constructor
     * @param product product being discounted
     * @param percentage percentage to discount by
     */
    public PercentageProductDecorator(ProductInterface product, double percentage) {
        super(product);
        this.percentage = percentage / 100;
    }

    /**
     * get function for price
     * @return discounted price
     */
    public double getPrice() {
        if (super.getPrice() * (1 - percentage) < 0) {
            return 0;
        }
        return super.getPrice() * (1 - percentage);
    }

    /**
     * get function for description
     * @return discount description
     */
    public String getDescription() {
        if (super.getPrice() * (1 - percentage) < 0) {
            return super.getDescription() + " - 100% off each";
        }
        return super.getDescription() + " - " + String.format("%.2f", percentage * 100) + "% off each";
    }

    private final double percentage;
    private static final long serialVersionUID = 123456L;
}
