package JavaCartPro.src.controller;
import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

import javax.swing.*;
import java.util.List;

public class CheckoutController {
    public void performCheckout(AppData appData, List<ProductInterface> cartItems, Customer customer, CheckoutView checkoutView, Payment payment) {
        if (!payment.getCcv().isEmpty() && !payment.getCardNumber().isEmpty() && !payment.getExpirationMonth().isEmpty()) {
            for (ProductInterface item : cartItems) {
                // Retrieve the seller from each product
                Seller seller = item.getSellerAccount();

                // Create a separate transaction for each product
                Transaction transaction = new Transaction(customer, seller, List.of(item));

                // Add the transaction to the seller's financial history
                seller.getFinancialHistory().addTransaction(transaction);

                // Remove each product from the seller's inventory
                Inventory.getInstance().removeProduct(item.getName(), seller.getUsername());
            }

            // Clear the customer's shopping cart after checkout
            customer.getShoppingCart().clearCart();

            // Display a confirmation message
            JOptionPane.showMessageDialog(checkoutView, "Checkout successful!");
            DataManager.saveData(appData);


            // Return to dashboard screen
            new DashboardView(appData, customer);
            checkoutView.dispose();
        }
        else {
            JOptionPane.showMessageDialog(checkoutView, "Invalid Payment Method", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
