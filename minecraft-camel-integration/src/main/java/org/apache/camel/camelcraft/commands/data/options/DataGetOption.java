package org.apache.camel.camelcraft.commands.data.options;

import static org.apache.camel.camelcraft.util.Properties.*;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.util.DataHelper;
import org.apache.camel.camelcraft.util.RobotHelper;

public class DataGetOption extends Option {
    public DataGetOption() {
        keyword = GET;
    }

    @Override
    public void doAction(String actions) {
        getData(actions);
    }

    private void getData(String tag) {
        String entryString = DataHelper.getData(tag);

        if(!entryString.isEmpty()) {
            System.out.println(entryString);
            RobotHelper.typeString(entryString);
        } else {
            RobotHelper.typeString("No data found for entry with tag " + tag + ".");
        }
    }

}
