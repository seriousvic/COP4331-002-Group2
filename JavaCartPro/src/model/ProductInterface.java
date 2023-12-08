package JavaCartPro.src.model;

public interface ProductInterface {
    /**
     * get function for seller
     * @return seller
     */
    String getSeller();
    /**
     * get function for name
     * @return product name
     */
    String getName();
    /**
     * get function for description
     * @return product description
     */
    String getDescription();
    /**
     * get function for price
     * @return product price
     */
    void setDescription(String description);
    /**
     * get function for price
     * @return product price
     */
    double getPrice();
    /**
     * set function for price
     * @param price product price
     */
    void setPrice(double price);
    /**
     * get function for stock
     * @return product stock
     */
    int getStock();
    /**
     * set function for stock
     * @param stock product stock
     */
    void setStock(int stock);
    /**
     * get function for seller
     * @return seller
     */
    Seller getSellerAccount();
    /**
     * get function for cost
     * @return product cost
     */
    double getCost();
    /**
     * sell a product
     */
    void oneSale();
}
