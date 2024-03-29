package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightZone extends JFrame
{
    private JTable table;
    private JTextField t;
    Choice ch1;
    
    FlightZone()
    {
        getContentPane().setBackground(new java.awt.Color( 77, 157 ,227));
        getContentPane().setFont(new Font("Arial", Font.BOLD, 18));
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize( 860, 523);
        setLayout(null);
        setVisible(true);
        
        JLabel flightCode=new JLabel("Flight Code");
        flightCode.setFont(new Font("Arial", Font.BOLD, 18));
        flightCode.setBounds( 100, 100, 150, 30);
        flightCode.setForeground(new Color( 15, 11, 11));
        add( flightCode);
        
        JLabel flightDetails=new JLabel("Air India Flight Infromation");
        flightDetails.setFont(new Font("Arial", Font.BOLD, 33));
        flightDetails.setBounds( 250, 20, 570, 35);
        flightDetails.setForeground(new Color( 15, 11, 11));
        add( flightDetails);
        
        JButton bt=new JButton("Show Details");
        bt.setFont(new Font ("AArial", Font.BOLD,20));
        bt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    String code=ch1.getSelectedItem();
                    ConnectionClass c=new ConnectionClass();
                    String q="select * from flight where flight_code='"+code+"'";
                    ResultSet rest=c.stm.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rest));
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }   
        });
        bt.setBounds( 560, 100, 220, 30);
        add(bt);
        
       table=new JTable();
       table.setBackground(Color.WHITE);
       table.setBounds( 23, 250, 800, 300);
       table.setFont(new Font("Arial",Font.BOLD, 14));
       add(table);
       
       ch1=new Choice();
       ch1.setBounds( 290, 103, 200, 35);
       ch1.setFont(new Font("Arial", Font.BOLD, 18));
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select distinct flight_code from flight";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch1.add(rest.getString("flight_code"));
                      
            }
            rest.close();
        }
        catch(Exception ex)
        {
        
           ex.printStackTrace();
        }
        add(ch1);
        
       JLabel flightC=new JLabel("Flight Code");
       flightC.setFont(new Font("Arial", Font.BOLD, 14));
       flightC.setBounds( 33, 220, 126, 16);
       flightC.setForeground(new Color( 15, 11, 1));
       add(flightC); 
       
       JLabel flightName=new JLabel("Flight Name");
       flightName.setFont(new Font("Arial", Font.BOLD, 14));
       flightName.setBounds( 155, 220, 120, 16);
       flightName.setForeground(new Color( 15, 11, 1));
       add(flightName); 
        
       JLabel source=new JLabel("Source");
       source.setFont(new Font("Arial", Font.BOLD, 14));
       source.setBounds( 275, 220, 104, 16);
       source.setForeground(new Color( 15, 11, 1));
       add(source); 
        
       JLabel destination=new JLabel("Destination");
       destination.setFont(new Font("Arial", Font.BOLD, 14));
       destination.setBounds( 380, 220, 120, 16);
       destination.setForeground(new Color( 15, 11, 1));
       add(destination); 
       
       JLabel capacity=new JLabel("Capacity");
       capacity.setFont(new Font("Arial", Font.BOLD, 14));
       capacity.setBounds( 497, 220, 111, 16);
       capacity.setForeground(new Color( 15, 11, 1));
       add(capacity); 
       
       JLabel className=new JLabel("Class Name");
       className.setFont(new Font("Arial", Font.BOLD, 14));
       className.setBounds( 610, 220, 120, 16);
       className.setForeground(new Color( 15, 11, 1));
       add(className); 
       
       JLabel price=new JLabel("Price");
       price.setFont(new Font("Arial", Font.BOLD, 14));
       price.setBounds( 740, 220, 111, 16);
       price.setForeground(new Color( 15, 11, 1));
       add(price); 
       
       setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       setSize( 900, 650);
       setVisible(true);
       setLocation(100,50);
       
       
    }
    
    public static void main(String []args)
    {
        new FlightZone().setVisible(true);
    }
}
