package JavaCartPro.src.ui;

import JavaCartPro.src.controller.*;
import JavaCartPro.src.model.*;

import javax.swing.*;

public class ShoppingCartView extends JFrame {
    public ShoppingCartView(AppData appData, ShoppingCart shoppingCart, User user) {
        this.appData = appData;
        this.shoppingCart = shoppingCart;
        this.user = user;
        startUI();
    }

    public void startUI() {}

    private AppData appData;
    private ShoppingCart shoppingCart;
    private User user;
    private ShoppingCartController controller = new ShoppingCartController();
}
