package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

public class ProductController {
    public void addToCartClick(ProductInterface product, int quantity, ShoppingCart shoppingCart){
        shoppingCart.addProduct(product, quantity);
    }
    public void addToBundleClick(ProductInterface productInterface, ShoppingCart shoppingCart) {
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
            }
        } else {
            bundleProduct = new BundleProduct(product);
            shoppingCart.addProduct(bundleProduct, 1);
        }
    }

    public void removeFromCartClick(ProductInterface product, int quantity, ShoppingCart shoppingCart){
        shoppingCart.removeProduct(product, quantity);
    }

    public void updateProductClick(Product product, String description, double price, int stock) {
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
    }
}
