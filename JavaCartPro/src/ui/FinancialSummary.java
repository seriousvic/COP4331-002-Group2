package JavaCartPro.src.ui;
import JavaCartPro.src.model.FinancialHistory;
import JavaCartPro.src.model.Transaction;
import JavaCartPro.src.model.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FinancialSummary extends JFrame {
    private FinancialHistory financialHistory;
    private JTextArea transactionTextArea;
    private JLabel totalSalesLabel;
    private JLabel revenueLabel;
    private JLabel profitLabel;
    private JLabel costsLabel;

    public FinancialSummary(FinancialHistory financialHistory) {
        this.financialHistory = financialHistory;

        setTitle("Financial Summary");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        calculateSummary();
    }

    private void initComponents() {
        transactionTextArea = new JTextArea(10, 30);
        transactionTextArea.setEditable(false);

        totalSalesLabel = new JLabel("Total Sales: $0.00");
        revenueLabel = new JLabel("Revenue: $0.00");
        profitLabel = new JLabel("Profit: $0.00");
        costsLabel = new JLabel("Costs: $0.00");

        JScrollPane scrollPane = new JScrollPane(transactionTextArea);

        setLayout(new FlowLayout());

        add(scrollPane);
        add(totalSalesLabel);
        add(revenueLabel);
        add(profitLabel);
        add(costsLabel);
    }

    private void calculateSummary() {
        List<Transaction> transactions = financialHistory.getTransactions();

        double totalSales = financialHistory.getTotalSales();
        double revenue = financialHistory.getTotalRevenue();
        double profit = financialHistory.getTotalProfit();
        double costs = financialHistory.getTotalCosts();

        totalSalesLabel.setText("Total Sales: $" + String.format("%.2f", totalSales));
        revenueLabel.setText("Revenue: $" + String.format("%.2f", revenue));
        profitLabel.setText("Profit: $" + String.format("%.2f", profit));
        costsLabel.setText("Costs: $" + String.format("%.2f", costs));

        // Display details of each transaction
        for (Transaction transaction : transactions) {
            displayTransaction(transaction);
        }
    }

    private void displayTransaction(Transaction transaction) {
        transactionTextArea.append("\nTransaction Details:\n");
        transactionTextArea.append("User: " + transaction.getUser().getUsername() + "\n");
        transactionTextArea.append("Products:\n");
        for (Product product : transaction.getProducts()) {
            transactionTextArea.append("- " + product.getName() + ": $" + product.getPrice() + "\n");
        }
        transactionTextArea.append("Total Sales: $" + transaction.getTotalSales() + "\n");
        transactionTextArea.append("Revenue: $" + transaction.getRevenue() + "\n");
        transactionTextArea.append("Profit: $" + (transaction.getRevenue() - transaction.getCosts()) + "\n");
        transactionTextArea.append("Costs: $" + transaction.getCosts() + "\n");
        transactionTextArea.append("------------\n");
    }
}