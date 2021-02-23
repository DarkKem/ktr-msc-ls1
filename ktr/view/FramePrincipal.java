package ktr.view;

import javax.swing.JFrame;
import ktr.Controleur;

public class FramePrincipal extends JFrame
{
    private Controleur ctrl;

    public FramePrincipal(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("KTR-MSC-LS1");
        this.setSize(400, 200);

        this.add(new PanelProfil(ctrl));
        this.setVisible(true);
    }
}
