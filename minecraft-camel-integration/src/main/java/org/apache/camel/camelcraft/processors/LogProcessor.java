package org.apache.camel.camelcraft.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.camelcraft.commands.Command;
import org.apache.camel.camelcraft.commands.CommandLoader;
import static org.apache.camel.camelcraft.util.Properties.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogProcessor implements Processor {
    private static boolean isActive = false;
    private static final Object lock = new Object();
    private static final Pattern pattern = Pattern.compile("\\[(\\d+:\\d+:\\d+)].+");

    @Override
    public void process(Exchange exchange) throws Exception {
        String logMessage = exchange.getMessage().getBody(String.class);

        if(logMessage.matches(".+\\[CHAT] You whisper to " + USERNAME + ": " + PREFIX  + ".+")) {
            activateSystem(logMessage);

            if(!isActive) {
                return;
            }

            String fullCommand = logMessage.substring(logMessage.indexOf(PREFIX) + PREFIX.length() + 1);
            String command = fullCommand.split(" ")[0];
            String options = fullCommand.substring(fullCommand.indexOf(command) + command.length()).trim();

            for(Command c : CommandLoader.getCommands()) {
                if(c.getKeyword().equals(command)) {
                    System.out.print("USER: " + USERNAME + " - ");
                    c.doOptions(options, exchange);
                }
            }

        }
    }

    private void activateSystem(String logMessage) {
        synchronized(lock) {
            if(!isActive) {
                Matcher matcher = pattern.matcher(logMessage);
                if(matcher.matches()) {
                    String timestamp = matcher.group(1);
                    String[] parsedTime = timestamp.split(":");
                    LocalDateTime dateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
                    LocalDateTime timeStampDateTime = LocalDateTime.of(dateTime.toLocalDate(), LocalTime.of(Integer.parseInt(parsedTime[0]), Integer.parseInt(parsedTime[1]), Integer.parseInt(parsedTime[2])));
                    if(dateTime.isEqual(timeStampDateTime) || dateTime.isEqual(timeStampDateTime.plusSeconds(1)) ||
                            dateTime.isEqual(timeStampDateTime.minusSeconds(1))) {
                        isActive = true;
                    }
                }
            }
        }
    }
}
