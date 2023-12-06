package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;

import java.awt.*;
import java.util.List;

public class InventoryView extends JFrame {

    public InventoryView(Inventory inventory, User user) {
        this.inventory = inventory;
        this.user = user;
        startUI();
        setTitle("Inventory");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void startUI() {
        JPanel lostProuductPanel = new JPanel();
        lostProuductPanel.setLayout(new BoxLayout(lostProuductPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(lostProuductPanel);
        add(scrollPane);

        List<ProductInterface> products = inventory.getProducts();
        for (ProductInterface product : products) {
            if (user instanceof Customer || (user instanceof Seller && product.getSeller().equals(user.getUsername()))) {
                JPanel productPanel = new JPanel();
                productPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                productPanel.add(new JLabel(product.getName()));
                productPanel.add(new JLabel(product.getSeller()));
                productPanel.add(new JLabel("$" + String.format("%.2f", product.getPrice())));
                lostProuductPanel.add(productPanel);
            }
        }
    }



    private Inventory inventory;
    private User user;
}
