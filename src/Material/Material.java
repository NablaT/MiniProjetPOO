package Material;

/**
 * Classe Material. Cette classe abstraite est utilisé pour définir les matériels que l'on peut emprunter. Un materiel 
 * se caractérise par un nom.
 */

public abstract class Material {

	protected String type;
	protected String id;

	/**
	 * Methode getType. Cette methode permet de retourner le type du materiel.
	 * @return
	 */
	
	public String getType(){
		return this.type; 
	}
	
	/**
	 * Methode getId. Cette methode retourne l'identifiant du materiel.
	 * @return
	 */
	
	public String getId(){
		return this.id;
	}
	
}
