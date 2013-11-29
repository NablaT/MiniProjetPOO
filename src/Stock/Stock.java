package Stock;

import java.util.ArrayList;
import java.util.HashMap;

import Living.Borrower;
import Material.Material;

/**
 * Classe Stock. Un Stock possede une liste des matériels présents dans le stock.
 * L'hashmap est construise de la façon suivante:
 * <1, Liste de Camera>
 * <2, Liste de HeadPhone>
 * <3, Liste de Phone>
 * <4, Liste de Tablet>
 * Pour tout nouveau matériel créé, il sera ajouté à la suite de l'hasmap.
 */

public class Stock {

	private HashMap<Integer, ArrayList<Material>> stock;

	/**
	 * Constructeur de la classe Stock.
	 * 
	 * @param stock
	 */
	
	public Stock(HashMap<Integer, ArrayList<Material>>  stock, ArrayList<Loan> loans) {
		this.stock = stock;
	}

	/**
	 * Methode getStock. Cette methode renvoie l'hashmap correspondant à la
	 * liste des matériels.
	 * @return
	 */
	
	public HashMap<Integer, ArrayList<Material>> getStock() {
		return this.stock;
	}

	/**
	 * Methode setStock. Cette methode remplace l'hasmap correspondant à la
	 * liste des matériels. 
	 * @param stock
	 */

	public void setStock(HashMap<Integer, ArrayList<Material>> stock) {
		this.stock = stock;
	}
	
    
	public boolean isInStock(Material material) {
		switch(material.getType()){
		case "Tablet": 
	
		}
		return false;
	}
	

	public void removeMaterial(Material material){
		if(isInStock(material)){
			
		}
	}
	
}
