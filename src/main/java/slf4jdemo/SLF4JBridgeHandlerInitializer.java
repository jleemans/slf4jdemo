package slf4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Upon initialization of the web application, this will ensure that all java.util.logging calls will be
 * bridged to the slf4j API.
 *
 * @author Joeri Leemans
 */
@WebListener
public class SLF4JBridgeHandlerInitializer implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(SLF4JBridgeHandlerInitializer.class);

    public void contextInitialized(ServletContextEvent sce) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();  // (since SLF4J 1.6.5)
        SLF4JBridgeHandler.install();
        LOGGER.debug("SLF4JBridgeHandlerInitializer initialized");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}