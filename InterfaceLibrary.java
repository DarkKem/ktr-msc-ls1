import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InterfaceLibrary 
{
    private static Console console=System.console();
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static void addCard(Controleur ctrl) {

        String name = "none";
        String nameCompany = "none";
        String email = "none";
        String phone = "0000000000";

        try {
            System.out.println("--------Add business cards---------");

            System.out.print("Enter name : ");
            name = console.readLine();

            System.out.print("Enter the name of the company : ");
            nameCompany = console.readLine();

            do {
                System.out.print("Enter the email : ");
                email = console.readLine();    
            } while (!validateEmail(email));
           
            do {
                System.out.print("Enter the phone number : ");
                phone = console.readLine();
            } while (String.valueOf(phone).length() != 10 && !isInteger(phone));

        } catch (Exception e) {
            e.printStackTrace();
        }

        ctrl.addCard(name, nameCompany, email, phone);
    }

    public static int listOfCard(String list, int nb)
    {
        int choice = -1;
        String enter;
        try {
            System.out.println("------------Liste of card------------");
            System.out.println(list);
            System.out.println("0) Quitte");
            
            enter = console.readLine();
            if(isInteger(enter)) choice = Integer.parseInt(enter);
            while(choice < 0 || choice > nb)
            {
                System.out.println("Wrong choice try again");
                enter = console.readLine();
                if(isInteger(enter)) choice = Integer.parseInt(enter);
            }
            } catch (Exception e) {
                e.getStackTrace();
            }

        return choice;
    }

    public static void displayCard(String name, String companyName, String email, String phone) 
    {
        System.out.println("----------- Card of "+name+" ------------");

        System.out.println("Name : " + name +"\nCompany name : " + companyName + "\nEmail : " + email + "\nPhone number : " + phone);

        System.out.println("Press enter to continue . . . ");
        console.readLine();
    }

    private static boolean isInteger(String val)
    {
        try {
            Integer.parseInt(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}
    
}
