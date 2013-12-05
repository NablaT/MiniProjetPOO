package Stock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Living.Borrower;
import Living.Teacher;
import Material.Camera;
import Material.Headphone;
import Material.Material;
import Material.Phone;
import Material.Tablet;

public class StockTest {

	private Stock stock;
	private HashMap<Integer, ArrayList<Material>> list;
	private ArrayList<Loan> loans;
	private ArrayList<Material> hp;
	private ArrayList<Material> tab;

	@Before
	public void setUp() throws Exception {
		this.list = new HashMap<Integer, ArrayList<Material>>();
		this.hp = new ArrayList<Material>();
		this.tab = new ArrayList<Material>();
		for (int i = 0; i < 2; i++) {
			this.hp.add(new Headphone());
			this.tab.add(new Tablet());
		}
		list.put(1,this.hp);
		list.put(3,this.tab);
		list.put(0,new ArrayList<Material>());
		list.put(2,new ArrayList<Material>());

		
		this.loans = new ArrayList<Loan>();
		for (int i = 0; i < 4; i++) {
			Calendar c= Calendar.getInstance();
			c.set(2013, 02, 32, 15,13+i);

			Calendar c2= Calendar.getInstance();
			c.set(2013, 02, 32, 15+i,13);
			if(i<2){
				this.loans.add(new Loan(c, c2,new Teacher("Jean" + i),
						"Emprunt pour " + i + " jours",new Phone()));
				
			}
			else{
				this.loans.add(new Loan(c, c2,new Teacher("Jean" + i),
						"Emprunt pour " + i + " jours",new Camera()));
			}	
		}
		
		this.stock = new Stock(this.list);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStock() {

	}

	@Test
	public void testGetStock() {
		assertEquals(this.stock.getStock().get(1).size(),2);
		assertEquals(this.stock.getStock().get(0).size(),0);
		assertEquals(this.stock.getStock().get(3).size(),2);
		assertEquals(this.stock.getStock().get(2).size(),0);

	}

	@Test
	public void testSetStock() {
		HashMap<Integer, ArrayList<Material>> list2 = new HashMap<Integer, ArrayList<Material>>();
		ArrayList<Material> phone = new ArrayList<Material>();
		ArrayList<Material> camera = new ArrayList<Material>();
		for (int i = 0; i < 2; i++) {
			phone.add(new Phone());
			camera.add(new Camera());
		}
		list2.put(1,new ArrayList<Material>());
		list2.put(3,new ArrayList<Material>());
		list2.put(0,camera);
		list2.put(2,phone);
		
		this.stock.setStock(list2);
		for (int i = 0; i < 2; i++) {
			assertEquals(this.stock.getStock().get(2).get(i).getType(),"Phone");
			assertEquals(this.stock.getStock().get(0).get(i).getType(),"Camera");
		}
		
		assertEquals(this.stock.getStock().get(1).size(),0);
		assertEquals(this.stock.getStock().get(3).size(),0);
		
	}

	@Test
	public void testIsInStock() {
		assertEquals(this.stock.isInStock(new Phone()),false);
		assertEquals(this.stock.isInStock(new Camera()),false);
		assertEquals(this.stock.isInStock(new Tablet()),true);
		assertEquals(this.stock.isInStock(new Headphone()),true);
	}

	@Test
	public void testSearch() {
		assertEquals(this.stock.search(this.tab,new Headphone()),false);
		assertEquals(this.stock.search(this.hp,new Headphone()),true);
	}

	@Test
	public void testRemoveMaterial() {
		assertEquals(this.stock.removeMaterial(new Headphone()),true);
		assertEquals(this.stock.removeMaterial(new Phone()),false);
		assertEquals(this.stock.removeMaterial(new Camera()),false);
		assertEquals(this.stock.removeMaterial(new Tablet()),true);

	}

}
