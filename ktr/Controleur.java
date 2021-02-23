package ktr;

import ktr.metier.Profil;
import ktr.view.InterfaceMenu;
import ktr.view.InterfaceProfil;
import ktr.view.InterfaceProtection;

public class Controleur
{
    private Profil profil;
    private String user;

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
            case 2 : return; //TODO: crate acounte  
            //break;
            case 0 : return;
        }
        
        InterfaceProfil.newProfil(this);
        this.displayProfil();

    }

    public void addProfil(String name, String companyName, String email, String phone)
    {
        profil = new Profil(name, companyName, email, phone);
    }

    public void displayProfil()
    {
        if(profil != null)
            InterfaceProfil.displayProfil(profil.getName(), profil.getCompanyName(), profil.getEmail(), profil.getPhone());
    }

    public static void main(String[] arg)
    {
        new Controleur();
    }
}