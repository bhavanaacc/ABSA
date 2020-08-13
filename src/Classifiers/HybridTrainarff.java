  
         /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classifiers;

import master.DbconnSemeval;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sunsoft
 */
public class HybridTrainarff {
    
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
        File file = new File("F:/arff1/HybridTrainarff.arff");
        FileWriter writer=null;
     try {
         DbconnSemeval db=new DbconnSemeval();
            Connection con = null;
            con = db.conn();
            Statement stat =con.createStatement();
            stat.executeQuery("select * from dptrainmatrix order by aspect");
             writer = new FileWriter(file);
            ResultSet rs = null;
            rs = stat.getResultSet();
            int pj=0;
            writer.write("@relation 'Aspect'");
             writer.write("\n");
            writer.write("@attribute 'id' numeric");
            writer.write("\n");
            writer.write("@attribute 'term' "+getstr()+"");
             writer.write("\n");
            writer.write("@attribute 'aspect' {ambiance,price,service,miscellaneous,food}");
             writer.write("\n");
            writer.write("@data");
             writer.write("\n");
              StringBuilder tokens=new StringBuilder();
           while (rs.next()) {
 
               String ss=kk+","+rs.getString(3).toLowerCase()+","+rs.getString(2);
               kk++;
               writer.write(ss);
               writer.write("\n");
               System.out.println(ss);
   }
           //*****************************
           Statement stat1 =con.createStatement();
            stat1.executeQuery("select * from trainmatrix order by aspect");
            ResultSet rs1 = null;
            rs1 = stat1.getResultSet();
           while (rs1.next()) {
 
               String ss=kk+","+rs1.getString(3).toLowerCase()+","+rs1.getString(2);
               kk++;
               writer.write(ss);
               writer.write("\n");
               System.out.println(ss);
   }
           
           //*************************************************
           
        writer.close();
        } catch (Exception ex) {
            
            System.out.println(ex);
            
        }
    }
}