package getirSimulation;
import java.util.Scanner;

public class MainMenu {

    Category category = new Category("");
    SubCategory subCategory = new SubCategory("", "");
    Product product = new Product("", 0.0, "", "");
    Basket basket;
    Scanner scn = new Scanner(System.in);
    String choosen;
    int i = 0;
    double price;

    public void mainMenu(Client client){
        System.out.println("\n **************** Product Categories ****************");

                /*Since the system is not connected to a Database, I created products that are created and
                kept registered within the program run time so that I can see the program is running.
                 */
        category.createCategoryByDefault();
        subCategory.cretaeSubCategoryByDefault();
        product.createCategoryByDefault();

                /* To get the category names, I pulled the category names from the category
                list I created in the category class.
                 */
        for (Category c: category.categoryList) {
            System.out.println(c.name);
            for(int y = 0; y < product.productList.size(); y++){
                if((c.name.equals(product.productList.get(y).categoryName) && product.productList.get(y).subCategory.equals("-"))){
                    System.out.println(" - Product Name: " +product.productList.get(y).name+ "  Price: " +product.productList.get(y).price);
                }
            }
        }

        this.choose(client);
        i = 0;
        System.out.println("\nChoose Category");
        choosen  = scn.next();
        this.listSubCategory(choosen);
    }

    public void listSubCategory(String choosen){
        for (SubCategory subCategory: subCategory.subCategoryList){

            /* The category name selected by the user is
            checked and the sub-categories of that category are listed. */
            if(choosen.equals(subCategory.categoryName)){
                System.out.println(" - " +subCategory.name);
            }else if((choosen.equals(product.productList.get(i).categoryName) && product.productList.get(i).subCategory.equals("-"))){
                System.out.println(" - Product Name: " +product.productList.get(i).name+ "  Price: " +product.productList.get(i).price);
            }
            i++;
        }
        i = 0;
    }

    //To add products to the Basket, view Categories again or Search.
    public void choose(Client client){
        System.out.println("Press 'A' to search \n Press 'P' add product to Basket \n Press 'S' to show your Basket.");
        choosen = scn.next();
        Scanner scanner = new Scanner(System.in);
        switch (choosen){
            case "A":
                break;
            case "P":
                System.out.println("Enter the name of the product you want to add.");
                String productName = scanner.next();
                System.out.println("Please enter the quantity of the product you want to buy.");
                int number = scanner.nextInt();

                break;
            case "S":

            default:
                break;

        }
    }
}
