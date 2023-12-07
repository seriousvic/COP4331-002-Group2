package JavaCartPro.src.controller;

import JavaCartPro.src.model.AppData;
import JavaCartPro.src.model.DataManager;
import JavaCartPro.src.model.Seller;

public class ListProductController {
    public void listProductClick(AppData appData, Seller sellerAccount, String seller, String name, String description, double price, int stock) {
        appData.addProduct(sellerAccount, seller, name, description, price, stock);
        DataManager.saveData(appData);
    }
}
