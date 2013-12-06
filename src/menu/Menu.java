package menu;

import java.util.ArrayList;
import Date.Date;
import java.util.HashMap;
import java.util.Scanner;

import Living.*;
import Material.*;
import Stock.*;

/**
 * Classe abstraite, mère de tous les autres types de menus. Elle possède les
 * attributs et méthodes utilisées par les autres Menus.
 * 
 * @author tom
 * 
 * */
public abstract class Menu {
	protected int nbChoices;
	protected static StockManagement stock = new DemoStock().getMstock();

	/**
	 * Fonction demandant à l'utilisateur un choix compris entre: - O et nbChoix
	 * si zeroIsValid - 1 et nbChoix sinon
	 * 
	 * @param nbChoix
	 * @param zeroIsValid
	 * @return
	 */
	public int getValidChoice(int nbChoix, boolean zeroIsValid) {
		System.out.println("Enter your choice : ");
		int choice = getChoice();
		while ((choice < (zeroIsValid ? 0 : 1)) || (choice > nbChoix)) {
			System.out.println("Invalid choice, enter your choice : ");
			choice = getChoice();
		}
		return choice;
	}

	/**
	 * Fonction demandant à l'utilisateur d'entre une date sous le format
	 * "dd/MM/yyyy"
	 * 
	 * @return
	 */
	public Date getValidDate() {
		System.out.println("Enter a date ('dd/MM/yyyy') : ");
		Date date = getDate();
		while (date == null || !(date.isACorrectDate())) {
			System.out.println("Invalid format/Date, please retry : ");
			date = getDate();
		}
		return date;
	}

	/**
	 * Fonction renvoyant le premier int entré par l'utilisateur
	 * 
	 * @return
	 */
	public int getChoice() {
		Scanner sc = new Scanner(System.in);
		int choix;
		try {
			choix = sc.nextInt();
		} catch (Exception e) {
			choix = -1;
		}
		return choix;
	}

	/**
	 * Fonction renvoyant la première date entrès par l'utilisateur si elle peut
	 * être parsée, la date vide sinon.
	 * 
	 * @return
	 */
	public Date getDate() {
		Date date = new Date();
		try {
			date = date.parse(getString());
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * Fonction renvoyant le premier String renvoyé par l'utilisateur.
	 * 
	 * @return
	 */
	public String getString() {
		return new Scanner(System.in).nextLine();

	}

	public abstract void handleChoice(int Choice);

}
