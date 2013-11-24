package Living;

public class Student extends Borrower {
	
	private static int numberOfStudent;
	
	/**
	 * Constructeur de la classe Student. Ce constructeur prend en parametre un nom et fait appel au constructeur
	 * de la classe Borrower. Le nombre de Student est incrémenté de 1.
	 * @param nom
	 */
	public Student(String nom) {
		super.nom=nom;
		super.type="Student";
		super.id='s'+this.numberOfStudent+super.nom;
		this.numberOfStudent++;
	}
	
	/**
	 * Methode getNumberOfStudent. Cette methode retourne le nombre de Student.
	 * @return
	 */

	public static int getNumberOfStudent() {
		return numberOfStudent;
	}

	/**
	 * Methode setNumberOfStudent. Cette methode remplace le nombre de Student.
	 * @param numberOfStudent
	 */
	public static void setNumberOfStudent(int numberOfStudent) {
		Student.numberOfStudent = numberOfStudent;
	}

}
