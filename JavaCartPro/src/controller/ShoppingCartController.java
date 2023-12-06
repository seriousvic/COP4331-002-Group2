package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class ShoppingCartController {

    public void removeFromCartClick(AppData appData, ProductInterface product, Customer user) {
       // ProductInterface product, int quantity
        int quantity = user.getShoppingCart().getQuantity(product);
        user.getShoppingCart().removeProduct(product, quantity);
        DataManager.saveData(appData);
    }

    public void productClick(AppData appData, ProductInterface product, User user, ShoppingCartView shoppingCartView) {
        if (product instanceof Product) {
            Product regularProduct = (Product) product;
            new ProductView(appData, regularProduct, user).setVisible(true);
        } else if (product instanceof BundleProduct) {
            BundleProduct bundleProduct = (BundleProduct) product;
            new BundleProductView(appData, bundleProduct, user, shoppingCartView).setVisible(true);
        }
    }
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
    public void dashboardClick(AppData appData, User user, ShoppingCartView shoppingCartView) {
        DataManager.saveData(appData);
        new DashboardView(appData, user);
        shoppingCartView.dispose();
    }

    public void goToInventoryClick(AppData appData, User user, ShoppingCartView shoppingCartView) {
        DataManager.saveData(appData);
        new InventoryView(appData, user);
        shoppingCartView.dispose();
    }
}
