package main;

import javax.swing.SwingUtilities;

public class run {

    static public void main(String[]args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                new login().setVisible(true);
            }
        });
    }

}
