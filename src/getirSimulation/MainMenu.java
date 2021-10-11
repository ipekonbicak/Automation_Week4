package getirSimulation;
import java.util.Scanner;

public class MainMenu {

    Category category;
    SubCategory subCategory;
    Product product;
    Basket basket;
    Scanner scn = new Scanner(System.in);
    String choosen;
    int i = 0;

    public MainMenu() {
        category = new Category("");
        subCategory = new SubCategory("", "");
        product = new Product("", 0.0, 0.0,"", "","",0.0);
        basket = new Basket(0.0, 0.0,"");

         /*Since the system is not connected to a Database, I created products that are created and
                kept registered within the program run time so that I can see the program is running.
                 */
        category.createCategoryByDefault();
        subCategory.cretaeSubCategoryByDefault();
        product.createCategoryByDefault();
    }

    //list categories
    public void mainMenu(Client client){
        System.out.println("\n **************** Product Categories ****************");
                /* To get the category names, I pulled the category names from the category
                list I created in the category class.
                 */
        for (Category c: category.categoryList) {
            System.out.println(c.name);
        }

        this.choose(client);

    }

    //list subcategory belongs to related category
    public void listSubCategory(String choosen, Client client){
        for (SubCategory subCategory: subCategory.subCategoryList){

            /* The category name selected by the user is
            checked and the sub-categories of that category are listed.
            */
            System.out.println("choosen " +choosen+ " cName: " +subCategory.categoryName);
            if(choosen.equals(subCategory.categoryName)){
                System.out.println(" - " +subCategory.name);
            }
            i++;
        }
        i = 0;
        this.choose(client);
    }

    //list products belongs to related subcategory
    public void listProduct(String name){
        for(int y = 0; y < product.productList.size(); y++){
            if(product.productList.get(y).subCategory.equals(name)){
                System.out.println(" - Product Name: " +product.productList.get(y).name+ "  Price: " +product.productList.get(y).price+ " Discounted Price:  " +product.productList.get(y).discountedPrice);
            }
        }
    }


    //I wanted this place to be opened after every transaction in the form of a menu.
    public void choose(Client client){
        System.out.println("\n");
        System.out.println("**** Menu *** \n" +
                " Press 'CL' to turn back to Categories \n" +
                " Press 'SL' to list SubCategories \n" +
                " Press 'SP' to search \n Press 'P' add product to Basket " +
                "\n Press 'SB' to show your Basket." +
                "\n Press 'L' to turn back to landing page" +
                "\n Press 'PL' to list subcategories' products.");
        choosen = scn.next();
        Scanner scanner = new Scanner(System.in);
        switch (choosen){
            case "SB":
                basket.seeBasket(client);
                break;
            case "P":
                Product p = new Product("", 0.0, 0.0, "", "","",0.0);;
                System.out.println("Enter the name of the product you want to add.");
                String productName = scanner.next();
                for(int y = 0; y < product.productList.size(); y++){
                    if(productName.equals(product.productList.get(y).name)){
                        p = product.productList.get(y);
                        System.out.println("Product Name: " +product.productList.get(y).name+ "\nPrice: " +product.productList.get(y).price+
                                "\nDiscounted price: " +product.productList.get(y).discountedPrice+
                                "\nDescription: " +product.productList.get(y).description);
                    }
                }

                System.out.println("Please enter the quantity of the product you want to buy.");
                int number = scanner.nextInt();
                basket.addProduct(number, p, client);
                break;
            case "CL":
                this.mainMenu(client);
            case "SL":
                System.out.println("\nChoose Category for seeing SubCategory");
                choosen  = scn.next();
                this.listSubCategory(choosen,client);
            case "L":
                LandingPage landingPage = new LandingPage();
                landingPage.landingPage(client);
            case "PL":
                System.out.println("\nChoose SubCategory for seeing Products");
                choosen  = scn.next();
                this.listProduct(choosen);
            default:
                break;

        }
    }
}
