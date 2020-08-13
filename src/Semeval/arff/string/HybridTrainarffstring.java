
package semeval.arff.string;

import master.DbconnSemeval;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HybridTrainarffstring {
    
    public static String getstr()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("{");
  try{
           DbconnSemeval db=new DbconnSemeval();
            Connection con = null;
            con = db.conn();
            Statement stat =con.createStatement();
            stat.executeQuery("select distinct(term) from dptrainmatrix");
             ResultSet rs = null;
            rs = stat.getResultSet();
             while (rs.next()) {
                 sb.append(rs.getString(1).toLowerCase()+",");
             }
             
             Statement stat1 =con.createStatement();
            stat1.executeQuery("select distinct(term) from trainmatrix");
            ResultSet rs1 = null;
            rs1 = stat1.getResultSet();
             while (rs1.next()) {
                 sb.append(rs1.getString(1).toLowerCase()+",");
             }
             
             sb.append("}");
        }
        catch(Exception ex)
        {
        }
        System.out.println(sb.toString());
  return sb.toString();
    }
    
    
    public static void main(String[] str)
    {
        int kk=0;
        File file = new File("F:/arff1/HybridTrainarffstring.arff");
        FileWriter writer=null;
     try {
         DbconnSemeval db=new DbconnSemeval();
            Connection con = null;
            con = db.conn();
            Statement stat =con.createStatement();
            stat.executeQuery("select * from reviewtrain");
             writer = new FileWriter(file);
            ResultSet rs = null;
            rs = stat.getResultSet();
            int pj=0;
            writer.write("@relation 'Aspect'");
             writer.write("\n");
            writer.write("@attribute 'id' numeric");
            writer.write("\n");
            writer.write("@attribute 'term' string");
             writer.write("\n");
            writer.write("@attribute 'aspect' {ambiance,price,service,anecdotes/miscellaneous,food}");
             writer.write("\n");
            writer.write("@data");
             writer.write("\n");
             
           while (rs.next()) {
                StringBuilder tokens=new StringBuilder();
               tokens.append(rs.getString(4));
 String data1[] = rs.getString(5).split(",");
 for(int jj=0; jj<data1.length-1; jj++)
 {
     tokens.append(data1[jj]+" ");
 }
 
               String ss=kk+",'"+tokens.toString()+"',"+rs.getString(6);
               kk++;
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