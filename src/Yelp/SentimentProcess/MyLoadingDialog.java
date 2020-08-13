/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yelp.SentimentProcess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pankaj
 */
public class MyLoadingDialog extends JDialog {

    private final JPanel pn = new JPanel();

    public MyLoadingDialog() {
        setBounds(100, 100, 200, 200);
        setBackground(Color.GRAY);
        getContentPane().setLayout(new BorderLayout());
        //pn.setLayout(new FlowLayout());
        //pn.setBorder(new EmptyBorder(5, 5,5, 5));

        //JPanel pnLoadingText=new JPanel();
        //pnLoadingText.setLayout(new FlowLayout(FlowLayout.LEFT));
        //pn.add(pnLoadingText,BorderLayout.NORTH);
        JLabel label = new JLabel("Please wait while processing");
        label.setForeground(Color.BLACK);
        pn.add(label);

        getContentPane().add(pn, BorderLayout.CENTER);
    }

}
