package JavaCartPro.src.ui;

import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;
import javax.swing.*;

public class ProductView extends JPanel {

    public ProductView(Product product, User user, ProductController controller) {
        this.product = product;
        this.user = user;
        this.controller = controller;
        startUI();
    }

    private void startUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Product Details"));

        nameLabel = new JLabel("Name: " + product.getName());
        sellerLabel = new JLabel("Seller: " + product.getSeller());
        descriptionLabel = new JLabel("Description: " + product.getDescription());
        priceLabel = new JLabel("Price: " + product.getPrice());
        stockLabel = new JLabel("Stock: " + product.getStock());

        add(nameLabel);
        add(sellerLabel);
        add(descriptionLabel);
        add(priceLabel);
        add(stockLabel);
        if (user instanceof Customer) {
            SpinnerModel customerQuantityModel = new SpinnerNumberModel(1, 1, product.getStock(), 1);
            JSpinner customerSpinner = new JSpinner(customerQuantityModel);
            addToCart = new JButton("Add to Cart");
            createBundle = new JButton("Add to bundle Bundle for seller " + product.getSeller());
            addToCart.addActionListener(e -> controller.addToCartClick(product, (int) customerSpinner.getValue(), ((Customer) user).getShoppingCart()));
            createBundle.addActionListener(e -> controller.addToBundleClick(product, ((Customer) user).getShoppingCart()));
            add(new JLabel("Quantity: "));
            add(customerSpinner);
            add(addToCart);
            add(createBundle);
        }

        if (user instanceof Seller) {
            updateButton = new JButton("Update Product");
            updateButton.addActionListener(e -> controller.updateProductClick(product, descriptionField.getText(), Double.parseDouble(priceField.getText()), Integer.parseInt(stockField.getText())));
            add(new JLabel("Description:"));
            add(descriptionField);
            add(new JLabel("Price:"));
            add(priceField);
            add(new JLabel("Stock:"));
            add(stockField);
            add(updateButton);
        }

//        toInventoryButton = new JButton("Back to Inventory");
//        toInventoryButton.addActionListener(e -> controller.toInventoryClick());
//        add(toInventoryButton);
    }

    private Product product;
    private User user;
    private JLabel nameLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;
    private JButton addToCart;
    private JButton createBundle;
    private JButton toInventoryButton;
    private JButton updateButton;
    private JTextField descriptionField;
    private JTextField priceField;
    private JTextField stockField;
    private JLabel sellerLabel;
    private ProductController controller;
}
