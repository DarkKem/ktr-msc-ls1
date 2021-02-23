package ktr.view;

import java.io.IOException;
import java.util.Scanner;

import ktr.Controleur;

public class IntefaceProfil {
    private static Scanner scanner = new Scanner(System.in);

    public static void newProfil(Controleur ctrl) {

        String name = "none";
        String nameCompany = "none";
        String email = "none";
        String phone = "0000000000";

        try {
            System.out.println("--------Create your profile---------");

            System.out.print("Enter you name : ");
            name = scanner.nextLine();

            System.out.print("Enter the name of you company : ");
            nameCompany = scanner.nextLine();

            System.out.print("Enter you email : ");
            email = scanner.nextLine();

            do {
                System.out.print("Enter you phone number : ");
                phone = scanner.next();
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

    public static void displayProfil(String name, String companyName, String email, String phone) 
    {
        System.out.println("----------- Your profile ------------");

        System.out.println("Name : " + name +"\nCompany name : " + companyName + "\nEmail :" + email + "\nPhone number :" + phone);
    }
    
}
