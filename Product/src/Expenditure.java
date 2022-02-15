package ia;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class Expenditure extends Income{
	private double luxuryExp = 0;
	private double foodExp = 0;
	private double transportExp = 0;
	private double utilityExp = 0;
	private double otherExp = 0;
	static File f = new File("TextFiles/" + LoginScreen.currentUser + "infoExp.txt");
	static String currentMonth = "000000";
	static int totalEntries = 0;
	static String expInfo = "";

	public Expenditure(String month, double taxRate, double income, double luxuryExp, double foodExp, double transportExp, double utilityExp, double otherExp){
		super(month, taxRate, income);
		this.luxuryExp = luxuryExp;
		this.foodExp = foodExp;
		this.transportExp = transportExp;
		this.utilityExp = utilityExp;
		this.otherExp = otherExp;
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
				if(totalEntries == 0) {
					expInfo += data + "\n";
				}
			}		
			sc.close();
		} catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		} 
		totalEntries++;
		Income.totalMonths--;
	}
	
	// Getter Methods
	public double getLuxuryExp(){
		return luxuryExp;
	}
	public double getFoodExp(){
		return foodExp;
	}
	public double getTransportExp(){
		return transportExp;
	}
	public double getUtilityExp(){
		return utilityExp;
	}
	public double getOtherExp(){
		return otherExp;
	}
	
	// Setter Methods
	public void setLuxuryExp(double a){
		luxuryExp = a;
	}
	public void setFoodExp(double a){
		foodExp = a;
	}
	public void setTransportExp(double a){
		transportExp = a;
	}
	public void setUtilityExp(double a){
		utilityExp = a;
	}
	public void setOtherExp(double a){
		otherExp = a;
	}
	
	// Other Methods
	public static String monthToString(){
		if(totalEntries > 0){
			String s = "";
			
			System.out.println(currentMonth);
			String m = currentMonth.substring(0, 2);
			String y = currentMonth.substring(2, currentMonth.length());
			
			if(m.equals("01")){
				s += "January ";
			}
			else if(m.equals("02")){
				s += "February ";
			}
			else if(m.equals("03")){
				s += "March ";
			}
			else if(m.equals("04")){
				s += "April ";
			}
			else if(m.equals("05")){
				s += "May ";
			}
			else if(m.equals("06")){
				s += "June ";
			}
			else if(m.equals("07")){
				s += "July ";
			}
			else if(m.equals("08")){
				s += "August ";
			}
			else if(m.equals("09")){
				s += "September ";
			}
			else if(m.equals("10")){
				s += "October ";
			}
			else if(m.equals("11")){
				s += "November ";
			}
			else if(m.equals("12")){
				s += "December ";
			}
			
			return s + y + "";
		}
		return "Add a month";
	}
	
	public static double calcExp(){
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				if(data.substring(0, data.indexOf(' ')).equals(currentMonth)){
					double lux = Double.parseDouble(data.substring(data.indexOf('l')+1, data.indexOf('f')));
					double food = Double.parseDouble(data.substring(data.indexOf('f')+1, data.indexOf('t')));
					double transp = Double.parseDouble(data.substring(data.indexOf('t')+1, data.indexOf('u')));
					double utility = Double.parseDouble(data.substring(data.indexOf('u')+1, data.indexOf('o')));
					double other = Double.parseDouble(data.substring(data.indexOf('o')+1, data.length()));
					return lux+food+transp+utility+other;
				}
				
			}		
			sc.close();
		} catch (FileNotFoundException e) {
			  System.out.println("An error occurred.");
			  e.printStackTrace();
		} 
		return -1.0;
	}
	
	public static void updateAll(){
		Expenditure.expInfo = Expenditure.expInfo.substring(0,Expenditure.expInfo.lastIndexOf(' ')) + " " + Main.exp.get(Expenditure.totalEntries-1).getTaxRate() + "-" + Main.exp.get(Expenditure.totalEntries-1).getIncome() + "l" + Main.exp.get(Expenditure.totalEntries-1).getLuxuryExp() + "f" + Main.exp.get(Expenditure.totalEntries-1).getFoodExp() + "t" + Main.exp.get(Expenditure.totalEntries-1).getTransportExp() + "u" + Main.exp.get(Expenditure.totalEntries-1).getUtilityExp() + "o" + Main.exp.get(Expenditure.totalEntries-1).getOtherExp() + "\n";
	}
}