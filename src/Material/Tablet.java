package Material;

/**
 * Classe Tablet. Cette classe hérite de la classe Material. Une Tablet se définit par son identifiant, son nom 
 * ainsi que le nombre de tablette existant. 
 * 
 */

public class Tablet extends ComputerDevice{
	
	private static int numberOfTablet;
	
	/**
	 * Constructeur par default classe Tablet.
	 */
	
	public Tablet(){
		type=Type.TABLET;
		super.typeOS=OperatingSystem.ANDROID;
		super.id="TAB"+String.valueOf(numberOfTablet);
		numberOfTablet++;
	}
	
	/**
	 * Constructeur de la classe Tablet. Ce constructeur prend en parametre un OperatingSysteme. 
	 * @param op
	 */
	
	public Tablet(OperatingSystem op){
		this.type=Type.TABLET;
		super.typeOS=op;
		numberOfTablet++;
	}
	/**
	 * Accesseur getNumberOfTablet. Cette methode retourne le nombre total de Tablet existant. 
	 * @return
	 */
	
	public static int getNumberOfTablet(){
		return numberOfTablet;
	}
	
	/**
	 * Methode setNumberOfTablet. Cette methode remplace le nombre total de Tablet existant par l'entier specifié en 
	 * parametre. 
	 * @param number
	 */
	public static void setNumberOfTablet(int number){
		numberOfTablet=number; 
	}
	
}
