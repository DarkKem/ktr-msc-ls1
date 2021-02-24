package ktr.metier;

import java.io.FileWriter;

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

    public void saveValue(String user)
    {
        try {
            FileWriter fw = new FileWriter("ktr/data/"+ user+".txt",false);
            fw.write(name +";"+companyName+";"+email+";"+phone);

            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
