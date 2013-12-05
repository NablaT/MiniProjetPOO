package Stock;

import java.util.Calendar;
import java.util.Date;
import Living.Borrower;
import Material.Material;
import Material.Tablet;
import Material.Type;

/**
 * Classe Loan. Un loan se caracterise par une date d'emprunt, une date de retour, l'emprunteur, le materiel emprunté et la description de l'emprunt. 
 * Cette classe permet de garder une trace des emprunts et de pouvoir les controler. En effet grâce à la date de
 * retour, on pourra savoir si un emprunteur est en retard ou non.
 */

public class Loan {

	private Calendar dateLoan;
	private Calendar dateBack;
	private Borrower borrower; 
	private Material material;
	private String description;
	
	/**
	 * Constructeur classe Loan. Ce constructeur permet de créer un Loan à partir de deux dates (date d'emprunt et date 
	 * de retour) et de l'emprunteur. 
	 * @param dateLoan
	 * @param dateBack
	 * @param borrower
	 * @param description
	 * @param material
	 */
	public Loan(Calendar dateLoan, Calendar dateBack, Borrower borrower, String description, Material material){
		this.dateLoan=dateLoan;
		this.dateBack=dateBack;
		this.borrower=borrower;
		this.description=description;
		this.material=material;
	}
	
	/**
	 * Methode getDateLoan. Cette methode retourne la date à laquelle l'emprunt a été fait.
	 * @return
	 */
	public Calendar getDateLoan(){
		return this.dateLoan;
	}
	
	/**
	 * Methode getDateBack. Cette methode retourne la date à laquelle l'emprunt se termine. 
	 * @return
	 */
	
	public Calendar getDateBack(){
		return this.dateBack;
	}
	
	/**
	 * Methode getBorrower. Cette methode retourne l'emprunteur.
	 * @return
	 */
	
	public Borrower getBorrower(){
		return this.borrower;
	}
	
	/**
	 * Methode getMaterial. Cette methode retourne le materiel emprunté. 
	 * @return
	 */
	
	public Material getMaterial(){
		return this.material;
	}
	
	/**
	 * Methode getDescription. Cette methode retourne la description de l'emprunt. 
	 * @return
	 */
	
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * Methode setDateLoan. Cette methode remplace la date à laquelle l'emprunt a été fait. 
	 * @param dateLoan
	 */
	
	public void setDateLoan(Calendar dateLoan){
		this.dateLoan=dateLoan;
	}
	
	/**
	 * Methode setDateBack. Cette methode remplace la date à laquelle le retour était fixé. 
	 * @param dateBack
	 */
	
	public void setDateBack(Calendar dateBack){
		this.dateBack=dateBack;
	}
	
	/**
	 * Methode setBorrower. Cette methode remplace l'emprunteur. 
	 * @param borrower
	 */
	
	public void setBorrower(Borrower borrower){
		this.borrower=borrower;
	}
	
	/**
	 * Methode setMaterial. Cette methode remplace le materiel emprunté. 
	 * @param material
	 */
	
	public void setMaterial(Material material){
		this.material=material;
	}
	
	/**
	 * Methode setDescription. Cette methode remplace la description de l'emprunt. 
	 * @param desc
	 */
	
	public void setDescription(String desc){
		this.description=desc;
	}
}
