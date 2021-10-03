package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {
    public String categoryId;
    public String name;
    public List<Category> categoryList = new ArrayList<Category>();
    public List<Product> productList = new ArrayList<Product>();
    public List<SubCategory> subCategoryList = new ArrayList<SubCategory>();

    public Category(String name) {
        this.categoryId = UUID.randomUUID().toString();
        this.name = name;
    }

    public void createCategoryByDefault(){
        Category category =  new Category("Atıştırmalıklar");
        this.categoryList.add(category);
        category = new Category("Meyve");
        this.categoryList.add(category);
    }
}
