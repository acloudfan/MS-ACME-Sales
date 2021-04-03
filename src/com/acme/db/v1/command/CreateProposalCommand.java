package com.acme.db.v1.command;

import com.acme.db.util.postgresql.JDBCBase;
import com.acme.db.CommandException;


import java.sql.Connection;

import java.util.ArrayList;

/**
 * This command has the business logic to create the proposal
 */
public class CreateProposalCommand extends JDBCBase implements Command {

    // REPLACE THIS WITH YOUR URL
    private final static String JDBC_URL="jdbc:postgresql://ziggy.db.elephantsql.com:5432/wzymokfo";
    private final static String JDBC_USER="wzymokfo";
    private final static String JDBC_PASSWORD="AqkmHdBj-Hd7dAMQ3sVwzFglQGjcLJx9";

    private final static String JDBC_PG_DRIVER = "org.postgresql.Driver";

    // Passenger information
    private final int customerId;
    private final String packageId;

    private ArrayList<String>  pax = new ArrayList<>();
    private ArrayList<Integer>  paxAge = new ArrayList<>();;

    // PostgreSQL JDBC driver MUST be available
    static {
        try {
            Class.forName(JDBC_PG_DRIVER);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    // Parameters = JSON string
    public CreateProposalCommand(int customerId, String packageId, String pax_1, int pax_1_age) {

        this.customerId = customerId;
        this.packageId = packageId;

        this.pax.add(pax_1);
        this.paxAge.add(pax_1_age);
    }

    // Adds/Updates the passenger
    public void addPax(String paxName, int paxAge){
        int index = pax.indexOf(pax);
        if(index < 0) {
            this.pax.add(paxName);
            this.paxAge.add(paxAge);
        } else {
            // Existing pax - just change age
            this.paxAge.set(index, paxAge);
        }
    }

    public void process() throws CommandException {
        Connection connection = null;
        // Put the business logic here

        // Logic for writing to the database
        try {

            // SQL Statement for insert
            String sql = createInsertSQL();

            executeSQLUpdate(sql);

        } catch(Exception e){
            e.printStackTrace();
        }

    }

//    public void process() throws CommandException {
//        Connection connection = null;
//        // Put the business logic here
//
//        // Logic for writing to the database
//        try {
//
//            connection  = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
//            connection.setAutoCommit(false);
//
//            System.out.println("JDBC Connection opened: "+connection);
//
//            // SQL Statement for insert
//            String sql = createInsertSQL();
//            Statement statement = connection.createStatement();
//
//            System.out.println("SQL Statement: "+sql);
//
//            statement.executeUpdate(sql);
//
//            // We may execute addtional SQL statements here - that will part of
//            // the unit of work ....
//
//            // Commit
//            connection.commit();
//
//            // Close the statement
//            statement.close();
//
//        } catch(Exception e){
//            e.printStackTrace();
//        } finally {
//            // Ensure connection is closed
//            try{  connection.close(); }catch(Exception e){}
//            System.out.println("JDBC Connection closed.");
//        }
//
//    }

    /**
     * Creates the INSERT statement
     * @return SQL Statement
     */
    private String createInsertSQL(){
        String sql = "INSERT INTO proposals(customer_id, package_id, pax_0, pax_age_0";
        String values = "VALUES("+customerId+", '"+ packageId +"' , '"+pax.get(0)+"',"+paxAge.get(0);

        for(int i=1; i < pax.size(); i++){
            sql += ","+"pax_"+i+", "+"pax_age_"+i;
            values += ", '"+pax.get(i) + "' ," + paxAge.get(i);
        }
        return sql+")  "+values+")";
    }
}
