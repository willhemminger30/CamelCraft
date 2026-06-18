package org.apache.camel.camelcraft.commands.shutdown;

import org.apache.camel.Exchange;
import org.apache.camel.camelcraft.util.Properties;
import org.apache.camel.camelcraft.commands.Command;

public class ShutdownCommand extends Command {
    public ShutdownCommand() {
        keyword = Properties.SHUTDOWN;
    }

    @Override
    public void doOptions(String options, Exchange exchange) {
        System.out.println("Shutting down...");
        new Thread(() -> exchange.getContext().shutdown()).start();
    }
}
