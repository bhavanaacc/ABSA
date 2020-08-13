package master;

import Yelp.SentimentProcess.Dashboard;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    public static String user;
    String pwrd;
    Statement st;
    public static int mn = 85;
    public static int mx = 91;
    public static String Sessionsuer = "";
    public static Dimension screen;

    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setBackground(Color.BLUE);
        screen = Toolkit.getDefaultToolkit().getScreenSize();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        passwd = new javax.swing.JPasswordField();
        userid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        signup = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Novel Approach for Sentiment Analysis of Customer Reviews");
        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(750, 580));
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(750, 580));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(153, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Aspect Based Sentiment Analysis using Machine Learning Appraoch");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, -10, 890, 100);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(130, 0, 950, 60);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton2.setText("Login");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(640, 490, 110, 40);
        jPanel1.add(passwd);
        passwd.setBounds(590, 410, 170, 30);
        jPanel1.add(userid);
        userid.setBounds(590, 350, 170, 30);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 420, 60, 20);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UserName");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(470, 360, 80, 20);

        signup.setBackground(new java.awt.Color(0, 153, 153));
        signup.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        signup.setText("New User");
        signup.setFocusPainted(false);
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        jPanel1.add(signup);
        signup.setBounds(460, 490, 110, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/header-bg.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(370, 330, 490, 250);

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Gungsuh", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/header-bg1.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(120, 60, 980, 270);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(110, 0, 1070, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        Registration rg = new Registration();
        rg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signupActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        user = userid.getText();
        pwrd = passwd.getText();
        try {
            DbconnSemeval db = new DbconnSemeval();
            Connection con = (Connection) db.conn();
            st = (Statement) con.createStatement();

            ResultSet rs = (ResultSet) st.executeQuery("select * from register where Username='" + user + "' && Password='" + pwrd + "'");
            if (rs.next()) {
                Sessionsuer = "user";
                //Semeval.SentimentProcess.Dashboard ds=new Semeval.SentimentProcess.Dashboard();
                // Yelp.SentimentProcess.Dashboard ds=new Yelp.SentimentProcess.Dashboard();
                Drug.SentimentProcess.Dashboard ds = new Drug.SentimentProcess.Dashboard();
                ds.show();
                this.hide();

            } else if (user.equals("admin") && pwrd.equals("admin")) {
                Sessionsuer = "admin";
                //Semeval.SentimentProcess.Dashboard ds=new Semeval.SentimentProcess.Dashboard();
                // Yelp.SentimentProcess.Dashboard ds=new Yelp.SentimentProcess.Dashboard();
                Drug.SentimentProcess.Dashboard ds = new Drug.SentimentProcess.Dashboard();
                ds.show();
                this.hide();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Enter username or password correctly");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public String pass() {

        return user;

    }

    public static void main(String args[]) {

        //hm.addMouseListener(hm);
        // hm.jPanel1.setSize((int) screen.getWidth(),200);
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwd;
    private javax.swing.JButton signup;
    private javax.swing.JTextField userid;
    // End of variables declaration//GEN-END:variables
}
