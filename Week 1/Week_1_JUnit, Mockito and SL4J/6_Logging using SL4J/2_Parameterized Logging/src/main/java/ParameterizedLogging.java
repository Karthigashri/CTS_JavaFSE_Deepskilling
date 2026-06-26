import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {

        String userName = "karthiga";
        int age = 22;
        double salary = 60000.0;

        logger.info("User Name: {}", userName);

        logger.info("User Name: {}, Age: {}", userName, age);

        logger.info("User Name: {}, Age: {}, Salary: {}",
                userName, age, salary);
    }
}