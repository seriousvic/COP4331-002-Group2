package JavaCartPro.src.controller;

import JavaCartPro.src.model.*;
import JavaCartPro.src.ui.*;

/**
 * controller for the product discount class
 */
public class ProductDiscountController {
    /**
     * function to apply a percent-based discount
     * @param appData data stored by the program
     * @param user user applying a discount
     * @param quantity quantity of discounts applied
     * @param product product being discounted
     * @param discount discount being applied
     * @param shoppingCartView shopping cart screen
     * @param productDiscountView product discount screen
     */
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

    /**
     * function to apply a flat discount
     * @param appData data stored by the program
     * @param user user applying a discount
     * @param quantity quantity of discounts applied
     * @param product product being discounted
     * @param discount discount being applied
     * @param shoppingCartView shopping cart screen
     * @param productDiscountView product discount screen
     */
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
