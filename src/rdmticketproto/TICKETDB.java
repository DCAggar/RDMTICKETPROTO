/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdmticketproto;

import java.sql.*;

/**
 *
 * @author Aggros the Wroth
 */
public class TICKETDB {
    
    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            // if necessary, set the home directory for Derby
            String dbDirectory = "";
            System.setProperty("", dbDirectory);

            // set the db url, username, and password
            String url = "jdbc:derby:TICKETDB";
            String username = "metro";
            String password = "roadrunner";

            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
                t.printStackTrace();   // for debugging
            return null;
        }
    }

    public static boolean disconnect()
    {
        try
        {
            // On a successful shutdown, this throws an exception
            String shutdownURL = "jdbc:derby:;shutdown=true";
            DriverManager.getConnection(shutdownURL);
        }
        catch (SQLException e)
        {
            if (e.getMessage().equals("Derby system shutdown."))
                return true;
        }
        return false;
    }
}
    

