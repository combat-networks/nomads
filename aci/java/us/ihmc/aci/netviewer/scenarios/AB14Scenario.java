package us.ihmc.aci.netviewer.scenarios;


import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.ihmc.aci.netviewer.NetViewer;
import us.ihmc.aci.nodemon.discovery.DiscoveryService;
import us.ihmc.util.serialization.SerializationException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Classed used to populate the network graph with information simulating the AgileBloodhound 2014
 * @author Rita Lenzi (rlenzi@ihmc.us)
 */
public class AB14Scenario extends GeneralScenario
{
    /**
     * Constructor
     * @throws IOException
     * @throws SerializationException
     */
    public AB14Scenario (String worldStateFile, String eventsFile) throws IOException, SerializationException
    {
        super(worldStateFile, eventsFile);
    }

    public static void main (String[] args)
    {
        String log4jFile = NetViewer.DEFAULT_LOG_CONFIG_FILE;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals ("-log4j")) {
                log4jFile = args[++i];
            }
        }

        Properties log4jProperties = new Properties();
        try {
            log4jProperties.load (new FileInputStream(log4jFile));

            Date day = new Date();
            String formattedDate = new SimpleDateFormat ("yyyyMMddHHmm").format (day);

            log4jProperties.setProperty ("log4j.appender.rollingFile.File", String.format ("../../log/%s-%s",
                    formattedDate, "ab14-scenario.log"));
        }
        catch (FileNotFoundException e) {
            System.err.println ("Unable to load log4j configuration, file not found");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.err.println ("Unable to load log4j configuration, error while I/O on disk");
            e.printStackTrace();
        }

        PropertyConfigurator.configure (log4jProperties);


        try {
            new AB14Scenario ("./data/ab14ScenarioWorldState.json", "./data/ab14ScenarioEvents.json");
        }
        catch (SerializationException e) {
            log.error ("Impossible to initialize the proxy scheduler", e);
            System.exit (-2);
        }
        catch (IOException e) {
            log.error ("Impossible to initialize the proxy server", e);
            System.exit (-3);
        }
    }


    private static final Logger log = LoggerFactory.getLogger (AB14Scenario.class);
}
