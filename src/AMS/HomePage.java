package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener
{
    JLabel l1,l2;
    Font f,f1,f2;
    
    HomePage()
    {
        super("Airlines India Home Page");
        setLocation( 0, 0);
        setSize( 1550, 800);
        
        f=new Font( "Lucida Fax", Font.BOLD, 20);
        f2=new Font( "Gadugi", Font.BOLD, 35);
        f1=new Font( "MS UI Gothic", Font.BOLD, 18);
        
        
        ImageIcon ing=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/19.jpg"));
        Image img=ing.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(img);
        l1=new JLabel(img2);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Passenger Profile");
        JMenuItem ment1=new JMenuItem("Add Passenger Profile");
        JMenuItem ment2=new JMenuItem("View Passenger Profile");
        men1.add(ment1);
        men1.add(ment2);
        m1.add(men1);
        
        JMenu men2=new JMenu("Manage Passenger");
        JMenuItem ment3=new JMenuItem("Update Passenger Details");
        men2.add(ment3);
        m1.add(men2);
        
        JMenu men3=new JMenu("Your Flight");
        JMenuItem ment4=new JMenuItem("Book Flight");
        JMenuItem ment5=new JMenuItem("View Booked Flight");
        men3.add(ment4);
        men3.add(ment5);
        m1.add(men3);
        
        JMenu men4=new JMenu("Flight Details");
        JMenuItem ment6=new JMenuItem("Journey Details");
        JMenuItem ment7=new JMenuItem("Flight Zone");
        men4.add(ment6);
        men4.add(ment7);
        m1.add(men4);
        
        JMenu men5=new JMenu("Cancellation");
        JMenuItem ment8=new JMenuItem("Cancel Ticket");
        JMenuItem ment9=new JMenuItem("View Canceled Ticket");
        men5.add(ment8);
        men5.add(ment9);
        m1.add(men5);
        
        JMenu men6=new JMenu("Bill");
        JMenuItem ment10=new JMenuItem("Check Payment");
        men6.add(ment10);
        m1.add(men6);
        
        JMenu men7=new JMenu("Logout");
        JMenuItem ment11=new JMenuItem("Exit");
        men7.add(ment11);
        m1.add(men7);
        
        
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
        
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment11.setFont(f1);
        
        m1.setBackground(new java.awt.Color( 4, 1, 54));
        
        men1.setForeground(Color.WHITE);
        men2.setForeground(Color.WHITE);
        men3.setForeground(Color.WHITE);
        men4.setForeground(Color.WHITE);
        men5.setForeground(Color.WHITE);
        men6.setForeground(Color.WHITE);
        men7.setForeground(Color.RED);
        
        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment4.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        ment8.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment10.setBackground(Color.BLACK);
        ment11.setBackground(Color.BLACK);
        
        ment1.setForeground(Color.YELLOW);
        ment2.setForeground(Color.YELLOW);
        ment3.setForeground(Color.YELLOW);
        ment4.setForeground(Color.YELLOW);
        ment5.setForeground(Color.YELLOW);
        ment6.setForeground(Color.YELLOW);
        ment7.setForeground(Color.YELLOW);
        ment8.setForeground(Color.YELLOW);
        ment9.setForeground(Color.YELLOW);
        ment10.setForeground(Color.YELLOW);
        ment11.setForeground(Color.YELLOW);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);    
        
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String cmd=e.getActionCommand();
        if(cmd.equals("Add Passenger Profile"))
        {
            new AddPassengerDetails();
        }
        else if(cmd.equals("View Passenger Profile"))
        {
            new ViewPassenger().setVisible(true);
        }
        else if(cmd.equals("Update Passenger Details"))
        {
            new UpdatePassenger().setVisible(true);
        }
        else if(cmd.equals("Book Flight"))
        {
            new BookFlight().setVisible(true);
        }
        else if(cmd.equals("View Booked Flight"))
        {
            new ViewBookedFlight().setVisible(true);
        }
        else if(cmd.equals("Journey Details"))
        {
            new FlightJourney();
        }
        else if(cmd.equals("Flight Zone"))
        {
            new FlightZone().setVisible(true);
        }
        else if(cmd.equals("Cancel Ticket"))
        {
            new CancelFlight().setVisible(true);
        }
        else if(cmd.equals("View Canceled Ticket"))
        {
            new ViewCanceledTicket().setVisible(true);
        }
        else if(cmd.equals("Check Payment"))
        {
            new CheckPaymentDetails().setVisible(true);
        }
        else if(cmd.equals("Exit"))
        {
            System.exit(0);
        }  
        
    }

    public static void main(String []args)
    {  
        new HomePage().setVisible(true);
    }

}