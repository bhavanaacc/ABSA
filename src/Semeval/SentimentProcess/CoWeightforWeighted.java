/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Semeval.SentimentProcess;

import master.DbconnSemeval;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sunsoft
 */
public class CoWeightforWeighted {
    
    public static ArrayList AspectListAmbiance =new ArrayList();
    public static ArrayList AspectListFood =new ArrayList();
    public static ArrayList AspectListMisc =new ArrayList();
    public static ArrayList AspectListPrice =new ArrayList();
    public static ArrayList AspectListService =new ArrayList();
    
    public static ArrayList GetList(String aspectTerm)
    {
        ArrayList List =new ArrayList();
      try{
        DbconnSemeval db= new DbconnSemeval();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();

            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='"+aspectTerm+"'");
            while (rs.next()) {
                String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                String ambiance=rs.getString("ambiance");
                String food=rs.getString("food");
                String price=rs.getString("price");
                String misc=rs.getString("miscellaneous");
                String service=rs.getString("service");
               List.add(id+","+aspect+","+term+","+ambiance+","+food+","+ misc+","+price+","+service);
               }
}
catch(Exception ex){}
    return List;
    }
   
    public static void calcualateCorelation()
    {
      AmbianceWight();
      Foodweight();
      Serviceweight();
      Priceweight();
      misc();
    }
    
    public static void AmbianceWight()
    {
        
     try{
        DbconnSemeval db= new DbconnSemeval();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
           
           AspectListAmbiance =GetList("ambiance");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='ambiance'");
            
            while (rs.next()) {
                double sum=0.0;
                 String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                double ambiance=Double.valueOf(rs.getString("ambiance"));
                double food=Double.valueOf(rs.getString("food"));
                double misc=Double.valueOf(rs.getString("miscellaneous"));
                double price=Double.valueOf(rs.getString("price"));
                double service=Double.valueOf(rs.getString("service"));
                for(int start=0; start<AspectListAmbiance.size(); start++)
                {
                  String[] dataparts = AspectListAmbiance.get(start).toString().split(",");
                  String Fs =dataparts[2].toString();
                  double am=Double.valueOf(dataparts[3]);
                  double fd=Double.valueOf(dataparts[4]);
                  double mi=Double.valueOf(dataparts[5]);
                  double pr=Double.valueOf(dataparts[6]);
                  double ser=Double.valueOf(dataparts[7]);
               
                  double coeeff =0.0;
                   double X[] = {ambiance, food, misc, price, service}; 
                   double Y[] = {am, fd, mi, pr, ser}; 
                   int n = X.length; 
                   coeeff=correlationCoefficient(X, Y, n); 
                   sum=(sum+coeeff);
                }
                double avg= (sum /Double.valueOf(AspectListAmbiance.size()));
                if (Double.isNaN(avg)|| Double.isInfinite(avg))  { avg=(float) 0.0;}
                System.out.println("Term \t"+term +"Average \t"+avg);
                Statement st1=con.createStatement();
                st1.executeUpdate("update weighted set weight='"+String.valueOf(avg)+"' where id ="+id+"");
                AspectListAmbiance.remove(term);
       }
}
catch(Exception ex){ System.out.println("1"+ex);}
    }
    
