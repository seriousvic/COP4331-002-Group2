package JavaCartPro.src.model;

import java.io.Serializable;

public abstract class ProductDecorator implements Serializable, ProductInterface{

    public ProductDecorator(ProductInterface product){
        this.product = product;
    }

    public double getPrice() {
        return product.getPrice();
    }

    public String getSeller() {
        return product.getSeller();
    }

    public String getName() {
        return product.getName();
    }

    public int getStock() {
        return product.getStock();
    }

    public String getDescription() {
        return product.getDescription();
    }

    public void setPrice(double price) {
        product.setPrice(price);
    }

    public void setStock(int stock) {
        product.setStock(stock);
    }

    public double getCost() {
        return product.getCost();
    }

    public void setDescription(String description) {
        product.setDescription(description);
    }

    public Seller getSellerAccount() {
        return product.getSellerAccount();
    }

    protected ProductInterface product;
    private static final long serialVersionUID = 123L;
}
