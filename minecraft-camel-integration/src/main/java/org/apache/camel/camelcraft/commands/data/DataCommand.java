package org.apache.camel.camelcraft.commands.data;

import org.apache.camel.camelcraft.commands.Command;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.commands.data.options.*;

import static org.apache.camel.camelcraft.util.Properties.*;

public class DataCommand extends Command {
    public DataCommand() {
        keyword = DATA;
        allowedOptions = new Option[] {new DataStoreOption(), new DataGetOption(),
                new DataAppendOption(), new DataListOption(), new DataDeleteOption()};
    }
}
