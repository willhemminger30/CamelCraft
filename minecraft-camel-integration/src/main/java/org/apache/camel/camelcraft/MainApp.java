package org.apache.camel.camelcraft;

import org.apache.camel.camelcraft.routes.LogStreamRouteBuilder;
import static org.apache.camel.camelcraft.util.Properties.*;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.main.BaseMainSupport;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();

        main.configure().addRoutesBuilder(new LogStreamRouteBuilder());

        main.addMainListener(new MainListenerSupport() {
            @Override
            public void beforeInitialize(BaseMainSupport main) {
                PropertiesComponent pc = new PropertiesComponent();
                pc.setLocation("file:application.properties");
                main.getCamelContext().setPropertiesComponent(pc);
            }

            @Override
            public void beforeStart(BaseMainSupport main) {
                initProperties(main.getCamelContext());
            }
        });

        main.run(args);
    }

}

