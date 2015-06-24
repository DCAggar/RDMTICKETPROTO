//PURPOSE: Sets up all the derby db stuff. DONT TOUCH IT. DONT YOU DARE.
//TODO: JACK SHIT.
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
            // SET HOME DIRECTORY OF DERBY TO THE LOCAL FOLDER
            String dbDirectory = "C:\\Users\\Aggros the Wroth\\Desktop\\PROTO2\\RDMTIX_2.0";
            System.setProperty("derby.system.home", dbDirectory);

            // set the db url, username, and password, IF NECESSARY, put ; create = false at the end
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
    

