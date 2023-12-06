package JavaCartPro.src.model;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.Serial;

public class FinancialHistory implements Serializable {
    @Serial
    private static final long serialVersionUID = 11123L;
    private List<Transaction> transactions;

    public FinancialHistory() {
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

    public double getTotalProfit() {
        double totalProfit = 0;
        for (Transaction transaction : transactions) {
            totalProfit += transaction.getRevenue() - transaction.getCosts();
        }
        return totalProfit;
    }

    public double getTotalCosts() {
        double totalCosts = 0;
        for (Transaction transaction : transactions) {
            totalCosts += transaction.getCosts();
        }
        return totalCosts;
    }
}