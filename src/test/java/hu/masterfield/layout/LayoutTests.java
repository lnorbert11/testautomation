package hu.masterfield.layout;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.galenframework.api.Galen;
import com.galenframework.junit.GalenJUnitTestBase;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import hu.masterfield.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static hu.masterfield.utils.ReportUpdate.reportUpdate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LayoutTests extends GalenJUnitTestBase {

    TestDevice device = new TestDevice("desktok",new Dimension(1024,800), Arrays.asList("desktop"));
    LayoutReport layoutReport;

    WebDriver driver;

@BeforeAll
    public void setup() {
    System.setProperty("webdriver.chrome.driver","chromedriver.exe");

    this.driver = new ChromeDriver();

    createDriver(); //set driver for Galen

    }


    //Galen Junit miatt kell
    //Galen Junit miatt kell
    @Override
    public WebDriver createDriver() {
        super.driver.set(this.driver);
        return this.driver;
    }

    @Test
    @DisplayName("TC1 - Tesco Layout test")
    public void test() throws IOException {
        //open("https://bevasarlas.tesco.hu/groceries");

    load("https://bevasarlas.tesco.hu/groceries", device.getScreenSize().width,device.getScreenSize().height); //Galen utasítása oldal url és hogy milyen méretben nyissa meg

        HomePage homePage = new HomePage();
        layoutReport= homePage.validateHomePageWithGalen(driver,device);

    }

    //html reporotot köp kki a végén
    //minden teszt egy report


    @AfterAll
    public void cleanup(){
        reportUpdate();
        closeWebDriver();
    }
}
