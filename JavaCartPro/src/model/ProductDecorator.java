package JavaCartPro.src.model;

public abstract class ProductDecorator implements ProductInterface{

    public ProductDecorator(ProductInterface product){
        this.product = product;
    }

    public double getPrice() {
        return product.getPrice();
    }

    public String getSeller() {
        return product.getSeller();
    }

    public String getName() {
        return product.getName();
    }

    public int getStock() {
        return product.getStock();
    }

    public String getDescription() {
        return product.getDescription();
    }

    public void setPrice(double price) {
        product.setPrice(price);
    }

    public void setStock(int stock) {
        product.setStock(stock);
    }

//    public void setName(String name) {
//        product.setName(name);
//    }

    public void setDescription(String description) {
        product.setDescription(description);
    }

    protected ProductInterface product;
}
