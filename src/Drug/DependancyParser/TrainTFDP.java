/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Drug.DependancyParser;


import static Drug.DependancyParser.Featureselection.Birth_ControlTF;
import static Drug.DependancyParser.Featureselection.DepressionTF;
import static Drug.DependancyParser.Featureselection.PainTF;
import static Drug.DependancyParser.Featureselection.Weight_LossTF;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import master.DbconnDrug;

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
            DbconnDrug db=new DbconnDrug();
            Connection conn=db.conn();
             Statement st1=conn.createStatement();
             Statement st2 = conn.createStatement();
             Statement st3=conn.createStatement();
             Statement st4 = conn.createStatement();
             Statement st5=conn.createStatement();
              
            for(int kk=0; kk< Birth_ControlTF.size(); kk++)
            {
                String data = Birth_ControlTF.get(kk).toString();
                double index1 = GetTFofTerm("Birth Control ", data,conn);
                double index2 = GetTFofTerm("Depression", data,conn);
                double index3 = GetTFofTerm("Bipolar Disorde", data,conn);
                double index4 = GetTFofTerm("Pain", data,conn);
                double index5 = GetTFofTerm("Weight Loss", data,conn);
                 st1.executeUpdate("insert into dpcooccurance (aspect,term,Birth_Control,Depression,Bipolar_Disorde,Pain,Weight_Loss) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "')");
                System.out.println("Birth Control Category Term \t" + data + "\t occurances \t" + index1 + "\t" + index2 + "\t" + index3 + "\t" + index4 + "\t" + index5);
            }

            for(int kk=0; kk< DepressionTF.size(); kk++)
            {
                String data = DepressionTF.get(kk).toString();
               double index1 = GetTFofTerm("Birth Control ", data,conn);
                double index2 = GetTFofTerm("Depression", data,conn);
                double index3 = GetTFofTerm("Bipolar Disorde", data,conn);
                double index4 = GetTFofTerm("Pain", data,conn);
                double index5 = GetTFofTerm("Weight Loss", data,conn);
                 st2.executeUpdate("insert into dpcooccurance (aspect,term,Birth_Control,Depression,Bipolar_Disorde,Pain,Weight_Loss) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "')");
                System.out.println("Depression Category Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            
            for(int kk=0; kk< Birth_ControlTF.size(); kk++)
            {
                String data = Birth_ControlTF.get(kk).toString();
                double index1 = GetTFofTerm("Birth Control ", data,conn);
                double index2 = GetTFofTerm("Depression", data,conn);
                double index3 = GetTFofTerm("Bipolar Disorde", data,conn);
                double index4 = GetTFofTerm("Pain", data,conn);
                double index5 = GetTFofTerm("Weight Loss", data,conn);
                 st3.executeUpdate("insert into dpcooccurance (aspect,term,Birth_Control,Depression,Bipolar_Disorde,Pain,Weight_Loss) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "')");
               System.out.println("Birth Control Category  \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
                
            }
            for(int kk=0; kk< PainTF.size(); kk++)
            {
                String data = PainTF.get(kk).toString();
               double index1 = GetTFofTerm("Birth Control ", data,conn);
                double index2 = GetTFofTerm("Depression", data,conn);
                double index3 = GetTFofTerm("Bipolar Disorde", data,conn);
                double index4 = GetTFofTerm("Pain", data,conn);
                double index5 = GetTFofTerm("Weight Loss", data,conn);
                 st4.executeUpdate("insert into dpcooccurance (aspect,term,Birth_Control,Depression,Bipolar_Disorde,Pain,Weight_Loss) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "')");
                System.out.println("Pain Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            for(int kk=0; kk< Weight_LossTF.size(); kk++)
            {
                String data = Weight_LossTF.get(kk).toString();
                double index1 = GetTFofTerm("Birth Control ", data,conn);
                double index2 = GetTFofTerm("Depression", data,conn);
                double index3 = GetTFofTerm("Bipolar Disorde", data,conn);
                double index4 = GetTFofTerm("Pain", data,conn);
                double index5 = GetTFofTerm("Weight Loss", data,conn);
                 st5.executeUpdate("insert into dpcooccurance (aspect,term,Birth_Control,Depression,Bipolar_Disorde,Pain,Weight_Loss) values ('ambiance', '" + data + "', '" + index1 + "','" + index2 + "','" + index3 + "','" + index4 + "','" + index5 + "')");
                System.out.println("Weight Loss Term \t"+data +"\t occurances \t"+index1+"\t"+index2+"\t"+index3+"\t"+index4+"\t"+index5);
            }
            // CalculateCOrelation();

        } catch (Exception ex) {
            System.out.println("Error"+ex);
        }
    
    }
}
