package ia;

import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main{
	static LinkedList i = new LinkedList();
	static LinkedList exp = new LinkedList();
	static Font ft;
	static ImageIcon icon = new ImageIcon("Images/sc.png");
	public static void main(String args[]) {
		
		// Font 
		try {
			ft = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Futura.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(ft);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(FontFormatException e) {
			e.printStackTrace();
		}
		
		LoginScreen ls = new LoginScreen();
		ls.setVisible(true);
        ls.setLocationRelativeTo(null);
		ls.setResizable(false);
		
		// Initializing Classes - To bypass NoClassDefFoundError
		Menu m = new Menu();
		IncomeUpdater b = new IncomeUpdater();
		ExpUpdater ex = new ExpUpdater();
		RegisterScreen r = new RegisterScreen();
		ImagePanel ip = new ImagePanel("Images/ls.png");
		MonthCreator mc = new MonthCreator();
		HistoryViewer hv = new HistoryViewer();
		TrendGrapher tg = new TrendGrapher();
    }
	
	public static void initArrayLists(){
		File f = new File("TextFiles/" + LoginScreen.currentUser + "info.txt");
	    File fe = new File("TextFiles/" + LoginScreen.currentUser + "infoExp.txt");
		// Reading existing income data
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				String month = data.substring(0, data.indexOf(' '));
				double taxRate = Double.parseDouble(data.substring(data.indexOf(' ')+1, data.indexOf('-')));
				double rawIncome = Double.parseDouble(data.substring(data.indexOf('-')+1, data.length()));
				i.add(new Income(month, taxRate, rawIncome));
			}		
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		// Reading existing expenditure data
		try {
			Scanner sc = new Scanner(fe);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				String month = data.substring(0, data.indexOf(' '));
				double taxRate = Double.parseDouble(data.substring(data.indexOf(' ')+1, data.indexOf('-')));
				double income = Double.parseDouble(data.substring(data.indexOf('-')+1, data.indexOf('l')));
				double lux = Double.parseDouble(data.substring(data.indexOf('l')+1, data.indexOf('f')));
				double food = Double.parseDouble(data.substring(data.indexOf('f')+1, data.indexOf('t')));
				double transp = Double.parseDouble(data.substring(data.indexOf('t')+1, data.indexOf('u')));
				double utility = Double.parseDouble(data.substring(data.indexOf('u')+1, data.indexOf('o')));
				double other = Double.parseDouble(data.substring(data.indexOf('o')+1, data.length()));
				exp.add(new Expenditure(month, taxRate, income, lux, food, transp, utility, other));
			}		
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}