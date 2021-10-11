package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends User implements UserOperations {
    private int clientSegment;
    public List<Card> cards = new ArrayList<>() ;
    public List<Client> clientList = new ArrayList<>();
    public Basket basket;
    public int userType;

    public Client(String name, String surname, String password, String email, String address, String phoneNumber) {
        super(name, surname, password, email, address, phoneNumber);
        this.clientSegment = 0;
        this.userType = 2;
    }

    @Override
    public void login() {
        String userEmail, userPassword;
        this.clients();

        Scanner loginInfo = new Scanner(System.in);
        System.out.print("Enter Your Email: ");
        userEmail = loginInfo.next();
        System.out.print("Enter Your Password: ");
        userPassword = loginInfo.next();
        for (Client client: this.clientList) {
            if(client.email.equals(userEmail) && client.password.equals(userPassword)){
                System.out.println("Welcome to Getir");
                LandingPage landingPage = new LandingPage();
                landingPage.landingPage(client);
            }
        }
        loginInfo.close();
    }

    @Override
    public void register() {
        Client client;
        String name, surname, password, email, address, number;

        //create scanners for getting informaiton from user.
        Scanner nameScn = new Scanner(System.in);
        Scanner surnameScn = new Scanner(System.in);
        Scanner passwordScn = new Scanner(System.in);
        Scanner emailScn = new Scanner(System.in);
        Scanner addressScn = new Scanner(System.in);
        Scanner numberScn = new Scanner(System.in);

        System.out.print("Please Enter your name: ");
        name = nameScn.next();
        System.out.print("Please Enter your surname: ");
        surname = surnameScn.next();
        System.out.print("Please Enter your password: ");
        password = passwordScn.next();
        System.out.print("Please Enter your Email: ");
        address = addressScn.next();
        System.out.print("Please Enter your Address: ");
        number = numberScn.next();
        System.out.print("Please Enter your number: ");

        //close scnnaer
        email = emailScn.next();
        nameScn.close();
        surnameScn.close();
        passwordScn.close();
        emailScn.close();
        addressScn.close();
        nameScn.close();

        //create user and add it to the clientList.
        for (Client c: clientList) {
            if(c.email.equals(email)){
                System.out.println("This email already exist.");
                break;
            }else if(c.phoneNumber.equals(number)){
                System.out.println("This phone number already exist.");
                break;
            } else {
                client = new Client(name, surname, password, email,number, address);
                this.clientList.add(client);
            }
        }
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    //This function has nothing to do with homework, I just added it to get some users in the system.
    public void clients(){
        Client client = new Client("Ahmet", "ahmet", "1234", "getir.com","İstanbul /Avcılar","05552909999");
        this.clientList.add(client);
        client = new Client("Mehmet", "mehmet","1234+","getir.com","Kocaeli / Gebze","05552909998");
        this.clientList.add(client);
        client = new Client("Ayşe", "ayşe", "12345", "getir.com","Konya /Selçuklu","02121682898");
        this.clientList.add(client);
        client = new Client("a", "a","a","a","Narlıdere","05514275597");
        this.clientList.add(client);
        client = new Client("Fatma", "fatma", "A12345+", "getir.com","Ordu / Ünye","01111111111");
        this.clientList.add(client);
        client = new Client("Hayriye", "hayriye", "1234", "getir.com","Samsun /Çarşamba","09999999999");
        this.clientList.add(client);
    }

    public void showProfile(Client client){
        Scanner scn = new Scanner(System.in);
        String s;
        System.out.println("::::::::::::: Profile :::::::::::::");
        System.out.println("Name: " +client.name+ "\nSurname: " +client.surname+ "\nAddress: " +client.address+ "\nPhone Number: " +client.phoneNumber);

        System.out.println("\nPress 'Landing Page' to landing page.\nPress 'Change Profile' to change profile.");
        s = scn.nextLine();

        if(s.equals("Landing Page")){
            LandingPage landingPage= new LandingPage();
            landingPage.landingPage(client);
        }else if(s.equals("Change Profile")){
            this.login();
        }else{
            System.exit(0);
        }
    }
}
