package Living;

/**
 * Classe Borrower. Cette classe hérite de la classe Human. 
 *
 */

public abstract class Borrower extends Human {

	//private static int numberOfBorrower;
	protected String type;
	
	/**
	 * Constructeur de la classe Borrower. Ce constructeur prend en parametre un nom (String) et fait appel au constructeur
	 * de la classe Human.
	 * @param nom
	 *//*
	
	public Borrower(String nom) {
		super(nom);
		numberOfBorrower++;
	}
	
	/**
	 * Methode getNumberOfBorrowers. Cette methode retourne le nombre de Borrower créés. 
	 * @return
	 */
	/*
	public int getNumberOfBorrowers(){
		return this.numberOfBorrower;
	}
	
	/**
	 * Methode setNumberOfBorrowers. Cette methode remplace le nombre de Borrowers.
	 * @param numberOfBorrowers
	 */
	/*
	public static void setNumberOfBorrowers(int numberOfBorrowers){
		Borrower.numberOfBorrower = numberOfBorrowers;
	}*/
	
	/**
	 * Methode equals. Cette methode compare deux Borrowers entre eux. Elle retourne true si ils sont identiques, 
	 * false sinon.
	 * @param borrower
	 * @return
	 */
	
	public boolean equals(Borrower borrower){
		return (super.id.equals(borrower.getId()));
	}

}