     public static void Foodweight()
    {
        
     try{
        DbconnSemeval db= new DbconnSemeval();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
           Statement st1 = (Statement) con.createStatement();
           
           AspectListFood =GetList("food");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='food'");
            
            while (rs.next()) {
                double sum=0.0;
                 String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                double ambiance=Double.valueOf(rs.getString("ambiance"));
                double food=Double.valueOf(rs.getString("food"));
                double misc=Double.valueOf(rs.getString("miscellaneous"));
                double price=Double.valueOf(rs.getString("price"));
                double service=Double.valueOf(rs.getString("service"));
                for(int start=0; start<AspectListFood.size(); start++)
                {
                  String[] dataparts = AspectListFood.get(start).toString().split(",");
                  String Fs =dataparts[2].toString();
                  double am=Double.valueOf(dataparts[3]);
                  double fd=Double.valueOf(dataparts[4]);
                  double mi=Double.valueOf(dataparts[5]);
                  double pr=Double.valueOf(dataparts[6]);
                  double ser=Double.valueOf(dataparts[7]);
               
                  double coeeff =0.0;
                   double X[] = {ambiance, food, misc, price, service}; 
                   double Y[] = {am, fd, mi, pr, ser}; 
                   int n = X.length; 
                   coeeff=correlationCoefficient(X, Y, n); 
                   sum=(sum+coeeff);
                }
                double avg= (sum /Double.valueOf(AspectListFood.size()));
               if (Double.isNaN(avg)|| Double.isInfinite(avg))  { avg=(float) 0.0;}
                System.out.println("Term \t"+term +"Average \t"+avg);
                st1.executeUpdate("update weighted set weight='"+String.valueOf(avg)+"' where id ="+id+"");
                AspectListFood.remove(term);
       }
}
catch(Exception ex){ System.out.println("2"+ex);}
    }
    
      public static void Serviceweight()
    {
        
     try{
        DbconnSemeval db= new DbconnSemeval();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
           Statement st1 = (Statement) con.createStatement();
             
           AspectListService =GetList("service");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='service'");
            
            while (rs.next()) {
                double sum=0.0;
                 String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                double ambiance=Double.valueOf(rs.getString("ambiance"));
                double food=Double.valueOf(rs.getString("food"));
                double misc=Double.valueOf(rs.getString("miscellaneous"));
                double price=Double.valueOf(rs.getString("price"));
                double service=Double.valueOf(rs.getString("service"));
                for(int start=0; start<AspectListService.size(); start++)
                {
                  String[] dataparts = AspectListService.get(start).toString().split(",");
                  String Fs =dataparts[2].toString();
                  double am=Double.valueOf(dataparts[3]);
                  double fd=Double.valueOf(dataparts[4]);
                  double mi=Double.valueOf(dataparts[5]);
                  double pr=Double.valueOf(dataparts[6]);
                  double ser=Double.valueOf(dataparts[7]);
               
                  double coeeff =0.0;
                   double X[] = {ambiance, food, misc, price, service}; 
                   double Y[] = {am, fd, mi, pr, ser}; 
                   int n = X.length; 
                   coeeff=correlationCoefficient(X, Y, n); 
                   sum=(sum+coeeff);
                }
                double avg= (sum /Double.valueOf(AspectListService.size()));
               if (Double.isNaN(avg)|| Double.isInfinite(avg))  { avg=(float) 0.0;}
                System.out.println("Term \t"+term +"Average \t"+avg);
                st1.executeUpdate("update weighted set weight='"+String.valueOf(avg)+"' where id ="+id+"");
                AspectListService.remove(term);
       }
}
catch(Exception ex){ System.out.println("3"+ex);}
    }
      
       public static void Priceweight()
    {
        
     try{
        DbconnSemeval db= new DbconnSemeval();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
           Statement st1 = (Statement) con.createStatement();
           
           AspectListPrice =GetList("price");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='price'");
            
            while (rs.next()) {
                double sum=0.0;
                 String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                double ambiance=Double.valueOf(rs.getString("ambiance"));
                double food=Double.valueOf(rs.getString("food"));
                double misc=Double.valueOf(rs.getString("miscellaneous"));
                double price=Double.valueOf(rs.getString("price"));
                double service=Double.valueOf(rs.getString("service"));
                for(int start=0; start<AspectListPrice.size(); start++)
                {
                  String[] dataparts = AspectListPrice.get(start).toString().split(",");
                  String Fs =dataparts[2].toString();
                  double am=Double.valueOf(dataparts[3]);
                  double fd=Double.valueOf(dataparts[4]);
                  double mi=Double.valueOf(dataparts[5]);
                  double pr=Double.valueOf(dataparts[6]);
                  double ser=Double.valueOf(dataparts[7]);
               
                  double coeeff =0.0;
                   double X[] = {ambiance, food, misc, price, service}; 
                   double Y[] = {am, fd, mi, pr, ser}; 
                   int n = X.length; 
                   coeeff=correlationCoefficient(X, Y, n); 
                   sum=(sum+coeeff);
                }
                double avg= (sum /Double.valueOf(AspectListPrice.size()));
              if (Double.isNaN(avg)|| Double.isInfinite(avg))  { avg=(float) 0.0;}
                System.out.println("Term \t"+term +"Average \t"+avg);
                st1.executeUpdate("update weighted set weight='"+String.valueOf(avg)+"' where id ="+id+"");
                AspectListPrice.remove(term);
       }
}
catch(Exception ex){ System.out.println("4"+ex);}
    }
       
