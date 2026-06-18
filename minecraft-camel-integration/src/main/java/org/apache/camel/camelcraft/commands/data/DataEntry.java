package org.apache.camel.camelcraft.commands.data;

public class DataEntry {
    private String tag;
    private String body;

    public DataEntry(String tag, String body) {
        this.tag = tag;
        this.body = body;
    }

    public String getTag() {
        return tag;
    }

    public String getBody() {
        return body;
    }
}
