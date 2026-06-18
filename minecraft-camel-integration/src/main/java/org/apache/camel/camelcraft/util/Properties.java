package org.apache.camel.camelcraft.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Properties {
    static {
        try(Scanner reader = new Scanner(new File("Properties.txt"))) {
            StringBuilder fileContents = new StringBuilder();
            while(reader.hasNext()) {
                fileContents.append(reader.nextLine() + ",");
            }

            if(!fileContents.isEmpty()) {
                String[] properties = fileContents.toString().split(",");
                for(String property : properties) {
                    String[] keyvalues = property.split("=");
                    if(keyvalues.length > 1) {
                        switch(keyvalues[0]) {
                            case "username" -> username = keyvalues[1];
                            case "prefix" -> prefix = keyvalues[1];
                            case "test" -> System.out.println("This is a test");
                            default -> System.out.println("Property not recognized: " + keyvalues[0]);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Properties file not found.");
            System.exit(1);
        }
    }
    public static String username;
    public static String prefix;

    // CONSTANTS
    public static final String PLAYERDATA = "PlayerData";

    // COMMAND
    public static final String DATA = "data";
    //  OPTIONS
    public static final String STORE = "store";
    public static final String GET = "get";
    public static final String LIST = "list";
    public static final String DELETE = "delete";
    // COMMAND
    public static final String SHUTDOWN = "shutdown";
    // COMMAND
    public static final String HELP = "help";
}
