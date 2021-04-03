package com.acme.db.v1.test;

import com.acme.db.v1.query.ProposalQuery;

public class TestQuery  {

    public static void main(String[] args){
        ProposalQuery query = new ProposalQuery();
        try {
//            String result = query.getProposal(9);
            String result = query.getProposalForCustomer(3);
            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
