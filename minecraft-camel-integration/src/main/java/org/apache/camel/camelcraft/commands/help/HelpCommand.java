package org.apache.camel.camelcraft.commands.help;

import org.apache.camel.Exchange;
import org.apache.camel.camelcraft.commands.Command;
import org.apache.camel.camelcraft.commands.CommandLoader;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.Properties;
import org.apache.camel.camelcraft.util.RobotHelper;

public class HelpCommand extends Command {
    public HelpCommand() {
        keyword = Properties.HELP;
    }

    @Override
    public void doOptions(String options, Exchange exchange) {
        StringBuilder output = new StringBuilder();
        CommandLoader.getCommands().forEach(command -> {
            output.append(command.getKeyword());
            if(command.getAllowedOptions() != null) {
                output.append(": ");
                for(Option o : command.getAllowedOptions()) {
                    output.append(" ").append(o.getKeyword());
                }
            }
            output.append(" | ");
        });

        if(!output.toString().isEmpty()) {
            System.out.println(output);
            RobotHelper.typeString(output.toString());
        }
    }
}
