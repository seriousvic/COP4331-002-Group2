package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for shopping cart screen
 */
public class ShoppingCartController {
    /**
     * function to remove a product from the cart
     * @param appData data stored by the program
     * @param product product to be removed
     * @param user user removing the product
     */
    public void removeFromCartClick(AppData appData, ProductInterface product, Customer user) {
       // ProductInterface product, int quantity
        int quantity = user.getShoppingCart().getQuantity(product);
        user.getShoppingCart().removeProduct(product, quantity);
        DataManager.saveData(appData);
    }

    /**
     * function to display the product clicked window
     * @param appData data stored by the program
     * @param product product clicked
     * @param user user who clicked the product
     * @param shoppingCartView shopping cart screen
     */
    public void productClick(AppData appData, ProductInterface product, User user, ShoppingCartView shoppingCartView) {
        if (product instanceof Product) {
            Product regularProduct = (Product) product;
            new ProductView(appData, regularProduct, user).setVisible(true);
        } else if (product instanceof FlatProductDecorator || product instanceof PercentageProductDecorator) {
            ProductInterface decoratedProduct = (ProductInterface) product;
            new ProductView(appData, decoratedProduct, user).setVisible(true);
        } else if (product instanceof BundleProduct) {
            BundleProduct bundleProduct = (BundleProduct) product;
            new BundleProductView(appData, bundleProduct, user, shoppingCartView).setVisible(true);
        }
    }

    /**
     * function to update a product's quantity
     * @param appData data stored by the program
     * @param product product being updated
     * @param quantity new quantity
     * @param user user updating product
     */
    public void updateQuantityClick(AppData appData, ProductInterface product, int quantity, Customer user) {
        ShoppingCart shoppingCart = user.getShoppingCart();
        int currentQuantity = shoppingCart.getQuantity(product);
        if (quantity > currentQuantity) {
            shoppingCart.addProduct(product, quantity - currentQuantity);
        } else if (quantity < currentQuantity) {
            shoppingCart.removeProduct(product, currentQuantity - quantity);
        }
        DataManager.saveData(appData);
    }

    /**
     * function to return to dashboard
     * @param appData data stored by the program
     * @param user user returning to dashboard
     * @param shoppingCartView shopping cart screen
     */
    public void dashboardClick(AppData appData, User user, ShoppingCartView shoppingCartView) {
        DataManager.saveData(appData);
        new DashboardView(appData, user);
        shoppingCartView.dispose();
    }
    /**
     * function to go to inventory screen
     * @param appData data stored by the program
     * @param user user viewing inventory
     * @param shoppingCartView shopping cart screen
     */
    public void goToInventoryClick(AppData appData, User user, ShoppingCartView shoppingCartView) {
        DataManager.saveData(appData);
        new InventoryView(appData, user);
        shoppingCartView.dispose();
    }

    /**
     * function to go to checkout screen
     * @param appData data stored by the program
     * @param shoppingCartView shopping cart screen
     * @param user customer checking out
     */
    public void goToCheckoutClick(AppData appData, ShoppingCartView shoppingCartView, Customer user) {
        DataManager.saveData(appData);
        new CheckoutView(appData, user);
        shoppingCartView.dispose();
    }

    /**
     * function to apply a discount
     * @param appData data stored by the program
     * @param product product being discounted
     * @param user user discounting a product
     * @param shoppingCartView shopping cart screen
     */
    public void applyDiscountClick(AppData appData, ProductInterface product, Customer user, ShoppingCartView shoppingCartView) {
        new ProductDiscountView(appData, product, user, shoppingCartView).setVisible(true);
    }
}
