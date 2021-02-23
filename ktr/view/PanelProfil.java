package ktr.view;


import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ktr.Controleur;

public class PanelProfil extends JPanel implements ActionListener {
    
    private Controleur ctrl;

    private JTextField txfName;
    private JTextField txfCompanyName;
    private JTextField txfEmail;
    private JTextField txfPhone;

    public PanelProfil(Controleur ctrl)
    {
        this.ctrl = ctrl;

     
    }

    public void actionPerformed(ActionEvent e)
	{

    }

}
