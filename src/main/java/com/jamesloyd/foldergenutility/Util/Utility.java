package com.jamesloyd.foldergenutility.Util;

import com.jamesloyd.foldergenutility.BugReporting.BugHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/*
 *   Copyright (c) 2014 James Loyd
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
public class Utility
{
    public static String createFolder(String folderName)
    {
        try
        {
            File file = new File("./" + folderName);
            if(file.exists())
            {
                return "EXISTS";
            }
            else
            {
                file.mkdir();
                return "CREATED";
            }

        }
        catch (Exception ex)
        {
           BugHandler bugHandler = new BugHandler(ex);
           bugHandler.generateReport();
           return "GENERAL ERROR";
        }
    }
    public static void createFile(String fileName, String containingFolderStatus , String containingFolderName)
    {


    }

    public static void createFile(String fileName, String containingFolderStatus , String containingFolderName, boolean incrementFileName)
    {
        try
        {
            File bugFile = new File(".\\Bugs\\Bug1"+".txt" );
            FileWriter fileWriter = new FileWriter(bugFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("gsd");
            fileWriter.flush();
            fileWriter.close();
            bufferedWriter.close();

        }
        catch (Exception e)
        {

        }

    }

    public static boolean checkForFile(String fileName)
    {
        File file = new File(".\\Bugs");
        File[] files = file.listFiles();
        boolean check = false;
        System.out.println(System.getProperty("user.dir"));
        for (int i = 0; i < files.length;i++)
        {
            if(files[i].isFile())
            {
               if(files[i].toString().equals(".\\Bugs\\Bug2.txt"))
               {
                   check = true;
                   break;
               }
            }
        }
        return check;
    }
}
