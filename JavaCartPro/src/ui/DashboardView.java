package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;

import java.awt.*;

public class DashboardView extends JFrame {

    public DashboardView(User user) {
        this.user = user;
        startUI();
        setTitle(user.getUsername() + "'s Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startUI() {
        setLayout(new FlowLayout());

        JButton inventoryButton = new JButton("View Inventory");
        inventoryButton.addActionListener(e -> goToInventory());
        add(inventoryButton);

        if (user instanceof Customer) {
            JButton cartButton = new JButton("View Cart");
            cartButton.addActionListener(e -> goToCart());
            add(cartButton);
        }

        if (user instanceof Seller) {
            JButton salesButton = new JButton("View Sales");
            salesButton.addActionListener(e -> goToFinancialHistory());
            add(salesButton);
        }
    }

    private User user;
}
