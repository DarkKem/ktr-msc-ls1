package ktr.view;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ktr.Controleur;

public class InterfaceProfil {
    private static Console console=System.console();

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public static void newProfil(Controleur ctrl) {

        String name = "none";
        String nameCompany = "none";
        String email = "none";
        String phone = "0000000000";

        try {
            System.out.println("--------Create your profile---------");

            System.out.print("Enter your name : ");
            name = console.readLine();

            System.out.print("Enter the name of your company : ");
            nameCompany = console.readLine();

            do {
                System.out.print("Enter your email : ");
                email = console.readLine();    
            } while (!validateEmail(email));

            do {
                System.out.print("Enter your phone number : ");
                phone = console.readLine();
            } while (String.valueOf(phone).length() != 10 && !isInteger(phone));

        } catch (Exception e) {
            e.printStackTrace();
        }

        ctrl.addProfil(name, nameCompany, email, phone);
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
    public static void displayProfil(String name, String companyName, String email, String phone) 
    {
        System.out.println("----------- Your profile ------------");

        System.out.println("Name : " + name +"\nCompany name : " + companyName + "\nEmail : " + email + "\nPhone number : " + phone);

        System.out.println("Press enter to continue . . . ");
        console.readLine();
    }

    public static void erreurExiste() 
    {
        System.out.println("The profil is not create, create a profil before");
    }
    
}
