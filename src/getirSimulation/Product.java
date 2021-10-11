package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {
    public String productId;
    public String name;
    public double price;
    public double discountedPrice;
    public String categoryName;
    public String subCategory;
    public String description;
    public double basketPrice;
    public double KDVratio;
    public int amount;
    public double amountWithKDV;
    public List<Product> productList = new ArrayList<>();

    public Product(String name, Double price, Double discountedPrice, String categoryName, String subCategoryName, String description, double KDVratio) {
        this.productId =  UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.categoryName = categoryName;
        this.subCategory = subCategoryName;
        this.description = description;
        this.basketPrice = discountedPrice;
        this.amount = 0;
        this.amountWithKDV = 0.0;
        this.KDVratio = KDVratio;

    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public double getBasketPrice() {
        return basketPrice;
    }

    public void setBasketPrice(double basketPrice) {
        this.basketPrice = basketPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setAmountWithKDV(double amountWithKDV) {
        this.amountWithKDV = amountWithKDV;
    }

    public double getAmountWithKDV() {
        return amountWithKDV;
    }

    public double getKDVratio() {
        return KDVratio;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //creating product that are wanted.
    public void createCategoryByDefault(){
        Product product;
        //burada Id tutulması gerekiyor.
        product = new Product("Elma", 5.8,4.8, "Meyve", "-", "açıklama", 0.18);
        productList.add(product);
        //this.registersProducts(product);
        product = new Product("Armut", 10.34, 8.9, "Meyve", "-", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Üzüm", 40.34, 3.0,"Meyve", "-", "açıklama", 0.18);
        productList.add(product);

        product = new Product("Domates", 28.0,8.5,"Sebze", "-", "açıklama", 0.1);
        productList.add(product);
        //this.registersProducts(product);
        product = new Product("Biber", 12.34, 2.0, "Sebze", "-", "açıklama", 0.1);
        productList.add(product);
        product = new Product("Patlıcan", 18.54,11.1, "Sebze", "-", "açıklama", 0.1);
        productList.add(product);

        product = new Product("Lays", 10.2, 12.5,"Atıştırmalıklar", "Cips", "açıklama",0.3);
        productList.add(product);
        product = new Product("Doritos", 26.0,17.0, "Atıştırmalıklar", "Cips", "açıklama",0.3);
        productList.add(product);
        product = new Product("Ruffles", 25.0, 10.0,"Atıştırmalıklar", "Cips", "açıklama", 0.3);
        productList.add(product);

        product = new Product("Tadelle",  23.4, 10.2, "Atıştırmalıklar", "Çikolata", "açıklama", 0.3);
        productList.add(product);
        product = new Product("Albeni", 21.0, 20.0,"Atıştırmalıklar", "Çikolata", "açıklama", 0.3);
        productList.add(product);
        product = new Product("Metro", 15.0, 13.0,"Atıştırmalıklar", "Çikolata", "açıklama", 0.3);
        productList.add(product);
        product = new Product("Hobby", 15.0, 14.2, "Atıştırmalıklar", "Çikolata", "açıklama", 0.3);
        productList.add(product);

        product = new Product("Tam Yağlı", 15.0, 5.7,"Kahvaltılık", "Süt", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Az Yağlı", 15.0, 7.7,"Kahvaltılık", "Süt", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Laktozsuz", 15.0, 10.0, "Kahvaltılık", "Süt", "açıklama", 0.18);
        productList.add(product);

        product = new Product("Kaşar", 15.0, 15.0,"Kahvaltılık", "Şarküteri", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Peynir", 34.0, 17.5,"Kahvaltılık", "Şarküteri", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Salam", 22.0, 13.0, "Kahvaltılık", "Şarküteri", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Sucuk", 11.0, 6.0,"Kahvaltılık", "Şarküteri", "açıklama", 0.18);
        productList.add(product);
        product = new Product("Zeytin", 15.0, 3.0,"Kahvaltılık", "Şarküteri", "açıklama", 0.18);
        productList.add(product);

    }

}
