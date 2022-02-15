package ia;

import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class Menu{
	static JOptionPane jOptionPane1;
	static JButton jButton1;
    static JButton jButton2;
    static JButton jButton3;
    static JButton jButton4;
    static JButton jButton5;
	static JButton jButton6;
	static JButton jButton7;
    static JLabel jLabel1;
    static JLabel jLabel2;
    static JLabel jLabel3;
    static JLabel jLabel4;
    static JLabel jLabel5;
    static JLabel jLabel6;
    static JScrollPane jScrollPane1;
    static JTextArea jTextArea1;
	static JFrame f = new JFrame();
	static ImagePanel mPanel = new ImagePanel(new ImageIcon("Images/menu.png").getImage());

	public static void menu(){
		CardLayout cl = new CardLayout(); // CardLayout for organizing different JPanels
		JPanel mainPanel = new JPanel();
		JPanel menuPanel = new JPanel();
		
		// CardLayout setup
		mainPanel.setLayout(cl);
		JPanel mainmenu = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		LayoutManager overlay = new OverlayLayout(mainmenu);	
		
		jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel6 = new JLabel();
        jButton6 = new JButton();
        jButton7 = new JButton();
		
		// Create new files - allows for user specific data
		try {
			System.out.println(LoginScreen.currentUser);
			File newFile = new File("TextFiles/" + LoginScreen.currentUser + "info.txt");
			if (newFile.createNewFile()) {
				System.out.println("The file was created.");
			} 
			else {
				System.out.println("The file already exists.");
			}
			
			File newFile2 = new File("TextFiles/" + LoginScreen.currentUser + "infoExp.txt");
			if (newFile2.createNewFile()) {
				System.out.println("The file was created.");
			} 
			else {
				System.out.println("The file already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		Income.f = new File("TextFiles/" + LoginScreen.currentUser + "info.txt");
		Expenditure.f = new File("TextFiles/" + LoginScreen.currentUser + "infoExp.txt");
		Main.initArrayLists(); // Creating the array lists of Income & Expenditure Objects

        jLabel1.setFont(Main.ft); 
        jLabel1.setText("Welcome back, "+ LoginScreen.currentUser + ". Month: " + Expenditure.monthToString());

        jLabel3.setFont(Main.ft);
		if(Income.findCurrentIncome() < 0){
			jLabel3.setText("Monthly Income: $0 [Enter data]");
		}
		else {
			String s = Income.findCurrentIncome() + "";
			jLabel3.setText("Monthly Income: $"+s);
		}
		jLabel4.setFont(Main.ft); 
		if(Expenditure.calcExp() <= 0){
			jLabel4.setText("Monthly Expenses: $0 [Enter data]");
		}
		else {
			String s = String.format("%.2f", Expenditure.calcExp());
			jLabel4.setText("Monthly Expenses: $"+s);
		}

        jLabel5.setFont(Main.ft);
		if(Income.findCurrentIncome() > 0 && Expenditure.calcExp() > 0){
			String s = String.format("%.2f", Income.findCurrentIncome() - Expenditure.calcExp());
			jLabel5.setText("Surplus Money: $" + s);
		}
		else if(Income.findCurrentIncome() > 0){
			String s = String.format("%.2f", Income.findCurrentIncome());
			jLabel5.setText("Surplus Money: $" + s);
		}
		else{
			jLabel5.setText("Surplus Money: $0 [Enter Data]");
		}

        jButton1.setText("Exit");
		jButton1.setBackground(new Color(0,76,153));
		jButton1.setForeground(Color.WHITE);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Month");
		jButton2.setBackground(new Color(102,178,255));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Past Months");
		jButton3.setBackground(new Color(102,178,255));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("View Trends");
		jButton4.setBackground(new Color(102,178,255));
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Savings & Investment Center");
		jButton5.setBackground(new Color(102,178,255));
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
		jButton6.setText("Update");
		jButton6.setBackground(new Color(102,178,255));
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
		
        jButton7.setText("Update");
		jButton7.setBackground(new Color(102,178,255));
		jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jTextArea1.setColumns(20);
        jTextArea1.setRows(4);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel6.setFont(Main.ft);
        jLabel6.setText("Personalized Advice");
		
		jTextArea1.setEditable(false);

        GroupLayout layout = new GroupLayout(menuPanel);
        menuPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)))
                        .addContainerGap())))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jButton6))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton7))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
		
		menuPanel.add(mPanel);
		
		// Card Layout
		mainPanel.add(menuPanel, "1");
		cl.show(mainPanel, "1"); 
		
		// JFrame
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		// frame.setResizable(false);
		f.add(mainPanel);
		f.setTitle("SmartCash - Financial Tracking Application");
		f.setIconImage(Main.icon.getImage());
		f.setSize(835,640);
		f.setResizable(false);
		f.setLocationRelativeTo(null); // Center frame on screen
		f.setVisible(true);
		
	}
	
	public static void jButton1ActionPerformed(ActionEvent evt) {    
		f.setVisible(false);
		LoginScreen ls = new LoginScreen();
		ls.setVisible(true);
        ls.setLocationRelativeTo(null);
    }                                        

    public static void jButton2ActionPerformed(ActionEvent evt) {                                         
		MonthCreator mc = new MonthCreator();
		mc.setVisible(true);
		mc.setLocationRelativeTo(null);
		mc.setResizable(false);
		mc.setDefaultCloseOperation(mc.DISPOSE_ON_CLOSE);
    }                                        

    public static void jButton3ActionPerformed(ActionEvent evt) {    
		HistoryViewer hv = new HistoryViewer();
		hv.setVisible(true);
		hv.setLocationRelativeTo(null);
		hv.setResizable(false);
		hv.setDefaultCloseOperation(hv.DISPOSE_ON_CLOSE);	
    }                                        

    public static void jButton4ActionPerformed(ActionEvent evt) {                                         
        TrendGrapher tg = new TrendGrapher();
		tg.setVisible(true);
		tg.setLocationRelativeTo(null);
		tg.setResizable(false);
		tg.setDefaultCloseOperation(tg.DISPOSE_ON_CLOSE);
    }                                        

    public static void jButton5ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
    }    
	public static void jButton6ActionPerformed(ActionEvent evt) { 
		if(Income.totalMonths == 0){
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"Create a new month first."); 
		}
		else{
			IncomeUpdater iu = new IncomeUpdater();
			iu.setVisible(true);
			iu.setLocationRelativeTo(null);
			iu.setResizable(false);
			iu.setDefaultCloseOperation(iu.DISPOSE_ON_CLOSE);
		}
    }   
	public static void jButton7ActionPerformed(ActionEvent evt) {    
		if(Expenditure.totalEntries == 0){
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"Create a new month first."); 
		}	
		else{
			ExpUpdater eu = new ExpUpdater();
			eu.setVisible(true);
			eu.setLocationRelativeTo(null);
			eu.setResizable(false);
			eu.setDefaultCloseOperation(eu.DISPOSE_ON_CLOSE);
			eu.setSize(440,410);
		}
    }  
	public static void reload(){
		jLabel1.setFont(Main.ft); 
        jLabel1.setText("Welcome back, "+ LoginScreen.currentUser + ". Month: " + Expenditure.monthToString());

		jLabel3.setFont(Main.ft);
		if(Income.findCurrentIncome() < 0){
			jLabel3.setText("Monthly Income: $0 [Enter data]");
		}
		else {
			String s = Income.findCurrentIncome() + "";
			jLabel3.setText("Monthly Income: $"+s);
		}
		jLabel4.setFont(Main.ft); 
		if(Expenditure.calcExp() <= 0){
			jLabel4.setText("Monthly Expenses: $0 [Enter data]");
		}
		else {
			String s = String.format("%.2f", Expenditure.calcExp());
			jLabel4.setText("Monthly Expenses: $"+s);
		}

        jLabel5.setFont(Main.ft);
		if(Income.findCurrentIncome() > 0 && Expenditure.calcExp() > 0){
			String s = String.format("%.2f", Income.findCurrentIncome() - Expenditure.calcExp());
			jLabel5.setText("Surplus Money: $" + s);
		}
		else if(Income.findCurrentIncome() > 0){
			String s = String.format("%.2f", Income.findCurrentIncome());
			jLabel5.setText("Surplus Money: $" + s);
		}
		else{
			jLabel5.setText("Surplus Money: $0 [Enter Data]");
		}
	}
}