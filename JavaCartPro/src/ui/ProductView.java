package JavaCartPro.src.ui;

import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;
import javax.swing.*;
import java.awt.*;

/**
 * product screen
 */
public class ProductView extends JFrame {
    /**
     * constructor
     * @param appData data stored by the program
     * @param product product being viewed
     * @param user user viewing product
     */
    public ProductView(AppData appData, ProductInterface product, User user) {
        this.appData = appData;
        this.product = product;
        this.user = user;
        startUI();
    }

    /**
     * start user interface
     */
    private void startUI() {
        setTitle("Product Details");
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

        if (user instanceof Customer) {
            if (product instanceof Product) {
                SpinnerModel customerQuantityModel = new SpinnerNumberModel(1, 1, product.getStock(), 1);
                JSpinner customerSpinner = new JSpinner(customerQuantityModel);
                addToCart = new JButton("Add to Cart");
                createBundle = new JButton("Add to bundle Bundle for seller " + product.getSeller());
                addToCart.addActionListener(e -> controller.addToCartClick(appData, product, (int) customerSpinner.getValue(), ((Customer) user).getShoppingCart()));
                createBundle.addActionListener(e -> controller.addToBundleClick(appData, product, ((Customer) user).getShoppingCart()));
                panel.add(new JLabel("Quantity: "));
                panel.add(customerSpinner);
                panel.add(addToCart);
                panel.add(createBundle);
            }

        }

        if (user instanceof Seller) {
            costLabel = new JLabel("Cost: " + String.format("%.2f", product.getCost()));
            updateButton = new JButton("Update Product");
            updateButton.addActionListener(e -> controller.updateProductClick(appData, product, descriptionField.getText(), Double.parseDouble(priceField.getText()), Integer.parseInt(stockField.getText())));
            panel.add(new JLabel("Description:"));
            descriptionField = new JTextField(product.getDescription(), 20);
            panel.add(descriptionField);
            panel.add(new JLabel("Price:"));
            priceField = new JTextField(String.valueOf(product.getPrice()), 20);
            panel.add(priceField);
            panel.add(new JLabel("Stock:"));
            stockField = new JTextField(String.valueOf(product.getStock()), 20);
            panel.add(stockField);
            panel.add(updateButton);
        }

        Container contentPane = getContentPane();
        contentPane.add(panel);
        pack();
        setVisible(true);
    }

    private AppData appData;
    private final ProductInterface product;
    private final User user;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;
    private JLabel costLabel;
    private JButton addToCart;
    private JButton createBundle;
    private JButton toInventoryButton;
    private JButton updateButton;
    private JTextField descriptionField;
    private JTextField priceField;
    private JTextField stockField;
    private JLabel sellerLabel;
    private ProductController controller = new ProductController();
}
