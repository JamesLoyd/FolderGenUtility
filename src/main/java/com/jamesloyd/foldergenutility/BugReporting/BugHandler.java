package com.jamesloyd.foldergenutility.BugReporting;

import com.jamesloyd.foldergenutility.Util.Utility;

import javax.swing.*;
import javax.swing.text.Utilities;
import java.io.File;
import java.util.logging.Logger;

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
public class BugHandler
{
    private Exception exception = null;
    private String osVersion;
    private String osName;
    private String version;
    private String vendor;
    static final String BUG_HANDLER_BUG_FOLDER = "Bugs";
    public BugHandler(Exception exception)
    {
        this.exception = exception;
    }

    public void generateReport()
    {
       try
       {
           JOptionPane.showMessageDialog(null, "A bug report has been generated at", "Bug Report", JOptionPane.INFORMATION_MESSAGE);
           getSystemInformation();
           getJavaEnviromentInformation();
           saveBugReportToFile();
       }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"A bug report has been generated wit the following information:" + ex.getMessage());
       }
    }

    private void getSystemInformation()
    {
        osName = System.getProperty("os.name");
        osVersion = System.getProperty("os.version");
    }

    private void getJavaEnviromentInformation()
    {
        version = Runtime.class.getPackage().getImplementationVersion();
        vendor = Runtime.class.getPackage().getImplementationVendor();
    }

    private void saveBugReportToFile()
    {

        StringBuffer buffer = new StringBuffer();
        buffer.append(osName + " ");
        buffer.append(osVersion + " ");
        buffer.append(vendor + " ");
        buffer.append(version + " ");
        System.out.println(buffer);
        if(Utility.createFolder(BUG_HANDLER_BUG_FOLDER))
        {
            System.out.println("Bug folder was created");
        }
        else
        {
            File file = new File("./" + BUG_HANDLER_BUG_FOLDER );
            if(file.exists())
            {
                System.out.println("Bug Folder already exists");
            }
            else
            {
                System.out.println("Bug Folder could not be created");
            }
        }

    }
}
