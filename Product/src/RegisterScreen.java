package ia;

import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterScreen extends JFrame {
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JPasswordField jPasswordField2;
    private JTextField jTextField1;
	private JOptionPane jOptionPane1;
	private ImagePanel rsPanel = new ImagePanel(new ImageIcon("Images/rs.png").getImage());

    public RegisterScreen() {
        initComponents();
		this.add(rsPanel);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }
	
    private void initComponents() {

        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jPasswordField2 = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Register");
		jButton1.setBackground(new Color(102,178,255));
		jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		
        jLabel1.setText("Create Username");

        jLabel2.setText("Create Password");

        jLabel3.setText("Re-Enter Password");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jPasswordField1)
                            .addComponent(jPasswordField2, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
		this.setIconImage(Main.icon.getImage());
		this.setTitle("SmartCash - Register");
        pack();
    }                       
    
	private void jButton1ActionPerformed(ActionEvent evt) {                                         
        String username = jTextField1.getText();
		String password = jPasswordField1.getText();
		String password2 = jPasswordField2.getText();
		
		if(!password.equals(password2)){
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"Your passwords don't match.");  
		}
		else{
			boolean isValid = true;
			
			if(!(username.indexOf(' ') < 0)){
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"You cannot have spaces in your username.");  		
			}
			else if(password.equals("") || username.equals("")){
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"Your username/password cannot be empty.");  	
			}
			else{
				String existingUser = "";
				try {
					Scanner sc = new Scanner(LoginScreen.logins);
					while (sc.hasNextLine()) {
						String data = sc.nextLine();
						existingUser = data.substring(0, data.indexOf(' '));
						if(username.equals(existingUser)){
							jOptionPane1 = new JOptionPane();
							JFrame f = new JFrame();  
							System.out.println("Username Taken");
							JOptionPane.showMessageDialog(f,"That username has been taken already.");  
							isValid = false;
							break;
						}
					}		
					if(isValid){
						try {
							LoginScreen.loginInfo += username + " " + password + "\n";
							FileWriter fw = new FileWriter("TextFiles/accounts.txt");
							BufferedWriter br = new BufferedWriter(fw);
							br.write(LoginScreen.loginInfo);
							br.close();
							
							jOptionPane1 = new JOptionPane();
							JFrame f = new JFrame();  
							JOptionPane.showMessageDialog(f,"You have successfully created an account. You may sign in now."); 
							this.setVisible(false);
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						} catch (IOException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
					}
					sc.close();
				} catch (FileNotFoundException e) {
					  System.out.println("An error occurred.");
					  e.printStackTrace();
				} 
			}
		}
    }                                      
}
