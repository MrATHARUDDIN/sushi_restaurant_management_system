/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resturante;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Utente
 */
public class SignUpFrame extends JFrame{
    private JPanel Signup;
    private JTextField email;
    private JTextField password;
    private JButton enter;
    private JLabel img;
    public SignUpFrame(String titolo){
       super(titolo);
                Signup = new  JPanel();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setBounds(500, 200, 750, 750);
                add(Signup);
                
                email = new JTextField("Email");
                email.setBounds(230, 200, 250, 75);
                Signup.add(email);
                
                password = new JTextField("Password");
                password.setBounds(230, 300, 250, 75);
                Signup.add(password);
                
                enter  = new JButton("enter");
                enter.setBounds(300, 390, 100, 30);
                Signup.add(enter);
                
                Signup.setLayout(null);
                
                ImageIcon icon = new ImageIcon(getClass().getResource("int.jpg"));
                img = new JLabel(icon);
                img.setBounds(0, 0, 750, 750);
                Signup.add(img);
                setVisible(true);
    }
}
