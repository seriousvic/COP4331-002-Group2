package JavaCartPro.src.ui;

import javax.swing.*;
import JavaCartPro.src.model.*;
import JavaCartPro.src.controller.*;

import java.awt.*;

public class ListProductView extends JFrame {

    public ListProductView(AppData appData, User user) {
        this.appData = appData;
        this.user = user;
        this.controller = new ListProductController();
        startUI();
    }

    private void startUI() {
        setTitle("List New Product");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        nameField = new JTextField(20);
        descriptionField = new JTextField(20);
        costField = new JTextField(20);
        priceField = new JTextField(20);
        quantityField = new JTextField(20);

        contentPane.add(new JLabel("Name: "));
        contentPane.add(nameField);

        contentPane.add(new JLabel("Description: "));
        contentPane.add(descriptionField);

        contentPane.add(new JLabel("Cost: "));
        contentPane.add(costField);

        contentPane.add(new JLabel("Price: "));
        contentPane.add(priceField);

        contentPane.add(new JLabel("Quantity: "));
        contentPane.add(quantityField);

        listProductButton = new JButton("List Product");
        listProductButton.addActionListener(e -> listProductClick());
        contentPane.add(listProductButton);

        pack();
        setVisible(true);
    }

    private void listProductClick() {
        try {
            String name = nameField.getText();
            String description = descriptionField.getText();
            double cost = Double.parseDouble(costField.getText());
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            if (!name.isEmpty() && !description.isEmpty() && price > 0 && quantity > 0) {
                controller.listProductClick(appData, (Seller) user, user.getUsername(), name, description, cost, price, quantity);
                JOptionPane.showMessageDialog(this, "Product listed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                //controller.goToDashboardClick(appData, user, this);
            } else {
                JOptionPane.showMessageDialog(this, "Error: Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Invalid number format", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private AppData appData;
    private double cost;
    private User user;
    private ListProductController controller;
    private JButton listProductButton;
    private JTextField nameField, costField, priceField, quantityField, descriptionField;
}
