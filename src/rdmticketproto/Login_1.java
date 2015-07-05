//PURPOSE: This is the first screen the users sees, and what the program defaults to when it is finished. From this screen, the user enters credentials, and the system takes them to
//the appropriate screen from there. The three screens possible after this one are Register_2_1 (renamed to be the 2nd screen for clarity), Extra_Tickets_2_2 (the second possible second
//screen, and Admin_2. This screen takes the credentials entered and checks them against the database.
//TODO: Enter 'next screen' logic.

//@DCA I changed the two text panes in here to text fields. They look similar, but a pane only displays text, doesn't allow entering or using it.
package rdmticketproto;

import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Preston
 * @collab DCAggar
 */
public class Login_1 extends javax.swing.JFrame {
    
    //creates a new DB connect, using TICKETDB.java.
    private static Connection connection = null;
    //variables
    public static String Snumber; //from the first jTextField
    public static String Sname; //from the second jTextField
    public static int Registered = 0; //for checking if user has registered
    public static Boolean IsValid = true; //for checking if the user exists
    public static int Greg2;
    

    /**
     * Creates new form pickup_UI_1
     */
    public Login_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(938, 525));
        setMinimumSize(new java.awt.Dimension(938, 525));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rdmticketproto/Metro_State_Roadrunners_00447a_d31243.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Enter your student ID:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setText("Confirm your last name:");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4.setText("RDM Ticketing System");

        jButton1.setText("I need help");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(373, 373, 373))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
         // @DCA: edited this because the secondary screen is unneccesary.
        // TODO: Uncomment the extra logic blocks
        
        /* //THIS STAR THING COMMENTS THE FUCK OUT OF THE STUFF BELOW.
        Snumber = jTextField1.getText();
        Sname = jTextField2.getText();
        //begin student finding SQL block 
        Connection c = null;
        Statement stmt = null;
        try 
        {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:TICKETDB.db");
        System.out.println("Opened database successfully");
        
        stmt = c.createStatement();
        
        String sql = "SELECT SID FROM STUDENTS WHERE SID = "+Snumber+"" ;
                  
                   
                   
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
        } 
        catch ( Exception e ) 
        {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      JOptionPane.showMessageDialog(null, "Student not found, please try again.");
        }
        //End of student finding SQL block
        //Begin of registeration status block
        try 
        {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:TICKETDB.db");
        System.out.println("Opened database successfully");
        
        stmt = c.createStatement();
        
        String sql = "SELECT REGISTERED FROM STUDENTS WHERE SID = "+Snumber+"" ;
         
        
                   
                   
        Registered = stmt.executeUpdate(sql);
        stmt.close();
        c.close();
        } 
        catch ( Exception e ) 
        {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      JOptionPane.showMessageDialog(null, "Student status not found, please try again.");
        }
        //End student registration block
        
        
        */
        if (Registered == 0)
        {
        
        this.dispose();
        Register_UI_1 a = new Register_UI_1();
        a.setVisible(true);
        }
        /*
        else //supposed to call the secondary 'extra 2 ticket pickup' window
        {
            //these 2 lines fetch the Greg date
            Calendar rightNow = Calendar.getInstance();
            int Greg = rightNow.get(Calendar.DAY_OF_YEAR); 
            //these lines fetch the date the SID registered (stored as a Greg int)
           
        try 
        {
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:TICKETDB.db");
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        
        String sql = "SELECT TIME FROM STUDENTS WHERE"+Snumber+"="+Snumber+"";
                 
        Greg2 = stmt.executeUpdate(sql); //THIS INITIALIZES THE COMPARE VAR, Greg2, and pushes the select statement into it.
        stmt.close();
        c.close();
        } 
        catch ( Exception e ) 
        {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
        }
        //SQL end
        if (Greg2 - Greg > 0)
        {
            JOptionPane.showMessageDialog(null, "You are eligible for extra tickets at this time. Please complete the request.");
         this.dispose();
        Extra_UI_1 b = new Extra_UI_1();
        b.setVisible(true); 
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "You are not eligible for extra tickets at this time. Please try again later. Thank you.");
            jTextField1.setText("");
            jTextField2.setText("");
        }
        }
        */ //END OF COMMENTED SECTION.
    }//GEN-LAST:event_ConfirmButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        connection = TICKETDB.getConnection();
        
        
        
        if (connection != null)
            System.out.println("SQLite has been started in embed mode. Connection Made.\n");
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
