package com.jamesloyd.foldergenutility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class Form extends JFrame implements ActionListener
{
    JPanel toppanel;
    JButton submitbutton;
    JLabel yolabel;

    public Form()
    {

    }

    public  void addComponentsToPane(Container pane)
    {
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        addAbutton("Button 1", pane);
        addALabel("This is a label",pane);
    }

    private  void addAbutton(String text, Container container)
    {

        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(this);
        container.add(button);
    }

    private  void addALabel(String text, Container container)
    {
        JLabel panel = new JLabel(text);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(panel);
    }

    public  void createShowGUI()
    {
        JFrame jFrame = new JFrame("Welcome");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(jFrame.getContentPane());
        jFrame.pack();
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
     JButton src = (JButton) e.getSource();
     System.out.println(src.getText());
    }
}
