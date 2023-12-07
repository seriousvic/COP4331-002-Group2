package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class ProductController {
    public void addToCartClick(AppData appData, ProductInterface product, int quantity, ShoppingCart shoppingCart){
        boolean alreadyContainsDiscountedProduct = shoppingCart.getItems().stream()
                .anyMatch(cartItem ->
                        cartItem.getName().equals(product.getName()) &&
                                cartItem.getSeller().equals(product.getSeller()) &&
                                cartItem instanceof ProductDecorator
                );
        if (!alreadyContainsDiscountedProduct) {
            int currentQuantity = shoppingCart.getQuantity(product);
            int totalQuantity = currentQuantity + quantity;
            if (shoppingCart.getItems().contains(product)) {
                if (totalQuantity > product.getStock()) {
                    shoppingCart.addProduct(product, product.getStock() - currentQuantity);
                } else {
                    shoppingCart.addProduct(product, quantity);
                }
            } else {
                shoppingCart.addProduct(product, quantity);
            }
            DataManager.saveData(appData);
        }
    }
    public void addToBundleClick(AppData appData, ProductInterface productInterface, ShoppingCart shoppingCart) {
        if (!(productInterface instanceof Product)) {
            return;
        }
        Product product = (Product) productInterface;
        BundleProduct bundleProduct = null;
        for (ProductInterface item : shoppingCart.getItems()) {
            if (item instanceof BundleProduct && item.getSeller().equals(product.getSeller())) {
                bundleProduct = (BundleProduct) item;
                break;
            }
        }

        if (bundleProduct != null) {
            if (!bundleProduct.getProducts().contains(product)) {
                bundleProduct.addProduct(product);
                DataManager.saveData(appData);
            }
        } else {
            bundleProduct = new BundleProduct(product);
            shoppingCart.addProduct(bundleProduct, 1);
            DataManager.saveData(appData);
        }
    }

    public void removeFromCartClick(AppData appData, ProductInterface product, int quantity, ShoppingCart shoppingCart){
        if (shoppingCart.getItems().contains(product)) {
            shoppingCart.removeProduct(product, quantity);
            DataManager.saveData(appData);
        }
    }

    public void updateProductClick(AppData appData, ProductInterface product, String description, double price, int stock) {
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        DataManager.saveData(appData);
    }
}
