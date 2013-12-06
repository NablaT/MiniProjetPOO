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
	 * 
	 * @return
	 */

	public ArrayList<Loan> getLoans() {
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
		this.loans = new ArrayList<Loan>();
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
			// this.stock.removeMaterial(loan.getMaterial());
			return true;
		}
		return false;
	}

	/**
	 * Methode getLoan. Cette methode renvoie le Loan correspondant à
	 * l'identifiant du Material specfié en parametre.
	 * 
	 * @param id
	 * @return
	 */

	public Loan getLoan(String id, Borrower borrower) {
		for (int i = 0; i < this.loans.size(); i++) {
			if (this.loans.get(i).getMaterial().getId().equals(id)
					&& this.loans.get(i).getBorrower().equals(borrower)) {
				return this.loans.get(i);
			}
		}
		return null;
	}

	/**
	 * Methode returnLoan. Cette methode permet de rendre un Loan. Si le Loan
	 * n'existe pas, elle retourne false. Sinon elle remet le materiel dans le
	 * stock, enlève le loan de la liste des loans et retourne true,
	 * 
	 * @param id
	 * @param borrower
	 * @return
	 */

	public boolean returnLoan(String id, Borrower borrower) {
		if (getLoan(id, borrower) != null) {
			Loan loan = getLoan(id, borrower);
			this.stock.addMaterial(loan.getMaterial());
			this.loans.remove(indexOfLoan(loan));
			return true;
		}
		return false;
	}

	/**
	 * Methode indexOfLoan. Cette methode retourne l'indice auquel c
	 * 
	 * @param loan
	 * @return
	 */

	public int indexOfLoan(Loan loan) {
		int index = 0;
		for (int i = 0; i < this.loans.size(); i++) {
			if (this.loans.get(index).equals(loan))
				break;
			index++;
		}
		return index;
	}

	/**
	 * Methode saveBadLoan. Cette methode permet de sauvegarder tous les loans
	 * qui ne peuvent pas être emprunter.
	 * 
	 * @param loan
	 * @return
	 */

	public ArrayList<Loan> saveBadsLoan(Loan loan) {
		ArrayList<Loan> loansNotLoanable = new ArrayList<Loan>();
		for (int i = 0; i < this.loans.size(); i++) {
			if (loan.getMaterial().equals(this.loans.get(i).getMaterial())
					&& (!(this.loans.get(i).getDateBack().before(loan
							.getDateLoan())) || (loan.getDateLoan().before(
							this.loans.get(i).getDateLoan()) && loan
							.getDateBack().before(
									this.loans.get(i).getDateLoan())))) {
				loansNotLoanable.add(this.loans.get(i));
			}
		}
		return loansNotLoanable;
	}

	public ArrayList<Loan> saveBadLoan(Loan loan) {
		ArrayList<Loan> loansNotLoanable = new ArrayList<Loan>();
		for (int i = 0; i < this.loans.size(); i++) {
			/*
			 * Si le material est le meme que le materiel du loan
			 */
			if (loan.getMaterial().equals(this.loans.get(i).getMaterial())) {
				/*
				 * Si la date de debut de loan (celui en parametre de la
				 * methode) est compris entre la date de debut et la date de fin
				 * du parametre courant
				 */
				if (this.loans.get(i).getDateBack().before(loan.getDateLoan())
						&& loan.getDateLoan().before(
								this.loans.get(i).getDateLoan())) {
					loansNotLoanable.add(this.loans.get(i));
				}
				/*
				 * Si la date de fin du loan (celui en parametre de la methode)
				 * est compris entre la date de debut et la date de fin du
				 * parametre courant.
				 */
				else if ((this.loans.get(i).getDateLoan()
						.before(loan.getDateBack()) && loan.getDateBack()
						.before(this.loans.get(i).getDateBack()))) {
					loansNotLoanable.add(this.loans.get(i));
				} 
			}
		}
		return loansNotLoanable;
	}

	/**
	 * Methode material isAvalaible. Cette methode vérifie si le Loan courant
	 * n'appartient pas à la liste save de Loan.
	 * 
	 * @param save
	 * @param current
	 * @return
	 */
	public boolean materialIsAvalaible(ArrayList<Loan> save, Loan current) {
		for (int i = 0; i < save.size(); i++) {
			if (save.get(i).equals(current)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Methode giveMeAvalaibleLoan. Cette methode renvoie le premier Loan qui
	 * est disponible. Elle appelle la methode materialIsAvalaible. On verifie
	 * pour chaque element de la liste de loan si il fait parti de la liste des
	 * elements que l'on ne peut pas emprunter. Si ce n'est pas le cas, alors on
	 * renvoie le Loan.
	 * 
	 * @param save
	 * @return
	 */

	public Loan giveMeAvailableLoan(ArrayList<Loan> save) {
		if (save.size() <= this.loans.size()) {
			for (int i = 0; i < loans.size(); i++) {
				if (materialIsAvalaible(save, this.loans.get(i))) {
					return this.loans.get(i);
				}
			}
		}
		return null;
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
	 * Methode askForAStudent. Cette methode verifie si le student en question
	 * est autorisé a faire un emprunt. Si il a déjà fait un emprunt, sa demande
	 * sera refusée. La methode retourne true si il peut emprunter, false sinon.
	 * 
	 * @param student
	 * @return
	 */

	public boolean askForAStudent(Borrower student) {
		for (int i = 0; i < this.loans.size(); i++) {
			if (this.loans.get(i).getBorrower().equals(student)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Methode AskForATeacher. Cette methode verifie si le teacher en question
	 * est autorisé à faire un emprunt. Un teacher peut faire plusieurs emprunts
	 * mais il est limité par un nombre max d'emprunt.
	 * 
	 * @param teacher
	 * @return
	 */

	public boolean askForATeacher(Borrower teacher) {
		int cptNbrOfLoans = 0;
		for (int i = 0; i < this.loans.size(); i++) {
			if (this.loans.get(i).getBorrower().equals(teacher)) {
				if (cptNbrOfLoans < Teacher.getNumberOfLoans()) {
					cptNbrOfLoans++;
					if (cptNbrOfLoans == Teacher.getNumberOfLoans()) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
