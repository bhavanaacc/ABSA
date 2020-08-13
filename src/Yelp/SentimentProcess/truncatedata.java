
package Yelp.SentimentProcess;

 
import master.DbconnYelp;
import java.sql.Connection;
import java.sql.Statement;
 
public class truncatedata {

    public static void truncatemaster() {
        Connection con;
        try {
            con = DbconnYelp.conn();

            Statement st1 = (Statement) con.createStatement();
            Statement st2 = (Statement) con.createStatement();
            Statement st3 = (Statement) con.createStatement();
             Statement st4 = (Statement) con.createStatement();
            Statement st5 = (Statement) con.createStatement();
//              st1.executeQuery("TRUNCATE table reviewtrain");
//               st2.executeQuery("TRUNCATE table reviewtest");
//               st3.executeQuery("TRUNCATE table frequency");
//                st4.executeQuery("TRUNCATE table cooccurance");
//               st5.executeQuery("TRUNCATE table weighted");
          
           

        } catch (Exception e) {
        }

    }

    public static void main(String[] agrs) {
      
    }

}
