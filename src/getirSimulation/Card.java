package getirSimulation;
import java.util.Date;

public class Card {
    public String cardNumber;
    public String cardName;
    public String cardCvc;
    public Date date;

    public Card(String cardNumber, String cardName, String cardCvc, Date date) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardCvc = cardCvc;
        this.date = date;
    }
}
