package com.ClassJoiner;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class OpenWebPage 
{
    public static void openWebPage(String link)
    {
        System.setProperty("webdriver.edge.driver", "[Path to Driver]");
        EdgeOptions edgeoptions = new EdgeOptions();

        edgeoptions.addArguments("user-data-dir=C:\\Users\\username\\AppData\\Local\\Microsoft\\Edge\\User Data");
        edgeoptions.addArguments("profile-directory=Default");
        edgeoptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeoptions);

        try {
        driver.get(link);

        Duration dur = Duration.ofSeconds(15);
        driver.manage().timeouts().implicitlyWait(dur);
        
        Set w = driver.getWindowHandles();
        Iterator t = w.iterator();
        String ch = t.next().toString();
       
        driver.switchTo().window(ch);
        }
        catch (Exception ex)
        {
            
        }
        
        try
        {
            Thread.sleep(300000);
        }
        catch (Exception ex)
        {

        }
        
        driver.close();
    }
}
