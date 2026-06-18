package org.apache.camel.camelcraft.commands;

import org.apache.camel.Exchange;

import java.util.ArrayList;

public abstract class Command {
    protected String keyword;
    protected Option [] allowedOptions;

    public String getKeyword() {
        return keyword;
    }

    public Option[] getAllowedOptions() {
        return allowedOptions;
    }

    public void doOptions(String options, Exchange exchange) {
        boolean optionFound = false;
        String[] optionArray = options.split(" ");
        String option;
        if(optionArray.length > 0) {
            option = optionArray[0];
        } else {
            option = "NONE";
        }


        for(Option o : allowedOptions) {
            if(o.getKeyword().equals(option)) {
                System.out.println("COMMAND: " + keyword + " - OPTION: " + option);
                o.doAction(options.substring(options.indexOf(option) + option.length()).trim());
                optionFound = true;
                break;
            }
        }

        if(!optionFound) {
            System.out.println("INVALID OPERATION FOR " + keyword);
        }
    }
}
