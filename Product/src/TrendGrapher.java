package ia;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrendGrapher extends JFrame {
	
	private JButton jButton1;
	private ImagePanel tgPanel = new ImagePanel(new ImageIcon("Images/tg.png").getImage());
	
    public TrendGrapher() {
        initComponents();
    }
                     
    private void initComponents() {

        jButton1 = new JButton();
		jButton1.setBackground(new Color(102,178,255));
        jButton1.setText("Exit");
		jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(542, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(417, Short.MAX_VALUE))
        );
		
		this.add(tgPanel);
		this.setIconImage(Main.icon.getImage());
		this.setTitle("SmartCash - View Trends");
        pack();
    }  
	
	private void jButton1ActionPerformed(ActionEvent evt) {    
		this.setVisible(false);
    }	
}
