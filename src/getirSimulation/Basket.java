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

    //adding product to a clients basket.
    public void basket(int number, Product product, Client client){
        MainMenu m = new MainMenu();
        double amount;
        int i = 0;
        //If client did not have a basket, create basket for relevant client.
        if(client.basket == null){
            Basket basket = new Basket(product.getDiscountedPrice() * number, client.userId);
            client.setBasket(basket);

        //If user has a basket already add new product to that basket or update existing product.
        }else{
            client.basket.setTotalPrice(client.basket.getTotalPrice() + (product.getDiscountedPrice() * number));

            for (Product p: client.basket.productList) {
                if(p.productId == product.productId){
                    amount = p.discountedPrice;
                    client.basket.productList.remove(i);
                    product.discountedPrice = amount;
                    break;
                }
                i++;
            }
        }
        this.productList.add(product);
        m.choose(client);
    }

    //show client's basket
    public void showBasket(Client client){
        MainMenu m = new MainMenu();
        int totalPrice;
        int division = 1;
        Product product = new Product("", 0.0,"","","");
        if(client.basket != null){
            System.out.println("PRODUCTS:");
            for (Product p: client.basket.productList) {
                for (Product p2: product.productList) {
                    if(p2.productId == p.productId){
                        division = (int)(p2.discountedPrice / p.discountedPrice);
                    }
                }
                System.out.println("Product Name: " + p.name + "Product Count" + division+
                        " Total price for this product: " +p.discountedPrice);
            }
            System.out.println("Total Basket Price: " + client.basket.totalPrice);
        }else{
            System.out.println("You don't have a Basket. Please add product to create.");
        }
        m.choose(client);
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
