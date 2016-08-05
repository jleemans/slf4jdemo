package slf4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Simple servlet that produces some logging through slf4j. It also shows that 3th party
 *
 * @author Joeri Leemans
 */
@WebServlet(name = "LoggingServlet", urlPatterns = "/*")
public class LoggingServlet extends HttpServlet {
    private static final Logger SLF = LoggerFactory.getLogger(LoggingServlet.class);
    private static final java.util.logging.Logger JUL =
            java.util.logging.Logger.getLogger(LoggingServlet.class.getName());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serve(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serve(req, resp);
    }

    private void serve(HttpServletRequest req, HttpServletResponse resp) {
        myOwnCodeThatUsesSLF4J();
        someThirdPartyCodeThatUsesJUL();
    }

    private void myOwnCodeThatUsesSLF4J() {
        SLF.debug("Debug (slf4j)");
        SLF.info("Info (slf4j)");
        SLF.warn("Warn (slf4j)");
        SLF.error("Error (slf4j)");
    }

    private void someThirdPartyCodeThatUsesJUL() {
        JUL.finest("Finest (JUL)");
        JUL.finer("Finer (JUL)");
        JUL.fine("Fine (JUL)");
        JUL.config("Config (JUL)");
        JUL.info("Info (JUL)");
        JUL.warning("Warning (JUL)");
        JUL.severe("Severe (JUL)");
    }
}
