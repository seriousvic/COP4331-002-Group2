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
}
