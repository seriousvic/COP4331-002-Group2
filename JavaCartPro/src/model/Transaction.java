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

    public Transaction(User user, List<Product> products) {
        this.user = user;
        this.products = products;
        calculateTransactionValues();
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