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
    public static String getMeetingLink(int vRow, int vColumn)
    {
        String link = "";
        Workbook wb = null;
        
        try 
        {
            FileInputStream fis = new FileInputStream("[Path to Spreadsheet]");
            wb = new XSSFWorkbook(fis);
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
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(vRow);
            Cell cell = row.getCell(vColumn);

            link = cell.getHyperlink().getAddress();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null;
        }

        return link;
    }
}
