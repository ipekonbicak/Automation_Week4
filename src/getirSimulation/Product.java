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
    public List<Product> productList = new ArrayList<>();

    public Product(String name, Double price, String categoryName, String subCategoryName, String description) {
        this.productId =  UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.discountedPrice = 0;
        this.categoryName = categoryName;
        this.subCategory = subCategoryName;
        this.description = description;

    }

    public void createCategoryByDefault(){

        //burada Id tutulması gerekiyor.
        Product product = new Product("Elma", 5.0,"Meyve", "-", "açıklama");
        productList.add(product);
        //this.registersProducts(product);
        product = new Product("Armut", 8.34, "Meyve", "-", "açıklama");
        productList.add(product);
        product = new Product("Doritos", 10.2, "Atıştırmalıklar", "Cips", "açıklama");
        productList.add(product);
        product = new Product("Pringles", 16.0, "Atıştırmalıklar", "Cips", "açıklama");
        productList.add(product);
        product = new Product("Milka", 5.0, "Atıştırmalıklar", "Çikolata", "açıklama");
        productList.add(product);
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
