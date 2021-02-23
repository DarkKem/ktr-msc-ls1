package ktr;

import ktr.metier.Card;
import ktr.metier.Library;
import ktr.metier.Profil;
import ktr.view.InterfaceLibrary;
import ktr.view.InterfaceMenu;
import ktr.view.InterfaceProfil;
import ktr.view.InterfaceProtection;

public class Controleur
{
    private Profil profil;
    private String user;
    private Library library;

    public Controleur()
    {
        this.play();
    }

    public void play()
    {
        switch(InterfaceMenu.menuConnexion())
        {
            case 1 : user = InterfaceProtection.connection();
            break;
            case 2 : return; //TODO: create acounte  
            //break;
            case 0 : return;
        }

        this.library = new Library(user);

        while(true)
        {
            switch(InterfaceMenu.menu())
            {
                case 1 : this.displayProfil();
                break;
                case 2 : this.displayListCards();
                break;
                case 3 : InterfaceProfil.newProfil(this);
                break;
                case 4 : InterfaceLibrary.addCard(this);
                break;
                case 5 : //TODE: Delete buisnesse card
                break;
                case 0 : return;
    
            }
        }

    }

    public void addProfil(String name, String companyName, String email, String phone)
    {
        profil = new Profil(name, companyName, email, phone);
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

    public void displayListCards()
    {
        String temp = "";

        for(int i = 0; i < library.getNbCard(); i++)
        {
            temp += (i+1) + ") " + library.getCard(i).getName() + " of " + library.getCard(i).getCompanyName() + "\n";
        }
        this.displayCard(InterfaceLibrary.listOfCard(temp, library.getNbCard()+1)-1);
    }

    public void displayCard(int indice)
    {
        
        if(indice != -1)
        {
            Card temp = library.getCard(indice);
            InterfaceLibrary.displayCard(temp.getName(), temp.getCompanyName(), temp.getEmail(), temp.getPhone());
        }
           
        
            
    }
    public static void main(String[] arg)
    {
        new Controleur();
    }

	
}