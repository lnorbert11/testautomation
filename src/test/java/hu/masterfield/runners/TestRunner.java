package hu.masterfield.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//ezt az osztályt lehet majd futtatni
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
                //features = "@target/cucumber-rerun.txt",  //így csak azt futtatja ami előzőleg hibára futott
                publish = true, //a felhőbe ahol 24 órán keresztül meg lehet nézni a reportot
                tags = "@signout", //csak ezeket a taggel rendelkező teszteket futtatja
                glue = "hu.masterfield.steps",
                plugin = {"pretty","json:target/cucumber-reports.json",
                        "junit:target/cucumber-reports.xml",
                        "html:target/cucumber-reports.html",
                        "rerun:target/cucumber-rerun.txt"}) //opciókat lehet megadni https://cucumber.io/docs/cucumber/api/?lang=java#options
public class TestRunner {

}
