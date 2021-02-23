package ktr;
import ktr.metier.Profil;
import ktr.view.IntefaceProfil;
import ktr.view.InterfaceProtection;

public class Controleur
{
    private Profil profil;

    public Controleur()
    {
        this.play();
    }

    public void play()
    {
        InterfaceProtection.connection();
        IntefaceProfil.newProfil(this);
        this.displayProfil();

    }

    public void addProfil(String name, String companyName, String email, String phone)
    {
        profil = new Profil(name, companyName, email, phone);
    }

    public void displayProfil()
    {
        if(profil != null)
            IntefaceProfil.displayProfil(profil.getName(), profil.getCompanyName(), profil.getEmail(), profil.getPhone());
    }

    public static void main(String[] arg)
    {
        new Controleur();
    }
}