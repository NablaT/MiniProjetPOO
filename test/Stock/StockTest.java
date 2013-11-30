package Stock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Material.Headphone;
import Material.Material;
import Material.Phone;

public class StockTest {
	
	private Stock stock;
	private HashMap<Integer,ArrayList<Material>> list;
	private ArrayList<Loan> loans;
	
	@Before
	public void setUp() throws Exception {
		this.list=new HashMap<Integer,ArrayList<Material>>();
		ArrayList<Headphone> hp= new ArrayList<Headphone>();
		for(int i=0; i<3;i++){
			hp.add(new Headphone());
		}
		this.loans= new ArrayList<Loan>();
		this.stock= new Stock(this.list, loans);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStock() {
		
	}

	@Test
	public void testGetStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsInStock() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveMaterial() {
		fail("Not yet implemented");
	}

}
