package Stock;

import java.util.ArrayList;

public class StockManagement {


	private ArrayList<Loan> loans;
	
	/**
	 * Constructeur de la classe Stock.
	 * 
	 * @param stock
	 * @param loans
	 */
	public StockManagement(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	/**
	 * Methode getBorrowers. Cette methode renvie la liste des emprunts.
	 * 
	 * @return
	 */

	public ArrayList<Loan> getBorrowers() {
		return this.loans;
	}
	/**
	 * Methode setLoans. Cette methode remplace la liste des emprunts.
	 * 
	 * @param loans
	 */

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	
}
