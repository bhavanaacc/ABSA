/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yelp.DependancyParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import master.DbconnYelp;

/**
 *
 * @author Sunsoft
 */
public class dependacytrainmatrix {

    public static String lbl = "";
    public static int flg = 0;

    public static String GetMatrix(String term) {
        int flag = 0;
        String res = "";

        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            //ResultSet rs = (ResultSet) st.executeQuery("select * from dptrainmatrix where term ='"+ term +"'");
            ResultSet rs = (ResultSet) st.executeQuery("select * from hybridmatrix where term ='" + term + "'");
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

    public static void Test() {
        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtest");
            while (rs.next()) {
                int id = rs.getInt(1);
                String term0 = rs.getString(4);
                String term1 = rs.getString(5);
                String aspect = rs.getString(6);
                String[] lemmas1 = term0.split("\\s");
                String[] lemmas2 = term1.split(",");

//**************** For Both *****************************************
                String[] DPlemmas = getsum(lemmas1, lemmas2); // both leamms and NLP      
//*********************For Lemmas***********************************************
                //  String[] DPlemmas = lemmas1; // only lemmas
//**************** For NLP *****************************************
         //       String[] DPlemmas = lemmas2; // only NLP
                //**************************************************

               int len = DPlemmas.length;
                int[][] testmatrix = new int[len][6];
                for (int start = 0; start < DPlemmas.length; start++) {
                    String[] data = GetMatrix(DPlemmas[start]).split(",");
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
                 System.out.println(id + "Predicted label is \t" + lbl);
                flg = 0;
                Connection conn = db.conn();
                Statement objstatement = conn.createStatement();
                objstatement.executeUpdate("update reviewtest set dpaspect ='" + lbl + "' where id='" + id + "' ");
            }
        } catch (Exception ex) {
            System.out.println("Here:" + ex);
        }
    }

    public static String checkflag(int id, Connection con) {
        String result = "";
        try {
            Connection conn = con;
            Statement st = con.createStatement();
            st.executeQuery("select aspect from reviewtest93. where id= '" + id + "'");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                result = rs.getString("aspect");
            }
        } catch (Exception e) {
        }
        return result;
    }
    // Function for sorting the weight

    public static String[] getsum(String[] first, String[] second) {
        List<String> both = new ArrayList<String>(first.length + second.length);
        Collections.addAll(both, first);
        Collections.addAll(both, second);
        return both.toArray(new String[both.size()]);
    }

    public static double getMax(double[] inputArray) {
        double maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static void GenerateHybridFset() {
        try {
            DbconnYelp db = new DbconnYelp();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            Statement st2 = (com.mysql.jdbc.Statement) con.createStatement();
            st2.executeUpdate("truncate hybridmatrix");
            st.executeUpdate("INSERT INTO hybridmatrix SELECT * FROM dptrainmatrix");
            st1.executeUpdate("INSERT INTO hybridmatrix SELECT * FROM trainmatrix");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
GenerateHybridFset();
    }
}
