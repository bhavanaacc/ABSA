/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yelp.arff.string;

import Classifiers.*;
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
public class DTFTrainarff {
    
    public static String getstr()
    {
        StringBuilder sb=new StringBuilder();
        sb.append("{");
  try{
           DbconnYelp db=new DbconnYelp();
            Connection con = null;
            con = db.conn();
            Statement stat =con.createStatement();
            stat.executeQuery("select distinct(term) from dptrainmatrix");
            ResultSet rs = null;
            rs = stat.getResultSet();
             while (rs.next()) {
                 sb.append(rs.getString(1).toLowerCase()+",");
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
        File file = new File("F:/arff2/DTFTrainarff.arff");
        FileWriter writer=null;
     try {
         DbconnYelp db=new DbconnYelp();
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
            writer.write("@attribute 'aspect' {ambiance,Ambience,Price,Service,Restaurant,Worthiness,Food,ambience,price,service,restaurant,worthiness,food}");
             writer.write("\n");
            writer.write("@data");
             writer.write("\n");
             int kk=0;
             StringBuilder tokens=new StringBuilder();
           while (rs.next()) {
 
               String ss=rs.getString(1)+","+rs.getString(3).toLowerCase()+","+rs.getString(2);
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