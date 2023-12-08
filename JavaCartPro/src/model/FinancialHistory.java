package JavaCartPro.src.model;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.Serial;

public class FinancialHistory implements Serializable {
    @Serial
    private static final long serialVersionUID = 11123L;
    private List<Transaction> transactions;

    private Seller seller;

    public FinancialHistory(Seller seller) {
        this.seller = seller;
        this.transactions = new ArrayList<>();
    }

    // Add a transaction to the financial history
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Get the list of transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getTotalSales() {
        int totalSales = 0;
        for (Transaction transaction : transactions) {
            totalSales += transaction.getTotalSales();
        }
        return totalSales;
    }

    public double getTotalRevenue() {
        double totalRevenue = 0;
        for (Transaction transaction : transactions) {
            totalRevenue += transaction.getRevenue();
        }
        return totalRevenue;
    }

    public double getTotalProfit(AppData appData) {
        double totalProfit = 0;
        double totalCosts = this.getTotalCosts(appData);
        for (Transaction transaction : transactions) {
            totalProfit += transaction.getRevenue();
        }
        totalProfit -= totalCosts;
        return totalProfit;
    }


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