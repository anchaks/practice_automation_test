
package utilities;

//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.text.SimpleDateFormat;
//import java.util.Date;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;

public class TakeScreenshot 
{
    //public static WebDriver driver;
    /* 
    public static void takeScreenshot(WebDriver driver, String fileName) 
    {
        // Cast the WebDriver to TakesScreenshot to enable screenshot capture
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the destination path where the screenshot will be saved
        // You are saving it to a specific folder on your desktop project directory
        File dest = new File("/Users/arnab/Desktop/Programming_Projects/VSCodeProjects/parabanking_project/src/screenshots/" + fileName);

        // Create the parent directories if they do not already exist
        dest.getParentFile().mkdirs(); // Ensure folder exists

        try
         {
            // Copy the screenshot file from the source to the destination
            // If the file already exists, it will be replaced
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
        } 
        catch (IOException e) 
        {
            // Copy the screenshot file from the source to the destination
            // If the file already exists, it will be replaced
            System.err.println("Error saving screenshot: " + e.getMessage());
        }
    }*/
}
