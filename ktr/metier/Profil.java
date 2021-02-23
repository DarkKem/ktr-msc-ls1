package ktr.metier;

public class Profil {
    private String name;
    private String companyName;
    private String email;
    private String    phone;

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

    public String getName(){return this.name;}
    public String getCompanyName(){return this.companyName;}
    public String getEmail(){return this.email;}
    public String    getPhone(){return this.phone;}

    public void   setName(String name){this.name = name;}
    public void   setCompanyName(String companyName){this.companyName = companyName;}
    public void   setEmail(String email){this.email = email;}
    public void   setPhone(String phone){this.phone = phone;}


    private void initValue()
    {

    }   

    public void saveValue()
    {

    }
}
