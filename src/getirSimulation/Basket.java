package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Basket {
    public String orderId;
    public double totalPrice;
    public String clientId;
    public List<Product> productList = new ArrayList<>();

    //create basket for the first time for an user.
    public Basket(double totalPrice, String clientId) {
        this.orderId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //adding product to a clients basket.
    public void addProduct(int number, Product product, Client client){
        MainMenu m = new MainMenu();
        int i = 0;
        //amount is a total price of added product amount.
        double amount = (product.getDiscountedPrice() * number);

        //If client did not have a basket, create basket for relevant client.
        if(client.basket == null){
            Basket basket = new Basket(amount, client.userId);
            client.setBasket(basket);
            basket.productList.add(product);
            client.basket.productList.get(0).setBasketPrice(amount);
            client.basket.productList.get(0).setAmount(number);

        //If user has a basket already add new product to that basket or update existing product price.
        }else{
            for (Product p: client.basket.productList) {
                client.basket.setTotalPrice( client.basket.getTotalPrice() + amount);
                //If the added product already exist in the basket, the necessary information of the product is updated in the following if block.
                if(product.name == p.name){
                    amount = p.getBasketPrice() + amount;
                    p.setAmount(number + p.getAmount());
                    p.setBasketPrice(amount);
                    break;

               //If a second product is added to the cart, it is added in the else block below.
                }else{
                    p.setBasketPrice(amount);
                    client.basket.productList.add(product);
                    break;
                }

            }

        }

        for (Product p: client.basket.productList) {
            //The total product price is divided by the unit product price and the number of products added to the cart is found.
            if(product.name == p.name){
                System.out.println("Product Name: " + product.name + "\nProduct Price: " +product.price+ "\nProduct discounted price " +product.getBasketPrice()+
                        "\nTotal price for this product: " +product.basketPrice);
            }
        }
        m.choose(client);
    }

    //show client's basket
    public void seeBasket(Client client){
        MainMenu m = new MainMenu();
        //Basket information is shown to the user.
        if(client.basket != null){
            System.out.println("::::::: PRODUCTS :::::::");
            for (Product p: client.basket.productList) {
                //The total product price is divided by the unit product price and the number of products added to the cart is found.
                System.out.println("Product Name: " + p.name + " Product Count " + p.amount +
                        " Total price for this product: " +p.basketPrice);
            }
            System.out.println("Total Basket Price: " + client.basket.totalPrice);
        }else{
            //If there is no basket created by the user before, a warning will appear on the screen.
            System.out.println("You don't have a Basket. Please add product to create.");
        }
        m.choose(client);
    }

}
