package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class InventoryController {

    public void dashboardClick(AppData appData, User user, InventoryView inventoryView) {
        DataManager.saveData(appData);
        new DashboardView(appData, user);
        inventoryView.dispose();
    }

    public void productClick(AppData appData, Product product, User user) {
        new ProductView(appData, product, user);
    }

    public void goToCartClick(AppData appData, User user, ShoppingCart shoppingCart, InventoryView inventoryView) {
        DataManager.saveData(appData);
        new ShoppingCartView(appData, shoppingCart, user);
        inventoryView.dispose();
    }
}
