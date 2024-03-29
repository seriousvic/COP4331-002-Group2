package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;

/**
 * product discount screen
 */
public class ProductDiscountView extends JFrame{
    /**
     * constructor
     * @param appData data stored by the program
     * @param product product being discounted
     * @param user user discounting product
     * @param shoppingCartView shopping cart screen
     */
    public ProductDiscountView(AppData appData, ProductInterface product, Customer user, ShoppingCartView shoppingCartView) {
        this.shoppingCartView = shoppingCartView;
        this.appData = appData;
        this.product = product;
        this.quantity = user.getShoppingCart().getQuantity(product);
        this.user = user;
        this.controller = new ProductDiscountController();
        startUI();
    }

    /**
     * start user interface
     */
    private void startUI() {
        setTitle("Apply Discount");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JRadioButton percentDiscountButton = new JRadioButton("Percent Discount");
        JRadioButton flatDiscountButton = new JRadioButton("Flat Discount");
        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(percentDiscountButton);
        discountGroup.add(flatDiscountButton);
        panel.add(percentDiscountButton);
        panel.add(flatDiscountButton);

        JTextField discountValueField = new JTextField(10);
        panel.add(new JLabel("Discount Value: "));
        panel.add(discountValueField);

        int productQuantity = user.getShoppingCart().getQuantity(product);
        String productName = product.getName();
        String buttonText = "Apply Discount to " + productQuantity + " " +
                (productQuantity > 1 ? productName + "'s" : productName);

        JButton applyDiscountButton = new JButton(buttonText);

        applyDiscountButton.addActionListener(e -> {
            try {
                double discountValue = Double.parseDouble(discountValueField.getText());
                if (percentDiscountButton.isSelected()) {
                    controller.applyPercentDiscount(appData, user, quantity, product, discountValue, shoppingCartView, this);
                } else if (flatDiscountButton.isSelected()) {
                    controller.applyFlatDiscount(appData, user, quantity, product, discountValue, shoppingCartView, this);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid discount value", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(applyDiscountButton);

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    private AppData appData;
    private int quantity;
    private ShoppingCartView shoppingCartView;
    private final ProductInterface product;
    private final Customer user;
    private ProductDiscountController controller;

}
