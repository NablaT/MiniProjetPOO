package menu;

import Stock.*;

public class MainMenu extends Menu {

	public MainMenu() {
		int choice;
		nbChoices = 2;
		do {
			displayMainMenu();
			choice = getValidChoice(this.nbChoices, true);
			handleChoice(choice);
		} while (choice != 0);
		sayGoodBye();
	}

	@Override
	public void handleChoice(int choice) {
		switch (choice) {
		case 1:
			new BorrowerMenu();
			break;
		case 2:
			System.out.println("Unavailble functionality");
			break;
		case 0:
			break;
		}
	}

	public void sayGoodBye() {
		System.out.println("Good bye !");
	}

	public void displayMainMenu() {
		System.out.println("You are : \n	1-A borrower\n	2-A manager\n	0-Quit");
	}

	public static void main(String[] args) {
		new MainMenu();

	}
}
