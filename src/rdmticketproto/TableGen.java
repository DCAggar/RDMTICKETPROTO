//PURPOSE: This class is only for running SQL commands against the database. Any returns or updates you need pre-program can be run here.
//TODO: Nothing really, just update the sql string to what you need the command to be.
package rdmticketproto;

import java.sql.*;

/**
 *
 * @author Aggros the Wroth
 */
public class TableGen {
    
    private static Connection c = null;
    
    public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:TICKETDB.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      String sql = "CREATE TABLE TICKETS " +
                   "(TID STRING PRIMARY KEY     NOT NULL," +
                   "SID           INT    NOT NULL) " ;
                   
                   
                   
      stmt.executeUpdate(sql);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Table created successfully");
  }
}
    

