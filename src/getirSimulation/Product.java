package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {
    public String productId;
    public String name;
    public double price;
    public double sale;
    public String categoryName;
    public String subCategory;
    public List<Product> productList = new ArrayList<>();

    public Product(String name, Double price, String categoryName, String subCategoryName) {
        this.productId =  UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.sale = 0;
        this.categoryName = categoryName;
        this.subCategory = subCategoryName;
    }

    public void createCategoryByDefault(){

        //burada Id tutulması gerekiyor.
        Product product = new Product("Elma", 5.0,"Meyve", "-");
        productList.add(product);
        //this.registersProducts(product);
        product = new Product("Armut", 8.34, "Meyve", "-");
        productList.add(product);
        product = new Product("Doritos", 10.2, "Atıştırmalıklar", "Cips");
        productList.add(product);
        product = new Product("Pringles", 16.0, "Atıştırmalıklar", "Cips");
        productList.add(product);
        product = new Product("Milka", 5.0, "Atıştırmalıklar", "Çikolata");
        productList.add(product);
    }
     /* public void registersProducts(Product p){
        Category category = new Category("");
        SubCategory subCategory = new SubCategory("","");

        if(p.subCategory.equals("")){
            category.productList.add(p);
        }else{
            subCategory.productList.add(p);
        }

     } */
}
