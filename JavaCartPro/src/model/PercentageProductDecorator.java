package JavaCartPro.src.model;

public class PercentageProductDecorator extends ProductDecorator {

    public PercentageProductDecorator(ProductInterface product, double percentage) {
        super(product);
        this.percentage = percentage / 100;
    }

    public double getPrice() {
        if (super.getPrice() * (1 - percentage) < 0) {
            return 0;
        }
        return super.getPrice() * (1 - percentage);
    }

    public String getDescription() {
        if (super.getPrice() * (1 - percentage) < 0) {
            return super.getDescription() + " - 100% off each";
        }
        return super.getDescription() + " - " + String.format("%.2f", percentage * 100) + "% off each";
    }

    private final double percentage;
    private static final long serialVersionUID = 123456L;
}
