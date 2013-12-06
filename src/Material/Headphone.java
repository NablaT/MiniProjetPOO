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
	
	private static int numberOfHeadphones=0;
	
	/**
	 * Constructeur de Headphone.
	 * 
	 */
	public Headphone(){
		type=Type.HEADPHONE;
		id="HPH"+numberOfHeadphones;
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
	
	public boolean equals(Headphone hp){
		return (this.type.equals(hp));
	}
}