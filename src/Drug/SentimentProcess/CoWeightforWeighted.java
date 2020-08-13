/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drug.SentimentProcess;

import master.DbconnDrug;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sunsoft
 */
public class CoWeightforWeighted {

    public static ArrayList AspectListBirth_Control = new ArrayList();
    public static ArrayList AspectListDepression = new ArrayList();
    public static ArrayList AspectListBipolar_Disorde = new ArrayList();
    public static ArrayList AspectListPain = new ArrayList();
    public static ArrayList AspectListWeight_Loss = new ArrayList();

    public static ArrayList GetList(String aspectTerm) {
        ArrayList List = new ArrayList();
        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='" + aspectTerm + "'");
            while (rs.next()) {
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                String BC = rs.getString("Birth_Control");
                String depress = rs.getString("Depression");
                String pain = rs.getString("Pain");
                String BD = rs.getString("Bipolar_Disorde");
                String WL = rs.getString("Weight_Loss");
                List.add(id + "," + aspect + "," + term + "," + BC + "," + depress + "," + pain + "," + BD + "," + WL);
            }
        } catch (Exception ex) {
        }
        return List;
    }

    public static void calcualateCorelation() {
        Birth_ControlWeight();
        Depressionweight();
        Painweight();
        Bipolar_Disordeweight();
        Weight_Lossweight();
    }

    public static void Birth_ControlWeight() {

        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            AspectListBirth_Control = GetList("Birth Control");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='Birth Control'");

            while (rs.next()) {
                double sum = 0.0;
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                
                double BC = Double.valueOf(rs.getString("Birth_Control"));
                double dep = Double.valueOf(rs.getString("Depression"));
                double pain = Double.valueOf(rs.getString("Pain"));
                double BD = Double.valueOf(rs.getString("Bipolar_Disorde"));
                double WL = Double.valueOf(rs.getString("Weight_Loss"));
                
                for (int start = 0; start < AspectListBirth_Control.size(); start++) {
                    String[] dataparts = AspectListBirth_Control.get(start).toString().split(",");
                    String Fs = dataparts[2].toString();
                
                   double BC1 = Double.valueOf(dataparts[3]);
                    double dep1 = Double.valueOf(dataparts[4]);
                    double pain1 = Double.valueOf(dataparts[5]);
                    double BD1 = Double.valueOf(dataparts[6]);
                    double WL1 = Double.valueOf(dataparts[7]);
                    
                    double coeeff = 0.0;
                    double X[] = {BC, dep, pain, BD, WL};
                    double Y[] = {BC1, dep1, pain1, BD1, WL1};
                    int n = X.length;
                    coeeff = correlationCoefficient(X, Y, n);
                    sum = (sum + coeeff);
                }
                double avg = (sum / Double.valueOf(AspectListBirth_Control.size()));
                if (Double.isNaN(avg) || Double.isInfinite(avg)) {
                    avg = (float) 0.0;
                }
                System.out.println("Term \t" + term + "Average \t" + avg);
                Statement st1 = con.createStatement();
                st1.executeUpdate("update weighted set weight='" + String.valueOf(avg) + "' where id =" + id + "");
                AspectListBirth_Control.remove(term);
            }
        } catch (Exception ex) {
            System.out.println("1" + ex);
        }
    }

    public static void Depressionweight() {

         try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            AspectListDepression = GetList("Depression");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='Depression'");

            while (rs.next()) {
                double sum = 0.0;
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                
                double BC = Double.valueOf(rs.getString("Birth_Control"));
                double dep = Double.valueOf(rs.getString("Depression"));
                double pain = Double.valueOf(rs.getString("Pain"));
                double BD = Double.valueOf(rs.getString("Bipolar_Disorde"));
                double WL = Double.valueOf(rs.getString("Weight_Loss"));
                
                for (int start = 0; start < AspectListDepression.size(); start++) {
                    String[] dataparts = AspectListDepression.get(start).toString().split(",");
                    String Fs = dataparts[2].toString();
                
                   double BC1 = Double.valueOf(dataparts[3]);
                    double dep1 = Double.valueOf(dataparts[4]);
                    double pain1 = Double.valueOf(dataparts[5]);
                    double BD1 = Double.valueOf(dataparts[6]);
                    double WL1 = Double.valueOf(dataparts[7]);
                    
                    double coeeff = 0.0;
                    double X[] = {BC, dep, pain, BD, WL};
                    double Y[] = {BC1, dep1, pain1, BD1, WL1};
                    int n = X.length;
                    coeeff = correlationCoefficient(X, Y, n);
                    sum = (sum + coeeff);
                }
                double avg = (sum / Double.valueOf(AspectListDepression.size()));
                if (Double.isNaN(avg) || Double.isInfinite(avg)) {
                    avg = (float) 0.0;
                }
                System.out.println("Term \t" + term + "Average \t" + avg);
                Statement st1 = con.createStatement();
                st1.executeUpdate("update weighted set weight='" + String.valueOf(avg) + "' where id =" + id + "");
                AspectListDepression.remove(term);
            }
        } catch (Exception ex) {
            System.out.println("1" + ex);
        }
    }

    public static void Painweight() {

        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            AspectListPain = GetList("Pain");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='Pain'");

            while (rs.next()) {
                double sum = 0.0;
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                
                double BC = Double.valueOf(rs.getString("Birth_Control"));
                double dep = Double.valueOf(rs.getString("Depression"));
                double pain = Double.valueOf(rs.getString("Pain"));
                double BD = Double.valueOf(rs.getString("Bipolar_Disorde"));
                double WL = Double.valueOf(rs.getString("Weight_Loss"));
                
                for (int start = 0; start < AspectListPain.size(); start++) {
                    String[] dataparts = AspectListPain.get(start).toString().split(",");
                    String Fs = dataparts[2].toString();
                
                   double BC1 = Double.valueOf(dataparts[3]);
                    double dep1 = Double.valueOf(dataparts[4]);
                    double pain1 = Double.valueOf(dataparts[5]);
                    double BD1 = Double.valueOf(dataparts[6]);
                    double WL1 = Double.valueOf(dataparts[7]);
                    
                    double coeeff = 0.0;
                    double X[] = {BC, dep, pain, BD, WL};
                    double Y[] = {BC1, dep1, pain1, BD1, WL1};
                    int n = X.length;
                    coeeff = correlationCoefficient(X, Y, n);
                    sum = (sum + coeeff);
                }
                double avg = (sum / Double.valueOf(AspectListPain.size()));
                if (Double.isNaN(avg) || Double.isInfinite(avg)) {
                    avg = (float) 0.0;
                }
                System.out.println("Term \t" + term + "Average \t" + avg);
                Statement st1 = con.createStatement();
                st1.executeUpdate("update weighted set weight='" + String.valueOf(avg) + "' where id =" + id + "");
                AspectListPain.remove(term);
            }
        } catch (Exception ex) {
            System.out.println("1" + ex);
        }
    }

    public static void Bipolar_Disordeweight() {

        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            AspectListBipolar_Disorde = GetList("Bipolar Disorde");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='Bipolar Disorde'");

            while (rs.next()) {
                double sum = 0.0;
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                
                double BC = Double.valueOf(rs.getString("Birth_Control"));
                double dep = Double.valueOf(rs.getString("Depression"));
                double pain = Double.valueOf(rs.getString("Pain"));
                double BD = Double.valueOf(rs.getString("Bipolar_Disorde"));
                double WL = Double.valueOf(rs.getString("Weight_Loss"));
                
                for (int start = 0; start < AspectListBipolar_Disorde.size(); start++) {
                    String[] dataparts = AspectListBipolar_Disorde.get(start).toString().split(",");
                    String Fs = dataparts[2].toString();
                
                   double BC1 = Double.valueOf(dataparts[3]);
                    double dep1 = Double.valueOf(dataparts[4]);
                    double pain1 = Double.valueOf(dataparts[5]);
                    double BD1 = Double.valueOf(dataparts[6]);
                    double WL1 = Double.valueOf(dataparts[7]);
                    
                    double coeeff = 0.0;
                    double X[] = {BC, dep, pain, BD, WL};
                    double Y[] = {BC1, dep1, pain1, BD1, WL1};
                    int n = X.length;
                    coeeff = correlationCoefficient(X, Y, n);
                    sum = (sum + coeeff);
                }
                double avg = (sum / Double.valueOf(AspectListBipolar_Disorde.size()));
                if (Double.isNaN(avg) || Double.isInfinite(avg)) {
                    avg = (float) 0.0;
                }
                System.out.println("Term \t" + term + "Average \t" + avg);
                Statement st1 = con.createStatement();
                st1.executeUpdate("update weighted set weight='" + String.valueOf(avg) + "' where id =" + id + "");
                AspectListBipolar_Disorde.remove(term);
            }
        } catch (Exception ex) {
            System.out.println("1" + ex);
        }
    }

    public static void Weight_Lossweight() {
        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            AspectListWeight_Loss = GetList("Weight Loss");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='Weight Loss'");

            while (rs.next()) {
                double sum = 0.0;
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                
                double BC = Double.valueOf(rs.getString("Birth_Control"));
                double dep = Double.valueOf(rs.getString("Depression"));
                double pain = Double.valueOf(rs.getString("Pain"));
                double BD = Double.valueOf(rs.getString("Bipolar_Disorde"));
                double WL = Double.valueOf(rs.getString("Weight_Loss"));
                
                for (int start = 0; start < AspectListWeight_Loss.size(); start++) {
                    String[] dataparts = AspectListWeight_Loss.get(start).toString().split(",");
                    String Fs = dataparts[2].toString();
                
                   double BC1 = Double.valueOf(dataparts[3]);
                    double dep1 = Double.valueOf(dataparts[4]);
                    double pain1 = Double.valueOf(dataparts[5]);
                    double BD1 = Double.valueOf(dataparts[6]);
                    double WL1 = Double.valueOf(dataparts[7]);
                    
                    double coeeff = 0.0;
                    double X[] = {BC, dep, pain, BD, WL};
                    double Y[] = {BC1, dep1, pain1, BD1, WL1};
                    int n = X.length;
                    coeeff = correlationCoefficient(X, Y, n);
                    sum = (sum + coeeff);
                }
                double avg = (sum / Double.valueOf(AspectListWeight_Loss.size()));
                if (Double.isNaN(avg) || Double.isInfinite(avg)) {
                    avg = (float) 0.0;
                }
                System.out.println("Term \t" + term + "Average \t" + avg);
                Statement st1 = con.createStatement();
                st1.executeUpdate("update weighted set weight='" + String.valueOf(avg) + "' where id =" + id + "");
                AspectListWeight_Loss.remove(term);
            }
        } catch (Exception ex) {
            System.out.println("1" + ex);
        }
    }

    static float correlationCoefficient(double X[], double Y[], int n) {

        double sum_X = 0, sum_Y = 0, sum_XY = 0;
        double squareSum_X = 0, squareSum_Y = 0;

        for (int i = 0; i < n; i++) {
            // sum of elements of array X. 
            sum_X = sum_X + X[i];

            // sum of elements of array Y. 
            sum_Y = sum_Y + Y[i];

            // sum of X[i] * Y[i]. 
            sum_XY = sum_XY + X[i] * Y[i];

            //  sum of square of array elements. 
            squareSum_X = squareSum_X + X[i] * X[i];
            squareSum_Y = squareSum_Y + Y[i] * Y[i];
        }

        // use formula for calculating correlation 
        // coefficient. 
        float corr = (float) (n * sum_XY - sum_X * sum_Y) / (float) (Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y)));
        if (Double.isNaN(corr)) {
            corr = (float) 0.0;
        }
        return corr;
    }
}
