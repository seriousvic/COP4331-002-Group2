package JavaCartPro.src.model;

import java.io.Serializable;

/**
 * decorator for product class
 */
public abstract class ProductDecorator implements Serializable, ProductInterface{

    public ProductDecorator(ProductInterface product){
        this.product = product;
    }
    /**
     * get function for price
     * @return product price
     */
    public double getPrice() {
        return product.getPrice();
    }
    /**
     * get function for seller
     * @return seller
     */
    public String getSeller() {
        return product.getSeller();
    }
    /**
     * get function for name
     * @return product name
     */
    public String getName() {
        return product.getName();
    }
    /**
     * get function for stock
     * @return product stock
     */
    public int getStock() {
        return product.getStock();
    }
    /**
     * get function for description
     * @return product description
     */
    public String getDescription() {
        return product.getDescription();
    }
    /**
     * set function for price
     * @param price product price
     */
    public void setPrice(double price) {
        product.setPrice(price);
    }
    /**
     * set function for stock
     * @param stock product stock
     */
    public void setStock(int stock) {
        product.setStock(stock);
    }
    /**
     * get function for cost
     * @return product cost
     */
    public double getCost() {
        return product.getCost();
    }
    /**
     * set function for description
     * @param description product description
     */
    public void setDescription(String description) {
        product.setDescription(description);
    }
    /**
     * get function for seller
     * @return seller
     */
    public Seller getSellerAccount() {
        return product.getSellerAccount();
    }
    /**
     * sell a product
     */
    public void oneSale() {
        product.oneSale();
    }

    protected ProductInterface product;
    private static final long serialVersionUID = 123L;
}
