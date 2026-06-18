package org.apache.camel.camelcraft.commands;

public abstract class Option {
    protected String keyword;

    public abstract void doAction(String actions);

    public String getKeyword() {
        return keyword;
    }
}
