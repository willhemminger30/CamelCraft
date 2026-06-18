package org.apache.camel.camelcraft.commands.data.options;

import org.apache.camel.camelcraft.util.Properties;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.RobotHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataGetOption extends Option {
    public DataGetOption() {
        keyword = Properties.GET;
    }

    @Override
    public void doAction(String actions) {
        getData(actions);
    }

    private void getData(String tag) {
        String filename = Properties.PLAYERDATA + "/" + Properties.username + ".txt";
        String entryString = "";
        Pattern pattern = Pattern.compile("(.+?),(.+)");
        Matcher matcher;

        if(tag.matches("\\S+")) {
            try(Scanner reader = new Scanner(new File(filename))) {
                while(reader.hasNext()) {
                    entryString = reader.nextLine();
                    matcher = pattern.matcher(entryString);
                    if(matcher.matches()) {
                        if(matcher.group(1).equals(tag)) {
                            entryString = matcher.group(2);
                        }
                    }
                }

                if(!entryString.isEmpty()) {
                    System.out.println(entryString);
                    RobotHelper.typeString(entryString);
                } else {
                    RobotHelper.typeString("No data found for entry with tag " + tag + ".");
                }

            } catch (FileNotFoundException e) {
                RobotHelper.typeString("No player data file found!");
                System.out.println("File " + filename + " not found!");
            }
        } else {
            RobotHelper.typeString("Invalid entry tag.");
        }
    }
}
