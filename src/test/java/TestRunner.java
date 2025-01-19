import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


/**
 * Configures the cucumber test runner.
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "org.demo")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty," +
        "json:target/cucumber-reports/Report.json," +
        "junit:target/cucumber-reports/Report.xml," +
        "html:target/cucumber-reports/Report.html")
public class TestRunner {

}
