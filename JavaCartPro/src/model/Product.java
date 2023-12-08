package JavaCartPro.src.model;

import java.io.Serializable;

/**
 * class representing a product
 */
public class Product implements ProductInterface, Serializable {
    /**
     * constructor
     * @param sellerAccount seller selling product
     * @param seller name of seller
     * @param name product name
     * @param description product description
     * @param cost product cost
     * @param price product price
     * @param stock product stock
     */
    public Product(Seller sellerAccount, String seller, String name, String description, double cost, double price, int stock) {
        this.sellerAccount = sellerAccount;
        this.seller = seller;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    /**
     * get function for seller
     * @return seller name
     */
    public String getSeller() {
        return this.seller;
    }

    /**
     * get function for name
     * @return product name
     */
    public String getName() {
        return this.name;
    }

    /**
     * get function for description
     * @return product description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * set function for description
     * @param description product description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get function for price
     * @return product price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * set function for price
     * @param price product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * get function for stock
     * @return product stock
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * set function for stock
     * @param stock product stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * get function for cost
     * @return product cost
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * get function for seller
     * @return seller
     */
    public Seller getSellerAccount() {
        return this.sellerAccount;
    }

    /**
     * sell a product
     */
    public void oneSale() {
        this.stock -= 1;
    }

    private final String seller;
    private final double cost;
    private final Seller sellerAccount;
    private final String name;
    private String description;
    private double price;
    private int stock;
    private static final long serialVersionUID = 12L;
}
