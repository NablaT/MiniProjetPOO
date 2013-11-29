package Material;
/**
 * Classe de définition de Headphone. Headphone hérite de Material.
 * 
 * @author Tom Veniat
 *
 */
public class Headphone extends Material {
	
	/**
	 * Variable de classe, correspondant au nombre de casques existants.
	 * 
	 */
	
	private static int numberOfHeadphones;
	
	/**
	 * Constructeur de Headphone.
	 * 
	 */
	public Headphone(){
		super.type=Type.HEADPHONE;
		//id="HPH"+String.valueOf(numberOfHeadphones);
		numberOfHeadphones++;
	}
	
	/**
	 * Getteur de numberOfHeadphones.
	 * 
	 * @return le nombre de Headphone créés.
	 */
	public static int getNumberOfHeadhones(){
		return numberOfHeadphones;
	}
	
	/**
	 * Setteur de numberOfHeadphones.
	 * 
	 * @param number le nombre que l'on veut assigner à numberOfHeadphone.
	 */
	public static void setNumberOfHeadphone(int number){
		numberOfHeadphones=number;
	}
}