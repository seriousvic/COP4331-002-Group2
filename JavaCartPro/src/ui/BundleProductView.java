package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;

public class BundleProductView extends JFrame {
    public BundleProductView(AppData appData, BundleProduct product, User user, ShoppingCartView shoppingCartView) {
        this.shoppingCartView = shoppingCartView;
        this.appData = appData;
        this.product = product;
        this.user = user;
        this.controller = new ProductBundleController();
        startUI();
    }

    private void startUI() {
        setTitle("Product Bundle Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Product Details"));

        nameLabel = new JLabel("Name: " + product.getName());
        sellerLabel = new JLabel("Seller: " + product.getSeller());
        descriptionLabel = new JLabel("Description: " + product.getDescription());
        priceLabel = new JLabel("Price: " + String.format("%.2f", product.getPrice()));
        stockLabel = new JLabel("Stock: " + product.getStock());

        panel.add(nameLabel);
        panel.add(sellerLabel);
        panel.add(descriptionLabel);
        panel.add(priceLabel);
        panel.add(stockLabel);

        for (ProductInterface productBundled : product.getProducts()) {
            JPanel productPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel productNameLabel = new JLabel(productBundled.getName());
            JLabel priceLabel = new JLabel("$" + String.format("%.2f", productBundled.getPrice()));
            JButton removeButton = new JButton("Remove from bundle");
            removeButton.addActionListener(e -> {
                controller.removeFromBundleClick(appData, (Customer) user, product, productBundled, shoppingCartView, this);
                if (!(product.getProducts().isEmpty())) {
                    refreshView();
                }
            });
            productPanel.add(productNameLabel);
            productPanel.add(priceLabel);
            productPanel.add(removeButton);
            productPanel.add(removeButton);
            panel.add(productPanel);
        }

        Container contentPane = getContentPane();
        contentPane.add(panel);
        pack();
        setVisible(true);
    }
    public void refreshView() {
        getContentPane().removeAll();
        startUI();
        revalidate();
        repaint();
    }

    private ShoppingCartView shoppingCartView;
    private ProductBundleController controller;
    private AppData appData;
    private BundleProduct product;
    private User user;
    private JLabel nameLabel;
    private JLabel sellerLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;

}