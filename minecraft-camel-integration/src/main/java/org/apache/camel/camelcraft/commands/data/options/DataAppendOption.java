package org.apache.camel.camelcraft.commands.data.options;

import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.DataHelper;
import org.apache.camel.camelcraft.util.RobotHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.camel.camelcraft.util.Properties.*;

public class DataAppendOption extends Option {
    public DataAppendOption() {
        keyword = APPEND;
    }

    @Override
    public void doAction(String actions) {
        appendData(actions);
    }

    private void appendData(String text) {
        String[] appendInfo = DataHelper.parseEntry(text);
        String existingEntry = null;
        String tag = null;
        String appendedBody = null;

        if(appendInfo != null) {
            tag = appendInfo[0];
            appendedBody = appendInfo[1];
            existingEntry = DataHelper.getData(tag);
        }

       if(existingEntry != null) {
           DataHelper.storeData(tag + " " + existingEntry + "  " + appendedBody);

       } else {
           RobotHelper.typeString("No data found for entry with tag " + tag + ".");
       }
    }
}
