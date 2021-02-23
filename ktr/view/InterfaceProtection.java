package ktr.view;

import java.io.Console; 


public class InterfaceProtection 
{
    private static Console console=System.console();

    public static String connection()
    {
        String userName = "none";
        String password = "";

        try {
                System.out.println("--------Enter your username and password--------");
                System.out.print("Username : ");
                userName = console.readLine();
                System.out.print("Password : ");
                password = new String(console.readPassword());
                while(!password.equals("admin"))
                {
                    System.out.println("Wrong pasword try again");
                    password = console.readLine();
                }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return userName;
    }

}
