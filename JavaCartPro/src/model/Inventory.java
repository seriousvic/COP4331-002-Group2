package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * class representing a seller's inventory
 */
public class Inventory implements Serializable {
    /**
     * constructor
     */
    private Inventory() {
        this.products = new ArrayList<>();
    }

    /**
     * get function for inventory
     * @return global inventory
     */
    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    /**
     * add product to inventory
     * @param sellerAccount inventory's seller
     * @param seller seller's name
     * @param name product name
     * @param description product description
     * @param cost product cost
     * @param price product price
     * @param stock product stock
     */
    public void addProduct(Seller sellerAccount, String seller, String name, String description, double cost, double price, int stock){
        for (ProductInterface product : products){
            if (product.getName().equals(name) && product.getSeller().equals(seller)){
                return;
            }
        }
        Product newProduct = new Product(sellerAccount, seller, name, description, cost, price, stock);
        products.add(newProduct);
    }

    /**
     * remove a product from the inventory
     * @param name name of product
     * @param seller name of seller
     */
    public void removeProduct(String name, String seller){
        Iterator<ProductInterface> iterator = products.iterator();
        while (iterator.hasNext()){
            ProductInterface product = iterator.next();
            if (product.getName().equals(name) && product.getSeller().equals(seller)){
                iterator.remove();
                return;
            }
        }
    }

    /**
     * update a product in the inventory
     * @param seller seller to which inventory belongs
     * @param name new name
     * @param description new description
     * @param price new price
     * @param stock new stock
     */
    public void updateProduct(String seller, String name, String description, double price, int stock){
        for (ProductInterface product : products){
            if (product.getName().equals(name) && product.getSeller().equals(seller)){
                product.setDescription(description);
                product.setPrice(price);
                product.setStock(stock);
                return;
            }
        }
    }

    /**
     * get function for products
     * @return a list of products in the inventory
     */
    public List<ProductInterface> getProducts(){
        return new ArrayList<>(products);
    }

    private static final long serialVersionUID = 12345L;
    private List<ProductInterface> products;
    private static Inventory instance;
}
