package getirSimulation;
import java.util.ArrayList;
import java.util.List;

public class SubCategory extends Category {
    public String categoryName;
    public List<SubCategory> subCategoryList = new ArrayList<SubCategory>();
    public List<Product> productList = new ArrayList<Product>();

    public SubCategory(String name, String categoryName) {
        super(name);
        this.categoryName = categoryName;
    }

    public void cretaeSubCategoryByDefault(){
        SubCategory subCategory = new SubCategory("Cips", "Atıştırmalıklar");
        this.subCategoryList.add(subCategory);
        addSubCategoryToCategory(subCategory);
        subCategory = new SubCategory("Çikolata", "Atıştırmalıklar");
        this.subCategoryList.add(subCategory);
    }

    public void addSubCategoryToCategory(SubCategory subCategory){
        Category category = new Category("");
        for(int i = 0; i < category.categoryList.size(); i++){
            if(this.categoryList.get(i).name.equals(subCategory.categoryName)){
                category.subCategoryList.add(subCategory);
            }
        }
    }
}
