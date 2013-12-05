package menu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Living.*;
import Material.*;
import Stock.*;

public class BorrowerMenu extends Menu {

	@Override
	public void handleChoice(int Choice) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	private Borrower currentUser=new Student("");
	
	public BorrowerMenu(){
		int choice;
		nbChoices=4;
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
		Material material=getWantedMaterial();
		Date beginning=getBeginningDate();
		Date end=getEndDate();
		String description = getDescription();
		Loan l=new Loan(beginning, end, currentUser, description,material);
		System.out.println("Le prêt de "+material+" pour " +currentUser+ " commence le "+beginning+ " et finit le "+end+"\n raison : "+description+"\n");
		return stock.makeALoan(l);
	}
	
	public Material getWantedMaterial() {
		return new Material (getWantedType(),getWantedOS());
	}

	private Type getWantedType() {
		System.out.println("Wich kind of material do you need ?\n	1-Tablet\n	2-Phone\n	3-Headphone\n	4-Camera");
		int choice=getValidChoice(4,false);
		Type wantedType = null;
		switch(choice){
		case 1:
			wantedType=Type.TABLET;break;
		case 2:
			wantedType=Type.PHONE;break;
		case 3:
			wantedType=Type.HEADPHONE;break;
		case 4:
			wantedType=Type.CAMERA;break;
		}
		return wantedType;
	}
	
	public OperatingSystem getWantedOS(){
		System.out.println("Wich Operating System do you need ?\n	1-Android\n	2-Windows\n	3-Ios\n");
		int choice=getValidChoice(3,false);
		OperatingSystem wantedOS = null;
		switch(choice){
		case 1:
			wantedOS=OperatingSystem.ANDROID;break;
		case 2:
			wantedOS=OperatingSystem.WINDOWS;break;
		case 3:
			wantedOS=OperatingSystem.IOS;break;
		}
		return wantedOS;
		
	}

	private String getDescription() {
		System.out.println("Why do you need it ?");
		return getString();
	}

	private Date getEndDate() {
		System.out.println("End of the Borrowing ?");
		return getValidDate();
	}

	private Date getBeginningDate() {
		System.out.println("Beginning of the borrowing ?");
		return getValidDate();

	}*/

}
