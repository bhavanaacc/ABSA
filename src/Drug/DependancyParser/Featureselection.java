package Drug.DependancyParser;

import static Drug.DependancyParser.TrainTFDP.Exeprocess;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import master.DbconnDrug;

public class Featureselection {

    public static ArrayList Birth_ControlF = new ArrayList();
    public static ArrayList DepressionF = new ArrayList();
    public static ArrayList Bipolar_DisordeF = new ArrayList();
    public static ArrayList PainF = new ArrayList();
    public static ArrayList Weight_LossF = new ArrayList();

    public static ArrayList Birth_ControlTF = new ArrayList();
    public static ArrayList DepressionTF = new ArrayList();
    public static ArrayList Bipolar_DisordeTF = new ArrayList();
    public static ArrayList PainTF = new ArrayList();
    public static ArrayList Weight_LossTF = new ArrayList();

    public static ArrayList AllinOne = new ArrayList();
    public static ArrayList AllinTFOne = new ArrayList();

    public static void LoadComments() {
        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();

            ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtrain order by id asc");
            while (rs.next()) {
                String id = rs.getString(1);
                String dependancy = rs.getString(5);
                String aspect = rs.getString(6);
                if (aspect.equalsIgnoreCase("Birth Control")) {
                    Birth_ControlF.add(id + "#" + dependancy);
                }
                if (aspect.equalsIgnoreCase("Depression")) {
                    DepressionF.add(id + "#" + dependancy);
                }
                if (aspect.equalsIgnoreCase("Bipolar Disorde")) {
                    Bipolar_DisordeF.add(id + "#" + dependancy);
                }
                if (aspect.equalsIgnoreCase("Pain")) {
                    PainF.add(id + "#" + dependancy);
                }
                if (aspect.equalsIgnoreCase("Weight Loss")) {
                    Weight_LossF.add(id + "#" + dependancy);
                }

            }
            System.out.println("Birth Control \t" + Birth_ControlF.size());
            System.out.println("Depression \t" + DepressionF.size());
            System.out.println("Bipolar Disorde \t" + Bipolar_DisordeF.size());
            System.out.println("pain \t" + PainF.size());
            System.out.println("weight loss \t" + Weight_LossF.size());
        } catch (Exception ex) {
        }

    }

    public static void GetSelectedTFIDFFeatures() {
        try {
            DbconnDrug db = new DbconnDrug();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select  distinct(term), aspect, frequency from dpfrequency order by frequency desc;");

            while (rs.next()) {
                String term = rs.getString(1);
                String aspect = rs.getString(2);
                int freq = Integer.parseInt(rs.getString(3));

                if (aspect.equalsIgnoreCase("Birth Control")) {
                    Birth_ControlTF.add(term);
                    AllinTFOne.add(term);
                }
                if (aspect.equalsIgnoreCase("Pain")) {
                    PainTF.add(term);
                    AllinTFOne.add(term);
                }
                if (aspect.equalsIgnoreCase("Bipolar Disorde")) {
                    Bipolar_DisordeTF.add(term);
                    AllinTFOne.add(term);
                }
                if (aspect.equalsIgnoreCase("Weight Loss")) {
                    Weight_LossTF.add(term);
                    AllinTFOne.add(term);
                }
                if (aspect.equalsIgnoreCase("Depression")) {
                    DepressionTF.add(term);
                    AllinTFOne.add(term);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Birth_Control features :" + Birth_ControlTF.size());
        System.out.println(" Bipolar DisordeTF features :" + Bipolar_DisordeTF.size());
        System.out.println(" Pain features :" + PainTF.size());
        System.out.println(" Depression features :" + DepressionTF.size());
        System.out.println(" Weight Loss features :" + Weight_LossTF.size());
        System.out.println(" All features :" + AllinTFOne.size());

    }

    public static void GneerateTrainMatrix() {
        try {
            Connection con = DbconnDrug.conn();
            Connection con1 = DbconnDrug.conn();
            Statement st = con.createStatement();
            Statement st1 = con1.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from dpcooccurance");
            while (rs.next()) {
                String aspect = rs.getString(2);
                String term = rs.getString(3);
                String birth = Double.valueOf(rs.getString(4)) > 0.0 ? "1" : "0";
                String dep = Double.valueOf(rs.getString(5)) > 0.0 ? "1" : "0";
                String bop = Double.valueOf(rs.getString(6)) > 0.0 ? "1" : "0";
                String pain = Double.valueOf(rs.getString(7)) > 0.0 ? "1" : "0";
                String wl = Double.valueOf(rs.getString(8)) > 0.0 ? "1" : "0";
                System.out.println(aspect + "\t" + term + "\t" + birth + "\t" + dep + "\t" + bop + "\t" + pain + "\t" + wl);
                String query = "insert into dptrainmatrix (aspect, term,Birth_Control,Depression,Bipolar_Disorde,Pain,Weight_Loss) values ('" + aspect + "','" + term + "','" + birth + "','" + dep + "','" + bop + "','" + pain + "','" + wl + "')";
                st1.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("Matrix Generation done");
    }

}
