package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;
public class ProductDiscountController {
    public void applyPercentDiscount(AppData appData, Customer user, int quantity, ProductInterface product, double discount, ShoppingCartView shoppingCartView, ProductDiscountView productDiscountView) {
        if (product instanceof Product){
            ProductInterface decoratedProduct = new PercentageProductDecorator(product, discount);
            user.getShoppingCart().removeProduct(product, quantity);
            user.getShoppingCart().addProduct(decoratedProduct, quantity);
            DataManager.saveData(appData);
            productDiscountView.dispose();
            shoppingCartView.refreshView();
        } else {
            System.out.println("Cannot apply discount to bundle");
        }
    }
    public void applyFlatDiscount(AppData appData, Customer user, int quantity, ProductInterface product, double discount, ShoppingCartView shoppingCartView, ProductDiscountView productDiscountView) {
        if (product instanceof Product){
            ProductInterface decoratedProduct = new FlatProductDecorator(product, discount);
            user.getShoppingCart().removeProduct(product, quantity);
            user.getShoppingCart().addProduct(decoratedProduct, quantity);
            DataManager.saveData(appData);
            productDiscountView.dispose();
            shoppingCartView.refreshView();
        } else {
            System.out.println("Cannot apply discount to bundle");
        }
    }
}
