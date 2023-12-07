package JavaCartPro.src.model;

public interface ProductInterface {
    String getSeller();
    String getName();
//    void setName(String name);
    String getDescription();
    void setDescription(String description);
    double getPrice();
    void setPrice(double price);
    int getStock();
    void setStock(int stock);
    Seller getSellerAccount();
}
