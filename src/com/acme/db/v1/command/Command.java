package com.acme.db.v1.command;

import com.acme.db.CommandException;

public interface Command {
    public abstract void process() throws CommandException;
}
