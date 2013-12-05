package Stock;

import java.util.ArrayList;
import java.util.HashMap;

import Living.Borrower;
import Material.Headphone;
import Material.Material;
import Material.Tablet;

/**
 * Classe Stock. Un Stock possede une liste des matériels présents dans le
 * stock. L'hashmap est construise de la façon suivante: <0, Liste de Camera>
 * <1, Liste de HeadPhone> <2, Liste de Phone> <3, Liste de Tablet> Pour tout
 * nouveau matériel créé, il sera ajouté à la suite de l'hasmap.
 */

public class Stock {

	private HashMap<Integer, ArrayList<Material>> stock;

	/**
	 * Constructeur de la classe Stock.
	 * 
	 * @param stock
	 */

	public Stock(HashMap<Integer, ArrayList<Material>> stock) {
		this.stock = stock;
	}

	/**
	 * Methode getStock. Cette methode renvoie l'hashmap correspondant à la
	 * liste des matériels.
	 * 
	 * @return
	 */

	public HashMap<Integer, ArrayList<Material>> getStock() {
		return this.stock;
	}
	

	/**
	 * Methode setStock. Cette methode remplace l'hasmap correspondant à la
	 * liste des matériels.
	 * 
	 * @param stock
	 */

	public void setStock(HashMap<Integer, ArrayList<Material>> stock) {
		this.stock = stock;
	}

	/**
	 * Methode materialIsFree. Cette methode vérifie si le matériel spécifié en
	 * parametre est libre. Elle effectue cette vérification en regardant dans
	 * le stock. Si le materiel y est, elle retourne true, sinon false.
	 * 
	 * @param m
	 * @return
	 */

	public boolean isInStock(Material m) {
		switch (m.getType()) {
		case "Camera":
			if (this.stock.get(0) != null) {
				return search(this.stock.get(0), m);
			}
			break;
		case "HeadPhone":

			if (this.stock.get(1) != null) {
				return search(this.stock.get(1), m);
			}
			break;
		case "Phone":
			if (this.stock.get(2) != null) {
				return search(this.stock.get(2), m);
			}
			break;

		case "Tablet":
			if (this.stock.get(3) != null) {
				return search(this.stock.get(3), m);
			}
			break;
		}
		return false;
	}

	/**
	 * Methode search. Cette methode prend en parametre un materiel et une
	 * liste. Elle regarde si le matériel se trouve dans la liste. Si il y est,
	 * elle retourne true, sinon false. Deux materiels sont identiques si leur
	 * type et leur type d'OS sont identiques.
	 * 
	 * @param list
	 * @param m
	 * @return
	 */

	public boolean search(ArrayList<Material> list, Material m) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(m)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode removeMaterial. Cette methode permet de supprimer un materiel
	 * dans le stock. Elle appelle la methode remove
	 * 
	 * @param material
	 * @return
	 */

	public boolean removeMaterial(Material material) {
		switch (material.getType()) {
		case "Camera":
			if (this.stock.get(0) != null) {
				return remove(this.stock.get(0), material);
			}
			break;
		case "HeadPhone":
			if (this.stock.get(1) != null) {
				return remove(this.stock.get(1), material);
			}
			break;
		case "Phone":
			if (this.stock.get(2) != null) {
				return remove(this.stock.get(2), material);
			}
			break;
		case "Tablet":
			if (this.stock.get(3) != null) {
				return remove(this.stock.get(3), material);
			}
			break;
		}
		return false;
	}

	/**
	 * Methode remove. Cette methode regarde si le materiel est présent dans la
	 * liste specifiee en parametre et le supprime.
	 * 
	 * @param list
	 * @param material
	 * @return
	 */

	private boolean remove(ArrayList<Material> list, Material material) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(material)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	public void initialize() {
		HashMap<Integer, ArrayList<Material>> materialInStock = new HashMap<Integer, ArrayList<Material>>();

		Tablet t1 = new Tablet();
		Tablet t2 = new Tablet();
		ArrayList<Material> lt = new ArrayList<Material>();
		lt.add(t1);
		lt.add(t2);
		Headphone h1 = new Headphone();
		ArrayList<Material> lh = new ArrayList<Material>();
		lh.add(h1);
		materialInStock.put(1, lh);
		materialInStock.put(3, lt);

		this.stock = materialInStock;

	}

}
