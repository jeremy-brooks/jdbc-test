package com.connect;

import java.sql.*;

/**
 * Created by jeremybrooks on 27/07/15.
 */
public class DBConnect {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String URL = "jdbc:sqlserver://{server}{port}";
    static final String USER = "{username}";
    static final String PASS = "{password}";

    Connection connection = null;
    Statement statement = null;

    public DBConnect(){
        try {
            // register connection
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // open connection
            this.connection = DriverManager.getConnection(URL, USER, PASS);

            // execute query
            this.statement = connection.createStatement();
            String sql = "SELECT [last_sync_time] FROM [swdata].[dbo].[replication_status]";
            ResultSet rs = statement.executeQuery(sql);

            // extract data from result set
            while (rs.next()){
                // retrieve by column
                System.out.print(rs.getDate("last_sync_time"));
                System.out.print("T" + rs.getTime("last_sync_time"));
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
