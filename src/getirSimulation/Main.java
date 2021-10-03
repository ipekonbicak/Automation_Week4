package getirSimulation;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Getir, Grocery service in minutes.");
        System.out.println("Press 'L' to login, 'S' to register.");

        Scanner scn = new Scanner(System.in);
        String choise;
        Client client = new Client("try", "try", "try", "try");
        choise = scn.next();

        try{
            if(choise.equals("L")){
                client.login();
            }else if(choise.equals("S")){
                client.register();
            }else{
                System.out.println("Please enter valid selection parameter.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Ups! Something went wrong try again.");
        }

        scn.close();
    }
}
