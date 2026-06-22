package org.apache.camel.camelcraft.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.camel.camelcraft.util.Properties.PLAYERDATA;
import static org.apache.camel.camelcraft.util.Properties.USERNAME;

public class DataHelper {
    public static String getData(String tag) {
        String filename = PLAYERDATA + "/" + USERNAME + ".txt";
        String entryString;
        String matchedEntry = "";
        Pattern pattern = Pattern.compile("(.+?),(.+)");
        Matcher matcher;

        if(tag.matches("\\S+")) {
            try(Scanner reader = new Scanner(new File(filename))) {
                while(reader.hasNext()) {
                    entryString = reader.nextLine();
                    matcher = pattern.matcher(entryString);
                    if(matcher.matches()) {
                        if(matcher.group(1).equals(tag)) {
                            matchedEntry = matcher.group(2);
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                RobotHelper.typeString("No player data file found!");
                System.out.println("File " + filename + " not found!");
            }
        } else {
            RobotHelper.typeString("Invalid entry tag.");
        }

        return matchedEntry;
    }

    public static void storeData(String text) {
        File dir = new File(PLAYERDATA);
        String[] entryData = parseEntry(text);
        String tag;
        String body;

        if(entryData != null) {
            tag = entryData[0];
            body = entryData[1];

            if(!dir.exists()) {
                if(!dir.mkdir()) {
                    System.out.println("Failed to create directory.");
                }
            }

            try(FileWriter writer = new FileWriter(dir.getPath() + "/" + USERNAME + ".txt", true)) {
                writer.write(tag + "," + body + "\n");

                RobotHelper.typeString("Data stored in entry: " + tag);
            } catch (IOException e) {
                RobotHelper.typeString("Failed to store data in entry: " + tag);
                System.out.println("Failure to write to file.");
                e.printStackTrace();
            }
        }
    }

    public static String[] parseEntry(String text) {
        Pattern pattern = Pattern.compile("(.+?) (.+)");
        Matcher matcher = pattern.matcher(text);
        if(matcher.matches()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }

        return null;
    }
}
