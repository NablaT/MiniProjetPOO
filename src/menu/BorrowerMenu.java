package menu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Living.*;
import Material.Type;
import Stock.Loan;
import Stock.StockManagement;

public class BorrowerMenu extends Menu {
	
	private Borrower currentUser=new Student("");
	
	public BorrowerMenu(){
		int choice;
		nbChoices=4;
		stock=new StockManagement(null,initializeStock());
		do{
			displayBorrowerMenu();
			choice = getValidChoice(this.nbChoices,true);
			handleChoice(choice);
		}while(choice!=0);
	}

	public void displayBorrowerMenu() {
		System.out.println("What do you want to do ?\n 	1-Borrow an object\n	2-return an object\n	3-See your informations\n	0-Quit");
	}

	@Override
	public void handleChoice(int choice) {
		switch(choice){
		case 1 :
			if (createBorrowing())System.out.println("Request sent");
			else System.out.println("You can't borrow that !") ;break;
		case 2 :
			System.out.println("Unavailble functionality");break;
		case 3 :
			System.out.println("Unavailble functionality");break;
		case 0 : break;
	}
		
	}

	public boolean createBorrowing() {
		Type material=getWantedMaterial();
		Date beginning=getBeginningDate();
		Date end=getEndDate();
		String description = getDescription();
		Loan l=new Loan(beginning, end, currentUser, description,material);
		System.out.println("Le prêt de "+material+" pour " +currentUser+ " commence le "+beginning+ " et finit le "+end+"\n raison : "+description+"\n");
		return stock.makeALoan(l);
	}

	private String getDescription() {
		System.out.println("Why do you need it ?");
		return getString();
	}

	public Type getWantedMaterial() {
		System.out.println("Wich material do you need ?\n	1-Tablet\n	2-Phone\n	3-Headphone\n	4-Camera");
		int choice=getValidChoice(4,false);
		Type wantedMaterial=null;
		switch(choice){
		case 1:
			wantedMaterial=Type.TABLET;break;
		case 2:
			wantedMaterial=Type.PHONE;break;
		case 3:
			wantedMaterial=Type.HEADPHONE;break;
		case 4:
			wantedMaterial=Type.CAMERA;break;
		case 0:
			break;
		}
		return wantedMaterial;
	}

	private Date getEndDate() {
		System.out.println("End of the Borrowing ?");
		return getValidDate();
	}

	private Date getBeginningDate() {
		System.out.println("Beginning of the borrowing ?");
		return getValidDate();

	}

}
