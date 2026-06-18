package org.apache.camel.camelcraft.commands.data;

import org.apache.camel.camelcraft.commands.Command;
import org.apache.camel.camelcraft.commands.Option;
import org.apache.camel.camelcraft.commands.data.options.DataDeleteOption;
import org.apache.camel.camelcraft.commands.data.options.DataGetOption;
import org.apache.camel.camelcraft.commands.data.options.DataListOption;
import org.apache.camel.camelcraft.commands.data.options.DataStoreOption;

import static org.apache.camel.camelcraft.util.Properties.*;

public class DataCommand extends Command {
    public DataCommand() {
        keyword = DATA;
        allowedOptions = new Option[] {new DataStoreOption(), new DataGetOption(), new DataListOption(), new DataDeleteOption()};
    }
}
