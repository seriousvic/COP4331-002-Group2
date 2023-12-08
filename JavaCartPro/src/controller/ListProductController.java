package JavaCartPro.src.controller;

import JavaCartPro.src.model.AppData;
import JavaCartPro.src.model.DataManager;
import JavaCartPro.src.model.Seller;

/**
 * controller for the product list
 */
public class ListProductController {
    /**
     * function to add a product to the product list
     * @param appData data stored by the program
     * @param sellerAccount seller adding a product
     * @param seller seller's name
     * @param name product name
     * @param description product description
     * @param cost product cost
     * @param price product price
     * @param stock product stock
     */
    public void listProductClick(AppData appData, Seller sellerAccount, String seller, String name, String description, double cost, double price, int stock) {
        appData.addProduct(sellerAccount, seller, name, description, cost, price, stock);
        DataManager.saveData(appData);
    }
}