       public static void misc()
    {
     try{
        DbconnSemeval db= new DbconnSemeval();
        Connection con=(Connection) db.conn();
           Statement st = (Statement) con.createStatement();
           Statement st1 = (Statement) con.createStatement();
           
           AspectListMisc =GetList("miscellaneous");
            ResultSet rs = (ResultSet) st.executeQuery("select * from weighted where aspect='miscellaneous'");
            
            while (rs.next()) {
                double sum=0.0;
                 String id = rs.getString("id");
                String aspect = rs.getString("aspect");
                String term = rs.getString("term");
                double ambiance=Double.valueOf(rs.getString("ambiance"));
                double food=Double.valueOf(rs.getString("food"));
                double misc=Double.valueOf(rs.getString("miscellaneous"));
                double price=Double.valueOf(rs.getString("price"));
                double service=Double.valueOf(rs.getString("service"));
                for(int start=0; start<AspectListMisc.size(); start++)
                {
                  String[] dataparts = AspectListMisc.get(start).toString().split(",");
                  String Fs =dataparts[2].toString();
                  double am=Double.valueOf(dataparts[3]);
                  double fd=Double.valueOf(dataparts[4]);
                  double mi=Double.valueOf(dataparts[5]);
                  double pr=Double.valueOf(dataparts[6]);
                  double ser=Double.valueOf(dataparts[7]);
               
                  double coeeff =0.0;
                   double X[] = {ambiance, food, misc, price, service}; 
                   double Y[] = {am, fd, mi, pr, ser}; 
                   int n = X.length; 
                   coeeff=correlationCoefficient(X, Y, n); 
                   sum=(sum+coeeff);
                }
                double avg= (sum /Double.valueOf(AspectListMisc.size()));
                if (Double.isNaN(avg)|| Double.isInfinite(avg))  { avg=(float) 0.0;}
                System.out.println("Term \t"+term +"Average \t"+avg);
                st1.executeUpdate("update weighted set weight='"+String.valueOf(avg)+"' where id ="+id+"");
                AspectListMisc.remove(term);
       }
}
catch(Exception ex){ System.out.println("5"+ex);}
    }
    
    static float correlationCoefficient(double X[], double Y[], int n) 
      { 
	
		double sum_X = 0, sum_Y = 0, sum_XY = 0; 
		double squareSum_X = 0, squareSum_Y = 0; 
	
		for (int i = 0; i < n; i++) 
		{ 
			// sum of elements of array X. 
			sum_X = sum_X + X[i]; 
	
			// sum of elements of array Y. 
			sum_Y = sum_Y + Y[i]; 
	
			// sum of X[i] * Y[i]. 
			sum_XY = sum_XY + X[i] * Y[i]; 
	
			//  sum of square of array elements. 
			squareSum_X = squareSum_X + X[i] * X[i]; 
			squareSum_Y = squareSum_Y + Y[i] * Y[i]; 
		} 
	
		// use formula for calculating correlation 
		// coefficient. 
		float corr = (float)(n * sum_XY - sum_X * sum_Y)/ (float)(Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y))); 
		if (Double.isNaN(corr)) { corr=(float) 0.0;}
                return corr; 
	} 
}
