package org.apache.camel.camelcraft.commands.data.options;

import org.apache.camel.camelcraft.util.Properties;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.RobotHelper;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataStoreOption extends Option {
    public DataStoreOption() {
        keyword = Properties.STORE;
    }

    @Override
    public void doAction(String actions) {
        storeText(actions);
    }

    private void storeText(String text) {
        File dir = new File(Properties.PLAYERDATA);
        Pattern pattern = Pattern.compile("(.+?) (.+)");
        Matcher matcher = pattern.matcher(text);
        String tag;
        String body;

        if(matcher.matches()) {
            tag = matcher.group(1);
            body = matcher.group(2);

            if(!dir.exists()) {
                if(!dir.mkdir()) {
                    System.out.println("Failed to create directory.");
                }
            }

            try(FileWriter writer = new FileWriter(dir.getPath() + "/" + Properties.username + ".txt", true)) {
                writer.write(tag + "," + body + "\n");

                RobotHelper.typeString("Data stored in entry: " + tag);
            } catch (IOException e) {
                RobotHelper.typeString("Failed to store data in entry: " + tag);
                System.out.println("Failure to write to file.");
                e.printStackTrace();
            }
        }
    }
}
