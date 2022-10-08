package AssignmentPart2.Utilis;

import AssignmentPart2.App;
import org.apache.log4j.Logger;

public class Log4j {
    public static org.apache.log4j.Logger logger = Logger.getLogger(App.class);

    public static void info(String info) {
        logger.info("Query : " + info);
    }

    public static void error(String error) {
        logger.error("Error : "+error);
    }
}
