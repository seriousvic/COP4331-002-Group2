package JavaCartPro.src.model;

import java.io.Serializable;

public class Product implements ProductInterface, Serializable {
    public Product(Seller sellerAccount, String seller, String name, String description, double cost, double price, int stock) {
        this.sellerAccount = sellerAccount;
        this.seller = seller;
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getSeller() {
        return this.seller;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return this.cost;
    }

    public Seller getSellerAccount() {
        return this.sellerAccount;
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
