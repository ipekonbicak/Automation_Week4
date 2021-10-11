package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Basket {
    public String orderId;
    public double totalPrice;
    public String clientId;
    public double totalPriceWithoutSale;
    public int deliveryFee = 2;
    public int amountForDiscount = 100;
    public List<Product> productList = new ArrayList<>();

    //create basket for the first time for an user.
    public Basket(double totalPrice, double totalPriceWithoutSale, String clientId) {
        this.orderId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.totalPrice = totalPrice;
        this.totalPriceWithoutSale = totalPriceWithoutSale;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPriceWithoutSale() {
        return totalPriceWithoutSale;
    }

    public void setTotalPriceWithoutSale(double totalPriceWithoutSale) {
        this.totalPriceWithoutSale = totalPriceWithoutSale;
    }

    public int getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(int deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    //adding product to a clients basket.
    public void addProduct(int number, Product product, Client client){
        MainMenu m = new MainMenu();
        int i = 0;
        //amount is a total price of added product amount.
        double amountDiscounted = (product.getDiscountedPrice() * number);
        double amountWithoutDiscounted = (product.getPrice() * number);

        //If client did not have a basket, create basket for relevant client.
        if(client.basket == null){
            Basket basket = new Basket((amountDiscounted * (1 + product.getKDVratio())),(amountWithoutDiscounted * (1 + product.getKDVratio())), client.userId);
            client.setBasket(basket);
            basket.productList.add(product);
            //KDV Formula KDV hariç ürün fiyatı × (1+KDV oranı)
            client.basket.productList.get(0).setAmountWithKDV( (amountDiscounted * (1 + product.getKDVratio())));
            client.basket.productList.get(0).setBasketPrice(amountDiscounted * (1 + product.getKDVratio()));
            client.basket.productList.get(0).setAmount(number);


        //If user has a basket already add new product to that basket or update existing product price.
        }else{
            for (Product p: client.basket.productList) {
                client.basket.setTotalPriceWithoutSale( client.basket.getTotalPrice() + (amountWithoutDiscounted * (1 + product.getKDVratio())));
                client.basket.setTotalPrice(client.basket.getTotalPrice() + (amountDiscounted * (1 + product.getKDVratio())));
                //If the added product already exist in the basket, the necessary information of the product is updated in the following if block.
                if(product.name == p.name){
                    amountDiscounted = p.getBasketPrice() + amountDiscounted;
                    p.setAmount(number + p.getAmount());
                    p.setAmountWithKDV( (amountDiscounted * (1 + product.getKDVratio())) );
                    p.setBasketPrice(p.getAmountWithKDV());
                    break;

               //If a second product is added to the cart, it is added in the else block below.
                }else{
                    p.setAmountWithKDV( (amountDiscounted * (1 + product.getKDVratio())) );
                    p.setBasketPrice(p.getAmountWithKDV());
                    client.basket.productList.add(p);
                    break;
                }

            }

        }

        for (Product p: client.basket.productList) {
            //The total product price is divided by the unit product price and the number of products added to the cart is found.
            if(product.name == p.name){
                System.out.println("Product Name: " + product.name + "\nProduct Price: " +product.price+ "\nProduct discounted price " +product.getBasketPrice()+
                        "\nTotal price for this product (KDV included): " +product.basketPrice);
            }
        }
        m.choose(client);
    }

    //show client's basket
    public void seeBasket(Client client){
        MainMenu m = new MainMenu();
        //Basket information is shown to the user.
        if(client.basket != null){

            //print products in basket.
            System.out.println("::::::: PRODUCTS :::::::");
            for (Product p: client.basket.productList) {
                //The total product price is divided by the unit product price and the number of products added to the cart is found.
                System.out.println("Product Name: " + p.name + " Product Count " + p.amount + " KDV: " +p.KDVratio+
                        " Total price for this product (KDV included): " +p.basketPrice);
            }

            //Fee checks.
            if(client.basket.getTotalPrice() >= 100) {
                client.basket.setDeliveryFee(0);
            }else {
                client.basket.setDeliveryFee(5);
            }

            //Basket total price transactions.
            System.out.println(" Total Basket Price (KDV included): " +client.basket.getTotalPrice() + client.basket.getDeliveryFee()+ " Delivery Fee: " +client.basket.getDeliveryFee()+ " Earned discount amount: " +(client.basket.getTotalPriceWithoutSale() - client.basket.getTotalPrice()));
        }else{
            //If there is no basket created by the user before, a warning will appear on the screen.
            System.out.println("You don't have a Basket. Please add product to create.");
        }
        m.choose(client);
    }

}
