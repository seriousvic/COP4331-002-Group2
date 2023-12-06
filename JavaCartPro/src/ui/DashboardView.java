package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;

public class DashboardView extends JFrame {

    public DashboardView(AppData appData, User user) {
        this.appData = appData;
        this.user = user;
        this.controller = new DashboardController();
        startUI();
        setTitle(user.getUsername() + "'s Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startUI() {
        setLayout(new FlowLayout());

        JButton inventoryButton = new JButton("View Inventory");
        inventoryButton.addActionListener(e -> controller.goToInventoryClick(appData, user, this));
        add(inventoryButton);

        if (user instanceof Customer) {
            JButton cartButton = new JButton("View Cart");
            cartButton.addActionListener(e -> controller.goToCartClick(appData, user, ((Customer) user).getShoppingCart(), this));
            add(cartButton);
        }

        if (user instanceof Seller) {
            JButton salesButton = new JButton("View Sales");
            salesButton.addActionListener(e -> controller.goToFinancialSummaryClick(appData, user, ((Seller) user).getFinancialHistory(), this));
            add(salesButton);
        }
    }

    private User user;
    private AppData appData;
    private DashboardController controller = new DashboardController();
}
