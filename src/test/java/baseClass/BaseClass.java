package baseClass;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
    public static WebDriver driver;
    public Properties property;

    @BeforeClass
    public void setup()throws IOException
    {
        property=new Properties();
        try
        {
            FileInputStream fis=new FileInputStream("/Users/arnab/Desktop/Programming_Projects/VSCodeProjects/practice_automation_test/src/resources/config.properties");
            property.load(fis);

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(property.getProperty("appURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
