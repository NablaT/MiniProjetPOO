package Stock;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Date.Date;
import Living.Student;
import Living.Teacher;
import Material.Camera;
import Material.Headphone;
import Material.Material;
import Material.Phone;
import Material.Tablet;

public class StockManagementTest {

	private StockManagement mstock;
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
		list.put(1, this.hp);
		list.put(3, this.tab);
		list.put(0, new ArrayList<Material>());
		list.put(2, new ArrayList<Material>());

		this.loans = new ArrayList<Loan>();
		for (int i = 0; i < 4; i++) {
			Date d = new Date(2013, 2, 2, 2, 2 + i);
			Date d2 = new Date(2013, 02, 20, 15 + i, 13);
			if (i < 2) {
				this.loans.add(new Loan(d, d2, new Teacher("Jean" + i),
						"Emprunt pour " + i + " jours", new Phone()));
			} else {
				this.loans.add(new Loan(d, d2, new Teacher("Jean" + i),
						"Emprunt pour " + i + " jours", new Camera()));
			}
		}
		this.stock = new Stock(this.list);
		this.mstock = new StockManagement(this.loans, this.stock);
	}

	@After
	public void tearDown() throws Exception {
		this.mstock = new StockManagement(this.loans, this.stock);
		for (int i = 0; i < 4; i++) {
			// assertEquals(this.mstock.getLoans().get(i).)
			// TODO
		}
	}

	@Test
	public void testStockManagement() {

	}

	@Test
	public void testGetBorrowers() {
		fail("Not yet implemented");
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
	public void testSetLoans() {
		fail("Not yet implemented");
	}

	@Test
	public void testInitialize() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakeALoan() {
		Date dateLoan = new Date(2013, 2, 2, 2, 2);
		Date dateBack = new Date(2013, 3, 3, 3, 3);
		Teacher teacher = new Teacher("Pierre");
		String description = "Je veux reserver cette tablette pour mon cours";
		Tablet material = new Tablet();
		Loan loan = new Loan(dateLoan, dateBack, teacher, description, material);
		assertEquals(this.mstock.makeALoan(loan), true);

	}

	@Test
	public void testAskForALoan() {
		Teacher teacher = new Teacher("Pierre");
		Student student = new Student("Luc");

		assertEquals(this.mstock.askForALoan(teacher), true);
		assertEquals(this.mstock.askForALoan(student), true);
		student.setType("visiteur");
		assertEquals(this.mstock.askForALoan(student), false);

	}

	@Test
	public void testAskForAStudent() {
		Student s = new Student("Luc");
		Student s2 = new Student("Carl");
		Phone p = new Phone();

		Date dateLoan = new Date(2013, 2, 2, 2, 2);
		Date dateBack = new Date(2013, 3, 3, 3, 3);

		Loan l = new Loan(dateLoan, dateBack, s, "ici description", p);

		this.mstock.getLoans().add(l);

		assertEquals(this.mstock.askForAStudent(s), false);
		assertEquals(this.mstock.askForAStudent(s2), true);
	}

	@Test
	public void testAskForATeacher() {
		Teacher t = new Teacher("Pierre");
		Teacher t2 = new Teacher("Thomas");
		Phone p = new Phone();

		Date dateLoan= new Date(2013, 2,2,2,2);
		Date dateBack= new Date(2013, 3,3,3,3);
		Loan l = new Loan(dateLoan,dateBack, t, "ici description", p);
		Loan l2 = new Loan(dateLoan,dateBack, t, "ici description", p);

		this.mstock.getLoans().add(l);
		this.mstock.getLoans().add(l2);

		assertEquals(this.mstock.askForATeacher(t), false);
		assertEquals(this.mstock.askForATeacher(t2), true);
	}

}
