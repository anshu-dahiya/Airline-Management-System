package AMS;

import java.sql.*;

public class ConnectionClass
{
    Connection con;
    Statement stm;
    
    ConnectionClass()
    {
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","root","Anshu@123");
           stm=con.createStatement();
        }
        catch(Exception ex)
        {
        
             ex.printStackTrace();
        }
    }
    
    public static void main(String []args)
    {
        new ConnectionClass();
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
