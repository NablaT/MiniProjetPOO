package Living;

/**
 * Classe Teacher. Cette classe hérite de la classe Borrower. Les enseignants qui peuvent emprunter plusieurs matériels 
 * pour un cours donné. Les enseignants peuvent garder le matériel pour une durée longue si le matériel est disponible. 
 * Ils peuvent le réserver à l'avance pour la période de leur cours.
 */


public class Teacher extends Borrower {

	private static int numberOfTeachers;
	
	/**
	 * Constructeur de la classe Teacher. Ce constructeur prend en parametre un nom et fait appel au constructeur
	 * de la classe Borrower. Le nombre de Teacher est incrémenté de 1.
	 * @param nom
	 */
	public Teacher(String nom) {
		super(nom);
		this.numberOfTeachers++;
	}
	
	/**
	 * Methode getNumberOfTeachers. Cette methode retourne le nombre de Teacher créés.
	 * @return
	 */
	
	public static int getNumberOfTeachers(){
		return numberOfTeachers;
	}
	
	/**
	 * Methode setNumberOfTeachers. Cette methode remplace le nombre de Teachers.
	 * @param numberOfTeachers
	 */
	public static void setNumberOfStudent(int numberOfTeachers) {
		Teacher.numberOfTeachers = numberOfTeachers;
	}

}
