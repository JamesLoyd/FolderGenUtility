package com.jamesloyd.foldergenutility;

import com.jamesloyd.foldergenutility.BugReporting.BugHandler;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

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
public abstract class AbstractFolder
{
    public abstract void generateFolders();

    protected void generate(ArrayList<File> fileList, String startpoint)
    {
        StringBuilder buffer = new StringBuilder();
        String result = "";
        int start = 0;
        if(startpoint == null)
        {
            start = 0;
        }
        else
        {
            start = Integer.parseInt(startpoint);
        }
        for (int i = start; i < fileList.size() ; i++)
        {
            File file = null;
            file = fileList.get(i);

            try
            {
                if(file.mkdir())
                {

                    buffer.append(file.toString());
                    buffer.append(" has been created");
                    buffer.append("\n");
                    result = "WAS CREATED";
                }
                else
                {
                    buffer.append(file.toString());
                    buffer.append(" has not been created");
                    buffer.append("\n");
                    result = "WAS NOT CREATED";

                }
                throw new Exception("Something");
            }
            catch(Exception e)
            {
                BugHandler bugHandler = new BugHandler(e);
                bugHandler.generateReport();
            }
        }
        JOptionPane.showMessageDialog(null, buffer.toString(), result, JOptionPane.INFORMATION_MESSAGE);
    }
}
