package JavaCartPro.src.model;

public class FlatProductDecorator extends ProductDecorator{

    public FlatProductDecorator(ProductInterface product, double discount) {
        super(product);
        this.flatDiscount = discount;
    }

    public double getPrice() {
        if (super.getPrice() - flatDiscount < 0) {
            return 0;
        }
        return super.getPrice() - flatDiscount;
    }

    private final double flatDiscount;
    private static final long serialVersionUID = 1234567L;
}