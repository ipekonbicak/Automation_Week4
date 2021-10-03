package getirSimulation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client extends User implements UserOperations {
    private int clientSegment;
    public List<Card> cards = new ArrayList<Card>() ;
    public List<Client> clientList = new ArrayList<Client>();
    public Basket basket;
    public int userType;

    public Client(String name, String surname, String password, String email) {
        super(name, surname, password, email);
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
        int i = 0;
        for (Client client: this.clientList) {
            if(client.email.equals(userEmail) && client.password.equals(userPassword)){
                System.out.println("Welcome to Getir");
                LandingPage landingPage = new LandingPage();
                landingPage.landingPage(client);
            }
            i++;
        }
        loginInfo.close();
    }

    @Override
    public void register() {
        Client client;
        String name, surname, password, email;

        //create scanners for getting informaiton from user.
        Scanner nameScn = new Scanner(System.in);
        Scanner surnameScn = new Scanner(System.in);
        Scanner passwordScn = new Scanner(System.in);
        Scanner emailScn = new Scanner(System.in);

        System.out.print("Please Enter your name: ");
        name = nameScn.next();
        System.out.print("Please Enter your surname: ");
        surname = surnameScn.next();
        System.out.print("Please Enter your password: ");
        password = passwordScn.next();
        System.out.print("Please Enter your Email: ");

        //close scnnaer
        email = emailScn.next();
        nameScn.close();
        surnameScn.close();
        passwordScn.close();
        emailScn.close();

        //create user and add it to the clientList.
        for (Client c: clientList) {
            if(c.email.equals(email)){
                System.out.println("This email already exist.");
                break;
            }else {
                client = new Client(name, surname, password, email);
                this.clientList.add(client);
            }
        }
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    //This function has nothing to do with homework, I just added it to get some users in the system.
    public void clients(){
        Client client = new Client("İpek", "Önbıçak", "123", "ipek@getir.com");
        this.clientList.add(client);
        client = new Client("a", "b","1234","a@getir.com");
        this.clientList.add(client);
        client = new Client("seyhan", "önbıçak", "şifre", "seyhan@getir.com");
        this.clientList.add(client);
        client = new Client("a", "a","a","a");
        this.clientList.add(client);
    }

}
