package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * class representing a shopping cart
 */
public class ShoppingCart implements Serializable {
    /**
     * constructor
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalPrice = 0;
    }

    /**
     * add product to the cart
     * @param product product to be added
     * @param quantity quantity to be added
     */
    public void addProduct(ProductInterface product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(product);
            totalPrice += product.getPrice();
        }
    }

    /**
     * remove product from the shopping cart
     * @param product product to be removed
     * @param quantity quantity to be removed
     */
    public void removeProduct(ProductInterface product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (items.remove(product)) {
                totalPrice -= product.getPrice();
            }
        }
    }

    /**
     * get function for quantity
     * @param product product whose quantity is desired
     * @return quantity of the product
     */
    public int getQuantity(ProductInterface product) {
        int quantity = 0;
        for (ProductInterface item : items) {
            if (item.equals(product)) {
                quantity++;
            }
        }
        return quantity;
    }

    /**
     * get function for total price
     * @return total price
     */
    public double getTotal() {
        double total = 0;
        for (ProductInterface item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     * clear shopping cart
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * get function for items
     * @return a list of the items in the shopping cart
     */
    public List<ProductInterface> getItems() {
        return items;
    }

    /**
     * set function for total price
     * @param total total price
     */
    public void setTotal(double total) {
        totalPrice = total;
    }

    /**
     * apply a discount to the shopping cart
     * @param discount discount to be applied
     * @param amount amount to be discounted
     */
    public void applyDiscount(Discount discount, double amount) {
        discount.applyDiscount(this, amount);
    }

    /**
     * get function for total price
     * @return total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    private static final long serialVersionUID = 1234566L;
    private List<ProductInterface> items;
    private double totalPrice;
}
