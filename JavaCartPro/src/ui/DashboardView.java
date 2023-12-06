package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;

public class DashboardView extends JFrame {

    public DashboardView(User user, DashboardController controller) {
        this.user = user;
        this.controller = controller;
        startUI();
        setTitle(user.getUsername() + "'s Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startUI() {
        setLayout(new FlowLayout());

        JButton inventoryButton = new JButton("View Inventory");
        inventoryButton.addActionListener(e -> controller.goToInventoryClick(user));
        add(inventoryButton);

        if (user instanceof Customer) {
            JButton cartButton = new JButton("View Cart");
            cartButton.addActionListener(e -> controller.goToCartClick(user, ((Customer) user).getShoppingCart()));
            add(cartButton);
        }

        if (user instanceof Seller) {
            JButton salesButton = new JButton("View Sales");
            salesButton.addActionListener(e -> controller.goToFinancialSummaryClick(user, ((Seller) user).getFinancialHistory()));
            add(salesButton);
        }
    }

    private User user;
    private DashboardController controller = new DashboardController();
}
