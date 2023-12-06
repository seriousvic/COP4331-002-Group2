package JavaCartPro.src.controller;

import JavaCartPro.src.model.AppData;
import JavaCartPro.src.model.DataManager;

public class ListProductController {
    public void listProductClick(AppData appData, String seller, String name, String description, double price, int stock) {
        appData.addProduct(seller, name, description, price, stock);
        DataManager.saveData(appData);
    }


}
