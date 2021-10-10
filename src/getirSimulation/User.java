package getirSimulation;
import java.util.UUID;

public abstract class User {
    public String userId;
    public String name;
    public String surname;
    protected String password;
    public String email;
    public String address;
    public String phoneNumber;

    public User(String name, String surname, String password, String email, String address, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
