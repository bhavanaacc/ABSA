/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yelp.SentimentProcess;

import master.DbconnYelp;
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
 public static void ExecuProcessUpdate()
 // public static void main(String[] args)
    {
         try{
      DbconnYelp db = new DbconnYelp();
            Connection con = (Connection) db.conn();
            Statement st = (Statement) con.createStatement();
             ResultSet rs = (ResultSet) st.executeQuery("select * from weighted");
            while (rs.next()) {
                
               int id =rs.getInt(1);
               String aspect =rs.getString(2);
               String term =rs.getString(3);
              
//               if(aspect.equalsIgnoreCase("food"))
//               {
                   double ambance=0.0;
                   double rest=0.0;
                   double wort=0.0;;
                   double service=0.0;
                   double food=0.0;
                     double price=0.0;
                   
                   Statement st1 = con.createStatement();
                 ResultSet rs1=(ResultSet) st1.executeQuery("select weight from weighted where aspect ='ambiance' and term ='"+term+"'");
                 if(rs1.next()) 
                 { 
                     ambance=rs1.getDouble(1);
                   }
                 
                 Statement st2 = con.createStatement();
                 ResultSet rs2=(ResultSet) st2.executeQuery("select weight from weighted where aspect ='Worthiness'and term ='"+term+"'");
                 if(rs2.next())
                 {
                     wort= rs2.getDouble(1);
                 }
                 
                 Statement st3 = con.createStatement();
                 ResultSet rs3=(ResultSet) st3.executeQuery("select weight from weighted where aspect ='Restaurant'and term ='"+term+"'");
                 if(rs3.next())
                 {
                      rest=rs3.getDouble(1);
                 }
                  
                 
                 Statement st4 = con.createStatement();
                 ResultSet rs4=(ResultSet) st4.executeQuery("select weight from weighted where aspect ='service'and term ='"+term+"'");
                 if(rs4.next())
                 {
                     
                     service=rs4.getDouble(1);
                 }
                  
                  Statement st5 = con.createStatement();
                 ResultSet rs5=(ResultSet) st5.executeQuery("select weight from weighted where aspect ='food'and term ='"+term+"'");
                 if(rs5.next())
                 {
                     
                     food=rs5.getDouble(1);
                 }
                 
                   Statement st6 = con.createStatement();
                 ResultSet rs6=(ResultSet) st6.executeQuery("select weight from weighted where aspect ='price'and term ='"+term+"'");
                 if(rs6.next())
                 {
                     
                     price=rs6.getDouble(1);
                 }
                 Statement stmt7=con.createStatement();
                 stmt7.executeUpdate("update weighted set ambiance='"+ambance+"', food ='"+food+"',restaurant ='"+rest+"',service ='"+service+"',Worthiness ='"+wort+"',price ='"+price+"' where id ="+id+"");
                 
              // }
               
            }
            System.out.println("done");
        }
        catch(Exception ex){ System.out.println(ex);}
}
}
