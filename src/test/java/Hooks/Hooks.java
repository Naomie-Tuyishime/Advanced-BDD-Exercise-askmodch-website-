package Hooks;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {



    public Hooks(){

    }

    @Before
    public void setUp() {
     DriverFactory.initializeWebDriver();
    }
    @After
    public void tearDown(){
        WebDriver driver = DriverFactory.getDriver();
        if(driver!=null){

         driver.quit();
        }
    }
}