package DependancyParser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import master.DbconnDrug;

public class Featureselection {
   
    public static ArrayList foodF =new ArrayList();
    public static ArrayList ambianceF =new ArrayList(); 
    public static ArrayList serviceF =new ArrayList();
    public static ArrayList priceF =new ArrayList();
    public static ArrayList miscellaneousF =new ArrayList();
    
     public static ArrayList foodTF =new ArrayList();
    public static ArrayList ambianceTF =new ArrayList(); 
    public static ArrayList serviceTF =new ArrayList();
     public static ArrayList priceTF =new ArrayList();
      public static ArrayList miscellaneousTF =new ArrayList();
    
      public static ArrayList AllinOne =new ArrayList();
       public static ArrayList AllinTFOne =new ArrayList();
    
    public static void LoadComments()
    {
        try
        {
         DbconnDrug db= new DbconnDrug();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
 
           ResultSet rs = (ResultSet) st.executeQuery("select * from reviewtrain order by id asc");
            while (rs.next()) {
                String id = rs.getString(1);
                String dependancy = rs.getString(5);
                String aspect = rs.getString(6);
                if(aspect.equalsIgnoreCase("food")){ foodF.add(id+"#"+dependancy);}
                if(aspect.equalsIgnoreCase("ambience")) {ambianceF.add(id+"#"+dependancy);}
                if(aspect.equalsIgnoreCase("service")){ serviceF.add(id+"#"+dependancy);}
                if(aspect.equalsIgnoreCase("price")){ priceF.add(id+"#"+dependancy);}
                if(aspect.equalsIgnoreCase("anecdotes/miscellaneous")) {miscellaneousF.add(id+"#"+dependancy);}
                else if(aspect.equalsIgnoreCase("anecdotes")) {miscellaneousF.add(id+"#"+dependancy);}
                else if(aspect.equalsIgnoreCase("miscellaneous")) {miscellaneousF.add(id+"#"+dependancy);}
            }
           System.out.println("Food \t"+foodF.size());
            System.out.println("ambiance \t"+ambianceF.size());
             System.out.println("service \t"+serviceF.size());
              System.out.println("price \t"+priceF.size());
               System.out.println("anecdotes/miscellaneous \t"+miscellaneousF.size());
        }
        catch(Exception ex)
        {}
     
    }    
      
  public static void GetSelectedTFIDFFeatures()
    {
      try
        { 
            DbconnDrug db = new DbconnDrug();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select  distinct(term), aspect, frequency from dpfrequency order by frequency desc;");
      
            while (rs.next()) {
            String term=rs.getString(1);  
            String aspect=rs.getString(2);  
            int freq=Integer.parseInt(rs.getString(3));
          
              if(aspect.equalsIgnoreCase("food"))
                {
                 foodTF.add(term);AllinTFOne.add(term);
                }
                if(aspect.equalsIgnoreCase("price"))
                {
                 priceTF.add(term); AllinTFOne.add(term);
                }
                if(aspect.equalsIgnoreCase("miscellaneous") || aspect.equalsIgnoreCase("anecdotes/miscellaneous")|| aspect.equalsIgnoreCase("anecdotes"))
                {
                  miscellaneousTF.add(term); AllinTFOne.add(term);
                }
                if(aspect.equalsIgnoreCase("ambiance"))
                {
                 ambianceTF.add(term); AllinTFOne.add(term);
                 }
                if(aspect.equalsIgnoreCase("service"))
                {
                  serviceTF.add(term);AllinTFOne.add(term);
                }
             }
            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("Food features :"+foodTF.size());
        System.out.println(" Price features :"+priceTF.size());
        System.out.println(" Misc features :"+miscellaneousTF.size());
        System.out.println(" Ambiance features :"+ambianceTF.size());
        System.out.println(" Service features :"+serviceTF.size());
         System.out.println(" All features :"+AllinTFOne.size());
         
    }
  
  public static void GneerateTrainMatrix()
  {
     try
        { 
            DbconnDrug db = new DbconnDrug();
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) db.conn();
            Statement st = (com.mysql.jdbc.Statement) con.createStatement();
             Statement st1 = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery("select * from dpcooccurance");
        while (rs.next()) {
          String aspect =rs.getString(2);                  
           String term =rs.getString(3);
            String ambiance =Double.valueOf(rs.getString(4)) > 0.0 ? "1"  : "0" ; 
             String food =Double.valueOf(rs.getString(5)) > 0.0 ? "1"  : "0" ; 
              String misc =Double.valueOf(rs.getString(6)) > 0.0 ? "1"  : "0" ; 
               String price =Double.valueOf(rs.getString(7)) > 0.0 ? "1"  : "0" ; 
               String service =Double.valueOf(rs.getString(8)) > 0.0 ? "1"  : "0" ; 
                 System.out.println(aspect +"\t"+term+"\t"+ambiance+"\t"+food+"\t"+misc+"\t"+price+"\t"+service);
                 String query ="insert into dptrainmatrix (aspect, term,ambiance,food,miscellaneous,price,service) values ('" + aspect +"','" + term +"','" + ambiance +"','" + food +"','" + misc +"','" + price +"','" + service +"')";
                st1.executeUpdate(query);
         }
         }
         catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println("Matrix Generation done");
  }
      
}
