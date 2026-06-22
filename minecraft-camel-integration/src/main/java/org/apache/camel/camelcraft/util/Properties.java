package org.apache.camel.camelcraft.util;

import org.apache.camel.CamelContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Properties {
    public static String USERNAME = null;
    public static String PREFIX = null;

    // CONSTANTS
    public static final String PLAYERDATA = "PlayerData";

    // COMMAND
    public static final String DATA = "data";
    //  OPTIONS
    public static final String STORE = "store";
    public static final String GET = "get";
    public static final String APPEND = "append";
    public static final String LIST = "list";
    public static final String DELETE = "delete";
    // COMMAND
    public static final String SHUTDOWN = "shutdown";
    // COMMAND
    public static final String HELP = "help";

    public static void initProperties(CamelContext camelContext) {
        USERNAME = camelContext.resolvePropertyPlaceholders("{{username}}");
        PREFIX = camelContext.resolvePropertyPlaceholders("{{prefix}}");
    }
}
