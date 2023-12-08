package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;
import java.util.List;

public class InventoryView extends JFrame {

    public InventoryView(AppData appData, User user) {
        this.appData = appData;
        this.user = user;
        startUI();
        setTitle("Inventory");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startUI() {
        JPanel listProductPanel = new JPanel();
        listProductPanel.setLayout(new BoxLayout(listProductPanel, BoxLayout.Y_AXIS));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.addActionListener(e -> controller.dashboardClick(appData, user, this));
        buttonPanel.add(dashboardButton);
        if (user instanceof Customer) {
            JButton cartButton = new JButton("View Cart");
            cartButton.addActionListener(e -> controller.goToCartClick(appData, user, ((Customer) user).getShoppingCart(), this));
            buttonPanel.add(cartButton);
        }

        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(listProductPanel);
        add(scrollPane);

        List<ProductInterface> products = appData.getInventory().getProducts();
        for (ProductInterface product : products) {
            if (user instanceof Customer && (product.getStock() > 0) || (user instanceof Seller && product.getSeller().equals(user.getUsername()))) {
                JPanel productPanel = new JPanel();
                productPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                JButton productNameButton = new JButton(product.getName());
                productNameButton.addActionListener(e -> controller.productClick(appData, (Product) product, user));
                productPanel.add(productNameButton);
                productPanel.add(new JLabel("Seller: " + product.getSeller()));
                productPanel.add(new JLabel("$" + String.format("%.2f", product.getPrice())));
                if (user instanceof Seller) {
                    JButton removeProductButton = new JButton("Remove Product");
                    removeProductButton.addActionListener(e -> controller.removeProductClick(appData, (Seller) user, (Product) product, this));
                    productPanel.add(removeProductButton);
                }
                listProductPanel.add(productPanel);
            }
        }
    }

    public void refreshView() {
        getContentPane().removeAll();
        startUI();
        revalidate();
        repaint();
    }

    private AppData appData;
//    private Inventory inventory;
    private User user;
    private InventoryController controller = new InventoryController();
}
