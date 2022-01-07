package com.ClassJoiner;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class OpenWebPage 
{
    /**
     * Method is used to open the webpage (or the link) for the class.
     * @param link - The link of the upcoming class, obtained from the Spreadsheet.
     */
    public static void openWebPage(String link)
    {
        System.setProperty("webdriver.edge.driver", "[Path to Driver]");    // Set system property for Edge to recognise the driver.
        EdgeOptions edgeoptions = new EdgeOptions();    // Object of class EdgeOptions. Used to add arguments to run the browser in a certain state.

        edgeoptions.addArguments("user-data-dir=C:\\Users\\username\\AppData\\Local\\Microsoft\\Edge\\User Data");
        edgeoptions.addArguments("profile-directory=Default");
        edgeoptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeoptions);     // Create a WebDriver Object for Microsoft Edge

        try {
        driver.get(link);       // Opens the WebPage

        Duration dur = Duration.ofSeconds(15);
        driver.manage().timeouts().implicitlyWait(dur);      // Implicitly waits 15 seconds for the webpage to respond.
        
        Set w = driver.getWindowHandles();
        Iterator t = w.iterator();
        String ch = t.next().toString();
        driver.switchTo().window(ch);       // Used to switch to any child windows.
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        try
        {
            Thread.sleep(300000);       // Explicit wait of 5 minutes to make sure Webex has been opened successfully.
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
        driver.close();     // Close the edge and the driver.
    }
}
