package org.apache.camel.camelcraft.commands;

import org.apache.camel.camelcraft.commands.data.DataCommand;
import org.apache.camel.camelcraft.commands.help.HelpCommand;
import org.apache.camel.camelcraft.commands.shutdown.ShutdownCommand;

import java.util.ArrayList;

public class CommandLoader {
    private static ArrayList<Command> commands = new ArrayList<Command>();
    static {
        commands.add(new DataCommand());
        commands.add(new ShutdownCommand());
        commands.add(new HelpCommand());
    }

    public static ArrayList<Command> getCommands() {
        return  commands;
    }

}
