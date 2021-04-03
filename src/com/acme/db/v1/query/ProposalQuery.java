package com.acme.db.v1.query;

import com.acme.db.util.postgresql.JDBCBase;
import com.acme.db.QueryException;

import java.sql.SQLException;

/**
 * Exposes mutiple functions for querying the Proposals
 */
public class ProposalQuery extends JDBCBase {

    /**
     * Get the proposal by Proposal ID
     * Returns a JSON String
     */
    public String getProposal(int proposalId) throws QueryException {
        String sql = "SELECT * from proposals WHERE proposal_id="+proposalId;
        try {
            String json = executeSQL(sql);

            return json;

        } catch(SQLException sqe){
            throw new QueryException(sqe);
        }
    }

    /**
     * Get all proposals created for the customer
     */
    public String getProposalForCustomer(int customerId) throws QueryException {

        // Lets get the customer information
        String sql = "SELECT * from customers WHERE customer_id="+customerId;
        String customerJSON = "";
        String proposalsJSON = "";

        try {
            customerJSON = executeSQL(sql, true);
        } catch(SQLException sqe){
            throw new QueryException(sqe);
        }

        // Lets get the customer information
        sql =  "SELECT * from proposals WHERE customer_id="+customerId;
        try {
            proposalsJSON = executeSQL(sql);
        } catch(SQLException sqe){
            throw new QueryException(sqe);
        }

        // Create the JSON to be returned as a result
        String json = "{customer: "+customerJSON+",";
        json += "proposals: "+proposalsJSON + "}";

        return json;
    }
}
