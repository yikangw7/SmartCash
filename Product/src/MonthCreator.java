package ia;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MonthCreator extends JFrame {                 
    private JButton jButton1;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextField1;    
	private JOptionPane jOptionPane1;
	private ImagePanel mcPanel = new ImagePanel(new ImageIcon("Images/nmt.png").getImage());    
	
    public MonthCreator() {
        initComponents();
    }
                     
    private void initComponents() {

        jComboBox1 = new JComboBox<>();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "December" }));

        jLabel1.setText("Select Month");
        jLabel2.setText("Enter Year");

        jButton1.setText("Create New Month");
		jButton1.setBackground(new Color(102,178,255));
		jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		
        jButton2.setText("Exit");
		jButton2.setBackground(new Color(102,178,255));
		jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton2)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(16, Short.MAX_VALUE))
        );
		
		this.setIconImage(Main.icon.getImage());
		this.setTitle("SmartCash - Add New Entry");
		this.add(mcPanel);
        pack();
    }                       

    private void jButton1ActionPerformed(ActionEvent evt) {         
		String month = jComboBox1.getSelectedItem() + "";
        month = monthToNum(month);
		try{
			int year = Integer.parseInt(jTextField1.getText());
			int mostRecentYr = Integer.parseInt(Expenditure.currentMonth.substring(2));
			int mostRecentMo = Integer.parseInt(Expenditure.currentMonth.substring(0,2));
			
			if(mostRecentYr > year){
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"Invalid year. Must be a more recent month & year."); 
			}
			else if(mostRecentYr == year && mostRecentMo >= Integer.parseInt(month)){
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"Invalid month. Must be a more recent month & year."); 
			}
			else if(jTextField1.getText().equals("")){
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"Please enter the year."); 
			}
			else{
				month += year + "";
				if(Expenditure.totalEntries > 0 && Income.totalMonths > 0){
					Expenditure.expInfo += month + " " + Main.i.get(Income.totalMonths-1).getTaxRate() + "-" + Main.i.get(Income.totalMonths-1).getRawIncome() + "l" + 0.0 + "f" + 0.0 + "t" + 0.0 + "u" + 0.0 + "o" + 0.0 + "\n";
					Income.incomeInfo += month + " " + Main.i.get(Income.totalMonths-1).getTaxRate() + "-" + Main.i.get(Income.totalMonths-1).getRawIncome() + "\n";
					
					Main.exp.add(new Expenditure(month, Main.i.get(Income.totalMonths-1).getTaxRate(), Main.i.get(Income.totalMonths-1).getRawIncome(), 0.0, 0.0, 0.0, 0.0, 0.0));
					Main.i.add(new Income(month, Main.i.get(Income.totalMonths-1).getTaxRate(), Main.i.get(Income.totalMonths-1).getRawIncome()));
					
					rewrite();
				}
				else{
					Expenditure.expInfo += month + " " + 0.0 + "-" + 0.0 + "l" + 0.0 + "f" + 0.0 + "t" + 0.0 + "u" + 0.0 + "o" + 0.0 + "\n";
					Income.incomeInfo += month + " " + 0.0 + "-" + 0.0 + "\n";
					
					Main.exp.add(new Expenditure(month, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
					Main.i.add(new Income(month, 0.0, 0.0));
					
					rewrite();
				}
				
				Income.currentMonth = month;
				Expenditure.currentMonth = month;
				jOptionPane1 = new JOptionPane();
				JFrame f = new JFrame();  
				JOptionPane.showMessageDialog(f,"You have successfully created a new month! Please enter expenditure data or update income information."); 
				Menu.reload();
				this.setVisible(false);
			}
		}
		catch(NumberFormatException e){
			jTextField1.setText("Invalid value. Please try again.");
		}
    }   
	
	private void jButton2ActionPerformed(ActionEvent evt) {                                           
        this.setVisible(false);
    } 
	
	private String monthToNum(String s){
		String monthNum = "";
			
		if(s.equals("January")){
			monthNum += "01";
		}
		else if(s.equals("February")){
			monthNum += "02";
		}
		else if(s.equals("March")){
			monthNum += "03";
		}
		else if(s.equals("April")){
			monthNum += "04";
		}
		else if(s.equals("May")){
			monthNum += "05";
		}
		else if(s.equals("June")){
			monthNum += "06";
		}
		else if(s.equals("July")){
			monthNum += "07";
		}
		else if(s.equals("August")){
			monthNum += "08";
		}
		else if(s.equals("September")){
			monthNum += "09";
		}
		else if(s.equals("October")){
			monthNum += "10";
		}
		else if(s.equals("November")){
			monthNum += "11";
		}
		else if(s.equals("December")){
			monthNum += "12";
		}	
		return monthNum;
	}
	
	private void rewrite(){
		try {
			FileWriter fw = new FileWriter("TextFiles/" + LoginScreen.currentUser + "infoExp.txt");
			BufferedWriter br = new BufferedWriter(fw);
			br.write(Expenditure.expInfo);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter("TextFiles/" + LoginScreen.currentUser + "info.txt");
			BufferedWriter br = new BufferedWriter(fw);
			br.write(Income.incomeInfo);
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
