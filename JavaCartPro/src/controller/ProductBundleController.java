package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class ProductBundleController {
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
