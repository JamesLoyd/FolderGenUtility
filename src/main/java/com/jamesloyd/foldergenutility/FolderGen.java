package com.jamesloyd.foldergenutility;

import java.io.File;

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
public class FolderGen
{
    private String location;
    private String numberOfFiles;
    private String startpoint;
    private String folderName;
    private char folderSeperator;
    /*
    public FolderGen(String location, int numberOfFiles, int startpoint, String folderName)
    {
        this.location = location;
        this.numberOfFiles = numberOfFiles;
        this.startpoint = startpoint;
        this.folderName = folderName;

    }
    */

    private FolderGen(FolderBuilder builder)
    {
        this.folderName = builder.folderName;
        this.numberOfFiles = builder.numberOfFiles;
        this.startpoint = builder.startpoint;
        this.location = builder.location;
        this.folderSeperator = builder.folderSeperator;
    }

    public void generateFolders()
    {
        Integer integer = null;
        integer= Integer.valueOf(numberOfFiles);
        if(integer == null)
        {
            System.out.println("Why no files?");
        }

       /*
        for (int i = startpoint; i <numberOfFiles;i++)
        {
            File f = new File(location+"\\"+folderName+i);
            try{
                if(f.mkdir()) {
                    System.out.println("Directory Created");
                } else {
                    System.out.println("Directory is not created");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
*/
    }

    //going for the builder pattern
    public static class FolderBuilder{
        private String location;
        private String numberOfFiles;
        private String startpoint;
        private String folderName;
        private char folderSeperator;

        public FolderBuilder(String location, String folderName)
        {
            this.location = location;
            this.folderName = folderName;
        }

        public FolderBuilder numberOfFiles(String numberOfFiles)
        {
            this.numberOfFiles = numberOfFiles;
            return this;
        }

        public FolderBuilder startpoint(String startpoint)
        {
            this.startpoint = startpoint;
            return this;
        }
        public FolderBuilder folderSeperator(char folderSeperator)
        {
            this.folderSeperator = folderSeperator;
            return this;
        }

        public FolderGen build()
        {
            return new FolderGen(this);
        }
    }
}
