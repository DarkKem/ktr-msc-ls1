import java.io.Console;


public class InterfaceProtection 
{
    private static Console console=System.console();

    public static String connection(Controleur ctrl)
    {
        String userName = "none";
        String password = "";

        try {
                System.out.println("--------Enter your username and password--------");
                System.out.print("Username : ");
                userName = console.readLine();
                System.out.print("Password : ");
                password = new String(console.readPassword());

                while(!ctrl.passwordValid(userName, password))
                {
                    System.out.println("Wrong, Try again ");
                    System.out.print("Username : ");
                    userName = console.readLine();
                    System.out.print("Password : ");
                    password = new String(console.readPassword());
                }
                
        } catch (Exception e) {
            e.getStackTrace();
        }
        return userName;
    }

    public static void createAcounte(Controleur ctrl)
    {
        String userName = "none";
        String password1 = "";
        String password2 = "";

        try {
                System.out.println("--------Create your acount--------");
                System.out.print("Username : ");
                userName = console.readLine();
                System.out.print("Password : ");
                password1 = new String(console.readPassword());
                System.out.print("Password again : ");
                password2 = new String(console.readPassword());

                while(!password1.equals(password2) )
                {
                    System.out.println("The 2 password are not the same, try again");
                    System.out.print("Password : ");
                    password1 = new String(console.readPassword());
                    System.out.print("Password again : ");
                    password2 = new String(console.readPassword());
                }

                ctrl.addAcount(userName, password1);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
