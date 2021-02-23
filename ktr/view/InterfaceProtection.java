package ktr.view;

import java.util.Scanner;


public class InterfaceProtection 
{
    private static Scanner scanner = new Scanner(System.in);

    public static String connection()
    {
        String userName = "none";
        String password = "";

        try {
                System.out.println("--------Enter your username and password--------");
                System.out.print("Username : ");
                userName = scanner.nextLine();
                System.out.print("Password : ");
                password = scanner.nextLine();
                while(!password.equals("admin"))
                {
                    System.out.println("Wrong pasword try again");
                    password = scanner.nextLine();
                }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return userName;
    }

}
