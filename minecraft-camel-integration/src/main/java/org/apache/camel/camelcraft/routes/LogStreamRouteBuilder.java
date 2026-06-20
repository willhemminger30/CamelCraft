package org.apache.camel.camelcraft.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.camelcraft.processors.LogProcessor;

public class LogStreamRouteBuilder extends RouteBuilder {
    private LogProcessor logProcessor;

    public LogStreamRouteBuilder() {
        logProcessor = new LogProcessor();
    }

    @Override
    public void configure() throws Exception {
        from( "stream:file?fileName={{logfile}}&scanStream=true&scanStreamDelay=500")
                .process(logProcessor);
    }
}
