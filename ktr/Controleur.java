package ktr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import ktr.metier.Card;
import ktr.metier.Library;
import ktr.metier.Profil;
import ktr.view.InterfaceLibrary;
import ktr.view.InterfaceMenu;
import ktr.view.InterfaceProfil;
import ktr.view.InterfaceProtection;

public class Controleur
{
    private Profil  profil;
    private String  user;
    private Library library;

    public Controleur()
    {
        this.play();
    }

    public void play()
    {
        switch(InterfaceMenu.menuConnexion())
        {
            case 1 : user = InterfaceProtection.connection(this);
            break;
            case 2 : InterfaceProtection.createAcounte(this);
            break;
            case 0 : return;
        }

        this.library = new Library(user);

        while(true)
        {
            switch(InterfaceMenu.menu())
            {
                case 1 : this.displayProfil();
                break;
                case 2 : this.displayListCards('A');
                break;
                case 3 : InterfaceProfil.newProfil(this);
                break;
                case 4 : InterfaceLibrary.addCard(this);
                break;
                case 5 : this.displayListCards('D');
                break;
                case 0 : return;
    
            }
        }

    }

    public void addProfil(String name, String companyName, String email, String phone)
    {
        profil = new Profil(name, companyName, email, phone);
        profil.saveValue(user);
    }

    public void addCard(String name, String companyName, String email, String phone) 
    {
        this.library.addCard(name, companyName, email, phone);
    }
    
    public void displayProfil()
    {
        if(profil == null)
            InterfaceProfil.erreurExiste();
        else
            InterfaceProfil.displayProfil(profil.getName(), profil.getCompanyName(), profil.getEmail(), profil.getPhone());
    }

    public void displayListCards(char action)
    {
        String temp = "";

        for(int i = 0; i < library.getNbCard(); i++)
        {
            temp += (i+1) + ") " + library.getCard(i).getName() + " of " + library.getCard(i).getCompanyName() + "\n";
        }
        if(action == 'A') this.displayCard(InterfaceLibrary.listOfCard(temp, library.getNbCard()+1)-1);
        else 
            if(action == 'D') library.deleteCard(InterfaceLibrary.listOfCard(temp, library.getNbCard()+1)-1);
    }

    public boolean passwordValid(String username, String password )
    {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        String[] temp;
        boolean valReturn = false;
        try {
            
            lecteurAvecBuffer = new BufferedReader(new FileReader("ktr/data/login.txt"));
            while((ligne = lecteurAvecBuffer.readLine()) != null )
            {
                temp = ligne.split(";");
                if(username.equals(temp[0]) && password.equals(temp[1])) valReturn = true;
            }
            lecteurAvecBuffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return valReturn;
    }

    public void displayCard(int indice)
    {
        if(indice != -1)
        {
            Card temp = library.getCard(indice);
            InterfaceLibrary.displayCard(temp.getName(), temp.getCompanyName(), temp.getEmail(), temp.getPhone());
        }
    }

    public void addAcount(String username, String password)
    {
        try {
            FileWriter fw = new FileWriter("ktr/data/login.txt",true);
            fw.write("\n"+username + ";"+password);
            fw.close();

            fw = new FileWriter("ktr/data/"+username+".txt",true);
            fw.write("");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        InterfaceProfil.newProfil(this);
    }
    public static void main(String[] arg)
    {
        new Controleur();
    }

}