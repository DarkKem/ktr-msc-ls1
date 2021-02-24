import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Profil extends Card {

    public Profil(String name, String companyName, String email, String phone)
    {
        this.name        = name;
        this.companyName = companyName;
        this.email       = email;
        this.phone       = phone;
    }

    public Profil(String user)
    {
        this.initValue(user);
    }

    private void initValue(String user)
    {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        String[] temp;
        try {
            
            lecteurAvecBuffer = new BufferedReader(new FileReader("ktr/data/"+user+".txt"));
            if((ligne = lecteurAvecBuffer.readLine()) != null)
            {
                temp = ligne.split(";");

                this.name        = temp[0];
                this.companyName = temp[1];
                this.email       = temp[2];
                this.phone       = temp[3];
            }
                
            lecteurAvecBuffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
