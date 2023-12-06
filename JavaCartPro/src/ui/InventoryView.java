package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;
import java.util.List;

public class InventoryView extends JFrame {

    public InventoryView(AppData appData, User user) {
        this.appData = appData;
        this.inventory = appData.getInventory();
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

        JScrollPane scrollPane = new JScrollPane(listProductPanel);
        add(scrollPane);

        List<ProductInterface> products = inventory.getProducts();
        for (ProductInterface product : products) {
            if (user instanceof Customer || (user instanceof Seller && product.getSeller().equals(user.getUsername()))) {
                JPanel productPanel = new JPanel();
                productPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                productPanel.add(new JLabel("Product: " + product.getName()));
                productPanel.add(new JLabel("Seller: " + product.getSeller()));
                productPanel.add(new JLabel("$" + String.format("%.2f", product.getPrice())));
                listProductPanel.add(productPanel);
            }
        }
    }


    private AppData appData;
    private Inventory inventory;
    private User user;
    private InventoryController controller = new InventoryController();
}
