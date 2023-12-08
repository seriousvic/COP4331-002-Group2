package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for the product class
 */
public class ProductController {
    /**
     * function to add a product to shopping cart
     * @param appData data stored by the program
     * @param product product being added
     * @param quantity quantity of product
     * @param shoppingCart customer's shopping cart
     */
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

    /**
     * function to add a product to a bundle
     * @param appData data stored by the program
     * @param productInterface product being added to the bundle
     * @param shoppingCart customer's shopping cart
     */
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

    /**
     * function to remove a product from the shopping cart
     * @param appData data stored by the program
     * @param product product being removed
     * @param quantity quantity of product being removed
     * @param shoppingCart shopping cart being removed from
     */
    public void removeFromCartClick(AppData appData, ProductInterface product, int quantity, ShoppingCart shoppingCart){
        if (shoppingCart.getItems().contains(product)) {
            shoppingCart.removeProduct(product, quantity);
            DataManager.saveData(appData);
        }
    }

    /**
     * function to update a product's information
     * @param appData data stored by the program
     * @param product product being updated
     * @param description new description
     * @param price new price
     * @param stock new stock
     */
    public void updateProductClick(AppData appData, ProductInterface product, String description, double price, int stock) {
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        DataManager.saveData(appData);
    }
}
