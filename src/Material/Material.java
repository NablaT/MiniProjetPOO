package Material;

/**
 * Classe Material. Cette classe abstraite est utilisé pour définir les matériels que l'on peut emprunter. Un materiel 
 * se caractérise par un nom.
 * 
 */

public abstract class Material {

	protected Type type;
	protected String id;
	
	/**
	 * Methode getType. Cette methode permet de retourner le type du materiel.
	 * @return
	 */
	
	public String getType(){
		return this.type.toString(); 
	}
	
	/**
	 * Methode getId. Cette methode retourne l'identifiant du materiel.
	 * @return
	 */
	
	public String getId(){
		return this.id;
	}

	
	
	/**
	 * Methode equals. Elle permet de comparer deux matériels entre eux. Deux matériels sont identiques si ils ont 
	 * le même type et le même type d'OS.
	 * @param m
	 * @return
	 */
	
	public boolean equals(Material m){
		return (this.type.equals(m.getType()));
	}
}
