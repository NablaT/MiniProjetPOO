package menu;

import Stock.*;
import java.util.Scanner;


public class MainMenu extends Menu{


	
	public MainMenu(){
		int choice;
		do{
			nbChoices=2;
			displayMainMenu();
			choice = getValidChoice(this.nbChoices);
			handleChoice(choice);
		}while(choice!=0);
		sayGoodBye();
	}


	@Override
	public void handleChoice(int choice){
		switch(choice){
		case 1 :new BorrowerMenu();break;
		case 2 :System.out.println("Unavailble functionality");break;
		case 0 : break;
		}
	}
	
	
	
	private void sayGoodBye() {
		System.out.println("Good bye !");
	}

	public void displayMainMenu(){
		System.out.println("You are : \n	1-A borrower\n	2-A manager\n	0-Quitter");
	}
	
	 public static void main(String[] args){
		 new MainMenu();
		 
	 }
}
