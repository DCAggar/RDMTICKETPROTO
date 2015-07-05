//PURPOSE: Sets up all the SQLite DB stuff. DONT TOUCH IT. DONT YOU DARE.
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
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:TICKETDB.db");
    } 
    catch ( Exception e ) 
    {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.out.println("SQLite doesn't seem to be working correctly. Fix it. \n");
      System.exit(0);
    }
    System.out.println("Opened database successfully");
    return null;
    }
            
        
    

    public static boolean disconnect()
    {
        try
        {
            // On a successful shutdown, this throws an exception
            String shutdownURL = "jdbc:sqlite:;shutdown=true";
            DriverManager.getConnection(shutdownURL);
        }
        catch (SQLException e)
        {
            if (e.getMessage().equals("SQLite system shutdown."))
                return true;
        }
        return false;
    }
}
    

