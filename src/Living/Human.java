package Living;

/**
 * Classe Human. Cette classe permet de définir un être humain. Un être humain se caractérise par un nom.
 */

public abstract class Human {

	protected String nom;
	protected String id;
	//private static int numberOfHuman;
	protected String type;
	
	/**
	 * Constructeur de la classe Human. Il permet de créer un humain à partir d'un nom specifié en parametre. 
	 * @param nom
	 */
	
	/*
	public Human(String nom){
		this.nom=nom; 
		this.id=this.numberOfHuman+nom;
		//this.numberOfHuman++;
	}
	*/
	
	/**
	 * Methode getType. Cette methode retourne le type de l'humain.
	 * @return
	 */
	
	public String getType(){
		return this.type; 
	}
	
	/**
	 * Methode getNom. Cette methode retourne le nom de l'humain.
	 * @return
	 */
	public String getNom(){
		return this.nom; 
	}
	
	/**
	 * Methode getId. Cette methode retourne le nom de l'humain.
	 * @return
	 */
	
	public String getId(){
		return this.id;
	}
	
	/**
	 * Methode getNumberOfHuman. Cette methode retourne le nombre d'humains.
	 * @return
	 */
	/*
	public int getNumberOfHuman(){
		return this.numberOfHuman;
	}*/
	
	/**
	 * Methode setNom. Cette methode permet de remplacer le nom de l'humain par celui specifié en parametre. 
	 * @param nom
	 */
	
	public void setNom(String nom){
		this.nom=nom; 
	}
	
	/**
	 * Methode setId. Cette methode remplace l'identifiant de l'humain par celui specifié en paraemetre. 
	 * @param id
	 */
	public void setId(String id){
		this.id=id;
	}
	
	/**
	 * Methode setType. Cette methode remplace le type de l'humain par celui specifié en parametre. 
	 * @param type
	 */
	
	public void setType(String type){
		this.type=type;
	}
	
	/**
	 * Methode setNumberOfHuman. Cette methode remplace le nombre de Human.
	 * @param numberOfHuman
	 */
	
	/*
	public static void setNumberOfStudent(int numberOfHuman) {
		Human.numberOfHuman = numberOfHuman;
	}*/
	
	/**
	 * Methode equals. Cette methode compare deux Humain entre eux. Elle retourne true si ils sont identiques, 
	 * false sinon.
	 * @param borrower
	 * @return
	 */
	
	public boolean equals(Human human){
		return (this.id.equals(human.getId()));
	}
}