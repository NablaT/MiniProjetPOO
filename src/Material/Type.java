package Material;

/**
 * Type est un type énuméré contenant les différents types de material existant.
 *
 * @author Tom Veniat.
 * 
 */

public enum Type {
	TABLET("Tablet"),
	PHONE("Phone"),
	HEADPHONE("HeadPhone"),
	CAMERA("Camera");
	
	
	String name;
	
	/**
	 * Constructeur de Type.
	 * 
	 * @param name Nom du Type, tel que l'on veut qu'il soit afficher.
	 */
	Type(String name){
		this.name=name;
	}
	
	
	/**
	 *  
	 * @return le nom du Type
	 */
	@Override
	public String toString(){
		return this.name;
	}
}
