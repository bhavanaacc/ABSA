/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DependancyParser;

import static DependancyParser.Featureselection.ambianceTF;
import static DependancyParser.Featureselection.foodTF;
import static DependancyParser.Featureselection.miscellaneousTF;
import static DependancyParser.Featureselection.priceTF;
import static DependancyParser.Featureselection.serviceTF;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import master.DbconnSemeval;

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
            DbconnSemeval db=new DbconnSemeval();
            Connection conn=db.conn();
             Statement st1=conn.createStatement();
             Statement st2 = conn.createStatement();
             Statement st3=conn.createStatement();
             Statement st4 = conn.createStatement();
             Statement st5=conn.createStatement();
              
            for(int kk=0; kk< ambianceTF.size(); kk++)
            {
                String data = ambianceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("miscellaneous", data,conn);
                double index4 = GetTFofTerm("price", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                 st1.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,miscellaneous,price,service) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "')");
                System.out.println("Ambiance Category Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5);
            }

            for(int kk=0; kk< foodTF.size(); kk++)
            {
                String data = foodTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("miscellaneous", data,conn);
                double index4 = GetTFofTerm("price", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                st2.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,miscellaneous,price,service) values ('food', '"+data+"', '"+index1+"','"+index2+"','"+index3+"','"+index4+"','"+index5+"')");
                System.out.println("Price Category Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            
            for(int kk=0; kk< miscellaneousTF.size(); kk++)
            {
                String data = miscellaneousTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("miscellaneous", data,conn);
                double index4 = GetTFofTerm("price", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                   st3.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,miscellaneous,price,service)values ('miscellaneous', '"+data+"', '"+index1+"','"+index2+"','"+index3+"','"+index4+"','"+index5+"')");
                System.out.println("Miscellaneous Category  \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
                
            }
            for(int kk=0; kk< priceTF.size(); kk++)
            {
                String data = priceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("miscellaneous", data,conn);
                double index4 = GetTFofTerm("price", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                  st4.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,miscellaneous,price,service) values ('price', '"+data+"', '"+index1+"','"+index2+"','"+index3+"','"+index4+"','"+index5+"')");
                System.out.println("Price Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            for(int kk=0; kk< serviceTF.size(); kk++)
            {
                String data = serviceTF.get(kk).toString();
                double index1 = GetTFofTerm("ambiance", data,conn);
                double index2 = GetTFofTerm("food", data,conn);
                double index3 = GetTFofTerm("miscellaneous", data,conn);
                double index4 = GetTFofTerm("price", data,conn);
                double index5 = GetTFofTerm("service", data,conn);
                   st5.executeUpdate("insert into dpcooccurance (aspect,term,ambiance,food,miscellaneous,price,service) values ('service', '"+data+"', '"+index1+"','"+index2+"','"+index3+"','"+index4+"','"+index5+"')");
                System.out.println("Service Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            // CalculateCOrelation();

        } catch (Exception ex) {
            System.out.println("Error"+ex);
        }
    
    }
}
