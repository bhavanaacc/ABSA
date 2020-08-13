package Yelp.arff.string;

import master.DbconnYelp;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sunsoft
 */
public class HybridTestarffstring {

    public static String getstr() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = null;
            con = db.conn();
            Statement stat = con.createStatement();
            stat.executeQuery("select distinct(term) from dptrainmatrix");
            ResultSet rs = null;
            rs = stat.getResultSet();
            while (rs.next()) {
                sb.append(rs.getString(1).toLowerCase() + ",");
            }
            sb.append("}");
        } catch (Exception ex) {
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] str) {
        File file = new File("F:/arff2/HybridTestarffstring.arff");
        FileWriter writer = null;
        try {
            DbconnYelp db = new DbconnYelp();
            Connection con = null;
            con = db.conn();
            Statement stat = con.createStatement();
            stat.executeQuery("select * from reviewtrain");
            writer = new FileWriter(file);
            ResultSet rs = null;
            rs = stat.getResultSet();
            int pj = 0;
            writer.write("@relation 'Aspect'");
            writer.write("\n");
            writer.write("@attribute 'id' numeric");
            writer.write("\n");
            writer.write("@attribute 'term' string");
            writer.write("\n");
            writer.write("@attribute 'aspect' {ambiance,price,service, Restaurant,Worthiness,Food}");
            writer.write("\n");
            writer.write("@data");
            writer.write("\n");
            int kk = 0;
            StringBuilder tokens = new StringBuilder();
            while (rs.next()) {
                String parts = rs.getString(5).toLowerCase();
                String p1 = parts.replace(",", " ");
                String ss = "";
                ss = rs.getString(1) + ",'" + p1 + "'," + rs.getString(6);
                writer.write(ss);
                writer.write("\n");
                System.out.println(ss);

            }
            writer.close();
        } catch (Exception ex) {

            System.out.println(ex);

        }
    }
}
