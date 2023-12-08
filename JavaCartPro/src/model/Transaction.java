package JavaCartPro.src.model;
import java.io.Serializable;
import java.io.Serial;
import java.util.List;

/**
 * Class representing a transaction between a customer and a seller
 */
public class Transaction implements Serializable {
    @Serial
    private static final long serialVersionUID = 1112L;
    private final Customer customer;
    private final Seller seller;
    private final List<ProductInterface> products;
    private int totalSales;
    private double revenue;
    private double costs;
    private final Discount discount;

    /**
     * Constructs a Transaction object without a discount
     * @param purchase customer involved in the transaction
     * @param sell seller involved in the transaction
     * @param products products involved in the transaction
     */
    public Transaction(Customer purchase, Seller sell, List<ProductInterface> products) {
        this.customer = purchase;
        this.seller = sell;
        this.products = products;
        calculateTransactionValues();
        this.discount = null;
    }

    /**
     * Constructs a Transaction object with a discount
     * @param purchase customer involved in the transaction
     * @param sell seller involved in the transaction
     * @param products products involved in the transaction
     * @param coupon discount to be applied to a purchase
     */
    public Transaction(Customer purchase, Seller sell, List<ProductInterface> products, Discount coupon) {
        this.customer = purchase;
        this.seller = sell;
        this.products = products;
        calculateTransactionValues();
        this.discount = coupon;
    }

    /**
     * Calculates the revenue, cost, and number of sales generated by a transaction
     */
    private void calculateTransactionValues() {
        for (ProductInterface product : products) {
            totalSales += 1;
            revenue += product.getPrice();
            costs += product.getCost();
        }
        if (this.discount != null) {
            discount.applyDiscount(this);
        }
    }

    /**
     * setter function for revenue (used for discounts)
     * @param newRevenue value to set revenue to
     */
    protected void setRevenue(double newRevenue) {
        this.revenue = newRevenue;
    }

    /**
     * getter function for customer
     * @return the customer involved in the transaction
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * getter function for seller
     * @return the seller involved in the transaction
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * getter function for products
     * @return a list of the products involved in the transaction
     */
    public List<ProductInterface> getProducts() {
        return products;
    }

    /**
     * getter function for totalSales
     * @return the number of sales generated by the transaction
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * getter function for revenue
     * @return the revenue generated by the transaction
     */
    public double getRevenue() {
        return revenue;
    }

    /**
     * getter function for costs
     * @return the costs incurred by the seller through the transaction
     */
    public double getCosts() {
        return costs;
    }
}