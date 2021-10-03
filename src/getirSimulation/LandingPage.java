package getirSimulation;
import java.util.Scanner;

public class LandingPage {
    MainMenu menu = new MainMenu();
    public void landingPage(Client client){
        Scanner choose = new Scanner(System.in);
        System.out.println("\n **************** Welcome to Getir's Landing Page ****************");
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
                System.out.println("Search tıklandı");
                break;
            case "Profile":
                System.out.println("Profile tıklandı");
                break;
            default:
                System.out.println("Something went wrong, please try again.");
                break;
        }
        choose.close();
    }
}
