/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Drug.SentimentProcess;

import Semeval.SentimentProcess.*;
 import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sunsoft
 */
public class NewClass1 {
    
     public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
 //public static void ExecuProcessUpdate()
   public static void main(String[] args)
    {
        
        //System.out.println(Gettearmsothercategory("food", "food"));
}
   
    public static String Gettearmsothercategory(String aspect, String term,Connection con)
    { 
        String sum="";
        double som=0;
        try{
//         Dbconn db= new Dbconn();
//        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
             ResultSet rs = (ResultSet) st.executeQuery("select * from cooccurance where aspect ='"+aspect +"' and term ='"+term+"'");
            while (rs.next())
          {
          double a= Double.valueOf(rs.getString(4));
          double b= Double.valueOf(rs.getString(5));
          double c= Double.valueOf(rs.getString(6));
          double d= Double.valueOf(rs.getString(7));
          double e= Double.valueOf(rs.getString(8));
           som=a+b+c+d+e;
           sum=a+","+b+","+c+","+d+","+e+","+som;
         
        }
        
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return sum;
    }
}
