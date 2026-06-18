package org.apache.camel.camelcraft.commands.data.options;

import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.Properties;
import org.apache.camel.camelcraft.util.RobotHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataDeleteOption extends Option {
    public DataDeleteOption() {
        keyword = Properties.DELETE;
    }

    public void doAction(String actions) {
        deleteEntry(actions);
    }

    private void deleteEntry(String tag) {
        HashMap<String, String> entries = new HashMap<>();

        String filename = Properties.PLAYERDATA + "/" + Properties.username + ".txt";
        String entryString = "";
        Pattern pattern = Pattern.compile("(.+?),(.+)");
        Matcher matcher;

        if(tag.matches("\\S+")) {
            System.out.println("Deleting entry for " + tag);
            try (Scanner reader = new Scanner(new File(filename))) {
                while(reader.hasNext()) {
                    entryString = reader.nextLine();
                    matcher = pattern.matcher(entryString);
                    if(matcher.matches()) {
                        if(!matcher.group(1).equals(tag)) {
                            entries.put(matcher.group(1), matcher.group(2));
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter(filename, false)) {
                for(String entry : entries.keySet()) {
                    writer.write(entry + "," + entries.get(entry) + "\n");
                }

                System.out.println("Deleted entry for " + tag);
                RobotHelper.typeString("Deleted entry for " + tag);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
