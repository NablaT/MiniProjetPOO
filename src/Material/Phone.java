package Material;

/**
 * Classe de définition de Phone. Phone hérite de Material.
 * 
 * @author Tom Veniat
 *
 */
public class Phone extends ComputerDevice {
	
	/**
	 * Variable de classe, correspondant au nombre de téléphones existants.
	 * 
	 */
	private static int numberOfPhones;
	
	/**
	 * Constructeur de Phone.
	 * 
	 */
	public Phone(){
		type=Type.PHONE;
		//id="PHO"+String.valueOf(numberOfPhones);
		numberOfPhones++;
	}
	
	/**
	 * Getteur de numberOfPhones.
	 * 
	 * @return le nombre de Phone créés.
	 */
	public static int getNumberOfPhones(){
		return numberOfPhones;
	}
	
	/**
	 * Setteur de numberOfPhones.
	 * 
	 * @param number le nombre que l'on veut assigner à numberOfPhone.
	 */
	public static void setNumberOfPhone(int number){
		numberOfPhones=number;
	}
	
	
}
