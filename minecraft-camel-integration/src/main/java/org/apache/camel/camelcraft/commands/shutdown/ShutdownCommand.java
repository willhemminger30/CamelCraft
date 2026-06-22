package org.apache.camel.camelcraft.commands.shutdown;

import org.apache.camel.Exchange;
import static org.apache.camel.camelcraft.util.Properties.*;
import org.apache.camel.camelcraft.commands.Command;
import org.apache.camel.camelcraft.util.RobotHelper;

public class ShutdownCommand extends Command {
    public ShutdownCommand() {
        keyword = SHUTDOWN;
    }

    @Override
    public void doOptions(String options, Exchange exchange) {
        System.out.println("Shutting down...");
        RobotHelper.typeString("Shutting down...");
        new Thread(() -> exchange.getContext().shutdown()).start();
    }
}
