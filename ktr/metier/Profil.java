package ktr.metier;

public class Profil extends Card {

    public Profil(String name, String companyName, String email, String phone)
    {
        this.name        = name;
        this.companyName = companyName;
        this.email       = email;
        this.phone       = phone;
    }

    public Profil()
    {
        this.initValue();
    }

    private void initValue()
    {

    }   

    public void saveValue()
    {

    }
}
