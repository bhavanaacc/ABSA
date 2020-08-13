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

/**
 *
 * @author Sunsoft
 */
public class Geteachweight {

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static void ExecuProcessUpdate() // public static void main(String[] args)
    {
        try {
            DbconnDrug db = new DbconnDrug();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted");
            while (rs.next()) {

                int id = rs.getInt(1);
                String aspect = rs.getString(2);
                String term = rs.getString(3);

//               if(aspect.equalsIgnoreCase("food"))
//               {
                double Birth_Control = 0.0;
                double Depression = 0.0;
                double Bipolar_Disorde = 0.0;;
                double Pain = 0.0;
                double Weight_Loss = 0.0;
                Statement st1 = con.createStatement();
                ResultSet rs1 = (ResultSet) st1.executeQuery("select weight from weighted where aspect ='Birth Control' and term ='" + term + "'");
                if (rs1.next()) {
                    Birth_Control = rs1.getDouble(1);
                }

                Statement st2 = con.createStatement();
                ResultSet rs2 = (ResultSet) st2.executeQuery("select weight from weighted where aspect ='Depression'and term ='" + term + "'");
                if (rs2.next()) {
                    Depression = rs2.getDouble(1);
                }

                Statement st3 = con.createStatement();
                ResultSet rs3 = (ResultSet) st3.executeQuery("select weight from weighted where aspect ='Bipolar Disorde'and term ='" + term + "'");
                if (rs3.next()) {
                    Bipolar_Disorde = rs3.getDouble(1);
                }

                Statement st4 = con.createStatement();
                ResultSet rs4 = (ResultSet) st4.executeQuery("select weight from weighted where aspect ='Pain'and term ='" + term + "'");
                if (rs4.next()) {

                    Pain = rs4.getDouble(1);
                }

                Statement st5 = con.createStatement();
                ResultSet rs5 = (ResultSet) st5.executeQuery("select weight from weighted where aspect ='Weight Loss'and term ='" + term + "'");
                if (rs5.next()) {

                    Weight_Loss = rs5.getDouble(1);
                }
                Statement stmt6 = con.createStatement();
                stmt6.executeUpdate("update weighted set Birth_Control='" + Birth_Control + "', Bipolar_Disorde ='" + Bipolar_Disorde + "',Pain ='" + Pain + "',Depression ='" + Depression + "',Weight_Loss ='" + Weight_Loss + "' where id =" + id + "");

                // }
            }
            System.out.println("done");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
