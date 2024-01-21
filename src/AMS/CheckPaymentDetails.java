package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class CheckPaymentDetails extends JFrame
{
    JTextField textField;
    JTable table;
    JLabel l1, l2, l3, l4, l5, l6;
    
    CheckPaymentDetails()
    {
        initialize();
    }
    
    private void initialize()
    {
        setTitle("Payment Details");
        getContentPane().setBackground(Color.WHITE);
        setSize( 860, 486);
        setLayout(null);
        
        JLabel UName=new JLabel("Username");
        UName.setForeground(Color.BLACK);
        UName.setFont(new Font("Arial", Font.BOLD, 18));
        UName.setBounds( 150, 160, 150, 26);
        add( UName);
        
        textField = new JTextField();
        textField.setBounds( 300, 160, 150, 26); 
        textField .setFont(new Font("Arial", Font.BOLD, 14));
        add(textField );
        
        table= new JTable();
        table.setBounds( 93, 297, 766, 87);
        add(table);
        
        JButton Show = new JButton("Show");
        Show.setFont(new Font("Arial", Font.BOLD,14));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
        Show.setBounds( 500, 160, 150, 26);
        add(Show);
        
        l1 =new JLabel("Check Payment Details");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial", Font.BOLD, 33));
        l1.setBounds( 291, 17, 800, 39);
        add(l1);
        
        l2 =new JLabel("Ticket ID");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial", Font.BOLD, 14));
        l2.setBounds( 117, 262, 106, 26);
        add(l2);
        
        l3 =new JLabel("Price");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Arial", Font.BOLD, 14));
        l3.setBounds( 237, 268, 38, 14);
        add(l3);
        
        
        l6 =new JLabel("Journey Date");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Arial", Font.BOLD, 14));
        l6.setBounds( 362, 264, 101, 24);
        add(l6);
        
        l4 =new JLabel("Journey Time");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial", Font.BOLD, 14));
        l4.setBounds( 485, 268, 114, 14);
        add(l4);
        
        JLabel UN=new JLabel("Username");
        UN.setForeground(Color.BLACK);
        UN.setFont(new Font("Arial", Font.BOLD, 14));
        UN.setBounds( 620, 269, 101, 14);
        add( UN);
        
        JLabel Status=new JLabel("Status");
        Status.setForeground(Color.BLACK);
        Status.setFont(new Font("Arial", Font.BOLD, 14));
        Status.setBounds( 752, 264, 86, 24);
        add( Status);
        
        l5 =new JLabel("");
        ImageIcon ing=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/35.jpg"));
        Image img=ing.getImage().getScaledInstance(1250, 800, Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(img);
        l5.setIcon(img2);
        l5.setBounds( 0, 0, 960, 590);
        add(l5);
        setVisible(true);
        
        
        Show.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    String usn = textField.getText();
                    ConnectionClass c=new ConnectionClass();
                    String q="select tID,price,journey_date,journey_time,username,status from bookedflight where username='"+usn+"'and status='Success'";
                    ResultSet rest=c.stm.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rest));
                    table.setFont(new Font("Arial", Font.BOLD,14));
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            } 
        });
        setSize( 960, 590);
        setLocation( 40, 20);
        setVisible(true);
        
        
        
                
    }
    
    public static void main(String []args)
    {
        new CheckPaymentDetails();
    }
    
}
