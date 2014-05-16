package com.jamesloyd.foldergenutility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

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
public class MainForm extends JFrame implements ActionListener , ItemListener
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
    char placeholder = '\u0000';
    String startpoint = null;
    String numberOfFiles = null;

    JFrame jFrame = new JFrame("FolderGenUtility");
    String path = "";
    JFileChooser fileChooser = new JFileChooser();
    public MainForm()
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
        addALabel("Current Root Directory Selected:" ,pane,true, labelFolderLocation);
        addAScrollPane(pane, scrollpane);
        addACheckBox(pane, checkboxForNumber);
        addALabel("<html><p>Please insert the number total</p></html>",pane,false,labelForMultipleFoldersName);
        addATextBox(pane, false,textFieldNumberOfFolders);
        addALabel("<html><p>Please insert the folder name</p></html>", pane, true, labelForFolderName);
        addATextBox(pane,true,textForFolderName);
        addAbutton("Submit Button", pane, submitButton);
        addAbutton("Clear",pane, clearButton);

    }

    private void addAScrollPane(Container container, JScrollPane scrollPane)
    {
        scrollPane.setVisible(true);
        scrollPane.setMaximumSize(new Dimension(290, 45));
        container.add(scrollPane);
    }


    private void addAFileChooser(Container container, JButton selectFolder)
    {
       selectFolder.setText("Select a Folder");
       selectFolder.setAlignmentX(Component.CENTER_ALIGNMENT);
       selectFolder.setMaximumSize(new Dimension(290,20));
       selectFolder.addActionListener(this);
      container.add(selectFolder);
    }

    private void addAToolbar(String text, Container container, JToolBar toolBar)
    {
        JButton button = new JButton();
        toolBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        toolBar.setMaximumSize(new Dimension(290, 30));
        toolBar.add(button);
        toolBar.setFloatable(false);
        container.add(toolBar);
    }
    private  void addAbutton(String text, Container container, JButton button)
    {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText(text);
        button.addActionListener(this);
        button.setMaximumSize(new Dimension(290,20));
        container.add(button);
    }

    private  void addALabel(String text, Container container, boolean show, JLabel label)
    {
        label.setText(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setMaximumSize(new Dimension(290, 30));
        label.setVisible(show);
        container.add(label);
    }

    private void addATextBox(Container container, boolean show, JTextField textField)
    {
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setMaximumSize(new Dimension(290, 20));
        textField.setVisible(show);
        container.add(textField);
    }

    public void addACheckBox(Container container, JCheckBox checkBox)
    {
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox.setText("Click me to set the number of folders");
        checkBox.setMaximumSize(new Dimension(290, 20));
        checkBox.addItemListener(this);
        container.add(checkBox);
    }

    public  void createShowGUI()
    {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(jFrame.getContentPane());
        jFrame.pack();
        jFrame.setSize(300, 300);
        jFrame.setVisible(true);
        jFrame.setMaximizedBounds(new Rectangle(300, 290));
        fileChooser.setCurrentDirectory(new File("."));
        textArea.setEditable(false);
        textArea.setText(fileChooser.getCurrentDirectory().toString());
        jFrame.setResizable(false);
        path = textArea.getText();
        textFieldNumberOfFolders.setText(null);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == submitButton)
        {
            startpoint = null;
            if(textForFolderName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please choose a root location", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                System.out.println(placeholder);
                if(textFieldNumberOfFolders.getText() == "")
                {
                    numberOfFiles = null;
                }
                else
                {
                    numberOfFiles = textFieldNumberOfFolders.getText();
                }
                SimpleFolder simpleFolderBuilder = SimpleFolderFactory.createFolders(path.toString(), textForFolderName.getText().toString(), startpoint, numberOfFiles, placeholder);
                simpleFolderBuilder.generateFolders();
            }

        }

        if(e.getSource() == selectFolder)
        {
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
            jFrame.invalidate();
            jFrame.validate();
        }

        if(e.getSource() == clearButton)
        {
            textArea.setText(fileChooser.getCurrentDirectory().toString());
            jFrame.setSize(new Dimension(300, 290));
            textFieldNumberOfFolders.setText("");
            textForFolderName.setText("");
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
