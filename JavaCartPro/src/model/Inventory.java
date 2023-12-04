package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory implements Serializable {
    private Inventory() {
        this.products = new ArrayList<>();
    }

    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addProduct(String seller, String name, String description, double price, int stock){
        for (ProductInterface product : products){
            if (product.getName().equals(name) && product.getSeller().equals(seller)){
                return;
            }
        }
        Product newProduct = new Product(seller, name, description, price, stock);
        products.add(newProduct);
    }

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

    public List<ProductInterface> getProducts(){
        return new ArrayList<>(products);
    }

    private static final long serialVersionUID = 987654321L;
    private List<ProductInterface> products;
    private static Inventory instance;
}
