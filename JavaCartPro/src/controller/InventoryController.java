package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for the inventory class
 */
public class InventoryController {
    /**
     * function to return to dashboard
     * @param appData data stored by the program
     * @param user user returning to dashboard
     * @param inventoryView inventory screen
     */
    public void dashboardClick(AppData appData, User user, InventoryView inventoryView) {
        DataManager.saveData(appData);
        new DashboardView(appData, user);
        inventoryView.dispose();
    }

    /**
     * function to open product view
     * @param appData data stored by the program
     * @param product product being clicked
     * @param user user clicking product
     */
    public void productClick(AppData appData, ProductInterface product, User user) {
        new ProductView(appData, product, user);
    }

    /**
     * function to go to shopping cart
     * @param appData data stored by the program
     * @param user customer viewing shopping cart
     * @param shoppingCart customer's shopping cart
     * @param inventoryView inventory screen
     */
    public void goToCartClick(AppData appData, User user, ShoppingCart shoppingCart, InventoryView inventoryView) {
        DataManager.saveData(appData);
        new ShoppingCartView(appData, shoppingCart, user);
        inventoryView.dispose();
    }

    /**
     * function to remove a product
     * @param appData data stored by the program
     * @param seller seller removing a product
     * @param product product being removed
     * @param inventoryView inventory screen
     */
    public void removeProductClick(AppData appData, Seller seller, Product product, InventoryView inventoryView) {
        appData.getInventory().removeProduct(product.getName(), seller.getUsername());
        DataManager.saveData(appData);
        inventoryView.refreshView();
    }
}
