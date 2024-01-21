package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class ViewBookedFlight  extends JFrame 
{
    JTable t;
    String x[]={"Ticket ID","Source","Destination","Class","Price","Flight Code","Flight Name","Journey Date","Journey Time","Username","Name","Status"};
    String y[][]=new String[20][12];
    int i=0, j=0;
    Font f;
    
    ViewBookedFlight()
    {
        super("Flight Journey Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic", Font.BOLD,17);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select *from bookedFlight";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("tID");
                y[i][j++]=rest.getString("source");
                y[i][j++]=rest.getString("destination");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("price");
                y[i][j++]=rest.getString("flight_code");
                y[i][j++]=rest.getString("flight_name");
                y[i][j++]=rest.getString("journey_date");
                y[i][j++]=rest.getString("journey_time");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("status");
                i++;
                j=0;
            }
            t=new JTable(y,x);            
            rest.close(); 
        }
        catch(Exception ex)
        {
        
           ex.printStackTrace();
        }
         t.setFont(f);
         t.setBackground(Color.BLACK);
         t.setForeground(Color.WHITE);
         JScrollPane js=new JScrollPane(t);
         add(js);
         
    }
    
    public static void main(String args[])
    {
        new ViewBookedFlight().setVisible(true);
    }
}
