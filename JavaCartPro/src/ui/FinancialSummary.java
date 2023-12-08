package JavaCartPro.src.ui;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * financial summary window
 */
public class FinancialSummary extends JFrame {
    private User user;
    private FinancialHistory financialHistory;
    private JTextArea transactionTextArea;
    private JLabel totalSalesLabel;
    private JLabel revenueLabel;
    private JLabel profitLabel;
    private JLabel costsLabel;
    private AppData appData;

    private FinancialSummaryController controller = new FinancialSummaryController();

    /**
     * constructor
     * @param appData data stored by the program
     * @param user user viewing financial summary
     * @param financialHistory user's financial history
     */
    public FinancialSummary(AppData appData, User user, FinancialHistory financialHistory) {
        this.appData = appData;
        this.user = user;
        this.financialHistory = financialHistory;

        setTitle("Financial Summary");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        calculateSummary();
    }

    /**
     * add components to page
     */
    private void initComponents() {
        transactionTextArea = new JTextArea(10, 30);
        transactionTextArea.setEditable(false);

        totalSalesLabel = new JLabel("Total Sales: 0");
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

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.addActionListener(e -> controller.dashboardClick(appData, user, this));
        buttonPanel.add(dashboardButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * calculate financial summary
     */
    private void calculateSummary() {
        List<Transaction> transactions = financialHistory.getTransactions();

        double totalSales = financialHistory.getTotalSales();
        double revenue = financialHistory.getTotalRevenue();
        double profit = financialHistory.getTotalProfit(appData);
        double costs = financialHistory.getTotalCosts(appData);


        totalSalesLabel.setText("Total Sales: " + String.format("%.0f", totalSales));
        revenueLabel.setText("Revenue: $" + String.format("%.2f", revenue));
        profitLabel.setText("Profit: $" + String.format("%.2f", profit));
        costsLabel.setText("Costs: $" + String.format("%.2f", costs));

        // Display details of each transaction
        for (Transaction transaction : transactions) {
            displayTransaction(transaction);
        }
    }

    /**
     * display a transaction
     * @param transaction transaction to display
     */
    private void displayTransaction(Transaction transaction) {
        transactionTextArea.append("\nTransaction Details:\n");
        transactionTextArea.append("User: " + transaction.getCustomer().getUsername() + "\n");
        transactionTextArea.append("Products:\n");
        for (ProductInterface product : transaction.getProducts()) {
            transactionTextArea.append("- " + product.getName() + ": $" + product.getPrice() + "\n");
        }
        transactionTextArea.append("Total Sales: " + transaction.getTotalSales() + "\n");
        transactionTextArea.append("Revenue: $" + transaction.getRevenue() + "\n");
        transactionTextArea.append("Profit: $" + (transaction.getRevenue() - transaction.getCosts()) + "\n");
        transactionTextArea.append("Costs: $" + transaction.getCosts() + "\n");
        transactionTextArea.append("------------\n");
    }
}