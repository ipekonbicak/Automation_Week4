package getirSimulation;
import java.util.Scanner;

public class MainMenu {

    Category category = new Category("");
    SubCategory subCategory = new SubCategory("", "");
    Product product = new Product("", 0.0, "", "","");
    Basket basket = new Basket(0.0, "");
    Scanner scn = new Scanner(System.in);
    String choosen;
    int i = 0;

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

    }

    public void listSubCategory(String choosen, Client client){
        for (SubCategory subCategory: subCategory.subCategoryList){

            /* The category name selected by the user is
            checked and the sub-categories of that category are listed.
            If there is no sub category the products directly shown if the categories were listed.*/
            if(choosen.equals(subCategory.categoryName)){
                System.out.println(" - " +subCategory.name);
            }else if((choosen.equals(product.productList.get(i).categoryName) && product.productList.get(i).subCategory.equals("-"))){
                System.out.println(" - Product Name: " +product.productList.get(i).name+ "  Price: " +product.productList.get(i).price);
            }
            i++;
        }
        i = 0;
        this.choose(client);
    }

    //To add products to the Basket, view Categories again or Search.
    public void choose(Client client){
        System.out.println("**** Menu *** \n" +
                " Press 'C' to turn back to Categories \n" +
                " Press 'S' to list SubCategories \n" +
                " Press 'A' to search \n Press 'P' add product to Basket " +
                "\n Press 'S' to show your Basket.");
        choosen = scn.next();
        Scanner scanner = new Scanner(System.in);
        switch (choosen){
            case "A":
                break;
            case "P":
                Product p = new Product("", 0.0, "", "","");;
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
                basket.basket(number, p, client);
                break;
            case "C":
                this.mainMenu(client);
            case "S":
                System.out.println("\nChoose Category for seeing SubCategory");
                choosen  = scn.next();
                this.listSubCategory(choosen,client);

            default:
                break;

        }
    }
}
