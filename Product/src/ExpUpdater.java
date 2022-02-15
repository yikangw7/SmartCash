package ia;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExpUpdater extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
	private JOptionPane jOptionPane1;
	private ImagePanel euPanel = new ImagePanel(new ImageIcon("Images/eu.png").getImage());

    public ExpUpdater() {
        initComponents();
    }
                    
    private void initComponents() {
		
        jComboBox1 = new JComboBox<>();
        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jTextField2 = new JTextField();
        jButton2 = new JButton();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Utility Bills", "Food", "Luxury", "Transport", "Other" }));
		
        jLabel1.setText("Expenditure Amount");
        jLabel2.setText("Expenditure Type");

        jButton1.setText("Add Expenditure");
		jButton1.setBackground(new Color(102,178,255));
		jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Change Existing Expenditures:");
        jLabel4.setText("Utility Bills");
        jLabel5.setText("Food");
        jLabel6.setText("Luxury");
        jLabel7.setText("Transport");
        jLabel8.setText("Other");

        jButton2.setText("Update");
		jButton2.setBackground(new Color(102,178,255));
		jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
		jButton3.setBackground(new Color(102,178,255));
		jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
		
        jButton4.setText("Update");
		jButton4.setBackground(new Color(102,178,255));
		jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton5.setText("Update");
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
        jButton7.setText("Exit");
		jButton7.setBackground(new Color(102,178,255));
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
		if(Expenditure.totalEntries > 0){
			jTextField2.setText(Main.exp.get(Expenditure.totalEntries-1).getUtilityExp()+"");
			jTextField3.setText(Main.exp.get(Expenditure.totalEntries-1).getFoodExp()+"");
			jTextField4.setText(Main.exp.get(Expenditure.totalEntries-1).getLuxuryExp()+"");
			jTextField5.setText(Main.exp.get(Expenditure.totalEntries-1).getTransportExp()+"");
			jTextField6.setText(Main.exp.get(Expenditure.totalEntries-1).getOtherExp()+"");
		}
		
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 160, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField6, GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField5)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton7)
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
		
		this.add(euPanel);
		this.setIconImage(Main.icon.getImage());
		this.setTitle("SmartCash - Update Expenditure Data");
        pack();
    }                   
    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        int expType = jComboBox1.getSelectedIndex();
	    try{
		    double expAmt = Double.parseDouble(jTextField1.getText());
		    if(expType == 0){
			   Main.exp.get(Expenditure.totalEntries-1).setUtilityExp(expAmt + Main.exp.get(Expenditure.totalEntries-1).getUtilityExp());
		    }
		    else if(expType == 1){
			   Main.exp.get(Expenditure.totalEntries-1).setFoodExp(expAmt + Main.exp.get(Expenditure.totalEntries-1).getFoodExp());
		    }
		    else if(expType == 2){
			   Main.exp.get(Expenditure.totalEntries-1).setLuxuryExp(expAmt + Main.exp.get(Expenditure.totalEntries-1).getLuxuryExp());
		    }
		    else if(expType == 3){
			   Main.exp.get(Expenditure.totalEntries-1).setTransportExp(expAmt + Main.exp.get(Expenditure.totalEntries-1).getTransportExp());
		    }
		    else if(expType == 4){
			   Main.exp.get(Expenditure.totalEntries-1).setOtherExp(expAmt + Main.exp.get(Expenditure.totalEntries-1).getOtherExp());
		    }
		    Expenditure.updateAll();
			
			rewrite();
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"You have successfully added an expenditure."); 
			jTextField1.setText("");
		    Menu.reload();
		    this.reload();
	    }
	    catch(NumberFormatException e){
		   jTextField1.setText("Invalid value. Please try again.");
	    }
    } 
	private void jButton2ActionPerformed(ActionEvent evt) {                                         
        try{
		    double expAmt = Double.parseDouble(jTextField2.getText());
			Main.exp.get(Expenditure.totalEntries-1).setUtilityExp(expAmt);
			Expenditure.updateAll();
			
			rewrite();
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"You have successfully updated your Utility expenditure data."); 
			jTextField1.setText("");
		    Menu.reload();
		    this.reload();
	    }
	    catch(NumberFormatException e){
		   jTextField2.setText("Invalid value. Please try again.");
	    }
    } 
	private void jButton3ActionPerformed(ActionEvent evt) {                                         
        try{
		    double expAmt = Double.parseDouble(jTextField3.getText());
			Main.exp.get(Expenditure.totalEntries-1).setFoodExp(expAmt);
			Expenditure.updateAll();
			
			rewrite();
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"You have successfully updated your Food expenditure data."); 
			jTextField1.setText("");
		    Menu.reload();
		    this.reload();
	    }
	    catch(NumberFormatException e){
		   jTextField2.setText("Invalid value. Please try again.");
	    }
    } 
	private void jButton4ActionPerformed(ActionEvent evt) {                                         
		try{
		    double expAmt = Double.parseDouble(jTextField4.getText());
			Main.exp.get(Expenditure.totalEntries-1).setLuxuryExp(expAmt);
			Expenditure.updateAll();
			
			rewrite();
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"You have successfully updated your Luxury expenditure data."); 
			jTextField1.setText("");
		    Menu.reload();
		    this.reload();
	    }
	    catch(NumberFormatException e){
		   jTextField2.setText("Invalid value. Please try again.");
	    }
    } 
	private void jButton5ActionPerformed(ActionEvent evt) {                                         
        try{
		    double expAmt = Double.parseDouble(jTextField5.getText());
			Main.exp.get(Expenditure.totalEntries-1).setTransportExp(expAmt);
			Expenditure.updateAll();
			
			rewrite();
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"You have successfully updated your Transport expenditure data."); 
			jTextField1.setText("");
		    Menu.reload();
		    this.reload();
	    }
	    catch(NumberFormatException e){
		   jTextField2.setText("Invalid value. Please try again.");
	    }
    } 
	private void jButton6ActionPerformed(ActionEvent evt) {                                         
		try{
		    double expAmt = Double.parseDouble(jTextField6.getText());
			Main.exp.get(Expenditure.totalEntries-1).setOtherExp(expAmt);
			Expenditure.updateAll();
			
			rewrite();
			jOptionPane1 = new JOptionPane();
			JFrame f = new JFrame();  
			JOptionPane.showMessageDialog(f,"You have successfully updated your Other expenditure data."); 
			jTextField1.setText("");
		    Menu.reload();
		    this.reload();
	    }
	    catch(NumberFormatException e){
		   jTextField2.setText("Invalid value. Please try again.");
	    }
    } 
    private void jButton7ActionPerformed(ActionEvent evt) {                                         
		this.setVisible(false);
    }                                                                                

	private void reload(){
		if(Expenditure.totalEntries > 0){
			jTextField2.setText(Main.exp.get(Expenditure.totalEntries-1).getUtilityExp()+"");
			jTextField3.setText(Main.exp.get(Expenditure.totalEntries-1).getFoodExp()+"");
			jTextField4.setText(Main.exp.get(Expenditure.totalEntries-1).getLuxuryExp()+"");
			jTextField5.setText(Main.exp.get(Expenditure.totalEntries-1).getTransportExp()+"");
			jTextField6.setText(Main.exp.get(Expenditure.totalEntries-1).getOtherExp()+"");
		}
	}
	
	private void rewrite(){
		try {
			FileWriter fw = new FileWriter(Expenditure.f);
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
	}
}
