import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Library 
{
    private ArrayList<Card> alCard;
    private String user;

    public Library(String user)
    {
        this.user = user;
        alCard = new ArrayList<Card>();
    }

    public void addCard(String name, String companyName, String email, String phone)
    {
        alCard.add(new Card(name, companyName, email, phone));
        try {
            FileWriter fw = new FileWriter("ktr/data/"+ user+".txt",true);
            fw.write("\n"+name +";"+companyName+";"+email+";"+phone);

            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Card getCard(int indice)
    {
        if(indice >= 0 && indice < alCard.size())
            return alCard.get(indice);
        return null;
    }
    
    public int getNbCard(){return alCard.size();}

    public void init()
    {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        String[] temp;
        try {
            
            lecteurAvecBuffer = new BufferedReader(new FileReader("ktr/data/"+user+".txt"));
            lecteurAvecBuffer.readLine();
            
            while((ligne = lecteurAvecBuffer.readLine()) != null)
            {
                temp = ligne.split(";");
                this.alCard.add(new Card(temp[0],temp[1],temp[2],temp[3]));
            }
                
            lecteurAvecBuffer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
