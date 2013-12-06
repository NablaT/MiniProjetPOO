package Living;

import java.util.ArrayList;

/**
 * Classe Borrower. Cette classe hérite de la classe Human.
 * 
 */

public abstract class Borrower extends Human {

	private static int numberOfBorrower=0;
	private static ArrayList<Borrower> borrowersList= new ArrayList<Borrower>();

	/**
	 * Constructeur de la classe Borrower. Ce constructeur prend en parametre un
	 * nom (String) et fait appel au constructeur de la classe Human.
	 * 
	 * @param nom
	 */

	public Borrower(String nom) {
		super(nom);
		numberOfBorrower++;
		borrowersList.add(this);
	}
	

	/**
	 * Methode getNumberOfBorrowers. Cette methode retourne le nombre de
	 * Borrower créés.
	 * 
	 * @return
	 */

	public static int getNumberOfBorrowers() {
		return numberOfBorrower;
	}
	
	
	public static ArrayList<Borrower> getBorrowersList(){
		return borrowersList;
		
	}
	
	public static Borrower getBorrower(String id){
		Borrower borrower=null;
		for (Borrower b : borrowersList){
			if (b.getId().equals(id))
				borrower = b;
		}
		return borrower;
	}

	/**
	 * Methode equals. Cette methode compare deux Borrowers entre eux. Elle
	 * retourne true si ils sont identiques, false sinon.
	 * 
	 * @param borrower
	 * 
	 * @return
	 */

	public boolean equals(Borrower borrower) {
		return (this.id.equals(borrower.getId()));
	}
	
	public static void initialize(){
		Borrower.borrowersList.add(new Student("el1"));
		Borrower.borrowersList.add(new Student("el2"));
		Borrower.borrowersList.add(new Teacher("prof1"));
	}

}
