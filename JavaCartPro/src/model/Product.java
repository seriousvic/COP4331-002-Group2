package JavaCartPro.src.model;

import java.io.Serializable;

public class Product implements ProductInterface, Serializable {
    public Product(String seller, String name, String description, double price, int stock) {
        this.seller = seller;
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

//    public void setName(String name) {
//        this.name = name;
//    }

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


    private final String seller;
    private final String name;
    private String description;
    private double price;
    private int stock;
    private static final long serialVersionUID = 123456789L;
}
