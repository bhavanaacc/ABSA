package Yelp.SentimentProcess;

import master.DbconnYelp;
import master.Home;
import Analysis.Performance;
import static Yelp.SentimentProcess.CoWeightforTFCC.CalculateCOrelation;
import static Yelp.SentimentProcess.CoWeightforWeighted.calcualateCorelation;
import static Yelp.SentimentProcess.UploadTest.TestList;
import static Yelp.SentimentProcess.UploadTrain.TrainList;
import static Yelp.SentimentProcess.publicparams.checkflag;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ProcessComments extends javax.swing.JFrame {

    private Connection con;
    public static int val = 0;
    public static int flag = 0;
    private com.mysql.jdbc.Statement st5;
    public static String methodname = "";

    String[] category = new String[5];
    public static ArrayList stopwordlist = new ArrayList();

    public static ArrayList lemmaslist = new ArrayList();
    public static ArrayList foodF = new ArrayList();
    public static ArrayList ambianceF = new ArrayList();
    public static ArrayList serviceF = new ArrayList();
    public static ArrayList RestaurantF = new ArrayList();
    public static ArrayList WorthinessF = new ArrayList();
    public static ArrayList priceF = new ArrayList();

    public static ArrayList foodRedudant = new ArrayList();
    public static ArrayList ambianceRedudant = new ArrayList();
    public static ArrayList serviceRedudant = new ArrayList();
    public static ArrayList RestaurantRedudant = new ArrayList();
    public static ArrayList WorthinessRedudant = new ArrayList();
    public static ArrayList PriceRedudant = new ArrayList();

    public static ArrayList foodTF = new ArrayList();
    public static ArrayList ambianceTF = new ArrayList();
    public static ArrayList serviceTF = new ArrayList();
    public static ArrayList RestaurantTF = new ArrayList();
    public static ArrayList WorthinessTF = new ArrayList();
    public static ArrayList priceTF = new ArrayList();

    public static ArrayList AllinOne = new ArrayList();
    public static ArrayList AllinTFOne = new ArrayList();

    public ProcessComments() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Novel Approach for Sentiment Analysis of Customer Reviews");
        setMinimumSize(new java.awt.Dimension(701, 551));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setMinimumSize(new java.awt.Dimension(750, 580));
        jPanel2.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Gungsuh", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/header-bg1.jpg"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 0, 900, 200);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Stopwords Removal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 50, 200, 40);

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("Select Features");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(590, 50, 200, 40);

        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton11.setText("Stemming");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(310, 50, 200, 40);

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton12.setText("TF-IFD");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12);
        jButton12.setBounds(40, 150, 200, 40);

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton13.setText("TF-IFD with Co-Relation");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13);
        jButton13.setBounds(270, 150, 310, 40);

        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton15.setText("Weighted Matrix");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15);
        jButton15.setBounds(620, 150, 200, 50);

        jButton16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton16.setText("Train (Weighted-CC)");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(620, 240, 200, 50);

        jButton17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton17.setText("Test");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17);
        jButton17.setBounds(40, 330, 160, 50);

        jButton18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton18.setText("Train (Weighted)");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18);
        jButton18.setBounds(400, 240, 190, 50);

        jButton19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton19.setText("Train (TF-CC)");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19);
        jButton19.setBounds(220, 240, 145, 50);

        jButton20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton20.setText("Train (TF)");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20);
        jButton20.setBounds(40, 240, 140, 50);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(30, 250, 840, 400);

        jButton4.setBackground(new java.awt.Color(109, 41, 32));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("HOME");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(40, 200, 110, 50);

        jButton10.setBackground(new java.awt.Color(109, 41, 32));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("UPLOAD TRAIN");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(150, 200, 200, 50);

        jButton6.setBackground(new java.awt.Color(109, 41, 32));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("UPLOAD TEST");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(350, 200, 200, 50);

        jButton8.setBackground(new java.awt.Color(109, 41, 32));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("PROCESS");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(550, 200, 131, 50);

        jButton9.setBackground(new java.awt.Color(109, 41, 32));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("ANAYSIS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(680, 200, 130, 50);

        jButton3.setBackground(new java.awt.Color(109, 41, 32));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(810, 200, 130, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(160, 0, 950, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void UpdateStopwords(ArrayList StopwordsList) {
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = db.conn();
            for (int startCount = 0; startCount < StopwordsList.size(); startCount++) {
                String[] inpstring = StopwordsList.get(startCount).toString().split(",");
                Statement st1 = con.createStatement();
                if (flag == 1) {
                    st1.executeUpdate("update reviewtrain set stopword= '" + inpstring[1] + "' where id='" + inpstring[0] + "'");
                } else {
                    st1.executeUpdate("update reviewtest set stopword= '" + inpstring[1] + "' where id='" + inpstring[0] + "'");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void UpdateLemmas(ArrayList Lemmaslits) {
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = db.conn();
            for (int startCount = 0; startCount < Lemmaslits.size(); startCount++) {
                String[] inpstring = Lemmaslits.get(startCount).toString().split(",");
                Statement st1 = con.createStatement();
                if (flag == 1) {
                    st1.executeUpdate("update reviewtrain set lemmas= '" + inpstring[1] + "' where id='" + inpstring[0] + "'");
                } else {
                    st1.executeUpdate("update reviewtest set lemmas= '" + inpstring[1] + "' where id='" + inpstring[0] + "'");
                }
            }
        } catch (Exception ex) {
        }
    }

    public static ArrayList ReadTrain() throws Exception {
        Connection con = DbconnYelp.conn();
        Statement st = (Statement) con.createStatement();

        ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtrain limit 100");
        while (rs.next()) {
            String id = rs.getString(1);
            String comment = rs.getString(2);
            String aspect = rs.getString(6);
            TrainList.add(id + "," + comment + "," + aspect);
        }
        return TrainList;
    }

    public static ArrayList ReadTest() throws Exception {
        Connection con = DbconnYelp.conn();
        Statement st = (Statement) con.createStatement();

        ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtest");
        while (rs.next()) {
            String id = rs.getString(1);
            String comment = rs.getString(2);
            String aspect = rs.getString(6);
            TestList.add(id + "," + comment + "," + aspect);
        }
        return TestList;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (master.Home.user.equals("admin") && TrainList.size() < 1) {
                ReadTrain();
            }
            if (TestList.size() < 1) {
                ReadTest();
            }
            RemoveStopwords rm = new RemoveStopwords();
            if (Home.Sessionsuer.equalsIgnoreCase("admin")) // Train
            {
                flag = 1;
                for (int startCount = 0; startCount < TrainList.size(); startCount++) {
                    String[] inpstring = TrainList.get(startCount).toString().split(",");
                    String result = rm.RemoveWords(inpstring[1]);
                    stopwordlist.add(inpstring[0] + "," + result + "," + inpstring[2]);
                    System.out.println("After stopword removing data is \t" + result);
                }
                UpdateStopwords(stopwordlist);
            } else // test
            {
                for (int startCount = 0; startCount < UploadTest.TestList.size(); startCount++) {
                    String[] inpstring = TestList.get(startCount).toString().split(",");
                    String result = rm.RemoveWords(inpstring[1]);
                    stopwordlist.add(inpstring[0] + "," + result + "," + inpstring[2]);
                    System.out.println("After stopword removing data is \t" + result);

                }
                UpdateStopwords(stopwordlist);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JOptionPane.showMessageDialog(rootPane, "Stopwors Removal Done");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static String getCurrentData(String domain) {
        String cdata = "";
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select features from featureset where aspect = '" + domain + "'");
            while (rs.next()) {
                cdata = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return cdata;
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtrain");
            while (rs.next()) {
                String id = rs.getString(1);
                String lemmas = rs.getString(4);
                String aspect = rs.getString(6);
                if (aspect.equalsIgnoreCase("food") && lemmas != "") {
                    foodF.add(id + "#" + lemmas);
                }
                if (aspect.equalsIgnoreCase("ambience") && lemmas != "") {
                    ambianceF.add(id + "#" + lemmas);
                }
                if (aspect.equalsIgnoreCase("service") && lemmas != "") {
                    serviceF.add(id + "#" + lemmas);
                }
                if (aspect.equalsIgnoreCase("Restaurant") && lemmas != "") {
                    RestaurantF.add(id + "#" + lemmas);
                }
                if (aspect.equalsIgnoreCase("Worthiness") && lemmas != "") {
                    WorthinessF.add(id + "#" + lemmas);
                }
                if (aspect.equalsIgnoreCase("price") && lemmas != "") {
                    priceF.add(id + "#" + lemmas);
                }
            }
            System.out.println("Food" + foodF.size());
            System.out.println("ambiance" + ambianceF.size());
            System.out.println("service" + serviceF.size());
            System.out.println("Restaurant" + RestaurantF.size());
            System.out.println("Worthiness" + WorthinessF.size());
            System.out.println("Price" + priceF.size());
        } catch (Exception ex) {
        }
        JOptionPane.showMessageDialog(rootPane, "Feature selection done..");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Home up = new Home();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        UploadTrain up = new UploadTrain();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        UploadTest up = new UploadTest();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ProcessComments up = new ProcessComments();
        up.show();
        this.hide();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Performance fp = new Performance();
        fp.show();
        this.hide();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        for (int startCount = 0; startCount < stopwordlist.size(); startCount++) {
            try {
                String[] inpstring = stopwordlist.get(startCount).toString().split(",");
                Stemmer ss = new Stemmer();
                String fname = "F:\\StemmerInput.txt";

                Writer writer = null;
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fname), "utf-8"));
                writer.append(inpstring[1]);
                writer.close();
                String Stemmed = ss.GetData(fname);
                lemmaslist.add(inpstring[0] + "," + Stemmed + "," + inpstring[2]);
                System.out.println("Data after Stemmed: :\t" + Stemmed);
            } catch (Exception ex) {
                Logger.getLogger(ProcessComments.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        UpdateLemmas(lemmaslist);
        JOptionPane.showMessageDialog(rootPane, "Stemming Done");
    }//GEN-LAST:event_jButton11ActionPerformed


    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            // TODO add your handling code here:
            DbconnYelp db = new DbconnYelp();
            Connection con = db.conn();

            //Food
            for (int startpoint = 0; startpoint < foodF.size(); startpoint++) {
                String[] foodparts = foodF.get(startpoint).toString().split("#");
                String cID = foodparts[0];
                String[] LemmasTokens = foodparts[1].split("\\s+");
                for (int first = 0; first < LemmasTokens.length; first++) {
                    String currentFeature = LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    foodRedudant.add(currentFeature);
                    int Count = GetFrequency.FoodFrequency(currentFeature);
                    System.out.println("id \t" + cID + "\t Term \t " + currentFeature + "\t TF \t" + Count);
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into frequency (id, aspect, term, frequency) values ('" + cID + "','food','" + currentFeature + "'," + Count + ")");
                }
            }
            System.out.println("-------------------------------Food------------------------------------");
            // price
            for (int startpoint = 0; startpoint < RestaurantF.size(); startpoint++) {
                String[] priceparts = RestaurantF.get(startpoint).toString().split("#");
                String cID = priceparts[0];
                String[] LemmasTokens = priceparts[1].split("\\s+");
                for (int first = 0; first < LemmasTokens.length; first++) {
                    String currentFeature = LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    RestaurantRedudant.add(currentFeature);
                    int Count = GetFrequency.RestaurantFrequency(currentFeature);
                    System.out.println("id \t" + cID + "\t Term \t " + currentFeature + "\t TF \t" + Count);
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into frequency (id, aspect, term, frequency) values ('" + cID + "','Restaurant','" + currentFeature + "'," + Count + ")");

                }
            }
            System.out.println("-------------------------------Restaurant------------------------------------");
            //ambiance
            for (int startpoint = 0; startpoint < ambianceF.size(); startpoint++) {
                String[] ambianceparts = ambianceF.get(startpoint).toString().split("#");
                String cID = ambianceparts[0];
                String[] LemmasTokens = ambianceparts[1].split("\\s+");
                for (int first = 0; first < LemmasTokens.length; first++) {
                    String currentFeature = LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    ambianceRedudant.add(currentFeature);
                    int Count = GetFrequency.AmbianceFrequency(currentFeature);
                    System.out.println("id \t" + cID + "\t Term \t " + currentFeature + "\t TF \t" + Count);
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into frequency (id, aspect, term, frequency) values ('" + cID + "','ambiance','" + currentFeature + "'," + Count + ")");

                }
            }
            System.out.println("-------------------------------Ambiance------------------------------------");
            //Service
            for (int startpoint = 0; startpoint < serviceF.size(); startpoint++) {
                String[] serviceparts = serviceF.get(startpoint).toString().split("#");
                String cID = serviceparts[0];
                String[] LemmasTokens = serviceparts[1].split("\\s+");
                for (int first = 0; first < LemmasTokens.length; first++) {
                    String currentFeature = LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    serviceRedudant.add(currentFeature);
                    int Count = GetFrequency.ServiceFrequency(currentFeature);
                    System.out.println("id \t" + cID + "\t Term \t " + currentFeature + "\t TF \t" + Count);
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into frequency (id, aspect, term, frequency) values ('" + cID + "','service','" + currentFeature + "'," + Count + ")");

                }
            }
            System.out.println("-------------------------------Service------------------------------------");
            //worthness
            for (int startpoint = 0; startpoint < WorthinessF.size(); startpoint++) {
                String[] miscellaneousparts = WorthinessF.get(startpoint).toString().split("#");
                String cID = miscellaneousparts[0];
                String[] LemmasTokens = miscellaneousparts[1].split("\\s+");
                for (int first = 0; first < LemmasTokens.length; first++) {
                    String currentFeature = LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    WorthinessRedudant.add(currentFeature);
                    int Count = GetFrequency.worthnessFrequency(currentFeature);
                    System.out.println("id \t" + cID + "\t Term \t " + currentFeature + "\t TF \t" + Count);
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into frequency (id, aspect, term, frequency) values ('" + cID + "','Worthiness','" + currentFeature + "'," + Count + ")");

                }
            }
            System.out.println("-------------------------------Worthiness------------------------------------");

            //price
            for (int startpoint = 0; startpoint < priceF.size(); startpoint++) {
                String[] miscellaneousparts = priceF.get(startpoint).toString().split("#");
                String cID = miscellaneousparts[0];
                String[] LemmasTokens = miscellaneousparts[1].split("\\s+");
                for (int first = 0; first < LemmasTokens.length; first++) {
                    String currentFeature = LemmasTokens[first];
                    AllinOne.add(currentFeature);
                    PriceRedudant.add(currentFeature);
                    int Count = GetFrequency.priceFrequency(currentFeature);
                    System.out.println("id \t" + cID + "\t Term \t " + currentFeature + "\t TF \t" + Count);
                    Statement st = con.createStatement();
                    st.executeUpdate("insert into frequency (id, aspect, term, frequency) values ('" + cID + "','price','" + currentFeature + "'," + Count + ")");

                }
            }
            System.out.println("-------------------------------price------------------------------------");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        GetSelectedTFIDFFeatures();
        JOptionPane.showMessageDialog(rootPane, "TF-IDF Done");

    }//GEN-LAST:event_jButton12ActionPerformed

    public static int GetTFofTerm(String aspect, String term, Connection conn) {
        int count = 0;
        try {
//     DbconnSemeval db=new DbconnSemeval();
//     Connection conn=db.conn();
            Statement st = conn.createStatement();
            String query = "select * from frequency where aspect= '" + aspect + "' and term='" + term + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                count = Integer.parseInt(rs.getString(4));
            }
        } catch (Exception ex) {
            System.out.println("Error in TF" + ex);
        }
        return count;
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        try {
            DbconnYelp db = new DbconnYelp();
            Connection conn = db.conn();
            Statement st1 = conn.createStatement();
            Statement st2 = conn.createStatement();
            Statement st3 = conn.createStatement();
            Statement st4 = conn.createStatement();
            Statement st5 = conn.createStatement();
            Statement st6 = conn.createStatement();

            for (int kk = 0; kk < ambianceTF.size(); kk++) {
                String data = ambianceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data, conn);
                double index2 = GetTFofTerm("food", data, conn);
                double index3 = GetTFofTerm("Worthiness", data, conn);
                double index4 = GetTFofTerm("Restaurant", data, conn);
                double index5 = GetTFofTerm("service", data, conn);
                double index6 = GetTFofTerm("price", data, conn);
                st1.executeUpdate("insert into cooccurance (aspect,term,ambiance,food,Worthiness,Restaurant,service,price) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','" + index6 + "')");
                System.out.println("Ambiance Category Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5 + "\t" + index6);
            }

            for (int kk = 0; kk < foodTF.size(); kk++) {
                String data = foodTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data, conn);
                double index2 = GetTFofTerm("food", data, conn);
                double index3 = GetTFofTerm("miscellaneous", data, conn);
                double index4 = GetTFofTerm("price", data, conn);
                double index5 = GetTFofTerm("service", data, conn);
                double index6 = GetTFofTerm("price", data, conn);
                st2.executeUpdate("insert into cooccurance (aspect,term,ambiance,food,Worthiness,Restaurant,service,price) values ('food', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','" + index6 + "')");
                System.out.println("Food Category Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5 + "\t" + index6);
            }

            for (int kk = 0; kk < WorthinessTF.size(); kk++) {
                String data = WorthinessTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data, conn);
                double index2 = GetTFofTerm("food", data, conn);
                double index3 = GetTFofTerm("miscellaneous", data, conn);
                double index4 = GetTFofTerm("price", data, conn);
                double index5 = GetTFofTerm("service", data, conn);
                double index6 = GetTFofTerm("price", data, conn);
                st3.executeUpdate("insert into cooccurance (aspect,term,ambiance,food,Worthiness,Restaurant,service,price) values ('Worthiness', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','" + index6 + "')");
                System.out.println("Worthiness Category  \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5 + "\t" + index6);

            }
            for (int kk = 0; kk < RestaurantTF.size(); kk++) {
                String data = RestaurantTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data, conn);
                double index2 = GetTFofTerm("food", data, conn);
                double index3 = GetTFofTerm("miscellaneous", data, conn);
                double index4 = GetTFofTerm("price", data, conn);
                double index5 = GetTFofTerm("service", data, conn);
                double index6 = GetTFofTerm("price", data, conn);
                st4.executeUpdate("insert into cooccurance (aspect,term,ambiance,food,Worthiness,Restaurant,service,price) values ('Restaurant', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','" + index6 + "')");
                System.out.println("Restaurant Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5 + "\t" + index6);
            }
            for (int kk = 0; kk < serviceTF.size(); kk++) {
                String data = serviceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data, conn);
                double index2 = GetTFofTerm("food", data, conn);
                double index3 = GetTFofTerm("miscellaneous", data, conn);
                double index4 = GetTFofTerm("price", data, conn);
                double index5 = GetTFofTerm("service", data, conn);
                double index6 = GetTFofTerm("price", data, conn);
                st5.executeUpdate("insert into cooccurance (aspect,term,ambiance,food,Worthiness,Restaurant,service,price) values ('service', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','" + index6 + "')");
                System.out.println("Service Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5 + "\t" + index6);
            }
            for (int kk = 0; kk < priceTF.size(); kk++) {
                String data = priceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data, conn);
                double index2 = GetTFofTerm("food", data, conn);
                double index3 = GetTFofTerm("miscellaneous", data, conn);
                double index4 = GetTFofTerm("price", data, conn);
                double index5 = GetTFofTerm("service", data, conn);
                double index6 = GetTFofTerm("price", data, conn);
                st6.executeUpdate("insert into cooccurance (aspect,term,ambiance,food,Worthiness,Restaurant,service,price) values ('price', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','" + index6 + "')");
                System.out.println("Service Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5 + "\t" + index6);
            }
            CalculateCOrelation();
            JOptionPane.showMessageDialog(rootPane, "Done");
        } catch (Exception ex) {
            Logger.getLogger(ProcessComments.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    public static void GetSelectedTFIDFFeatures() {
        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select  distinct(term), aspect, frequency from frequency order by frequency desc;");

            while (rs.next()) {
                String term = rs.getString(1);
                String aspect = rs.getString(2);
                int freq = Integer.parseInt(rs.getString(3));

                //if(freq >= 3)//when co-occurance
                if (freq >= 1) // when weighted
                {
                    if (aspect.equalsIgnoreCase("food")) {
                        foodTF.add(term);
                        AllinTFOne.add(term);
                    }
                    if (aspect.equalsIgnoreCase("Restaurant")) {
                        RestaurantTF.add(term);
                        AllinTFOne.add(term);
                    }
                    if (aspect.equalsIgnoreCase("Worthiness")) {
                        WorthinessTF.add(term);
                        AllinTFOne.add(term);
                    }
                    if (aspect.equalsIgnoreCase("ambiance")) {
                        ambianceTF.add(term);
                        AllinTFOne.add(term);
                    }
                    if (aspect.equalsIgnoreCase("service")) {
                        serviceTF.add(term);
                        AllinTFOne.add(term);
                    }
                    if (aspect.equalsIgnoreCase("price")) {
                        priceTF.add(term);
                        AllinTFOne.add(term);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Food features :" + foodTF.size());
        System.out.println(" Restaurant features :" + RestaurantTF.size());
        System.out.println(" Worthiness features :" + WorthinessTF.size());
        System.out.println(" Ambiance features :" + ambianceTF.size());
        System.out.println(" Service features :" + serviceTF.size());
        System.out.println("Price features :" + priceTF.size());
        System.out.println(" All features :" + AllinTFOne.size());

    }

    public static ArrayList getUniqueList(ArrayList myList) {
        ArrayList Uniquelist = new ArrayList();
        Set<String> hashsetList = new HashSet<String>(myList);
        for (String s : hashsetList) {
            Uniquelist.add(s);
        }
        return Uniquelist;
    }
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            // TODO add your handling code here:
            DbconnYelp db = new DbconnYelp();
            Connection conn = db.conn();

            for (int kk = 0; kk < foodTF.size(); kk++) {
                String dataparts = foodTF.get(kk).toString();
                String out = NewClass1.Gettearmsothercategory("food", dataparts, conn);
                String[] set = out.split(",");
                double localtearms = Double.parseDouble(set[1]);
                double othertearms = Double.parseDouble(set[6]);
                double weight = localtearms / othertearms;
                if (weight >= 0.10) {
                    Statement st = conn.createStatement();
                    st.executeUpdate("insert into weighted (aspect,term,food,othercount,weight) values ('food', '" + dataparts + "', '" + localtearms + "','" + othertearms + "','" + weight + "')");
                    System.out.println("Term \t" + dataparts + "\t Weight \t" + weight);
                }

            }
            System.out.println("Food Category Done");
            for (int kk = 0; kk < priceTF.size(); kk++) {
                String dataparts = priceTF.get(kk).toString();
                String[] set = NewClass1.Gettearmsothercategory("price", dataparts, conn).split(",");
                double localtearms = Double.parseDouble(set[5]);
                double othertearms = Double.parseDouble(set[6]);
                double weight = localtearms / othertearms;
                if (weight >= 0.05) {
                    Statement st = conn.createStatement();
                    st.executeUpdate("insert into weighted (aspect,term,price,othercount,weight) values ('price', '" + dataparts + "', '" + localtearms + "','" + othertearms + "','" + weight + "')");
                    System.out.println("Term \t" + dataparts + "\t Weight \t" + weight);
                }
            }
            System.out.println("Price Category Done");
            for (int kk = 0; kk < ambianceTF.size(); kk++) {
                String dataparts = ambianceTF.get(kk).toString();
                String[] set = NewClass1.Gettearmsothercategory("ambiance", dataparts, conn).split(",");
                double localtearms = Double.parseDouble(set[0]);
                double othertearms = Double.parseDouble(set[6]);
                double weight = localtearms / othertearms;
                if (weight >= 0.05) {
                    Statement st = conn.createStatement();
                    st.executeUpdate("insert into weighted (aspect,term,ambiance,othercount,weight) values ('ambiance', '" + dataparts + "', '" + localtearms + "','" + othertearms + "','" + weight + "')");
                    System.out.println("Term \t" + dataparts + "\t Weight \t" + weight);
                }
            }
            System.out.println("Food Ambiance Done");
            for (int kk = 0; kk < WorthinessTF.size(); kk++) {
                String dataparts = WorthinessTF.get(kk).toString();
                String[] set = NewClass1.Gettearmsothercategory("Worthiness", dataparts, conn).split(",");
                double localtearms = Double.parseDouble(set[2]);
                double othertearms = Double.parseDouble(set[6]);
                double weight = localtearms / othertearms;
                Statement st = conn.createStatement();
                st.executeUpdate("insert into weighted (aspect,term,Worthiness,othercount,weight) values ('Worthiness', '" + dataparts + "', '" + localtearms + "','" + othertearms + "','" + weight + "')");
                System.out.println("Term \t" + dataparts + "\t Weight \t" + weight);
            }
            System.out.println("Worthiness Category Done");
            for (int kk = 0; kk < serviceTF.size(); kk++) {
                String dataparts = serviceTF.get(kk).toString();
                String[] set = NewClass1.Gettearmsothercategory("service", dataparts, conn).split(",");
                double localtearms = Double.parseDouble(set[4]);
                double othertearms = Double.parseDouble(set[6]);
                double weight = localtearms / othertearms;
                if (weight >= 0.05) {
                    Statement st = conn.createStatement();
                    st.executeUpdate("insert into weighted (aspect,term,service,othercount,weight) values ('service', '" + dataparts + "', '" + localtearms + "','" + othertearms + "'," + weight + ")");
                    System.out.println("Term \t" + dataparts + "\t Weight \t" + weight);
                }
            }
            System.out.println("Service Category Done");

            for (int kk = 0; kk < RestaurantTF.size(); kk++) {
                String dataparts = RestaurantTF.get(kk).toString();
                String[] set = NewClass1.Gettearmsothercategory("Restaurant", dataparts, conn).split(",");
                double localtearms = Double.parseDouble(set[3]);
                double othertearms = Double.parseDouble(set[6]);
                double weight = localtearms / othertearms;
                if (weight >= 0.05) {
                    Statement st = conn.createStatement();
                    st.executeUpdate("insert into weighted (aspect,term,service,othercount,weight) values ('Restaurant', '" + dataparts + "', '" + localtearms + "','" + othertearms + "'," + weight + ")");
                    System.out.println("Term \t" + dataparts + "\t Weight \t" + weight);
                }
            }
            System.out.println("Restaurant Category Done");
            Geteachweight.ExecuProcessUpdate();
            JOptionPane.showMessageDialog(rootPane, "Weight Calculation Done");
            System.out.println("Execute co-relation now...");
            calcualateCorelation();
            JOptionPane.showMessageDialog(rootPane, "Co-Relation Calculation Done");
        } catch (Exception ex) {
            Logger.getLogger(ProcessComments.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton15ActionPerformed


    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {

            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted");
            while (rs.next()) {
                String aspect = rs.getString(2);
                String term = rs.getString(3);

                String ambiance = Double.valueOf(rs.getString(4)) > 0.0 ? "1" : "0";
                String food = Double.valueOf(rs.getString(5)) > 0.0 ? "1" : "0";
                String worthiness = Double.valueOf(rs.getString(6)) > 0.0 ? "1" : "0";
                String rest = Double.valueOf(rs.getString(7)) > 0.0 ? "1" : "0";
                String service = Double.valueOf(rs.getString(8)) > 0.0 ? "1" : "0";
                String price = Double.valueOf(rs.getString(9)) > 0.0 ? "1" : "0";
                double w = Double.valueOf(rs.getString(11));
                double th = 0.85;
                if (w <= th) {
                    System.out.println(aspect + "\t" + term + "\t" + ambiance + "\t" + food + "\t" + worthiness + "\t" + rest + "\t" + service + "\t" + price);
                    String query = "insert into trainmatrix (aspect, term,ambiance,food,worthiness,Restaurant,service,price,weight) values ('" + aspect + "','" + term + "','" + ambiance + "','" + food + "','" + worthiness + "','" + rest + "','" + service + "','" + price + "','" + w + "')";
                    st1.executeUpdate(query);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Matrix Generation done");
    }//GEN-LAST:event_jButton16ActionPerformed
    public static String GetMatrix(String term) {
        int flag = 0;
        String res = "";
        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from trainmatrix where term ='" + term + "'");
            while (rs.next()) {
                res = rs.getString(4) + "," + rs.getString(5) + "," + rs.getString(6) + "," + rs.getString(7) + "," + rs.getString(8) + "," + rs.getString(9);
                flag = 1;
                break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        if (flag == 0) {
            res = "0,0,0,0,0,0";
        }

        return res;
    }
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:

        val = Integer.parseInt(JOptionPane.showInputDialog("Enter id 1:tf 2:tf-cc 3:weighted 4: weighted-cc"));

        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtest");
            while (rs.next()) {
                int id = rs.getInt(1);
                String term = rs.getString(4);
                String aspect = rs.getString(6);

                String[] lemmas = term.split("\\s");
                int len = lemmas.length;
                int[][] testmatrix = new int[len][6];
                for (int start = 0; start < lemmas.length; start++) {
                    String[] data = GetMatrix(lemmas[start]).split(",");
                    testmatrix[start][0] = Integer.parseInt(data[0]);
                    testmatrix[start][1] = Integer.parseInt(data[1]);
                    testmatrix[start][2] = Integer.parseInt(data[2]);
                    testmatrix[start][3] = Integer.parseInt(data[3]);
                    testmatrix[start][4] = Integer.parseInt(data[4]);
                    testmatrix[start][5] = Integer.parseInt(data[5]);
                }
                System.out.println("done");
                int ambi = 0;
                int food = 0;
                int worth = 0;
                int rest = 0;
                int pri = 0;
                int ser = 0;

                for (int segpoint = 0; segpoint < testmatrix.length; segpoint++) {
                    ambi = ambi + testmatrix[segpoint][0];
                    food = food + testmatrix[segpoint][1];
                    worth = worth + testmatrix[segpoint][2];
                    rest = rest + testmatrix[segpoint][3];
                    ser = ser + testmatrix[segpoint][4];
                    pri = pri + testmatrix[segpoint][5];

                }
                double tot = ambi + food + worth + rest + ser + pri;
                double ambiweight = (ambi / tot);
                double foodweight = (food / tot);
                double worthweight = (worth / tot);
                double restweight = (rest / tot);
                double serweight = (ser / tot);
                double priweight = (pri / tot);
                  
                System.out.println(ambiweight + "\t" + foodweight + "\t" + worthweight + "\t" + restweight + "\t" + serweight + "\t" + priweight);
                double data[] = new double[]{ambiweight, foodweight,worthweight, restweight, serweight, priweight};
                double ValMax = getMax(data);
                String lbl = "";
                int flg = 0;
                if (ValMax == ambiweight) {
                    lbl = "Ambiance";
                    flg = 1;
                } else if (ValMax == foodweight && flg != 1) {
                    lbl = checkflag(id, con);
                    flg = 1;
                } else if (ValMax == worthweight && flg != 1) {
                    lbl = "Worthiness";
                    flg = 1;
                } else if (ValMax == restweight && flg != 1) {
                    lbl = "Restaurant";
                    flg = 1;
                } else if (ValMax == serweight && flg != 1) {
                    lbl = "Service";
                }
                else if (ValMax == priweight && flg != 1) {
                    lbl = "Price";
                }
                System.out.println("Predicted label is \t" + lbl);
                Connection conn = db.conn();
                Statement objstatement = conn.createStatement();
                if (val == 1) //TF
                {
                    methodname = "TF";
                    objstatement.executeUpdate("update reviewtest set tfaspect ='" + lbl + "' where id='" + id + "' ");
                }
                if (val == 2) // TF-CC
                {
                    methodname = "TF-CC";
                    objstatement.executeUpdate("update reviewtest set tfcoaspect ='" + lbl + "' where id='" + id + "' ");
                }
                if (val == 3) // WEIGHTED
                {
                    methodname = "weighted";
                    objstatement.executeUpdate("update reviewtest set weightedaspect ='" + lbl + "' where id='" + id + "' ");
                }
                if (val == 4) // WEIGHTED-CC
                {
                    methodname = "weighted-CC";
                    objstatement.executeUpdate("update reviewtest set weightedcoaspect ='" + lbl + "' where id='" + id + "' ");
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        JOptionPane.showMessageDialog(rootPane, "Done");
        Analysis.Performance p = new Performance();
        p.show();
        this.hide();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted");
            while (rs.next()) {
                String aspect = rs.getString(2);
                String term = rs.getString(3);

                String ambiance = Double.valueOf(rs.getString(4)) > 0.0 ? "1" : "0";
                String food = Double.valueOf(rs.getString(5)) > 0.0 ? "1" : "0";
                String worthiness = Double.valueOf(rs.getString(6)) > 0.0 ? "1" : "0";
                String rest = Double.valueOf(rs.getString(7)) > 0.0 ? "1" : "0";
                String service = Double.valueOf(rs.getString(8)) > 0.0 ? "1" : "0";
                String price = Double.valueOf(rs.getString(9)) > 0.0 ? "1" : "0";
                double w = Double.valueOf(rs.getString(11));

                System.out.println(aspect + "\t" + term + "\t" + ambiance + "\t" + food + "\t" + worthiness + "\t" + rest + "\t" + service + "\t" + price);
                String query = "insert into trainmatrix (aspect, term,ambiance,food,worthiness,Restaurant,service,price,weight) values ('" + aspect + "','" + term + "','" + ambiance + "','" + food + "','" + worthiness + "','" + rest + "','" + service + "','" + price + "','" + w + "')";
                st1.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Matrix Generation done");

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from cooccurance");
            while (rs.next()) {
                String aspect = rs.getString(2);
                String term = rs.getString(3);

                String ambiance = Double.valueOf(rs.getString(4)) > 0.0 ? "1" : "0";
                String food = Double.valueOf(rs.getString(5)) > 0.0 ? "1" : "0";
                String worthiness = Double.valueOf(rs.getString(6)) > 0.0 ? "1" : "0";
                String rest = Double.valueOf(rs.getString(7)) > 0.0 ? "1" : "0";
                String service = Double.valueOf(rs.getString(8)) > 0.0 ? "1" : "0";
                String price = Double.valueOf(rs.getString(9)) > 0.0 ? "1" : "0";

                double w = Double.valueOf(rs.getString(10));
                if (w < 0.60) {
                    System.out.println(aspect + "\t" + term + "\t" + ambiance + "\t" + food + "\t" + worthiness + "\t" + rest + "\t" + service + "\t" + price);
                    String query = "insert into trainmatrix (aspect, term,ambiance,food,worthiness,Restaurant,service,price,weight) values ('" + aspect + "','" + term + "','" + ambiance + "','" + food + "','" + worthiness + "','" + rest + "','" + service + "','" + price + "','" + w + "')";
                    st1.executeUpdate(query);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Matrix Generation done");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from cooccurance");
            while (rs.next()) {
                String aspect = rs.getString(2);
                String term = rs.getString(3);

                String ambiance = Double.valueOf(rs.getString(4)) > 0.0 ? "1" : "0";
                String food = Double.valueOf(rs.getString(5)) > 0.0 ? "1" : "0";
                String worthiness = Double.valueOf(rs.getString(6)) > 0.0 ? "1" : "0";
                String rest = Double.valueOf(rs.getString(7)) > 0.0 ? "1" : "0";
                String service = Double.valueOf(rs.getString(8)) > 0.0 ? "1" : "0";
                String price = Double.valueOf(rs.getString(9)) > 0.0 ? "1" : "0";

                double w = Double.valueOf(rs.getString(10));
                System.out.println(aspect + "\t" + term + "\t" + ambiance + "\t" + food + "\t" + worthiness + "\t" + rest + "\t" + service + "\t" + price);
                String query = "insert into trainmatrix (aspect, term,ambiance,food,worthiness,Restaurant,service,price,weight) values ('" + aspect + "','" + term + "','" + ambiance + "','" + food + "','" + worthiness + "','" + rest + "','" + service + "','" + price + "','" + w + "')";
                st1.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Matrix Generation done");
    }//GEN-LAST:event_jButton20ActionPerformed

    // Function for sorting the weight
    public static double getMax(double[] inputArray) {
        double maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static int GetCurrentcategoryweight(ArrayList current, String term) {
        int count = 0;
        for (int start = 0; start < current.size(); start++) {
            String data = current.get(start).toString();
            if (data.equalsIgnoreCase(term)) {
                count = count + 1;
            }
        }
        return count;
    }

    public static String Gettearmsothercategory(String aspect, String term) {
        String sum = "";
        double som = 0;
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from cooccurance where aspect ='" + aspect + "' and term ='" + term + "'");
            while (rs.next()) {
                double a = Double.valueOf(rs.getString(4));
                double b = Double.valueOf(rs.getString(5));
                double c = Double.valueOf(rs.getString(6));
                double d = Double.valueOf(rs.getString(7));
                double e = Double.valueOf(rs.getString(8));
                som = a + b + c + d + e;
                sum = a + "," + b + "," + c + "," + d + "," + e + "," + som;

            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return sum;
    }

    public void Gettearms(String username) {
        //jp=new JOptionPane();
        // MyLoadingDialog d=new MyLoadingDialog();//(MyLoadingDialog)jp.createDialog("Please wait while processing");
        //d.set
        Frame window = new Frame();

        // Create a modal dialog
        Dialog d = new Dialog(window, "Message", false);

        // Use a flow layout
        d.setLayout(new FlowLayout());
        d.setBounds(600, 300, 200, 100);
        // Create an OK button
        d.add(new Label("Please wait while processing"));

        // Show dialog
        // d.pack();
        d.setVisible(true);

        //JOptionPane.showMessageDialog(rootPane, "please wait while processing");
        int pos = 0, neg = 0;
        // System.out.println("In Doget Method"+name);
        try {
            Connection con = DbconnYelp.conn();

            Statement stUpdate = con.createStatement();

            // stUpdate.executeUpdate("update productdescription set Process='OK' where Name='"+name+"'");
            Classifier csScore = new Classifier();
            Statement stSelect = con.createStatement();
            stSelect.executeQuery("truncate reviewdetails");
            ResultSet rsProcess;
            String query;
            if (username.equalsIgnoreCase("admin")) {
                query = "select * from productdescription where Name='admin'";
            } else {
                query = "select * from productdescription where ! (Name ='admin')";
            }
            rsProcess = stSelect
                    .executeQuery(query);
            while (rsProcess.next()) {
                String CommentedText = rsProcess.getString("Comment");

                StringTokenizer stdot = new StringTokenizer(CommentedText, ".");

                while (stdot.hasMoreTokens()) {
                    String FirstTokendot = stdot.nextToken();
                    System.out.println("====== token of dot ===== " + FirstTokendot);

                    StringTokenizer stComma = new StringTokenizer(FirstTokendot, ",");

                    while (stComma.hasMoreTokens()) {
                        String FirstTokenComma = stComma.nextToken();
                        System.out.println("====== token of comma ===== "
                                + FirstTokenComma);

                        String arr[] = FirstTokenComma.split("but");
                        System.out.println(" ----- " + arr.length);
                        Stemmer ss = new Stemmer();
                        RemoveStopwords rmst = new RemoveStopwords();
                        for (int i = 0; i < arr.length; i++) {
                            String arr1[] = arr[i].split("and");
                            System.out.println(" ----- " + arr1.length);
                            for (int i1 = 0; i1 < arr1.length; i1++) {
                                StringTokenizer stSemi = new StringTokenizer(arr1[i1], ";");

                                while (stSemi.hasMoreTokens()) {
                                    String FirstToken = stSemi.nextToken();
                                    System.out.println("First Token " + FirstToken);

                                    String stopwordless = rmst.RemoveWords(FirstToken);

                                    String fname = "F:\\StemmerInput.txt";

                                    Writer writer = null;
                                    writer = new BufferedWriter(new OutputStreamWriter(
                                            new FileOutputStream(fname), "utf-8"));
                                    writer.append(stopwordless);
                                    writer.close();
                                    String Stemmed = ss.GetData(fname);
                                    System.out.println("Final Data after Stemmed: - \t"
                                            + Stemmed);

                                    calculateScore calculateScore = new calculateScore();
                                    // calculateScore.Calcscore(Stemmed);
                                    String score = calculateScore.Calcscore(Stemmed);
                                    System.out.println(score);
                                    pos = 0;
                                    neg = 0;
                                    String[] parts = score.split("\t");
                                    pos = Integer.parseInt(parts[0]);
                                    neg = Integer.parseInt(parts[1]);
                                    int size = 10;
                                    System.out.println("Postive words:- " + pos);
                                    System.out.println("Negetive words:- " + neg);
                                    Statement stCount = con.createStatement();
                                    ResultSet rsCount = stCount.executeQuery("select count(*) from trainnigdata");
                                    if (rsCount.next()) {
                                        size = rsCount.getInt(1);
                                    }

                                    String insertQuery = "";
                                    double[] arrScore = new double[size];
                                    double[] arrScore1 = new double[size];
                                    Statement stScore = con.createStatement();
                                    ResultSet rsScore = stScore.executeQuery("select * from trainnigdata");
                                    int is = 0;
                                    while (rsScore.next()) {
                                        String Aspect = rsScore.getString("Synonmus");
                                        arrScore[is] = csScore.GetNBScore(Aspect.toLowerCase(), Stemmed.toLowerCase());
                                        is++;
                                    }

                                    Arrays.sort(arrScore);
                                    String AspectNbScore = "";
                                    System.out.println("------ aaaaaaaaaaa -------- " + arrScore[arrScore.length - 1]);
                                    double large = arrScore[arrScore.length - 1];
                                    ResultSet rsScore1 = stScore.executeQuery("select * from trainnigdata");
                                    if (large != 0.0) {

                                        System.out.println("------ aaaaaaaaaaa -------- " + arrScore[arrScore.length - 1]);
                                        double Check = 0;
                                        while (rsScore1.next()) {
                                            String Aspect = rsScore1.getString("Synonmus");
                                            Check = csScore.GetNBScore(Aspect.toLowerCase(), Stemmed.toLowerCase());
                                            if (Check == large) {
                                                AspectNbScore = rsScore1.getString("Aspect");;
                                            }

                                        }
                                    }

                                    insertQuery = "insert into reviewdetails values('"
                                            + Stemmed + "','" + AspectNbScore + "','" + pos + "','" + neg
                                            + "')";

                                    /*if (Stemmed.contains("Screen")
                                     || Stemmed.contains("screen")) {
						
						
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','screen','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Camera")
                                     || Stemmed.contains("camera")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','camera','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Battery")
                                     || Stemmed.contains("battery")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','battery','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Ram") || Stemmed.contains("ram")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','ram','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Processor")
                                     || Stemmed.contains("processor")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','processor','" + pos + "','"
                                     + neg + "')";
                                     }
                                     if (Stemmed.contains("Speed") || Stemmed.contains("speed")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','speed','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Memory")
                                     || Stemmed.contains("memory")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','memory','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Sound") || Stemmed.contains("sound")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','sound','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("Weight")
                                     || Stemmed.contains("weight")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','weight','" + pos + "','" + neg
                                     + "')";
                                     }
                                     if (Stemmed.contains("OS") || Stemmed.contains("os")) {
                                     insertQuery = "insert into reviewdetails values('"
                                     + Stemmed + "','os','" + pos + "','" + neg
                                     + "')";
                                     }*/
                                    System.out.println(" Query for update is " + insertQuery);
                                    Statement stSelectUpdate = con.createStatement();
                                    Boolean ResultUpdate = false;
                                    ResultSet rsSelectUpdate;

                                    Statement st1 = con.createStatement();
                                    if (!AspectNbScore.equals("")) {
                                        // st1.executeUpdate("insert into reviewdetails(UserCommented) values('"
                                        // + name + "'  )");
                                        Statement st1Update = con.createStatement();
                                        st1Update.executeUpdate(insertQuery);
                                    }

                                }

                            }
                        }
                    }
                }
                //	------------

            }

            pos = 0;
            neg = 0;
            Statement st4 = con.createStatement();
            ResultSet rs4 = st4.executeQuery("select * from  reviewdetails");
            while (rs4.next()) {
                pos = pos + rs4.getInt(3);
                neg = neg + rs4.getInt(4);

            }

//			session.setAttribute("pos", pos);
//			session.setAttribute("neg", neg);
//
//			RequestDispatcher rd = request
//					.getRequestDispatcher("/DisplayStemmed.jsp");
//			rd.include(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        d.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProcessComments().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
