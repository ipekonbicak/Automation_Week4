package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {
    public String orderId;
    public double totalPrice;
    public String clientId;
    public List<Product> productList = new ArrayList<>();

    public Basket(double totalPrice, String clientId) {
        this.orderId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.totalPrice = totalPrice;
    }

    public void basket(int number, Product product, Client client){
        int toltalPrice;
        product.discountedPrice= product.getDiscountedPrice() * number;
        this.productList.add(product);
        Basket basket = new Basket(product.discountedPrice, client.userId);
        client.setBasket(basket);
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

}
