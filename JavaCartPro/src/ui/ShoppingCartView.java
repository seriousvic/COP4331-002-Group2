package JavaCartPro.src.ui;

import JavaCartPro.src.controller.*;
import JavaCartPro.src.model.*;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * shopping cart view
 */
public class ShoppingCartView extends JFrame {
    /**
     * constructor
     * @param appData data stored by the program
     * @param shoppingCart customer's shopping cart
     * @param user user viewing shopping cart
     */
    public ShoppingCartView(AppData appData, ShoppingCart shoppingCart, User user) {
        this.appData = appData;
        this.shoppingCart = shoppingCart;
        this.user = user;
        startUI();
        setTitle("Shopping Cart");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * start user interface
     */
    public void startUI() {
        setTitle("Shopping Cart");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel listPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JButton inventoryButton = new JButton("View Inventory");
        inventoryButton.addActionListener(e -> controller.goToInventoryClick(appData, user, this));
        buttonPanel.add(inventoryButton);
        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.addActionListener(e -> controller.dashboardClick(appData, user, this));
        buttonPanel.add(dashboardButton);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(listPanel);
        getContentPane().add(scrollPane);

        for (ProductInterface product : uniqueProducts(shoppingCart)) {
            JPanel productPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JButton productNameButton = new JButton(product.getName());
            productNameButton.addActionListener(e -> controller.productClick(appData, product, user, this));
            JLabel priceLabel = new JLabel("$" + String.format("%.2f", product.getPrice()));
            JLabel quantityLabel = new JLabel("Quantity: " + shoppingCart.getQuantity(product));

            SpinnerModel model = new SpinnerNumberModel(1, 1, product.getStock(), 1);
            JSpinner quantitySpinner = new JSpinner(model);
            quantitySpinner.setEnabled(!(product instanceof BundleProduct));

            if (product instanceof Product) {
                Product regularProduct = (Product) product;
                JButton applyDiscountButton = new JButton("Apply Discount");
                applyDiscountButton.addActionListener(e -> controller.applyDiscountClick(appData, regularProduct, (Customer) user, this));
                productPanel.add(applyDiscountButton);
            }


            JButton removeButton = new JButton("Remove from cart");
            removeButton.addActionListener(e -> {
                controller.removeFromCartClick(appData, product, (Customer) user);
                refreshView();
            });
            JButton updateButton = new JButton("Update");
            updateButton.setEnabled(!(product instanceof BundleProduct));
            updateButton.addActionListener(e -> {
                int newQuantity = (Integer) quantitySpinner.getValue();
                controller.updateQuantityClick(appData, product, newQuantity, (Customer) user);
                refreshView();
            });

            productPanel.add(productNameButton);
            productPanel.add(priceLabel);
            productPanel.add(quantityLabel);
            productPanel.add(quantitySpinner);
            productPanel.add(updateButton);
            productPanel.add(removeButton);
            listPanel.add(productPanel);
        }

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> controller.goToCheckoutClick(appData, this, (Customer) user));
        getContentPane().add(checkoutButton, BorderLayout.SOUTH);
    }

    /**
     * list unique products
     * @param shoppingCart shopping cart to list products in
     * @return list of unique products
     */
    private List<ProductInterface> uniqueProducts(ShoppingCart shoppingCart) {
        List<ProductInterface> uniqueProducts = new ArrayList<>();

        for (ProductInterface product : shoppingCart.getItems()) {
            if (!containsProduct(uniqueProducts, product)) {
                uniqueProducts.add(product);
            }
        }

        return uniqueProducts;
    }

    /**
     * checks to see if the shopping cart contains a product
     * @param productList list of products in shopping cart
     * @param productToCheck product to check for uniqueness
     * @return true or false
     */
    private boolean containsProduct(List<ProductInterface> productList, ProductInterface productToCheck) {
        for (ProductInterface product : productList) {
            if (product.getName().equals(productToCheck.getName()) && product.getSeller().equals(productToCheck.getSeller())) {
                return true;
            }
        }
        return false;
    }

    /**
     * refresh window
     */
    public void refreshView() {
        getContentPane().removeAll();
        startUI();
        revalidate();
        repaint();
    }

    private AppData appData;
    private ShoppingCart shoppingCart;
    private User user;
    private ShoppingCartController controller = new ShoppingCartController();
}
