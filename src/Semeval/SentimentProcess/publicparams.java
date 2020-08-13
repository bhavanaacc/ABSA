/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Semeval.SentimentProcess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sunsoft
 */
public class publicparams {
       
      public static String checkflag(int id,Connection con)
  {
      String result="";
     try{
     Connection conn=con;
            Statement st = con.createStatement();
            st.executeQuery("select aspect from reviewtest where id= '"+id+"'");
            ResultSet rs = st.getResultSet();
             while (rs.next()) {
                 result= rs.getString("aspect");
              }
     }
     catch(Exception e)
     {
     }
     return result;
  }
}
