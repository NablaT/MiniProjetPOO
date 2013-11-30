package menu;

public class BorrowerMenu extends Menu {
	
	public BorrowerMenu(){
		int choice;
		do{
			nbChoices=0;
			displayBorrowerMenu();
			choice = getValidChoice(this.nbChoices);
			handleChoice(choice);
		}while(choice!=0);
	}

	private void displayBorrowerMenu() {
		System.out.println("The Borrower Menu !\n 	0-	quit");
		
	}

	@Override
	public void handleChoice(int Choice) {
		// TODO Auto-generated method stub
		
	}

}
