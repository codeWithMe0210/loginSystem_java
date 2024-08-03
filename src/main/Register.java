package main;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

import common.CommonComponent;
import db.mydb;

public class Register extends form {

    public Register() {
        super("::Register::");
        add();
        
    }
    public void add()
    {
          JLabel label,label2,label3,label4,label5;
            label=new JLabel("::REGISTER::");
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
            label3.setBounds(30,250,400,40);
            label3.setForeground(CommonComponent.text);
            label3.setFont(new Font("",Font.PLAIN,15));
            add(label3);

            label5=new JLabel("RePassword");
            label5.setBounds(30,350,400,40);
            label5.setForeground(CommonComponent.text);
            label5.setFont(new Font("",Font.PLAIN,15));
            add(label5);



            label4=new JLabel("Have any account? Click here");
            label4.setBounds(180,520,600,50);
        
            label4.setForeground(CommonComponent.text);
            label4.setFont(new Font("",Font.ITALIC,12));
            label4.addMouseListener(new MouseListener() {
               @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    Register.this.dispose();
                    new login().setVisible(true);
                   }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {}
                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {}

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {}

                @Override
                public void mouseExited(java.awt.event.MouseEvent e){}

                
                
            });
            add(label4);

            JTextField field1;
            field1=new JTextField();
            field1.setBounds(30,200,440,40);
            field1.setFont(new Font("",Font.BOLD,20));
            field1.setBackground(CommonComponent.secondary);
            field1.setForeground(CommonComponent.text);
            add(field1);

            JPasswordField passwordField,passwordField2;
            passwordField=new JPasswordField();
            passwordField.setBounds(30,300,440,40);
            passwordField.setFont(new Font("",Font.BOLD,20));
            passwordField.setBackground(CommonComponent.secondary);
            passwordField.setForeground(CommonComponent.text);
            add(passwordField);

            passwordField2=new JPasswordField();
            passwordField2.setBounds(30,400,440,40);
            passwordField2.setFont(new Font("",Font.BOLD,20));
            passwordField2.setBackground(CommonComponent.secondary);
            passwordField2.setForeground(CommonComponent.text);
            add(passwordField2);

            JButton button=new JButton("Resister");
            button.setBounds(180,470,150,40);
            button.setBackground(CommonComponent.secondary);
            button.setForeground(CommonComponent.text);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // get username
                    String name = field1.getText();
    
                    // get password
                    String password = new String(passwordField.getPassword());
    
                    // get repassword
                    String rePassword = new String(passwordField2.getPassword());
    
                    // validate user input
                    if(validateUserInput(name, password, rePassword)){
                        // register user to the database
                        if(mydb.register(name, password)){
                            // dispose of this gui
                            Register.this.dispose();
    
                            // take user back to the login gui
                            login loginFormGUI = new login();
                            loginFormGUI.setVisible(true);
    
                            // create a result dialog
                            JOptionPane.showMessageDialog(loginFormGUI,
                                    "Registered Account Successfully!");
                        }else{
                            // register failed (likely due to the user already existing in the database)
                            JOptionPane.showMessageDialog(Register.this,
                                    "Error: Username already taken");
                        }
                    }else{
                        // invalid user input
                        JOptionPane.showMessageDialog(Register.this,
                                "Error: Username must be at least 6 characters \n" +
                                        "and/or Passwords must match");
                    }
                }
            });
    
            button.setFocusable(false);
            add(button);

            



    }
    private boolean validateUserInput(String username, String password, String rePassword){
        // all fields must have a value
        if(username.length() == 0 || password.length() == 0 || rePassword.length() == 0) return false;

        // username has to be at least 6 characters long
        if(username.length() < 6) return false;

        // password and repassword must be the same
        if(!password.equals(rePassword)) return false;

        // passes validation
        return true;
    }

}

