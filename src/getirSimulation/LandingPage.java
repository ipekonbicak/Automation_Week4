package getirSimulation;
import java.util.Scanner;

public class LandingPage {
    MainMenu menu = new MainMenu();

    public void landingPage(Client client){
        Scanner choose = new Scanner(System.in);
        System.out.println("\n **************** Welcome to Getir's Landing Page ****************");
        System.out.println("::::::::::::::::::  Most discounted products ::::::::::::::::::");
        this.listDiscountedProduct();
        System.out.println("Type the name of the menu you want to select.");
        System.out.println("AnaMenu: \n" +
                "Search \n" +
                "Profile");

        String choosedSelection = choose.next();
        switch (choosedSelection){
            case "a":
                menu.mainMenu(client);
                break;
            case "Search":
                System.out.println("Search clicked.");
                Search search =  new Search();
                search.seacrhProduct(client);
                break;
            case "Profile":
                client.showProfile(client);
                break;
            default:
                System.out.println("Something went wrong, please try again.");
                break;
        }
        choose.close();
    }

    public void listDiscountedProduct(){
        Product product = new Product("", 0.0, 0.0,"", "","", 0.0);
        product.createCategoryByDefault();
        double [] doubleArray = new double[product.productList.size()];
        String [] productName = new String[product.productList.size()];
        int i = 0;
        double tempDouble;
        String tempString;
        for (Product p: product.productList) {
            doubleArray[i] = p.discountedPrice;
            productName[i] = p.name;
            i++;
        }


        //Sorts the discounted products from smallest to largest.
        for(i = 0; i < (product.productList.size() - 1); i++)
        {
            for(int j = i+1; j < product.productList.size(); j++)
            {
                if(doubleArray[j] < doubleArray[i]) {
                    tempDouble = doubleArray[i];
                    tempString = productName[i];
                    productName[i] = productName[j];
                    doubleArray[i] = doubleArray[j];
                    doubleArray[j] = tempDouble;
                    productName[j] = tempString;
                }
            }
        }

        //5 of the most discounted products are listed on the LandingPage.
        for(int j = 0; j <= 5; j++){
            System.out.println("Product Name: " +productName[j]+ " - Discounted Price: " +doubleArray[j]);
        }
    }
}
