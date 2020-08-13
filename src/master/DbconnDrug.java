/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbconnDrug {

    public DbconnDrug() throws SQLException {
        //initComponents();
        //Connection con;

    }

    public static Connection conn() throws SQLException, ClassNotFoundException {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/aspectmining-drug", "root", "admin");// for local database

        return (con);

    }

}
