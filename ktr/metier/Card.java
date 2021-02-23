package ktr.metier;

public class Card 
{
    protected String name;
    protected String companyName;
    protected String email;
    protected String phone;

    public Card(String name, String companyName, String email, String phone)
    {
        this.name        = name;
        this.companyName = companyName;
        this.email       = email;
        this.phone       = phone;
    }

    protected Card() {};

    public String getName(){return this.name;}
    public String getCompanyName(){return this.companyName;}
    public String getEmail(){return this.email;}
    public String getPhone(){return this.phone;}

    public void   setName(String name){this.name = name;}
    public void   setCompanyName(String companyName){this.companyName = companyName;}
    public void   setEmail(String email){this.email = email;}
    public void   setPhone(String phone){this.phone = phone;}


}
