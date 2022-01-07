package com.ClassJoiner;

import java.util.Calendar;

public class App 
{
    /**
     * The Main Method. Keeps looping till school ends.
     * 
     * Sunday is 1.
     * Saturday is 7.
     * @param args
     */

    public static void main(String[] args)
    {
        int day, hour, minute, second;

        try 
        {
            while(true)
            {
                Calendar cal = Calendar.getInstance();      // This part basically obtains the Current Day and Time.
                day = cal.get(Calendar.DAY_OF_WEEK);
                hour = cal.get(Calendar.HOUR_OF_DAY);
                minute = cal.get(Calendar.MINUTE);
                second = cal.get(Calendar.SECOND);      // The second variable hasnt really been used in the program, but i did not want to remove it.

                JoinMeeting(day, hour, minute, second);
            }
        } 
        catch (Exception e) 
        {
            Delay(5000);
            main(args);
        }        
   
    }

    /**
     * 
     * @param d - The day of the week. (1 - Sunday, 7 - Saturday)
     * @param h - The hour of the day (24 hour format)
     * @param m - The minute.
     * @param s - The second.
     */
    
    public static void JoinMeeting(int d, int h, int m, int s)
    {
        int row = 0, col = 0;       
        String meetingLink = "";

        if(d <= 6 && d >= 2)
        {
            row = d - 1;
            
            if(h == 7 && (m >= 52 && m <= 56))
            {
                col = 1;
            }
            else if(h == 8 && (m >= 42 && m <= 45))
            {
                col = 2;
            }
            else if(h == 9 && (m >= 32 && m <= 35))
            {
                col = 3;
            }
            else if(h == 10 && (m >= 42 && m <= 45))
            {
                col = 5;
            }
            else if(h == 11 && (m >= 32 && m <= 35))
            {
                col = 6;
            }
            else if(h == 12 && (m >= 22 && m <= 25))
            {
                col = 7;
            }
            else if(h == 13 && (m >= 12 && m <= 15))
            {
                col = 8;
            }
            else if(h >= 14)
            {
                // School has ended, so killing Webex processes
                AppKiller.killProcessANDchildren("WebexHost.exe");
                AppKiller.killProcessANDchildren("atmgr.exe");
                System.exit(0);
            }
            else
            {
                // School hasnt started OR a Class is ongoing
                Delay(180000);
                return;
            }
        }
        else
        {
            // No Class Today (Weekend)
            System.exit(0);
        }

        AppKiller.killProcessBUTNOTchildren("atmgr.exe");
        meetingLink = ReadXLSX.getMeetingLink(row, col);
        if(meetingLink.contains("webex"))    {
            OpenWebPage.openWebPage(meetingLink);
            Delay(360000);
        }

        return;
    }


    /**
     * Adds Delay to the program using the {@code Thread.sleep(long millis)} method.
     * Takes in ms (Time in milliseconds) as an arguement
     * @param ms - a {@code long} variable / parameter
     */

    public static void Delay(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (Exception ex)
        {
            return;
        }

        return;
    }
}
