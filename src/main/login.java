package main;
import common.*;
import db.mydb;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class login extends form {

    public login() {
        super("frame");
        addComponent();
        
        }
        
        private void addComponent()
        {
            JLabel label,label2,label3,label4;
            label=new JLabel("::LOGIN::");
            label.setBounds(0,25,520,100);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("",Font.BOLD,40));
            label.setForeground(CommonComponent.text);
            add(label);

            label2=new JLabel("Username");
            label2.setBounds(30,150,400,40);
            label2.setForeground(CommonComponent.text);
            label2.setFont(new Font("",Font.PLAIN,15));
            add(label2);

            label3=new JLabel("Password");
            label3.setBounds(30,300,400,40);
            label3.setForeground(CommonComponent.text);
            label3.setFont(new Font("",Font.PLAIN,15));
            add(label3);

            label4=new JLabel("Have Not account? Register here");
            label4.setBounds(150,490,600,50);
        
            label4.setForeground(CommonComponent.text);
            label4.setFont(new Font("",Font.ITALIC,13));
            label4.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                     login.this.dispose();

                     new Register().setVisible(true);
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e){}
                @Override
                public void mouseExited(MouseEvent e){}

                
                
            });
            add(label4);

            JTextField field1;
            field1=new JTextField();
            field1.setBounds(30,200,440,40);
            field1.setFont(new Font("",Font.BOLD,20));
            field1.setBackground(CommonComponent.secondary);
            field1.setForeground(CommonComponent.text);
            add(field1);

            JPasswordField passwordField;
            passwordField=new JPasswordField();
            passwordField.setBounds(30,350,440,40);
            passwordField.setFont(new Font("",Font.BOLD,20));
            passwordField.setBackground(CommonComponent.secondary);
            passwordField.setForeground(CommonComponent.text);
            add(passwordField);

            JButton button=new JButton("Login");
            button.setBounds(180,450,150,40);
            button.setBackground(CommonComponent.secondary);
            button.setForeground(CommonComponent.text);
            button.setFocusable(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String name=field1.getText();
                    String password=new String(passwordField.getPassword());
                    if(mydb.validateLogin(name,password))
                    {
                        JOptionPane.showMessageDialog(login.this,"Login Successfully");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(login.this,"Login Failed");
                    }
                }
            });
            add(button);



        }

    

}
