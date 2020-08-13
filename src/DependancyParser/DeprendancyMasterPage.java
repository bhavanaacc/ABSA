/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DependancyParser;

 
import Classifiers.Classification;
import static DependancyParser.Featureselection.AllinOne;
import static DependancyParser.Featureselection.GetSelectedTFIDFFeatures;
import static DependancyParser.Featureselection.GneerateTrainMatrix;
import static DependancyParser.Featureselection.LoadComments;
import static DependancyParser.Featureselection.ambianceF;
import static DependancyParser.Featureselection.foodF;
import static DependancyParser.Featureselection.miscellaneousF;
import static DependancyParser.Featureselection.priceF;
import static DependancyParser.Featureselection.serviceF;
import static DependancyParser.TrainTFDP.Exeprocess;
import static DependancyParser.dependacytrainmatrix.GenerateHybridFset;
import static DependancyParser.dependacytrainmatrix.Test;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import master.DbconnSemeval;

/**
 *
 * @author sunsoft
 */
public class DeprendancyMasterPage extends javax.swing.JFrame {

    public static ArrayList TestVector = new ArrayList();
    public static ArrayList arrayInputData = new ArrayList();
    public static ArrayList CrossoverResult = new ArrayList();
    public static ArrayList MutationResult = new ArrayList();
    public static ArrayList FinalData = new ArrayList();
    public int selectedfeatureSet = 10;
    public static int totalPapers;
    public static Connection AcoConn;
    public int GenSize = 20;
    public static int phereomone;

    /**
     * Creates new form MasterPage
     */
    public DeprendancyMasterPage() {
        initComponents();
     this.setSize(750, 300);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("TestFeatures");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(480, 30, 160, 40);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("TrainFeatures ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(30, 30, 170, 40);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("Feature Selection");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(260, 30, 170, 40);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setText("Classification");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(390, 130, 170, 40);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("Final Test");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7);
        jButton7.setBounds(170, 130, 170, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DependancyTest.ExtractTestFeatures();
        } catch (Exception ex) {
            Logger.getLogger(DeprendancyMasterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
 

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            DependancyTrain.ExtractTrainFeatures();
        } catch (Exception ex) {
            Logger.getLogger(DeprendancyMasterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     // Load all dependancy fetures in arraylist
       
        LoadComments();
        System.out.println("Comments loaded success");
       // Now apply TF 
        try {
            // TODO add your handling code here:
            DbconnSemeval db=new DbconnSemeval();
            Connection con=db.conn();
            
            //Food
           for (int startpoint =0; startpoint< foodF.size(); startpoint++)
            {
                String[] foodparts = foodF.get(startpoint).toString().split("#");
                String cID = foodparts[0];
                String[] LemmasTokens =foodparts[1].split(",");
                for (int first =0;first <LemmasTokens.length; first++)
                {
                    String currentFeature =LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    int Count= GetDependancyFrequency.FoodFrequency(currentFeature);
                   // if(Count >1){
                    System.out.println("id \t"+cID +"\t Term \t "+currentFeature +"\t TF \t"+Count);
                    Statement st=con.createStatement();
                   st.executeUpdate("insert into dpfrequency (id, aspect, term, frequency) values ('"+cID+"','food','"+currentFeature+"',"+Count+")");
                    System.out.println(cID+"','food','"+currentFeature+"',"+Count);}
               // }
            }
            System.out.println("-------------------------------Food------------------------------------");
            // price
            for (int startpoint =0; startpoint< priceF.size(); startpoint++)
            {
                String[] priceparts = priceF.get(startpoint).toString().split("#");
                String cID = priceparts[0];
                String[] LemmasTokens =priceparts[1].split(",");
                for (int first =0;first <LemmasTokens.length; first++)
                {
                    String currentFeature =LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    int Count= GetDependancyFrequency.PriceFrequency(currentFeature);
                    // if(Count >1){
                    System.out.println("id \t"+cID +"\t Term \t "+currentFeature +"\t TF \t"+Count);
                    Statement st=con.createStatement();
                    st.executeUpdate("insert into dpfrequency (id, aspect, term, frequency) values ('"+cID+"','price','"+currentFeature+"',"+Count+")");
                     //}
                }
            }
            System.out.println("-------------------------------Price------------------------------------");
            //ambiance
            for (int startpoint =0; startpoint< ambianceF.size(); startpoint++)
            {
                String[] ambianceparts = ambianceF.get(startpoint).toString().split("#");
                String cID = ambianceparts[0];
                String[] LemmasTokens =ambianceparts[1].split(",");
                for (int first =0;first <LemmasTokens.length; first++)
                {
                    String currentFeature =LemmasTokens[first];
                      AllinOne.add(currentFeature);
                    int Count= GetDependancyFrequency.AmbianceFrequency(currentFeature);
                  //   if(Count >1){
                    System.out.println("id \t"+cID +"\t Term \t "+currentFeature +"\t TF \t"+Count);
                     Statement st=con.createStatement();
                    st.executeUpdate("insert into dpfrequency (id, aspect, term, frequency) values ('"+cID+"','ambiance','"+currentFeature+"',"+Count+")");
                   //  }
                }
            }
            System.out.println("-------------------------------Ambiance------------------------------------");
            //Service
            for (int startpoint =0; startpoint< serviceF.size(); startpoint++)
            {
                String[] serviceparts = serviceF.get(startpoint).toString().split("#");
                String cID = serviceparts[0];
                String[] LemmasTokens =serviceparts[1].split(",");
                for (int first =0;first <LemmasTokens.length; first++)
                {
                    String currentFeature =LemmasTokens[first];
                      AllinOne.add(currentFeature); 
                    int Count= GetDependancyFrequency.ServiceFrequency(currentFeature);
                  //   if(Count >1){
                    System.out.println("id \t"+cID +"\t Term \t "+currentFeature +"\t TF \t"+Count);
                     Statement st=con.createStatement();
                    st.executeUpdate("insert into dpfrequency (id, aspect, term, frequency) values ('"+cID+"','service','"+currentFeature+"',"+Count+")");
                   //  }
                }
            }
            System.out.println("-------------------------------Service------------------------------------");
            //miscellaneous
            for (int startpoint =0; startpoint< miscellaneousF.size(); startpoint++)
            {
                String[] miscellaneousparts = miscellaneousF.get(startpoint).toString().split("#");
                String cID = miscellaneousparts[0];
                String[] LemmasTokens =miscellaneousparts[1].split(",");
                for (int first =0;first <LemmasTokens.length; first++)
                {
                    String currentFeature =LemmasTokens[first];
                      AllinOne.add(currentFeature); 
                    int Count= GetDependancyFrequency.miscellaneousFrequency(currentFeature);
                   //  if(Count >1){
                    System.out.println("id \t"+cID +"\t Term \t "+currentFeature +"\t TF \t"+Count);
                     Statement st=con.createStatement();
                    st.executeUpdate("insert into dpfrequency (id, aspect, term, frequency) values ('"+cID+"','miscellaneous','"+currentFeature+"',"+Count+")");
                   //  }
                }
            }
            System.out.println("-------------------------------Miscellaneous------------------------------------");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        GetSelectedTFIDFFeatures();
         Exeprocess();
        System.out.println("TF-IDF done");
        System.out.println("Now system generating training matrix");
       
               System.out.println("TF done"); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
Classifiers.Classification cf=new Classification();
cf.show();
this.hide();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //for generate train matrix   
          GneerateTrainMatrix();       
          GenerateHybridFset();
             Test(); // need to comment 
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(DeprendancyMasterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeprendancyMasterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeprendancyMasterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeprendancyMasterPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeprendancyMasterPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
