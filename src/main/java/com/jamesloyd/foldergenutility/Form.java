package com.jamesloyd.foldergenutility;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

/**
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
public class Form extends JFrame implements ActionListener , ItemListener
{
    private JTextField textFieldNumberOfFolders;
    private JCheckBox checkboxForNumber;
    private JButton submitButton;
    private JLabel labelForFolderLocation;
    private JLabel labelFolderLocation;
    private JLabel labelForMultipleFoldersName;
    private JTextField textForFolderName;
    private JLabel labelForFolderName;
    private JLabel labelForMultipleFoldersIncrement;
    private JToolBar toolBar;
    private JButton selectFolder;
    private JTextArea textArea;
    private JScrollPane scrollpane;
    private JButton clearButton;

    JFrame jFrame = new JFrame("FolderGenUtility");
    String path = "";
    public Form()
    {
        this.toolBar = new JToolBar();
        this.labelFolderLocation = new JLabel();
        this.textFieldNumberOfFolders = new JTextField();
        this.checkboxForNumber = new JCheckBox();
        this.submitButton = new JButton();
        this.labelForFolderLocation = new JLabel();
        this.labelForMultipleFoldersIncrement = new JLabel();
        this.textForFolderName = new JTextField();
        this.labelForFolderName = new JLabel();
        this.labelForMultipleFoldersName = new JLabel();
        this.selectFolder = new JButton();
        this.textArea = new JTextArea();
        this.scrollpane = new JScrollPane(this.textArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.clearButton = new JButton();
    }

    public  void addComponentsToPane(Container pane)
    {

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        addAToolbar("yo", pane, toolBar);
        addALabel("<html><p>Please insert a folder location</p></html>", pane, true, labelForFolderLocation);
        addAFileChooser(pane,selectFolder);
        addALabel("Current Root Directory Selected:" ,pane,false, labelFolderLocation);
        addAScrollPane(pane, scrollpane);
        //addALabel("<html><p>Would you like to generate a large number of folders?</p></html>", pane, true, labelForMultipleFoldersIncrement);
        //addACheckBox(pane, checkboxForNumber);
        //addALabel("<html><p>Please insert the stuff</p></html>",pane,false,labelForMultipleFoldersName);
       // addATextBox(pane, false,textFieldNumberOfFolders);
        addALabel("<html><p>Please insert the folder name</p></html>", pane, true, labelForFolderName);
        addATextBox(pane,true,textForFolderName);
        addAbutton("Submit Button", pane, submitButton);
        addAbutton("Clear",pane, clearButton);

    }

    private void addAScrollPane(Container container, JScrollPane scrollPane)
    {
        scrollPane.setVisible(false);
        scrollPane.setMaximumSize(new Dimension(259, 45));
        container.add(scrollPane);
    }


    private void addAFileChooser(Container container, JButton selectFolder)
    {
       selectFolder.setText("Select a Folder");
       selectFolder.setAlignmentX(Component.CENTER_ALIGNMENT);
       selectFolder.setMaximumSize(new Dimension(259,20));
       selectFolder.addActionListener(this);
      container.add(selectFolder);
    }

    private void addAToolbar(String text, Container container, JToolBar toolBar)
    {
        JButton button = new JButton();
        toolBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        toolBar.setMaximumSize(new Dimension(300, 30));
        toolBar.add(button);
        toolBar.setFloatable(false);
        container.add(toolBar);
    }
    private  void addAbutton(String text, Container container, JButton button)
    {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText(text);
        button.addActionListener(this);
        button.setMaximumSize(new Dimension(259,20));
        container.add(button);
    }

    private  void addALabel(String text, Container container, boolean show, JLabel label)
    {
        label.setText(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setMaximumSize(new Dimension(300, 30));
        label.setVisible(show);
        container.add(label);
    }

    private void addATextBox(Container container, boolean show, JTextField textField)
    {
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(new Dimension(259, 20));
        textField.setVisible(show);
        container.add(textField);
    }

    public void addACheckBox(Container container, JCheckBox checkBox)
    {
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox.setText("Click me to set the number of folders");
        checkBox.addItemListener(this);
        container.add(checkBox);
    }

    public  void createShowGUI()
    {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(jFrame.getContentPane());
        jFrame.pack();
        jFrame.setSize(300,250);
        jFrame.setVisible(true);
        jFrame.setMaximizedBounds(new Rectangle(300,300));
        jFrame.setMaximumSize(new Dimension(300,350));
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submitButton)
        {
            if (checkboxForNumber.isSelected())
            {

            }
            else
            {
               FolderGen folderGen = FolderGen.getFolderWithLocationAndNameOnly(path.toString(),textForFolderName.getText());
               folderGen.generateFolders();
            }


        }

        if(e.getSource() == selectFolder)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setCurrentDirectory(new File("."));
            fileChooser.showOpenDialog(this);
            fileChooser.approveSelection();
            path = fileChooser.getSelectedFile().getAbsolutePath();
            StringBuffer buffer = new StringBuffer();
            buffer.append(path);
            System.out.println(path);
            textArea.setText(buffer.toString());
            textArea.setMaximumSize(new Dimension(259,20));
            labelFolderLocation.setVisible(true);
            scrollpane.setVisible(true);
            textArea.setVisible(true);
            jFrame.invalidate();
            jFrame.validate();
        }

        if(e.getSource() == clearButton)
        {
            textArea.setVisible(false);
            labelFolderLocation.setVisible(false);
            scrollpane.setVisible(false);
            jFrame.setSize(new Dimension(300,250));
            jFrame.invalidate();
            jFrame.validate();
        }

    }


    public void openFileDialog()
    {

    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getStateChange() == ItemEvent.SELECTED)
        {
            jFrame.setSize(300,350);
            textFieldNumberOfFolders.setVisible(true);
            labelForMultipleFoldersName.setVisible(true);
            jFrame.invalidate();
            jFrame.validate();


        }
        else
        {
            textFieldNumberOfFolders.setVisible(false);
            labelForMultipleFoldersName.setVisible(false);
            jFrame.setSize(300,300);
            jFrame.invalidate();
            jFrame.validate();
        }
    }
}
