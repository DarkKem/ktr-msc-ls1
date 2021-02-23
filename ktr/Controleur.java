package ktr;
import ktr.view.FramePrincipal;

public class Controleur
{
    public Controleur()
    {
        new FramePrincipal(this);
    }

    public static void main(String[] arg)
    {
        new Controleur();
    }
}