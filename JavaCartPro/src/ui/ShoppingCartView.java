package JavaCartPro.src.ui;

import JavaCartPro.src.controller.*;
import JavaCartPro.src.model.*;

public class ShoppingCartView {
    public ShoppingCartView(ShoppingCart shoppingCart, User user) {
        this.shoppingCart = shoppingCart;
        this.user = user;
        startUI();
    }


    private ShoppingCart shoppingCart;
    private User user;
    private ShoppingCartController controller = new ShoppingCartController();
}
