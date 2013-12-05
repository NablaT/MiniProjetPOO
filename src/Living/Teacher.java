package Living;

/**
 * Classe Teacher. Cette classe hérite de la classe Borrower. Les enseignants qui peuvent emprunter plusieurs matériels 
 * pour un cours donné. Ici le nombre d'emprunt est limité à 2 par enseignant. Les enseignants peuvent garder le matériel pour une durée longue si le matériel est disponible. 
 * Ils peuvent le réserver à l'avance pour la période de leur cours.
 */


public class Teacher extends Borrower {

	private static int numberOfTeachers;
	private static final int numberOfLoans=2;
	
	/**
	 * Constructeur de la classe Teacher. Ce constructeur prend en parametre un nom et fait appel au constructeur
	 * de la classe Borrower. Le nombre de Teacher est incrémenté de 1.
	 * @param nom
	 */
	public Teacher(String nom) {
		super.nom=nom;
		super.id='t'+this.numberOfTeachers+super.nom; 
		super.type="Teacher";
		this.numberOfTeachers++;
	}
	
	/**
	 * Methode getType. Cette methode retourne le "Student" ce qui correspond au type d'un Student. 
	 */
	@Override
	public String getType(){
		return super.type; 
	}
	
	/**
	 * Methode setType. Cette methode remplace le type du student par celui specifié en parametre. Cette methode
	 * a ete creee pour les tests JUnit. 
	 */
	@Override
	public void setType(String type){
		this.type=type;
	}
	/**
	 * Methode getNumberOfTeachers. Cette methode retourne le nombre de Teacher créés.
	 * @return
	 */
	
	public static int getNumberOfTeachers(){
		return numberOfTeachers;
	}
	
	/**
	 * Methode getNumberOfLoans. Cette methode retourne le nombre maximum d'emprunt qu'un Teacher peut faire.
	 * @return
	 */
	
	public static int getNumberOfLoans(){
		return numberOfLoans; 
	}
	
	/**
	 * Methode setNumberOfTeachers. Cette methode remplace le nombre de Teachers.
	 * @param numberOfTeachers
	 */
	public static void setNumberOfStudent(int numberOfTeachers) {
		Teacher.numberOfTeachers = numberOfTeachers;
	}

}
