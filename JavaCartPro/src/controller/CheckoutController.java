package JavaCartPro.src.controller;
import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

import javax.swing.*;
import java.util.List;

/**
 * controller for the checkout class
 */
public class CheckoutController {
    /**
     * function to perform a checkout
     * @param appData data stored by the program
     * @param cartItems items in the shopping cart
     * @param customer customer checking out
     * @param checkoutView checkout screen
     * @param payment customer's payment information
     * @param shoppingCart customer's shopping cart
     * @param discountType discount type to be applied
     * @param discountAmount discount amount to be applied
     */
    public void performCheckout(AppData appData, List<ProductInterface> cartItems, Customer customer, CheckoutView checkoutView, Payment payment, ShoppingCart shoppingCart, String discountType, double discountAmount) {


        if (!payment.getCcv().isEmpty() && !payment.getCardNumber().isEmpty() && !payment.getExpirationMonth().isEmpty()) {


            if (discountType.equals("Percent")) {
                shoppingCart.applyDiscount(new PercentDiscount(), discountAmount);

            } else if (discountType.equals("Flat")) {
                shoppingCart.applyDiscount(new FlatDiscount(), discountAmount);
            }

            double totalPrice = shoppingCart.getTotalPrice();

            for (ProductInterface item : cartItems) {
                // Retrieve the seller from each product
                Seller seller = item.getSellerAccount();

                // Create a separate transaction for each product
                Transaction transaction = new Transaction(customer, seller, List.of(item));

                // Add the transaction to the seller's financial history
                seller.getFinancialHistory().addTransaction(transaction);

                // Remove each product from the seller's inventory
                item.oneSale();
            }

            payment.chargeCard(totalPrice);

            // Clear the customer's shopping cart after checkout
            customer.getShoppingCart().clearCart();

            // Display a confirmation message
            JOptionPane.showMessageDialog(checkoutView, "Checkout successful for " + String.format("%.2f", totalPrice) + "!");
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
