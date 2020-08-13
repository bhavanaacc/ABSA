
package Classifiers;


import Analysis.Performance;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Classification extends javax.swing.JFrame {

    public static BufferedImage image = null;
    BufferedImage image1,emb_image;
    File imagefile;
    int w,h;
    public static int m,n;
    String one = ""; 
    String two = ""; 
    private BufferedReader br;
    private String tmp;
     public Classification() {
        initComponents();
     this.setSize(650, 550);
        jButton2.enable(false);
        jButton5.enable(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cuser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        testDB = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        trainDB = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Classification (.arff)");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(220, 10, 290, 40);

        cuser.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cuser.setForeground(new java.awt.Color(255, 255, 255));
        cuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(cuser);
        cuser.setBounds(560, 30, 140, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 700, 60);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        testDB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        testDB.setName(""); // NOI18N
        jPanel1.add(testDB);
        testDB.setBounds(220, 110, 220, 30);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(450, 110, 90, 30);

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("Process");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(200, 320, 110, 30);

        trainDB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        trainDB.setName(""); // NOI18N
        jPanel1.add(trainDB);
        trainDB.setBounds(220, 50, 220, 30);

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(450, 50, 90, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Select Training Dataset : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 50, 210, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Select Classifier :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 190, 180, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Select Testing Dataset : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 110, 210, 30);

        jList1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "NaiveBayes", "SVM" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(220, 180, 220, 70);

        jButton9.setBackground(new java.awt.Color(0, 153, 153));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton9.setText("Cancel");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(360, 320, 100, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 700, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        JFileChooser chooser = new JFileChooser("F:\\arff1");
        int result = chooser.showOpenDialog(null);
       
        if (result == JFileChooser.APPROVE_OPTION)
        {
            imagefile = chooser.getSelectedFile();
        }
        else
        {
            System.out.println("!Error");
        }
         
        try
        {
            image = ImageIO.read(imagefile);
        }
        catch (IOException exception)
        {
            System.out.println("!Error loading image " + exception);
        }
        testDB.setText(imagefile.getAbsolutePath());       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      this.hide();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {      
            int _mType=0;
    // System.out.println(jList1.getSelectedValuesList());
     List data=jList1.getSelectedValuesList();
     String parts = "";
            String train=trainDB.getText();
            String test=testDB.getText();
         if(train.contains("DTFTrainarff") && test.contains("DTFTestarff"))
         {
           _mType=1;
             System.out.println("Type-1");
         }
        if(train.contains("WeightedCCTrainarff") && test.contains("WeightedCCTestarff"))
         {
           _mType=2;
           System.out.println("Type-2");
         }
        if(train.contains("HybridTrainarff") && test.contains("HybridTestarff"))
         {
           _mType=3;
           System.out.println("Type-3");
         }
            
            for(int kk=0;kk<data.size();kk++)
          {
              parts=parts+data.get(kk).toString()+"#";
            
          }
          
            Classifiers cs=new Classifiers();
            int res=cs.Execute(train, test, parts, _mType);
//            if(res==0)
//            {
//                JOptionPane.showMessageDialog(rootPane, "Select Minimum 5 Classifiers");
//            }
         
                    
           }
        catch (Exception ex) {
                Logger.getLogger(Classification.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser("F:\\arff1");
        int result = chooser.showOpenDialog(null);
       
        if (result == JFileChooser.APPROVE_OPTION)
        {
            imagefile = chooser.getSelectedFile();
        }
        else
        {
            System.out.println("!Error");
        }
         
        try
        {
            image = ImageIO.read(imagefile);
        }
        catch (IOException exception)
        {
            System.out.println("!Error loading image " + exception);
        }
        trainDB.setText(imagefile.getAbsolutePath());
    }//GEN-LAST:event_jButton3ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
               new Classification().setVisible(true);
           
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel cuser;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField testDB;
    private javax.swing.JTextField trainDB;
    // End of variables declaration//GEN-END:variables

  
    }

   
