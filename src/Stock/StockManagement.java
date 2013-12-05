package Stock;

import java.util.ArrayList;
import Living.Borrower;
import Living.Teacher;
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
	 * Methode getStock. Cette methode retourne le stock.
	 * 
	 * @return
	 */

	public Stock getStock() {
		return this.stock;
	}
	
	/**
	 * Methode getLoans. Cette methode retourne la liste des loans. 
	 * @return
	 */
	
	public ArrayList<Loan> getLoans(){
		return this.loans; 
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
		this.stock.initialize();
		this.loans=new ArrayList<Loan>();
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
		if (this.stock.isInStock(loan.getMaterial())
				&& askForALoan(loan.getBorrower())) {
			this.loans.add(loan);
			this.stock.removeMaterial(loan.getMaterial());
			return true;
		}
		return false;
	}
	
	/*
	public Loan getLoan(Borrower b){
		return new Loan();
	}
	*/
	
	public boolean returnLoan(Loan loan){
		return true; 
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
	
	/**
	 * Methode askForAStudent. Cette methode verifie si le student en question est autorisé a faire un emprunt. Si 
	 * il a déjà fait un emprunt, sa demande sera refusée. La methode retourne true si il peut emprunter, false sinon.
	 * @param student
	 * @return
	 */

	public boolean askForAStudent(Borrower student) {
		for (int i = 0; i < this.loans.size(); i++) {
			if(this.loans.get(i).getBorrower().equals(student)){
				return false;
			}
		}
		return true;
	}

	/**
	 * Methode AskForATeacher. Cette methode verifie si le teacher en question est autorisé à faire un emprunt. Un 
	 * teacher peut faire plusieurs emprunts mais il est limité par un nombre max d'emprunt. 
	 * @param teacher
	 * @return
	 */
	
	public boolean askForATeacher(Borrower teacher) {
		int cptNbrOfLoans=0;
		for (int i = 0; i < this.loans.size(); i++) {
			if(this.loans.get(i).getBorrower().equals(teacher)){
				if(cptNbrOfLoans < Teacher.getNumberOfLoans()){
					cptNbrOfLoans++; 
					if(cptNbrOfLoans==Teacher.getNumberOfLoans()){
						return false; 
					}
				}

			}
		}
		System.out.println();
		return true;
	}
	
	
}
