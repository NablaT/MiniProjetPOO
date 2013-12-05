package menu;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import Date.Date;
import Living.*;
import Material.*;
import Stock.*;

/**
 * Menu utilisé lorsqu'un Borrower veut utiliser l'application, 
 * il lui permet de réserver un objet, 
 * de rendre un objet ou encore de consulter ses informations.
 * @author tom
 *
 */

public class BorrowerMenu extends Menu {
	

	private Borrower currentUser=new Student("");
	
	
	/**
	 * Un nouveau BorrowerMenu affiche les possibilités et prend le choix de l'utilisateur,
	 * il traite ensuite ce choix, et redemande à l'utilisateur ce qu'il souhaite faire.
	 */
	public BorrowerMenu(){
		int choice;
		nbChoices=4;
		do{
			displayBorrowerMenu();
			choice = getValidChoice(this.nbChoices,true);
			handleChoice(choice);
		}while(choice!=0);
	}
	
	/**
	 * Méthode affichant le premier menu d'un Borrower.
	 */
	public void displayBorrowerMenu() {
		System.out.println("What do you want to do ?\n 	1-Borrow an object\n	2-return an object\n	3-See your informations\n	0-Quit");
	}

	
	/**
	 * Méthode gérant le choix entré par l'utilisateur, elle fait appelle aux fonctions correspondante, et affiche le résultat de l'opération.
	 */
	@Override
	public void handleChoice(int choice) {
		switch(choice){
		case 1 :
			if (createBorrowing())System.out.println("Request sent");
			else System.out.println("You can't borrow that !") ;break;
		case 2 :
			if (getBackObject()) System.out.println("return done !");
			else System.out.println("you can't do it");break;
		case 3 :
			System.out.println("Unavailble functionality");break;
		case 0 : break;
	}
		
	}

	private boolean getBackObject() {
		String idMaterial=getString();
				
		return false;
	}
	
	/**
	 * Fonction qui crée un nouveau Loan, à partir de données entrées par l'utilisateur,
	 * Renvoie true si le Loan à bien été créé, false sinon.
	 * @return
	 */
	public boolean createBorrowing() {
		Material material=getWantedMaterial();
		Date beginning,end;
		do{
			beginning=getBeginningDate();
			end=getEndDate();
		}while (!isWellOrdered(beginning, end));
		
		String description = getDescription();
		Loan l=new Loan(beginning, end, currentUser, description,material);
		return stock.makeALoan(l);
	}
	
	/**
	 * Fonction qui vérifie que la date de début d'emprunt est bien située avant la date de fin.
	 * 
	 * @param beginning
	 * @param end
	 * @return
	 */
	private boolean isWellOrdered(Date beginning, Date end) {
		boolean isOrdered=beginning.before(end);
		if (!isOrdered)
			System.out.println("The loan must begin BEFORE the end");
		return isOrdered;
	}

	/**
	 * Fonction renvoyant un material correspondant à ce que l'utilisateur souhaite.
	 * 
	 * @return
	 */
	public Material getWantedMaterial() {
		
		switch (getWantedType()){
		case HEADPHONE:
			return new Headphone();
		case CAMERA:
			return new Camera();
		case PHONE:
			return new Phone(getWantedOS());
		case TABLET:
			return new Tablet(getWantedOS());
		default: return null;
		}
	}

	/**
	 * getWantedType demande à l'utilisateur le Type de Material qu'il veut,
	 * et renvoie le Type en question. 
	 * 
	 * @return
	 */	
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
	
	
	/**
	 * getWantedOS demande à l'utilisateur l'OS qu'il veut pour son ComputerDevice,
	 * et renvoie l'OperatingSystem en question. 
	 * 
	 * @return
	 */
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

	/**
	 * Fonction qui demande la raison de cet emprunt, et renvoie le String entré par l'utilisateur.
	 * 
	 * @return
	 */
	
	private String getDescription() {
		System.out.println("Why do you need it ?");
		return getString();
	}

	
	/**
	 * getEndDate ask for a Date end verify that the user input is a correct Date.
	 * 
	 * @return
	 */
	private Date getEndDate() {
		System.out.println("End of the Borrowing ?");
		return getValidDate();
	}

	
	/**
	 * getBeginningDate ask for a Date end verify that the user input is a correct Date.
	 * 
	 * @return
	 */
	private Date getBeginningDate() {
		System.out.println("Beginning of the borrowing ?");
		return getValidDate();

	}

}
