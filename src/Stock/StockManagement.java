package Stock;

import java.util.ArrayList;

import Living.Borrower;
import Material.Material;

public class StockManagement {

	private Stock stock;
	private ArrayList<Loan> loans;

	/**
	 * Constructeur de la classe Stock.
	 * 
	 * @param stock
	 * @param loans
	 */

	public StockManagement(ArrayList<Loan> loans, Stock stock) {
		this.loans = loans;
		this.stock = stock;
	}

	/**
	 * Methode getBorrowers. Cette methode renvoie la liste des emprunts.
	 * 
	 * @return
	 */

	public ArrayList<Loan> getBorrowers() {
		return this.loans;
	}

	/**
	 * Methode getStock. Cette methode retourne le stock.
	 * 
	 * @return
	 */

	public Stock getStock() {
		return this.stock;
	}

	/**
	 * Methode setStock. Cette methode remplace le stock.
	 * 
	 * @param stock
	 */

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Methode setLoans. Cette methode remplace la liste des emprunts.
	 * 
	 * @param loans
	 */

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	/**
	 * Cette methode initialise le stock.
	 */

	public void initialize() {

	}

	/**
	 * Methode makeALoan. Cette methode permet de creer un emprunt. Elle verifie
	 * dans un premier que l'emprunt est possible. Pour cela il faut que le
	 * materiel soit dans le stock et que l'emprunteur peut emprunter. Une fois
	 * la vérification faite, on enleve le materiel du stock et on rajoute un
	 * nouvel emprunt.
	 * 
	 * @param loan
	 * @return
	 */

	public boolean makeALoan(Loan loan) {
		if (materialIsFree(loan.getMaterial())
				&& askForALoan(loan.getBorrower())) {
			this.loans.add(loan);
			this.stock.removeMaterial(loan.getMaterial());
			return true;
		}
		return false;
	}

	/**
	 * Methode materialIsFree. Cette methode vérifie si le matériel spécifié en
	 * parametre est libre. Elle effectue cette vérification en regardant dans
	 * le stock. Si le materiel y est, elle retourne true, sinon false.
	 * 
	 * @param m
	 * @return
	 */

	public boolean materialIsFree(Material m) {
		switch (m.getType()) {
		case "Camera":
			return search(this.stock.getStock().get(0), m);
		case "Headphone":
			return search(this.stock.getStock().get(1), m);
		case "Phone":
			return search(this.stock.getStock().get(2), m);
		case "Tablet":
			return search(this.stock.getStock().get(3), m);
		}
		return false;
	}

	/**
	 * Methode search. Cette methode prend en parametre un materiel et une
	 * liste. Elle regarde si le matériel se trouve dans la liste. Si il y est,
	 * elle retourne true, sinon false. Deux matériels sont identiques si ils
	 * ont
	 * 
	 * @param list
	 * @param m
	 * @return
	 */

	public boolean search(ArrayList<Material> list, Material m) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(m))
				return true;
		}
		return false;
	}

	/**
	 * Methode askForALoan. Cette methode
	 * 
	 * @param borrower
	 * @return
	 */

	public boolean askForALoan(Borrower borrower) {
		if (borrower.getType().equals("Student")) {
			return askForAStudent(borrower);
		} else if (borrower.getType().equals("Teacher")) {
			return askForATeacher(borrower);
		}

		return false;
	}

	public boolean askForAStudent(Borrower student) {
		for (int i = 0; i < this.loans.size(); i++) {
			if(this.loans.get(i).getBorrower().equals(student)){
				return false;
			}
		}
		return true;
	}

	public boolean askForATeacher(Borrower teacher) {
		for (int i = 0; i < this.loans.size(); i++) {
			
		}
		return true;
	}
}
