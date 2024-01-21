package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton bt1,bt2;
    JPasswordField pf;
    JTextField tf;
    JFrame f;
    
    Login()
    {
        f=new JFrame("Login Account");
        f.getContentPane().setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);
        
        ImageIcon ing=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/6.jpg"));
        Image img=ing.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(img);
        l1.setIcon(img2);
        
        l2=new JLabel("Username");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l2);
        f.add(l1);
                      
        l3=new JLabel("Login Account");
        l3.setBounds(190, 30, 500, 50);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l1.add(l3);
        
        l4=new JLabel("Password");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l4);
        
        tf=new JTextField();
        tf.setBounds(320,120, 150, 30);
        l1.add(tf);
        
        pf=new JPasswordField();
        pf.setBounds(320,170, 150, 30);
        l1.add(pf);
        
        
        bt1=new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(120, 220, 100, 30);
        bt1.addActionListener(this);
        l1.add(bt1);
        
        bt2=new JButton("SignUp");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(320, 220, 100, 30);
        bt2.addActionListener(this);
        l1.add(bt2);
        
        f.setSize(580, 380);
        f.setLocation(500, 200);
        f.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String username=tf.getText();
            String pass=pf.getText();
            try
            {
                 ConnectionClass obj=new ConnectionClass();
                 String q="Select * from signup where username ='"+username+"' and password='"+pass+"'";
                 ResultSet rs=obj.stm.executeQuery(q);
                   if(rs.next())
                   {
                       new HomePage().setVisible(true);
                       JOptionPane.showMessageDialog(null,"Login Successful");
                       f.setVisible(false);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"You have entered Wrong Username or Password");
                       f.setVisible(false);
                       f.setVisible(true);
                   }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
           this.f.setVisible(false);
           //new SignupMessage();
        }
    }
    
    
    public static void main(String[] args)
    {
        new Login();
    }
}
