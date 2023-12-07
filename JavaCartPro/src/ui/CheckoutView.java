package JavaCartPro.src.ui;
import JavaCartPro.src.controller.*;
import JavaCartPro.src.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static javax.swing.BoxLayout.Y_AXIS;

public class CheckoutView extends JFrame {
    private Customer customer;
    private AppData appData;

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

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, Y_AXIS));
        List<ProductInterface> cartItems = customer.getShoppingCart().getItems();

        for (ProductInterface item : cartItems) {
            itemPanel.add(new JLabel(item.getName()));
            itemPanel.add(new JLabel("$" + item.getPrice()));
        }

        JLabel totalLabel = new JLabel("Total: $" + calculateTotalPrice(cartItems));

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> controller.performCheckout(appData, cartItems, customer, CheckoutView.this));

        add(itemPanel, BorderLayout.CENTER);
        add(totalLabel, BorderLayout.SOUTH);
        add(checkoutButton, BorderLayout.EAST);

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