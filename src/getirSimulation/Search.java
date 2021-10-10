package getirSimulation;

import java.util.Scanner;

public class Search {

    Category category;
    SubCategory subCategory;
    Product product;
    String stringOfProduct, string, isEqualString, productName;
    Basket basket;
    int i = 0, productAmount;
    Scanner scn = new Scanner(System.in);
    String str = new String();
    char[] ch = new char[3];
    char[] isEqualChar = new char[3];

    public Search() {
        category = new Category("");
        subCategory = new SubCategory("", "");
        product = new Product("", 0.0, "", "","");
        basket = new Basket(0.0, "");

        //So that the products are here too.
        category.createCategoryByDefault();
        subCategory.cretaeSubCategoryByDefault();
        product.createCategoryByDefault();
    }

    public void seacrhProduct(Client client){
        System.out.println("Type something to search.");
        for(int z = 0; z < product.productList.size(); z++){
            stringOfProduct = product.productList.get(z).name;
            for(int y = 1; y <= 3; y++){
                isEqualChar[y-1] = java.util.Arrays.toString(stringOfProduct.split("(?<=\\G...)")).charAt(y);
            }
            System.out.println(isEqualChar[0]+ " --- " +isEqualChar[1]+ " --- " +isEqualChar[2]);
            isEqualString = str.valueOf(isEqualChar);

            //3 characters taken from user.
            while(i < 3){
                ch[i] = scn.next().charAt(0);
                i++;
            }

            //The characters given from user are turn to string.
            string = str.valueOf(ch);
            if(string.equals(isEqualString)){
                System.out.println("Product Found. If you want to add the product to the your basket press 'Y' ");
                System.out.println("Product Name: " + product.name + "\nProduct Price: " +product.price+ "\nProduct discounted price " +product.getBasketPrice()+
                        "\nTotal price for this product: " +product.basketPrice);
                productName = scn.next();
                if(productName.equals('Y')){
                    System.out.println("Please write product amount.");
                    productAmount = scn.nextInt();
                    basket.addProduct(productAmount,product.productList.get(i),client);
                }else{
                    //If the user does not want to add the product, they are redirected back to the LandingPage page.
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.choose(client);
                }
                break;
            }
        }
    }
}
