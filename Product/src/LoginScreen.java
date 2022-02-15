package ia;

import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginScreen extends JFrame {
	private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
	private JOptionPane jOptionPane1;
	private ImagePanel lsPanel = new ImagePanel(new ImageIcon("Images/ls2.png").getImage());
	static boolean firstLogin = true;
	static String loginInfo = "";
	static File logins = new File("TextFiles/accounts.txt");
	static String currentUser = "";
    
	public LoginScreen() {
        initComponents();
		this.add(lsPanel);
		this.setIconImage(Main.icon.getImage());
		this.setTitle("SmartCash - Login");
		try {
			Scanner sc = new Scanner(logins);
			while (sc.hasNextLine()) {
				loginInfo += sc.nextLine() + "\n";
			}
			sc.close();
		} catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		} 
    }
                   
    private void initComponents() {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jTextField1 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Login");
		jButton1.setBackground(new Color(102,178,255));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Register");
		jButton2.setBackground(new Color(102,178,255));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPasswordField1)
                        .addComponent(jTextField1)
                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(203, 203, 203))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        pack();
    }                     

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
		String username = jTextField1.getText();
		String password = jPasswordField1.getText();
		boolean success = false;
		
		String existingUser = "";
		String existingPswd = "";
		try {
			Scanner sc = new Scanner(logins);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				existingUser = data.substring(0, data.indexOf(' '));
				existingPswd = data.substring(data.indexOf(' ')+1,data.length());
				if(username.equals(existingUser) && password.equals(existingPswd)){
					System.out.println("Successful Login");
					success = true;
					if(firstLogin){
						firstLogin = false;
						currentUser = username;
						Menu.menu();
					}
					else{
						if(currentUser != username){
							currentUser = username;
							// Switching Users
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
							
							// Clearing the Object ArrayLists
							Main.i.clear();
							Main.exp.clear();
							
							// Clearing the Static Variables
							Expenditure.currentMonth = "000000";
							Income.currentMonth = "000000";
							Expenditure.totalEntries = 0;
							Income.totalMonths = 0;
							Expenditure.expInfo = "";
							Income.incomeInfo = "";
							
							// Changing the target files
							Income.f = new File("TextFiles/" + LoginScreen.currentUser + "info.txt");
							Expenditure.f = new File("TextFiles/" + LoginScreen.currentUser + "infoExp.txt");
							
							// Recreating the Object ArrayLists
							Main.initArrayLists(); 
							
							Menu.reload();
						}
						Menu.f.setVisible(true);
					}
					this.setVisible(false);
					break;
				}
			}
			if(!success){
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"Invalid username or password.");  	
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		} 
    }                                        

    private void jButton2ActionPerformed(ActionEvent evt) {                                         
		RegisterScreen r = new RegisterScreen();
		r.setVisible(true);
		r.setLocationRelativeTo(null);
		r.setResizable(false);
    }                                                                    
}