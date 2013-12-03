package Material;

public enum OperatingSystem {
	ANDROID("Android"),
	IOS("Ios"),
	WINDOWS("Windows");
	
	
	String name;
	
	/**
	 * Constructeur de OperatingSystem.
	 * 
	 * @param name Nom de l'OS, tel que l'on veut qu'il soit afficher.
	 */
	OperatingSystem(String name){
		this.name=name;
	}
	
	
	/**
	 *  
	 * @return le nom de l'OS
	 */
	@Override
	public String toString(){
		return this.name;
	}
}
