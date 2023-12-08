package JavaCartPro.src.model;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.Serial;

/**
 * class representing the financial history of a seller
 */
public class FinancialHistory implements Serializable {
    @Serial
    private static final long serialVersionUID = 11123L;
    private List<Transaction> transactions;

    private Seller seller;

    /**
     * constructor
     * @param seller seller to construct history of
     */
    public FinancialHistory(Seller seller) {
        this.seller = seller;
        this.transactions = new ArrayList<>();
    }

    /**
     * add transaction to history
     * @param transaction transaction to be added
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * get functiuon for transactions
     * @return a list of the seller's transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * get function for total sales
     * @return total sales
     */
    public int getTotalSales() {
        int totalSales = 0;
        for (Transaction transaction : transactions) {
            totalSales += transaction.getTotalSales();
        }
        return totalSales;
    }

    /**
     * get function for total revenue
     * @return total revenue
     */
    public double getTotalRevenue() {
        double totalRevenue = 0;
        for (Transaction transaction : transactions) {
            totalRevenue += transaction.getRevenue();
        }
        return totalRevenue;
    }

    /**
     * get function for total profit
     * @param appData data stored by the program
     * @return total profit
     */
    public double getTotalProfit(AppData appData) {
        double totalProfit = 0;
        double totalCosts = this.getTotalCosts(appData);
        for (Transaction transaction : transactions) {
            totalProfit += transaction.getRevenue();
        }
        totalProfit -= totalCosts;
        return totalProfit;
    }

    /**
     * get function for total costs
     * @param appData data stored by the program
     * @return total costs
     */
    public double getTotalCosts(AppData appData) {
        double totalCosts = 0;
        for (ProductInterface product : appData.getInventory().getProducts()) {
            if (product.getSeller().equals(seller.getUsername())) {
                totalCosts += product.getCost() * product.getStock();
            }
        }
        return totalCosts;

    }
}

//    public double getTotalCosts() {
//        double totalCosts = 0;
//        for (Transaction transaction : transactions) {
//            totalCosts += transaction.getCosts();
//        }
//        return totalCosts;
//    }
//}