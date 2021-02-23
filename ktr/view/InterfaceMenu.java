package ktr.view;

import java.util.Scanner;

public class InterfaceMenu 
{
    private static Scanner scanner = new Scanner(System.in);
    
    public static int menuConnexion()
    {
        int choice = -1;
        try {
            System.out.println("--------Menu connexion--------");
            System.out.print("1) Connexion");
            System.out.print("2) Create acounte");
            System.out.print("0) Quitte");
            
            choice = scanner.nextInt();
            while(choice < 0 || choice > 2)
            {
                System.out.println("Wrong choice try again");
                choice = scanner.nextInt();
            }
            } catch (Exception e) {
                e.getStackTrace();
            }

        return choice;
    }
}
