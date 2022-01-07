package com.ClassJoiner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSX 
{
    /**
     * This method returns the link for the class in {@code String} format.
     * 
     * @param vRow - Row Number, derived from what day of the week it is.
     * @param vColumn - Column Number, derived from upcoming class timing.
     * 
     * @return link - The link to the upcoming class
     */
    public static String getMeetingLink(int vRow, int vColumn)
    {
        String link = "";
        Workbook wb = null;     // Initialising the Workbook object.
        
        try 
        {
            FileInputStream fis = new FileInputStream("[Path to Spreadsheet]");     // Gets the spreadsheeet
            wb = new XSSFWorkbook(fis);     // Inputs the spreadsheet in the Workbook object. XSSF refers to the newer spreadsheet format (2007 - current)
                                            // Use HSSF for older format (2003 and before)
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }

        try 
        {
            Sheet sheet = wb.getSheetAt(0);     // Get the sheet which contains the links
            Row row = sheet.getRow(vRow);       // Get the respective row
            Cell cell = row.getCell(vColumn);   // Get the cell which contains the link for the upcoming class

            link = cell.getHyperlink().getAddress();    // Grab the Hyperlink in form of a string.
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;        // Encountered if the cell didnt contain any link. Logical error occured.
        }

        return link;
    }
}
