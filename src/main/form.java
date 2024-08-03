package main;

import javax.swing.JFrame;

import common.CommonComponent;

public class form extends JFrame{

    public form(String title)
    {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(520,620);
        setLocationRelativeTo(null);
        getContentPane().setBackground(CommonComponent.primary);
    
    }
    

}
