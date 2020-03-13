package com.taw.common.elements;

import java.sql.*;

/**
 * @author gjore.zaharchev
 */
public class Database extends ElementBase {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    //TODO DB Calls implementation
    // Database
    public void dbConnection(final String connectionString, final String username, final String password) {
        try {
            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (SQLException se) {
            se.printStackTrace();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public ResultSet executeQuery(final String sqlQuery) {
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

}
