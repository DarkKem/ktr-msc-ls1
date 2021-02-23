package ktr.view;

import java.io.Console; 

public class InterfaceMenu 
{
    private static Console console=System.console();
    
    public static int menuConnexion()
    {
        int choice = -1;
        String enter;
        try {
            System.out.println("--------Menu connexion--------");
            System.out.println("1) Connexion");
            System.out.println("2) Create acounte");
            System.out.println("0) Quitte");
            
            enter = console.readLine();
            if(isInteger(enter)) choice = Integer.parseInt(enter);
            while(choice < 0 || choice > 2)
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

    public static int menu()
    {
        int choice = -1;
        String enter;
        try {
            System.out.println("------------Menu------------");
            System.out.println("1) Show profil");
            System.out.println("2) Show buisness cards");
            System.out.println("3) Update Profil");
            System.out.println("4) Add buisness cards");
            System.out.println("5) Delete buisness cards");
            System.out.println("0) Quitte");
            
            enter = console.readLine();
            if(isInteger(enter)) choice = Integer.parseInt(enter);
            while(choice < 0 || choice > 5)
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

    private static boolean isInteger(String val)
    {
        try {
            Integer.parseInt(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
