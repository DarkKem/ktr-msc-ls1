package ktr.metier;

import java.util.ArrayList;

public class Library 
{
    private ArrayList<Card> alCard;

    public Library(String user)
    {
        alCard = new ArrayList<Card>();
    }

    public void addCard(String name, String companyName, String email, String phone)
    {
        alCard.add(new Card(name, companyName, email, phone));
    }

    public Card getCard(int indice)
    {
        if(indice >= 0 && indice < alCard.size())
            return alCard.get(indice);
        return null;
    }

    public void deleteCard(int indice)
    {
        if(indice >= 0 && indice < alCard.size())
            alCard.remove(indice);
    }
    
    public int getNbCard(){return alCard.size();}

}
