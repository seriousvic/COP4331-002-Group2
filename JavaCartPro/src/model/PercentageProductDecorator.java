package JavaCartPro.src.model;

public class PercentageProductDecorator extends ProductDecorator {

    public PercentageProductDecorator(ProductInterface product, double percentage) {
        super(product);
        this.percentage = percentage;
    }

    public double getPrice() {
        return super.getPrice() * (1 - percentage);
    }

    private final double percentage;
    private static final long serialVersionUID = 123456L;
}
