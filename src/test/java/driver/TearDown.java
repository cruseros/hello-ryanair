package driver;

import cucumber.api.java.After;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.helpers.Driver;

import java.awt.*;
import java.io.File;

public class TearDown {

    private static final Logger logger = Logger.getLogger(TearDown.class.getName());
    private static final String junitReportFile = "target\\cucumber-reports\\index.html";

    @After
    public static void teardown() {
        quitDriver();
        openReport();
    }

    private static void quitDriver() {
        WebDriver driver = Driver.getDriver();
        driver.quit();
    }

    private static void openReport() {
        try {
            File junitReport = new File(junitReportFile);

            Desktop.getDesktop().browse(junitReport.toURI());
        } catch(Exception e) {
            logger.info("Unable to open generated HTML report");
        }
    }
}
