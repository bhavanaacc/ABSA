/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * @author sunsoft
 */
package Drug.SentimentProcess;

import Drug.SentimentProcess.*;
import master.DbconnDrug;
import master.Home;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author GALAXY
 */
public class UploadTest extends javax.swing.JFrame {

    public static BufferedImage image = null;
    BufferedImage image1, emb_image;
    File imagefile;
    int w, h;
    public static int m, n;
    String one = "";
    String two = "";
    private BufferedReader br;
    private String tmp;
    private Connection con;
    int id = 0;
    private com.mysql.jdbc.Statement st5;
    File selectedfile;

    public static ArrayList TestList = new ArrayList();

    public UploadTest() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        jButton2.setEnabled(true);
        jButton5.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        img_name = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Novel Approach for Sentiment Analysis of Customer Reviews");
        setMinimumSize(new java.awt.Dimension(701, 551));
        getContentPane().setLayout(null);

        jPanel3.setMinimumSize(new java.awt.Dimension(750, 580));
        jPanel3.setName("A Novel Approach for Sentiment Analysis of Customer Reviews"); // NOI18N
        jPanel3.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Gungsuh", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/header-bg1.jpg"))); // NOI18N
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 0, 900, 270);

        jButton3.setBackground(new java.awt.Color(109, 41, 32));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(780, 270, 130, 50);

        jButton4.setBackground(new java.awt.Color(109, 41, 32));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("HOME");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(10, 270, 110, 50);

        jButton6.setBackground(new java.awt.Color(109, 41, 32));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("UPLOAD TEST");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(320, 270, 200, 50);

        jButton7.setBackground(new java.awt.Color(109, 41, 32));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("PROCESS");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(520, 270, 131, 50);

        jButton8.setBackground(new java.awt.Color(109, 41, 32));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("ANAYSIS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(650, 270, 130, 50);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        img_name.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPanel1.add(img_name);
        img_name.setBounds(230, 50, 260, 40);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(490, 50, 110, 40);

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("Upload");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(610, 50, 110, 40);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Select Test DB File");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 60, 200, 30);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(".");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 100, 600, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 110, 770, 280);

        jButton9.setBackground(new java.awt.Color(109, 41, 32));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("UPLOAD");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(170, 270, 160, 50);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(60, 320, 800, 410);

        jButton10.setBackground(new java.awt.Color(109, 41, 32));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("UPLOAD TRAIN");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(120, 270, 200, 50);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(160, 0, 1010, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JFileChooser fileChooser = new JFileChooser("F:\\ME 2017-18\\PHD Bhavana\\dataset");

        fileChooser.setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        int option = fileChooser.showDialog(null,
                "Select Comments file");

        if (option == JFileChooser.APPROVE_OPTION) {
            selectedfile = fileChooser.getSelectedFile();
            jButton2.setEnabled(false);
            jButton5.setEnabled(true);
            System.out.println("Selected file for import " + selectedfile);
            img_name.setText(selectedfile.getAbsolutePath());
            JOptionPane.showMessageDialog(fileChooser, "File Selected Successfully...");
            jLabel4.setVisible(true);
            jLabel4.setText("Comments will be uploaded here. Please click on Upload button");
        }


    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        readFile();
        JOptionPane.showMessageDialog(rootPane, "File Imported Successfully..");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Home up = new Home();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        UploadTest up = new UploadTest();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ProcessComments up = new ProcessComments();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed
    public void readFile() {

        try {
            int kk = 0;
            System.out.println(" Upload Comments ");
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(selectedfile.getAbsolutePath()));
            String sCurrentLine;
            con = DbconnDrug.conn();
            Statement maxNo = (Statement) con.createStatement();
            String NOT = "NOT";
            Statement st = con.createStatement();
            st.executeUpdate("truncate reviewtest");
            ResultSet ResmaxNo;
            String FileContent = "";
            String Pdata = "";
            while ((sCurrentLine = br.readLine()) != null) {
                kk++;
                System.out.println(kk);
                String currentdata = sCurrentLine;
                if (currentdata != null) {
                    Statement st1 = con.createStatement();
                    String[] parts = null;
                    if (currentdata != null) {
                        parts = currentdata.split("#");
                    }
                    if (parts[0] != null && parts[1] != null) {
                        if (parts[0].equals("")) {
                            parts[0] = Pdata;
                        }
                        st1.executeUpdate("insert into reviewtest (usercomment, aspect) values ('" + parts[0] + "','" + parts[1] + "')");
                        TestList.add(kk + "," + parts[0] + "," + parts[1]);
                        System.out.println(sCurrentLine);
                        Pdata = parts[0];
                    }

                    jTextArea1.append(currentdata);
                    jTextArea1.append("\n");
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UploadTest().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField img_name;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
