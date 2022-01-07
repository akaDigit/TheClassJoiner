package com.ClassJoiner;

public class AppKiller 
{
    static String cmd = "";

    public static void killProcessANDchildren(String processName) 
    {
        cmd = "taskkill /f /im" + processName + "/t";
        try 
        {
            Runtime rt = Runtime.getRuntime();
            
            rt.exec(cmd);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }
    
    public static void killProcessBUTNOTchildren(String processName) 
    {
        cmd = "taskkill /f /im" + processName;
        try 
        {
            Runtime rt = Runtime.getRuntime();
            
            rt.exec(cmd);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }
}
