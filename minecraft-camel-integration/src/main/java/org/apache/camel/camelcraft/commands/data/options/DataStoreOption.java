package org.apache.camel.camelcraft.commands.data.options;

import static org.apache.camel.camelcraft.util.Properties.*;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.DataHelper;
import org.apache.camel.camelcraft.util.RobotHelper;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataStoreOption extends Option {
    public DataStoreOption() {
        keyword = STORE;
    }

    @Override
    public void doAction(String actions) {
        storeData(actions);
    }

    void storeData(String text) {
        DataHelper.storeData(text);
    }
}
