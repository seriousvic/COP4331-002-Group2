package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BundleProduct implements ProductInterface, Serializable {

    public BundleProduct(Product product) {
        this.products.add(product);
        this.name = product.getSeller() + "'s Product Bundle";
        this.description = "A bundle of products from " + product.getSeller() + " containing" + product.getName() + ".";
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.seller = product.getSeller();
    }

    public void addProduct(ProductInterface product) {
        if (!products.contains(product) && product.getSeller().equals(seller)) {
            products.add(product);
            updateBundle();
        }
    }

    public void removeProduct(ProductInterface product) {
        if (products.contains(product)) {
            products.remove(product);
            updateBundle();
        }
    }

    public void updateBundle() {
        this.setDescription("");
        this.setPrice(0.0);
        this.setStock(0);
    }

    public void setDescription(String description){
        if (products.isEmpty()){
            this.description = "Empty Bundle for seller " + this.seller + ".";
            return;
        }
        StringBuilder newDescription = new StringBuilder("A bundle of products from " + this.seller);

        if (products.size() == 1){
            newDescription.append(" containing ").append(products.get(0).getName()).append(".");
            this.description = newDescription.toString();
            return;
        }
        newDescription.append(" with a 5% discount containing");
        for (ProductInterface product : products){
            newDescription.append(" ").append(product.getName()).append(",");
        }
        newDescription.setLength(newDescription.length() - 1);
        newDescription.append(".");
        this.description = newDescription.toString();
    }

    public void setPrice(double price){
        double sumPrice = 0.0;
        for (ProductInterface product : products){
            sumPrice += product.getPrice();
        }
        if (products.size() > 1){
            sumPrice *= 0.95;
        }
        this.price = sumPrice;
    }

    public void setStock(int stock){
        if (products.isEmpty()){
            this.stock = 0;
        }
        int minStock = Integer.MAX_VALUE;
        for (ProductInterface product : products){
            if (product.getStock() < minStock){
                minStock = product.getStock();
            }
        }
        this.stock = minStock;
    }


    public String getSeller(){
        return this.seller;
    }

    public int getStock(){
        return this.stock;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getDescription(){
        return this.description;
    }

    public List<ProductInterface> getProducts(){
        return this.products;
    }


    private List<ProductInterface> products = new ArrayList<>();
    private final String name;
    private String description;
    private double price;
    private int stock;
    private final String seller;
    private static final long serialVersionUID = 123L;
}
