package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addProduct(ProductInterface product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(product);
            totalPrice += product.getPrice();
        }
    }

    public void removeProduct(ProductInterface product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (items.remove(product)) {
                totalPrice -= product.getPrice();
            }
        }
    }

    public int getQuantity(ProductInterface product) {
        int quantity = 0;
        for (ProductInterface item : items) {
            if (item.equals(product)) {
                quantity++;
            }
        }
        return quantity;
    }

    public double getTotal() {
        double total = 0;
        for (ProductInterface item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public List<ProductInterface> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private static final long serialVersionUID = 1234566L;
    private List<ProductInterface> items;
    private double totalPrice;
}
