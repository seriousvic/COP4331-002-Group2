package JavaCartPro.src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * class representing a bundle of products
 */
public class BundleProduct implements ProductInterface, Serializable {
    /**
     * constructor for BundleProduct
     * @param product product to be bundled
     */
    public BundleProduct(Product product) {
        this.products.add(product);
        this.sellerAccount = product.getSellerAccount();
        this.name = product.getSeller() + "'s Product Bundle";
        this.description = "A bundle of products from " + product.getSeller() + " containing" + product.getName() + ".";
        this.cost = product.getCost();
        this.price = product.getPrice();
        this.stock = product.getStock();
        this.seller = product.getSeller();
    }

    /**
     * function to add product to a bundle
     * @param product product to be added
     */
    public void addProduct(ProductInterface product) {
        if (!products.contains(product) && product.getSeller().equals(seller)) {
            products.add(product);
            updateBundle();
        }
    }

    /**
     * function to remove a product from a bundle
     * @param product product to be removed
     */
    public void removeProduct(ProductInterface product) {
        if (products.contains(product)) {
            products.remove(product);
            updateBundle();
        }
    }

    /**
     * function to update a bundle
     */
    public void updateBundle() {
        this.setDescription("");
        this.setPrice(0.0);
        this.setStock(0);
        this.setCost(0.0);
    }

    /**
     * function to set a bundle description
     * @param description bundle description
     */
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

    /**
     * function to set a bundle's price
     * @param price bundle price
     */
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

    /**
     * function to set a cost to the seller
     * @param cost cost to be set
     */
    public void setCost(double cost){
        double sumCost = 0.0;
        for (ProductInterface product : products){
            sumCost += product.getCost();
        }
        this.price = sumCost;
    }

    /**
     * function to set a product's stock
     * @param stock new stock
     */
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

    /**
     * get function for bundle cost
     * @return bundle cost
     */
    public double getCost(){
        return this.cost;
    }

    /**
     * function to sell bundle in one sale
     */
    public void oneSale(){
        for (ProductInterface product : products){
            product.oneSale();
        }
    }

    /**
     * get function for seller
     * @return seller's name
     */
    public String getSeller(){
        return this.seller;
    }

    /**
     * get function for stock
     * @return bundle's stock
     */
    public int getStock(){
        return this.stock;
    }

    /**
     * get function for name
     * @return bundle's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * get function for price
     * @return bundle's price
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * get function for description
     * @return bundle's description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * get function for products
     * @return list of products in the bundle
     */
    public List<ProductInterface> getProducts(){
        return this.products;
    }

    /**
     * get function for seller
     * @return seller's account
     */
    public Seller getSellerAccount() {
        return this.sellerAccount;
    }
    private final Seller sellerAccount;
    private List<ProductInterface> products = new ArrayList<>();
    private double cost;
    private final String name;
    private String description;
    private double price;
    private int stock;
    private final String seller;
    private static final long serialVersionUID = 123L;
}
