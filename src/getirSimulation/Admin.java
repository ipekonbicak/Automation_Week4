package getirSimulation;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements UserOperations {
    public List<Admin> adminList;
    public int userType;

    public Admin(String name, String surname, String password, String email, String address, String phoneNumber) {
        super(name, surname, password, email, address, phoneNumber);
        this.userType = 1;
    }

    public void addProduct(){};
    public void removeProduct(){};
    public void addCategory(){};
    public void addSubCategory(){};

    @Override
    public void login() {
        String userEmail, userPassword;
        this.register();
        Scanner loginInfo = new Scanner(System.in);
        System.out.print("Enter Your Email: ");
        userEmail = loginInfo.next();
        System.out.print("Enter Your Password: ");
        userPassword = loginInfo.next();
        loginInfo.close();

        for (Admin admin: adminList) {
            if(admin.email.equals(userEmail) && admin.password.equals(userPassword)){
                System.out.println("Welcome to Getir");
                break;
            }else {
                System.out.println("Your username or password is incorrect.");
                break;
            }
        }
    }

    @Override
    public void register() {
        Admin admin = new Admin("admin", "admin", "1234", "admin@admin.com","admin address", "05514275597");
    }
}
