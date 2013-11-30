package menu;

import java.util.Scanner;

import Stock.StockManagement;

public abstract class Menu {
	protected int nbChoices;
	private StockManagement Stock;
	
	public int getValidChoice(int nbChoix){
		System.out.println("Enter your choice : ");
		int choice=getInt();
		while ((choice<0)||(choice>nbChoix)){
			System.out.println("Invalid choice, enter your choice : ");
			choice=getInt();		
		}
		return choice;
	}
	
	private int getInt() {
		Scanner sc= new Scanner(System.in);
		int choix;
		try{
			choix =sc.nextInt();
			}catch(Exception e){choix =-1;}
		return choix;
	}
	
	public abstract void handleChoice(int Choice);
}
