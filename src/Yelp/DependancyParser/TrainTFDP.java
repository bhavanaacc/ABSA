/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yelp.DependancyParser;

import static Yelp.DependancyParser.Featureselection.ambianceTF;
import static Yelp.DependancyParser.Featureselection.foodTF;
import static Yelp.DependancyParser.Featureselection.worthinessTF;
import static Yelp.DependancyParser.Featureselection.restaurantTF;
import static Yelp.DependancyParser.Featureselection.priceTF;
import static Yelp.DependancyParser.Featureselection.serviceTF;
import static Yelp.SentimentProcess.CoWeightforTFCC.CalculateCOrelation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import master.DbconnYelp;


/**
 *
 * @author Sunsoft
 */
public class TrainTFDP {
    
   
      
     public static int GetTFofTerm(String aspect, String term,Connection conn)
    {
     int count=0;
     try{
//     Dbconn db=new Dbconn();
//     Connection conn=db.conn();
     Statement st=conn.createStatement();
     String query="select * from dpfrequency where aspect= '"+aspect +"' and term='"+term+"'";
     ResultSet rs=st.executeQuery(query);
     if(rs.next()){
     count=Integer.parseInt(rs.getString(4));
     }
     }
     catch(Exception ex){
         System.out.println("Error in TF"+ex);
     }
     return count;
    }
   
     public static void Exeprocess()
    {
    try {
            DbconnYelp db=new DbconnYelp();
            Connection conn=db.conn();
             Statement st1=conn.createStatement();
             Statement st2 = conn.createStatement();
             Statement st3=conn.createStatement();
             Statement st4 = conn.createStatement();
             Statement st5=conn.createStatement();
             Statement st6=conn.createStatement();
              
            for(int kk=0; kk< ambianceTF.size(); kk++)
            {
                String data = ambianceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("worthiness", data,conn);
                double index4 = GetTFofTerm("Restaurant", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                double index6 = GetTFofTerm("price", data,conn);
                 st1.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,worthiness,Restaurant,service,price) values ('Ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','"+index6+"')");
                System.out.println("Ambiance Category Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5);
            }

            for(int kk=0; kk< foodTF.size(); kk++)
            {
                String data = foodTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("worthiness", data,conn);
                double index4 = GetTFofTerm("Restaurant", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                double index6 = GetTFofTerm("price", data,conn);
                 st2.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,worthiness,Restaurant,service,price) values ('Food', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','"+index6+"')");
                System.out.println("food Category Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            
            for(int kk=0; kk< worthinessTF.size(); kk++)
            {
                String data = worthinessTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("worthiness", data,conn);
                double index4 = GetTFofTerm("Restaurant", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                double index6 = GetTFofTerm("price", data,conn);
                 st3.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,worthiness,Restaurant,service,price) values ('Worthiness', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','"+index6+"')");
               System.out.println("worthiness Category  \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
                
            }
            for(int kk=0; kk< priceTF.size(); kk++)
            {
                String data = priceTF.get(kk).toString();
               double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("worthiness", data,conn);
                double index4 = GetTFofTerm("Restaurant", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                double index6 = GetTFofTerm("price", data,conn);
                 st4.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,worthiness,Restaurant,service,price) values ('Price', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','"+index6+"')");
                System.out.println("Price Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            for(int kk=0; kk< serviceTF.size(); kk++)
            {
                String data = serviceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("worthiness", data,conn);
                double index4 = GetTFofTerm("Restaurant", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                double index6 = GetTFofTerm("price", data,conn);
                 st5.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,worthiness,Restaurant,service,price) values ('Service', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','"+index6+"')");
               System.out.println("Service Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
              for(int kk=0; kk< restaurantTF.size(); kk++)
            {
                String data = restaurantTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("worthiness", data,conn);
                double index4 = GetTFofTerm("Restaurant", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                double index6 = GetTFofTerm("price", data,conn);
                 st6.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,worthiness,Restaurant,service,price) values ('Restaurant', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "','"+index6+"')");
               System.out.println("restaurant Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            CalculateCOrelation();

        } catch (Exception ex) {
            System.out.println("Error"+ex);
        }
    
    }
}
