package ia;

import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class Income{
	static String currentMonth = "000000";
	static int totalMonths = 0;
	private String month;
	private double taxRate;
	private double rawIncome;
	private double income;
	static String incomeInfo = "";
	static File f = new File("TextFiles/" + LoginScreen.currentUser + "info.txt");

	public Income(String month, double taxRate, double rawIncome){
		this.month = month;
		this.taxRate = taxRate;
		this.rawIncome = rawIncome;
		if(taxRate == 0.0) this.income = rawIncome;
		else this.income = rawIncome - rawIncome * (taxRate/100.0);
		if(currentMonth.equals("000000")) {
			currentMonth = month;
		}
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				if(!sc.hasNextLine()){
					currentMonth = data.substring(0, data.indexOf(' '));
				}
				if(totalMonths == 0) {
					incomeInfo += data + "\n";
				}
			}		
			sc.close();
		} catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		} 
		totalMonths++;
	}
	
	// Getter Methods
	public String getMonth(){
		return month;
	}
	public double getTaxRate(){
		return taxRate;
	}
	public double getRawIncome(){
		return rawIncome;
	}
	public double getIncome(){
		return income;
	}
	
	// Setter Methods
	public void setMonth(String month){
		this.month = month;
	}
	public void setTaxRate(double taxRate){
		this.taxRate = taxRate;
	}
	public void setRawIncome(double rawIncome){
		this.rawIncome = rawIncome;
	}
	public void setIncome(double income){
		this.income = income;
	}
	
	public static double findCurrentIncome(){
		String lineMonth = "";
		double lineIncome = 0.0;
		double lineTax = 0.0;
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				lineMonth = data.substring(0, data.indexOf(' '));
				lineIncome = Double.parseDouble(data.substring(data.indexOf('-')+1,data.length()));
				lineTax = Double.parseDouble(data.substring(data.indexOf(' ')+1, data.indexOf('-')));
				if(lineMonth.equals(currentMonth)){
					if(lineTax == 0.0) {
						return lineIncome;
					}
					else {
						return lineIncome - lineIncome * (lineTax/100.0);
					}
					
				}
			}
			sc.close();
			return 0.0;		
		} catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		} 
		return 0.0;
	}
	
	public void updateIncome(){
		if(taxRate == 0.0) this.income = rawIncome;
		else this.income = rawIncome - rawIncome * (taxRate/100.0);
	}
}