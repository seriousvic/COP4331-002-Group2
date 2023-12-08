package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for the product bundle class
 */
public class ProductBundleController {
    /**
     * function to remove a product from a bundle
     * @param appData data stored by the program
     * @param user user removing a product
     * @param productBundle bundle being removed from
     * @param product product being removed
     * @param shoppingCartView shopping cart screen
     * @param bundleProductView bundle product screen
     */
        public void removeFromBundleClick(AppData appData, Customer user, BundleProduct productBundle, ProductInterface product, ShoppingCartView shoppingCartView, BundleProductView bundleProductView) {
            productBundle.removeProduct(product);
            if (productBundle.getProducts().size() == 0) {
                user.getShoppingCart().removeProduct(productBundle, 1);
                bundleProductView.dispose();
            }
            shoppingCartView.refreshView();
            DataManager.saveData(appData);
        }
}
