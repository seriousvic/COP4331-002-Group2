package JavaCartPro.src.ui;
import JavaCartPro.src.controller.*;
import JavaCartPro.src.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CheckoutView extends JFrame {
    private Customer customer;
    private AppData appData;
    private Payment payment = new Payment();

    private CheckoutController controller = new CheckoutController();

    // Constructor
    public CheckoutView(AppData appData, Customer customer) {
        this.customer = customer;
        this.appData = appData;
        setSize(800, 400);

        initComponents();
    }

    private void initComponents() {
        setTitle("Checkout Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        List<ProductInterface> cartItems = customer.getShoppingCart().getItems();

        for (ProductInterface item : cartItems) {
            itemPanel.add(new JLabel(item.getName()));
            itemPanel.add(new JLabel("$" + item.getPrice()));
        }

        JPanel itemListAndTotalPanel = new JPanel(new GridLayout(0, 1));
        itemListAndTotalPanel.add(itemPanel);

        JLabel totalLabel = new JLabel("Total: $" + calculateTotalPrice(cartItems));
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        itemListAndTotalPanel.add(totalLabel);

        // Create text fields for credit card information
        JTextField cardNumberField = new JTextField();
        JTextField expirationField = new JTextField();
        JTextField ccvField = new JTextField();

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns

        paymentPanel.add(new JLabel("Card Number:"));
        paymentPanel.add(cardNumberField);
        paymentPanel.add(new JLabel("Expiration Date:"));
        paymentPanel.add(expirationField);
        paymentPanel.add(new JLabel("CVV:"));
        paymentPanel.add(ccvField);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> {
            // Set payment information in the Payment object
            payment.setCardNumber(cardNumberField.getText());
            payment.setExpirationMonth(expirationField.getText());
            payment.setCcv(ccvField.getText());

            // Perform checkout with credit card information
            controller.performCheckout(appData, cartItems, customer, CheckoutView.this, payment);
        });

        mainPanel.add(itemListAndTotalPanel, BorderLayout.WEST);
        mainPanel.add(paymentPanel, BorderLayout.EAST);
        mainPanel.add(checkoutButton, BorderLayout.SOUTH);

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private double calculateTotalPrice(List<ProductInterface> cartItems) {
        double total = 0;
        for (ProductInterface item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}