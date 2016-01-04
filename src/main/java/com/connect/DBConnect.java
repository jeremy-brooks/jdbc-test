package com.connect;

import net.sourceforge.jtds.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jeremybrooks on 27/07/15.
 */
public class DBConnect {

    static final String URL = "jdbc:jtds:sqlserver://{hostname}:1433/{dbname}";
    static final String USER = "{username}";
    static final String PASS = "{password}";

    Connection connection = null;
    Statement statement = null;
    Driver jdbcDriver = new Driver();

    public DBConnect(){
        try {
            // register connection
            Class.forName(jdbcDriver.getClass().getName());

            // open connection
            this.connection = DriverManager.getConnection(URL, USER, PASS);

            // execute query
//            this.statement = connection.createStatement();
//            String sql = "SELECT ...";
//            ResultSet rs = statement.executeQuery(sql);
//
//            // extract data from result set
//            while (rs.next()){
//                // retrieve by column
//            }
//            rs.close();
  //          statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
