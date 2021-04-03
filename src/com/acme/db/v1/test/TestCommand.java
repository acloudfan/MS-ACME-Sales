package com.acme.db.v1.test;

import com.acme.db.CommandException;
import com.acme.db.v1.command.CreateProposalCommand;

public class TestCommand {

    public static void main(String[] args){
        CreateProposalCommand cmd = new CreateProposalCommand(3,
                "BAHAMA5NIGHT@COCOCLUB",
                "John D", 32);
        cmd.addPax("Jane Doe",27);

        try {
            cmd.process();
        } catch(CommandException e){
            e.printStackTrace();
        }
    }
}
