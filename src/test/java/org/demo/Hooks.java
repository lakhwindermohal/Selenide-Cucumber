package org.demo;

import static org.demo.common.Constants.SETTINGS_PROPERTIES_FILENAME;
import static org.demo.common.Formats.SETTINGS_PROPERTIES_NOT_FOUND;
import static org.demo.common.Lookups.ChromeOptions.DISABLE_INFOBARS;
import static org.demo.common.Lookups.ChromeOptions.ENABLE_AUTOMATION;
import static org.demo.common.Lookups.ChromeOptions.INCOGNITO;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SimpleReport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import org.demo.common.PropertiesReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {

    /**
     * Logger for logging events during test report generation.
     */
    private static Logger LOGGER;
    /**
     * The properties reader used to set up the browser options.
     */
    private PropertiesReader propertiesReader;


    /**
     * Default hook constructor.
     */
    public Hooks() throws Exception, IOException {
        super();
        LOGGER = LoggerFactory.getLogger(Hooks.class);
        LOGGER.info("Hooks constructor called");
    }

    /**
     * Before each scenario, set up the browser.
     *
     * @throws Exception An exception is thrown if the browser cannot be opened.
     */
    @Before
    public void openBrowser() throws Exception {

        this.propertiesReader = new PropertiesReader(
            Optional.ofNullable(Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(SETTINGS_PROPERTIES_FILENAME))
                .map(url -> {
                    try {
                        return new File(url.toURI()).getPath();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException("Invalid URL syntax for settings.properties", e);
                    }
                })
                .orElseThrow(() -> new Exception(SETTINGS_PROPERTIES_NOT_FOUND)));


        // The page load strategy is set to "None" to prevent the cron jobs from timing out.
        Configuration.pageLoadStrategy = PageLoadStrategy.NONE.toString();
        Configuration.browser = this.propertiesReader.getValue("browser");
        Configuration.browserSize = this.propertiesReader.getValue("screenSize");
        Configuration.headless = Boolean.parseBoolean(this.propertiesReader.getValue("headless"));
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();

        Configuration.browserCapabilities = new ChromeOptions()
            .addArguments(ENABLE_AUTOMATION.option)
            .addArguments(DISABLE_INFOBARS.option)
            .addArguments(INCOGNITO.option);

        Configuration.holdBrowserOpen = false;

    }


    /**
     * After each scenario, close the browser.
     */
    @After
    public void afterScenario() {

        // Close the browser after the scenario.
        Selenide.closeWebDriver();
    }


    /**
     * Captures a screenshot and attaches it to the provided Cucumber scenario.
     *
     * @param scenario       The Cucumber {@link Scenario} to which the screenshot will be attached.
     * @param screenshotName The name under which the screenshot will be attached.
     */
    public static void addScreenshotToScenario(Scenario scenario, String screenshotName) {
        byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", screenshotName);
    }
}
