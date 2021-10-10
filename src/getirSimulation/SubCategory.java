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
        SubCategory subCategory;

        subCategory = new SubCategory("Meyve", "Meyve & Sebze");
        this.subCategoryList.add(subCategory);
        subCategory = new SubCategory("Sebze", "Meyve & Sebze");
        this.subCategoryList.add(subCategory);
        subCategory = new SubCategory("Cips", "Atıştırmalık");
        this.subCategoryList.add(subCategory);
        subCategory = new SubCategory("Çikolata", "Atıştırmalık");
        this.subCategoryList.add(subCategory);
        subCategory = new SubCategory("Süt", "Kahvaltılık");
        this.subCategoryList.add(subCategory);
        subCategory = new SubCategory("Şarküteri", "Kahvaltılık");
        this.subCategoryList.add(subCategory);
    }

}
