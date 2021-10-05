package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {
    public String orderId;
    public double totalPrice;
    public String clientId;
    public Product product;
    public String productName;
    public List<Product> productList = new ArrayList<>();

    public Basket(double totalPrice, String clientId, String productName, Product product) {
        this.orderId = UUID.randomUUID().toString();
        this.totalPrice = totalPrice;
        this.clientId = clientId;
        this.productName = productName;
        this.productList.add(product);
    }

    public void basket(){

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
