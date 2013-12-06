package Material;

/**
 * Classe abstraire ComputerDevice, Classe mère des Material possédant un OS.
 * 
 * 
 */
public abstract class ComputerDevice extends Material {

	protected OperatingSystem typeOS;

	/**
	 * Methode getTypeOS. Cette methode retourne le type d'OS du matériel.
	 * 
	 * @return
	 */

	public OperatingSystem getTypeOS() {
		return this.typeOS;
	}

	/**
	 * Methode setTypeOS. Cette methode permet de remplacer le type d'OS du
	 * matériel.
	 * 
	 * @param typeOS
	 */

	public void setTypeOS(OperatingSystem typeOS) {
		this.typeOS = typeOS;
	}

	/**
	 * Methode equals. Cette methode compare deux ComputerDevice et renvoie true
	 * si ils sont identiques. Sinon false.
	 * 
	 * @param cd
	 * @return
	 */

	public boolean equals(ComputerDevice cd) {
		return (this.type.equals(cd.getType()) && this.typeOS.equals(cd
				.getTypeOS()));
	}
}
