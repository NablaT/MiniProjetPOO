package Living;

/**
 * Classe Manager. Cette classe hérite de la classe Human.
 *
 */

public class Manager extends Human {

	private static int numberOfManagers; 
	
	/**
	 * Constructeur de la classe Borrower. Ce constructeur prend en parametre un nom et fait appel au constructeur
	 * de la classe Human.
	 * @param nom
	 */
	
	public Manager(String nom) {
		super.nom=nom;
		super.type="Manager";
		super.id='m'+this.numberOfManagers+super.nom; 
		this.numberOfManagers++;
	}
	
	/**
	 * Methode getNumberOfManagers. Cette methode retourn le nombre de managers créés.
	 * @return
	 */
	public static int getNumberOfManagers(){
		return numberOfManagers;
	}
	
	/**
	 * Methode setNumberOfManagers. Cette methode remplace le nombre de Managers.
	 * @param numberOfManager
	 */
	public static void setNumberOfStudent(int numberOfManager) {
		Manager.numberOfManagers = numberOfManager;
	}
	
}
