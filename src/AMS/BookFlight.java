package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;


public class BookFlight extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JButton bt1,bt2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPanel p1,p2,p3;
    Font f,f1;
    Choice ch1,ch2,ch3,ch4,ch5,ch6;
    
    BookFlight()
    {
        super("Book Airlines India Flight");
        setLocation(50,10);
        setSize(1100,650);
        
        f=new Font("Arial",Font.BOLD,28);
        f1=new Font("Arial",Font.BOLD,20);
        
        ch1=new Choice();
        ch2=new Choice();
        ch3=new Choice();
        ch4=new Choice();
        ch5=new Choice();
        ch6=new Choice();
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select distinct Source from flight";
            ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
           {
               ch1.add(rest.getString("source"));
           }
           rest.close(); 
        }
         catch(Exception ex)
        {
        
             ex.printStackTrace();
        }
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select username from passenger";
            ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
           {
               ch6.add(rest.getString("username"));
           }
           rest.close(); 
        }
         catch(Exception ex)
        {
        
             ex.printStackTrace();
        }
        
        
        
        l1=new JLabel("Book Airlines India Flight");
        l2=new JLabel("Ticket ID");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Class");
        l6=new JLabel("Price");
        l7=new JLabel("Flight Code");
        l8=new JLabel("Flight Name");
        l9=new JLabel("Journey Date");
        l10=new JLabel("Journey Time");
        l11=new JLabel("Username");
        l12=new JLabel("Name");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
       
        tf1.setEditable(false);
        tf2.setEditable(false);
        tf5.setEditable(false);
        
        Random r = new Random();
        tf1.setText(""+Math.abs(r.nextInt() % 100000));
        tf1.setForeground(Color.RED);
        
        bt1=new JButton("Book Flight");
        bt2=new JButton("Back");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
           
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new java.awt.Color(232, 2, 125));
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l12.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        l2.setForeground(new java.awt.Color( 103, 3, 173 ));
        l3.setForeground(new java.awt.Color( 103, 3, 173 ));
        l4.setForeground(new java.awt.Color( 103, 3, 173 ));
        l5.setForeground(new java.awt.Color( 103, 3, 173 ));
        l6.setForeground(new java.awt.Color( 103, 3, 173 ));
        l7.setForeground(new java.awt.Color( 103, 3, 173 ));
        l8.setForeground(new java.awt.Color( 103, 3, 173 ));
        l9.setForeground(new java.awt.Color( 103, 3, 173 ));
        l10.setForeground(new java.awt.Color( 103, 3, 173 ));
        l11.setForeground(new java.awt.Color( 103, 3, 173 ));
        l12.setForeground(new java.awt.Color( 103, 3, 173 ));
        
        bt1.setBackground(new java.awt.Color( 232, 2, 125 ));
        bt2.setBackground(Color.BLACK);
         
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(new java.awt.Color( 232, 2, 125 ));
        
        p1=new JPanel();
        p1.setLayout(new GridLayout( 1, 1, 10, 10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout( 12, 2, 10, 10));
        
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(ch1);
        p2.add(l4);
        p2.add(ch2);
        p2.add(l5);
        p2.add(ch3);
        p2.add(l6);
        p2.add(ch4);
        p2.add(l7);
        p2.add(ch5);
        p2.add(l8);
        p2.add(tf2);
        p2.add(l9);
        p2.add(tf3);
        p2.add(l10);
        p2.add(tf4);
        p2.add(l11);
        p2.add(ch6);
        p2.add(l12);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout( 1, 1, 10, 10));
        
        ImageIcon ing=new ImageIcon(ClassLoader.getSystemResource("AMS/icons/16.png"));
        Image img=ing.getImage().getScaledInstance(650, 470, Image.SCALE_SMOOTH);
        ImageIcon img2=new ImageIcon(img);
        
        l13=new JLabel(img2);
        p3.add(l13);
        
        setLayout(new BorderLayout( 10, 10));
        add(p1, "North");
        add(p2, "Center");
        add(p3, "West");
        
        
        ch6.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                        ConnectionClass obj=new ConnectionClass();
                        String username=ch6.getSelectedItem();
                        String q1="select name from passenger where username='"+username+"'";
                        ResultSet rest1=obj.stm.executeQuery(q1);
                        while(rest1.next())
                        {
                               tf5.setText(rest1.getString("name"));
                        }
                        rest1.close(); 
                }
                catch(Exception ex)
                {
        
                     ex.printStackTrace();
                }
        
            }
        });
        
        
        ch1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                ch2.removeAll();
                try
                {
                        ConnectionClass obj=new ConnectionClass();
                        String source=ch1.getSelectedItem();
                        String q1="select distinct destination from flight where source='"+source+"'";
                        ResultSet rest1=obj.stm.executeQuery(q1);
                        while(rest1.next())
                        {
                               ch2.add(rest1.getString("destination"));
                        }
                        rest1.close(); 
                }
                catch(Exception exx)
                {
        
                     exx.printStackTrace();
                }
        
            }
        });
        
        
        ch2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                ch3.removeAll();
                try
                {
                        ConnectionClass obj=new ConnectionClass();
                        String source=ch1.getSelectedItem();
                        String destination=ch2.getSelectedItem();
                        String q1="select distinct class_name from flight where source='"+source+"'and destination='"+destination+"'";
                        ResultSet rest1=obj.stm.executeQuery(q1);
                        while(rest1.next())
                        {
                               ch3.add(rest1.getString("class_name"));
                        }
                        rest1.close(); 
                }
                catch(Exception exx)
                {
        
                     exx.printStackTrace();
                }
        
            }
        });
        
         ch3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                ch4.removeAll();
                try
                {
                        ConnectionClass obj=new ConnectionClass();
                        String source=ch1.getSelectedItem();
                        String destination=ch2.getSelectedItem();
                        String class_name=ch3.getSelectedItem();
                        String q1="select distinct price from flight where source='"+source+"'and destination='"+destination+"'and class_name='"+class_name+"'";
                        ResultSet rest2=obj.stm.executeQuery(q1);
                        while(rest2.next())
                        {
                               ch4.add(rest2.getString("price"));
                        }
                        rest2.close(); 
                }
                catch(Exception exx)
                {
        
                     exx.printStackTrace();
                }
        
            }
        });
        
        
         ch4.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                ch5.removeAll();
                try
                {
                        ConnectionClass obj=new ConnectionClass();
                        String source=ch1.getSelectedItem();
                        String destination=ch2.getSelectedItem();
                        String class_name=ch3.getSelectedItem();
                        String price=ch4.getSelectedItem();
                        String q1="select distinct flight_code from flight where source='"+source+"'and destination='"+destination+"'and class_name='"+class_name+"'and price='"+price+"'";
                        ResultSet rest2=obj.stm.executeQuery(q1);
                        while(rest2.next())
                        {
                               ch5.add(rest2.getString("flight_code"));
                        }
                        rest2.close(); 
                }
                catch(Exception exx)
                {
        
                     exx.printStackTrace();
                }
        
            }
        });
         
         
          ch5.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                        ConnectionClass obj=new ConnectionClass();
                        String source=ch1.getSelectedItem();
                        String destination=ch2.getSelectedItem();
                        String class_name=ch3.getSelectedItem();
                        String price=ch4.getSelectedItem();
                        String flight_code=ch5.getSelectedItem();
                        String q1="select distinct flight_name from flight where source='"+source+"'and destination='"+destination+"'and class_name='"+class_name+"'and price='"+price+"'and flight_code='"+flight_code+"'";
                        ResultSet rest2=obj.stm.executeQuery(q1);
                        while(rest2.next())
                        {
                               tf2.setText(rest2.getString("flight_name"));
                        }
                        rest2.close(); 
                }
                catch(Exception exx)
                {
        
                     exx.printStackTrace();
                }
        
            }
        });
        
        
          
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String tID=tf1.getText();
            String source=ch1.getSelectedItem();
            String destination=ch2.getSelectedItem();
            String class_name=ch3.getSelectedItem();
            String price=ch4.getSelectedItem();
            String flight_code=ch5.getSelectedItem();
            String flight_name=tf2.getText();
            String journey_date=tf3.getText();
            String journey_time=tf4.getText();
            String username=ch6.getSelectedItem();
            String name=tf5.getText();
            String status="Success";
           
            try
                {
                        ConnectionClass obj3=new ConnectionClass();
                        String q2="insert into bookedFlight (tID,source,destination,class_name,price,flight_code,flight_name,journey_date,journey_time,username,name,status) values('"+tID+"','"+source+"','"+destination+"','"+class_name+"','"+price+"','"+flight_code+"','"+flight_name+"','"+journey_date+"','"+journey_time+"','"+username+"','"+name+"','"+status+"')";
                        int aa=obj3.stm.executeUpdate(q2);
                        if(aa==1)
                        {
                            JOptionPane.showMessageDialog(null,"Your flight successfully booked");
                            this.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please!, Fill all details carefully");
                            
                        }
                }
                catch(Exception ee)
                {
        
                     ee.printStackTrace();
                }   
        }                   
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null,"Are you sure!!!!");
            this.setVisible(false);
                            
        }
        
    }
  
    public static void main(String []args)
    {
        new BookFlight().setVisible(true);
    }
    
}
