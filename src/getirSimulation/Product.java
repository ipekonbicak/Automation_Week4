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
    public int amount;
    public List<Product> productList = new ArrayList<>();

    public Product(String name, Double price, String categoryName, String subCategoryName, String description) {
        this.productId =  UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.discountedPrice = 10;
        this.categoryName = categoryName;
        this.subCategory = subCategoryName;
        this.description = description;
        this.basketPrice = discountedPrice;
        this.amount = 0;

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

    public void createCategoryByDefault(){
        Product product;
        //burada Id tutulması gerekiyor.
        product = new Product("Elma", 5.0,"Meyve", "-", "açıklama");
        productList.add(product);
        //this.registersProducts(product);
        product = new Product("Armut", 8.34, "Meyve", "-", "açıklama");
        productList.add(product);
        product = new Product("Üzüm", 8.34, "Meyve", "-", "açıklama");
        productList.add(product);

        product = new Product("Domates", 5.0,"Sebze", "-", "açıklama");
        productList.add(product);
        //this.registersProducts(product);
        product = new Product("Biber", 8.34, "Sebze", "-", "açıklama");
        productList.add(product);
        product = new Product("Patlıcan", 8.34, "Sebze", "-", "açıklama");
        productList.add(product);

        product = new Product("Lays", 10.2, "Atıştırmalıklar", "Cips", "açıklama");
        productList.add(product);
        product = new Product("Doritos", 16.0, "Atıştırmalıklar", "Cips", "açıklama");
        productList.add(product);
        product = new Product("Ruffles", 5.0, "Atıştırmalıklar", "Cips", "açıklama");
        productList.add(product);

        product = new Product("Tadelle", 10.2, "Atıştırmalıklar", "Çikolata", "açıklama");
        productList.add(product);
        product = new Product("Albeni", 16.0, "Atıştırmalıklar", "Çikolata", "açıklama");
        productList.add(product);
        product = new Product("Metro", 5.0, "Atıştırmalıklar", "Çikolata", "açıklama");
        productList.add(product);
        product = new Product("Hobby", 5.0, "Atıştırmalıklar", "Çikolata", "açıklama");
        productList.add(product);

        product = new Product("Tam Yağlı", 5.0, "Kahvaltılık", "Süt", "açıklama");
        productList.add(product);
        product = new Product("Az Yağlı", 5.0, "Kahvaltılık", "Süt", "açıklama");
        productList.add(product);
        product = new Product("Laktozsuz", 5.0, "Kahvaltılık", "Süt", "açıklama");
        productList.add(product);

        product = new Product("Kaşar", 5.0, "Kahvaltılık", "Şarküteri", "açıklama");
        productList.add(product);
        product = new Product("Peynir", 5.0, "Kahvaltılık", "Şarküteri", "açıklama");
        productList.add(product);
        product = new Product("Salam", 5.0, "Kahvaltılık", "Şarküteri", "açıklama");
        productList.add(product);
        product = new Product("Sucuk", 5.0, "Kahvaltılık", "Şarküteri", "açıklama");
        productList.add(product);
        product = new Product("Zeytin", 5.0, "Kahvaltılık", "Şarküteri", "açıklama");
        productList.add(product);

    }

}
