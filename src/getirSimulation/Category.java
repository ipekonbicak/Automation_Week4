package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {
    public String categoryId;
    public String name;
    public List<Category> categoryList = new ArrayList<>();
    String[] categoryNameArray = {"Meyve & Sebze","Atıştırmalık","Kahvaltılık"};
    public Category(String name) {
        this.categoryId = UUID.randomUUID().toString();
        this.name = name;
    }

    public void createCategoryByDefault(){
        Category category;
        for(int i = 0; i < categoryNameArray.length; i++){
            category =  new Category(categoryNameArray[i]);
            this.categoryList.add(category);
        }
    }
}
