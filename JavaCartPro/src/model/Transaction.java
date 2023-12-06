package JavaCartPro.src.model;
import java.io.Serializable;
import java.io.Serial;
import java.util.List;

public class Transaction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1112L;

    private final User user;
    private final List<Product> products;
    private int totalSales;
    private double revenue;
    private double costs;
    private final Discount discount;

    public Transaction(User user, List<Product> products) {
        this.user = user;
        this.products = products;
        calculateTransactionValues();
        this.discount = null;
    }

    public Transaction(User user, List<Product> products, Discount coupon) {
        this.user = user;
        this.products = products;
        calculateTransactionValues();
        this.discount = coupon;
    }

    //calculate total sales, revenue, and cost for seller
    private void calculateTransactionValues() {
        for (Product product : products) {
            //customer purchase transaction
            if (user instanceof Customer) {
                totalSales += 1;
                revenue += product.getPrice();
            }
            //seller inventory addition transaction
            else if (user instanceof Seller) {
                costs += product.getPrice();
            }
        }
        if (this.discount != null) {
            discount.applyDiscount(this);
        }
    }

    protected void setRevenue(double newRevenue) {
        this.revenue = newRevenue;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getCosts() {
        return costs;
    }
}