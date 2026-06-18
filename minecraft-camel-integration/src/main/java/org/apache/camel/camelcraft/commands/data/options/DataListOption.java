package org.apache.camel.camelcraft.commands.data.options;

import org.apache.camel.camelcraft.util.Properties;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.RobotHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataListOption extends Option {
    public DataListOption() {
        keyword = Properties.LIST;
    }

    @Override
    public void doAction(String actions) {
        listData();
    }

    private void listData() {
        String filename = Properties.PLAYERDATA + "/" + Properties.username + ".txt";
        String entryString = "";
        Pattern pattern = Pattern.compile("(.+?),(.+)");
        Matcher matcher;
        StringBuilder output = new StringBuilder();
        HashSet<String> entrySet = new HashSet<>();

        try(Scanner reader = new Scanner(new File(filename))) {
            while(reader.hasNext()) {
                entryString = reader.nextLine();
                matcher = pattern.matcher(entryString);
                if(matcher.matches()) {
                    entrySet.add(matcher.group(1));
                }
            }

            if(!entrySet.isEmpty()) {
                Iterator itr = entrySet.iterator();

                while(itr.hasNext()) {
                    output.append(itr.next());
                    if(itr.hasNext()) {
                        output.append(", ");
                    }
                }
                System.out.println(output);
                RobotHelper.typeString(output.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found!");
        }
    }
}
