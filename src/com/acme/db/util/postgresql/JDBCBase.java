package com.acme.db.util.postgresql;

import com.acme.db.ResultsetToJSON;
import org.json.JSONArray;

import java.sql.*;

/**
 * https://www.vinsguru.com/cqrs-pattern-microservice-design-patterns/
 * Added the line for gradle / PG JDBC driver
 * compile group: 'org.postgresql', name: 'postgresql', version: '42.2.8'
 * All commands will inherit from this
 */
public abstract class JDBCBase {
    protected final static String JDBC_URL="jdbc:postgresql://ziggy.db.elephantsql.com:5432/wzymokfo";
    protected final static String JDBC_USER="wzymokfo";
    protected final static String JDBC_PASSWORD="AqkmHdBj-Hd7dAMQ3sVwzFglQGjcLJx9";


    protected void executeSQLUpdate(String sql) throws SQLException {
        Connection connection = null;
        // Put the business logic here

        // Logic for writing to the database
        try {

            connection  = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            connection.setAutoCommit(false);

            System.out.println("JDBC Connection opened: "+connection);

            Statement statement = connection.createStatement();

            System.out.println("SQL Statement: "+sql);

            statement.executeUpdate(sql);

            // We may execute addtional SQL statements here - that will part of
            // the unit of work ....

            // Commit
            connection.commit();

            // Close the statement
            statement.close();

        } finally {
            // Ensure connection is closed
            try{  connection.close(); }catch(Exception e){}
            System.out.println("JDBC Connection closed.");
        }
    }

    /**
     * Execute a query
     */
    protected String executeSQL(String sql) throws SQLException {
        return  executeSQL(sql, false);
    }

    protected String executeSQL(String sql, boolean firstElementOnly) throws SQLException {
        Connection connection = null;
        // Put the business logic here

        // Logic for writing to the database
        try {

            connection  = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
            connection.setAutoCommit(true);

            System.out.println("JDBC Connection opened: "+connection);

            Statement statement = connection.createStatement();

            System.out.println("SQL Statement: "+sql);

            ResultSet rs = statement.executeQuery(sql);

            JSONArray jsonArray = ResultsetToJSON.convert(rs);

            // Close the statement
            statement.close();

            if(firstElementOnly){
                if(jsonArray.length() > 0){
                    return jsonArray.getJSONObject(0).toString(4);
                } else {
                    return "{}";
                }
            }

            return jsonArray.toString(4);

        } finally {
            // Ensure connection is closed
            try{  connection.close(); }catch(Exception e){}
            System.out.println("JDBC Connection closed.");
        }


    }


}
