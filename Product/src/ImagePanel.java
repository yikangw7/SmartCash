package ia;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ImagePanel extends JPanel {
	private Image i;
	public ImagePanel(String i) {
		this(new ImageIcon(i).getImage());
	}
	
	public ImagePanel(Image i) {
		this.i = i;
		Dimension size = new Dimension(i.getWidth(null), i.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(i, 0, 0, null);
	}
}