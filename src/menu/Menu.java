package menu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import Material.*;
import Stock.*;

public abstract class Menu {
	protected int nbChoices;
	protected StockManagement stock;
	
	public int getValidChoice(int nbChoix, boolean zeroIsValid){
		System.out.println("Enter your choice : ");
		int choice=getChoice();
		while ((choice<(zeroIsValid ? 0:1))||(choice>nbChoix)){
			System.out.println("Invalid choice, enter your choice : ");
			choice=getChoice();		
		}
		return choice;
	}
	
	public Date getValidDate(){
		System.out.println("Enter a date ('dd/MM/yyyy') : ");
		Date date=getDate();
		while (date==null){
			System.out.println("Invalid format, please retry : ");
			date=getDate();		
		}
		return date;
	}
	
	public int getChoice() {
		Scanner sc= new Scanner(System.in);
		int choix;
		try{
			choix =sc.nextInt();
			}catch(Exception e){choix =-1;}
		return choix;
	}
	
	public Date getDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false); 
		Date date = null;
		try {
			date = format.parse(getString());
			} catch (Exception e) {}
		return date;
	}
	
	public String getString(){
		return new Scanner(System.in).nextLine();

		}
	
	public abstract void handleChoice(int Choice);
	
	
}
