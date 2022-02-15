package ia;

import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IncomeUpdater extends JFrame {
	
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
	private JOptionPane jOptionPane1;
	private ImagePanel iuPanel = new ImagePanel(new ImageIcon("Images/iu.png").getImage());
	
    public IncomeUpdater() {
        initComponents();
    }
                         
    private void initComponents() {

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();

        jLabel1.setFont(new Font("Arial", 1, 14)); 
        jLabel1.setText("Tax Rate:");

        jLabel2.setFont(new Font("Arial", 1, 14));
        jLabel2.setText("Monthly Income:");

        jLabel3.setFont(new Font("Arial", 1, 14)); 
        jLabel3.setText("Manually Change Income:");
		
		// Initializing the text boxes
		if(Income.totalMonths != 0){
			jTextField1.setText(Main.i.get(Income.totalMonths-1).getRawIncome()+"");
			jTextField2.setText(Main.i.get(Income.totalMonths-1).getTaxRate()+"");
		}

        jButton1.setText("Exit");
		jButton1.setBackground(new Color(102,178,255));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

		jButton2.setBackground(new Color(102,178,255));
        jButton2.setText("Update");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addGap(13, 13, 13)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
		
		this.add(iuPanel);
		this.setIconImage(Main.icon.getImage());
		this.setTitle("SmartCash - Update Income Data");
        pack();
    }                     

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        this.setVisible(false);
    }
	
	private void jButton2ActionPerformed(ActionEvent evt) {       
		System.out.println("Activated Update");
        double rawInc = 0.0, taxRate = 0.0, manual = 0.0;
		boolean success = true;
		if(jTextField3.getText().equals("")){
			try{
				rawInc = Double.parseDouble(jTextField1.getText());
			}
			catch(NumberFormatException e){
				jTextField1.setText("Invalid value. Please try again.");
				success = false;
			}
			try{
				taxRate = Double.parseDouble(jTextField2.getText());
			}
			catch(NumberFormatException e){
				jTextField2.setText("Invalid value. Please try again.");
				success = false;
			}
			
			if(success){
				Main.i.get(Income.totalMonths-1).setTaxRate(taxRate);
				Main.i.get(Income.totalMonths-1).setRawIncome(rawInc);
				System.out.println(Main.i.size());
				System.out.println(Main.i.get(Income.totalMonths-1).getTaxRate());
				System.out.println(Main.i.get(Income.totalMonths-1).getRawIncome());
				System.out.println(Income.incomeInfo.lastIndexOf(' '));
				System.out.println(Income.incomeInfo);
				Income.incomeInfo = Income.incomeInfo.substring(0,Income.incomeInfo.lastIndexOf(' ')) + " " + taxRate + "-" + rawInc + "\n";
				try {
					FileWriter fw = new FileWriter(Income.f);
					BufferedWriter br = new BufferedWriter(fw);
					br.write(Income.incomeInfo);
					br.close();
						
					jOptionPane1 = new JOptionPane();
					JFrame f = new JFrame();  
					JOptionPane.showMessageDialog(f,"You have successfully updated this month's information."); 
					jTextField1.setText("");
					jTextField2.setText("");
				} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
				} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
				}
				Main.i.get(Income.totalMonths-1).updateIncome();
				Menu.reload();
			}
		}
		else{
			try{
				manual = Double.parseDouble(jTextField3.getText());
				rawInc = manual;
				Main.i.get(Income.totalMonths-1).setTaxRate(taxRate);
				Main.i.get(Income.totalMonths-1).setRawIncome(manual);
				System.out.println(Main.i.get(Income.totalMonths-1).getTaxRate());
				System.out.println(Main.i.get(Income.totalMonths-1).getRawIncome());
				Income.incomeInfo = Income.incomeInfo.substring(0,Income.incomeInfo.lastIndexOf(' ')) + " " + taxRate + "-" + rawInc + "\n";
				try {
					FileWriter fw = new FileWriter(Income.f);
					BufferedWriter br = new BufferedWriter(fw);
					br.write(Income.incomeInfo);
					br.close();
						
					jOptionPane1 = new JOptionPane();
					JFrame f = new JFrame();  
					JOptionPane.showMessageDialog(f,"You have successfully updated this month's information."); 
					jTextField1.setText("");
					jTextField2.setText("");
				} catch (FileNotFoundException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
				} catch (IOException e) {
						System.out.println("An error occurred.");
						e.printStackTrace();
				}
				Main.i.get(Income.totalMonths-1).updateIncome();
				Menu.reload();
			}
			catch(NumberFormatException e){
				jTextField3.setText("Invalid value. Please try again.");
			}
		}
		
		this.setVisible(false);
    }  	
}
