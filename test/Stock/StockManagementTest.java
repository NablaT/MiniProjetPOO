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
	private Teacher teach;
	private Phone phone;

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
		this.teach = new Teacher("Pierre");
		this.phone = new Phone();

		for (int i = 0; i < 4; i++) {
			Date d = new Date(2013, 2, 2, 2, 2 + i);
			Date d2 = new Date(2013, 02, 20, 15 + i, 13);
			if (i == 0) {
				this.loans.add(new Loan(d, d2, this.teach, "Emprunt pour " + i
						+ " jours", this.phone));
			}
			if (i == 1) {
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
		
	}

	@Test
	public void testGetStock() {
		
	}

	@Test
	public void testSetStock() {
		
	}

	@Test
	public void testSetLoans() {
		
	}

	@Test
	public void testInitialize() {
		
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

		Date dateLoan = new Date(2013, 2, 2, 2, 2);
		Date dateBack = new Date(2013, 3, 3, 3, 3);
		Loan l = new Loan(dateLoan, dateBack, t, "ici description", p);
		Loan l2 = new Loan(dateLoan, dateBack, t, "ici description", p);

		this.mstock.getLoans().add(l);
		this.mstock.getLoans().add(l2);

		assertEquals(this.mstock.askForATeacher(t), false);
		assertEquals(this.mstock.askForATeacher(t2), true);
	}

	@Test
	public void testGetLoan() {
		assertEquals(this.mstock.getLoan(this.phone.getId(), this.teach),
				this.loans.get(0));
		assertEquals(
				this.mstock.getLoan(this.phone.getId(), new Student("Joe")),
				null);
	}

	@Test
	public void testReturnLoan() {
		assertEquals(this.mstock.returnLoan(this.phone.getId(), this.teach),
				true);
		assertEquals(
				this.mstock.returnLoan(this.phone.getId(), new Student("Joe")),
				false);
	}

	@Test
	public void testIndexOfLoan() {
		for (int i = 0; i < this.mstock.getLoans().size(); i++) {
			assertEquals(this.mstock.indexOfLoan(this.loans.get(i)), i);
		}
	}

	@Test
	public void testMaterialIsAvalaible() {
		ArrayList<Loan> save = new ArrayList<Loan>();
		Teacher t1 = new Teacher("Pierre");
		Phone p1 = new Phone();
		Loan l1 = new Loan(new Date(2013, 12, 14, 15, 10), new Date(2013, 12,
				17, 15, 10), t1, " ", p1);
		save.add(l1);
		Loan l2 = new Loan(new Date(2013, 12, 18, 15, 10), new Date(2013, 12,
				17, 15, 10), t1, " ", p1);
		assertEquals(this.mstock.materialIsAvalaible(save, l2), true);
		assertEquals(this.mstock.materialIsAvalaible(save, l1), false);

	}

	@Test
	public void testGiveMeAvailableLoan() {
		Teacher t1 = new Teacher("Pierre");
		Phone p1 = new Phone();
		Loan l1 = new Loan(new Date(2013, 12, 14, 15, 10), new Date(2013, 12,
				17, 15, 10), t1, " ", p1);
		Loan l2 = new Loan(new Date(2013, 12, 18, 15, 10), new Date(2013, 12,
				20, 15, 10), t1, " ", p1);
		
		this.loans = new ArrayList<Loan>();
		this.loans.add(l1);
		this.loans.add(l2);
		

		Loan l3 = new Loan(new Date(2013, 12, 25, 15, 10), new Date(2013, 12,
				27, 15, 10), t1, " ", p1);
		
		ArrayList<Loan> list2= new ArrayList<Loan>();
		list2.add(l1);
		list2.add(l2);
		list2.add(l3);
		
		this.mstock.setLoans(list2);
		assertEquals(this.mstock.giveMeAvailableLoan(this.loans),l3);
		Loan l4 = new Loan(new Date(2013, 12, 23, 15, 10), new Date(2013, 12,
				27, 15, 10), t1, " ", p1);
		this.loans.add(l3);
		this.loans.add(l4);
		assertEquals(this.mstock.giveMeAvailableLoan(this.loans),null);
	}

	@Test
	public void testSaveSameLoan() {
		Teacher t1 = new Teacher("Pierre");
		Phone p1 = new Phone();
		Loan l1 = new Loan(new Date(2013, 12, 14, 15, 10), new Date(2013, 12,
				17, 15, 10), t1, " ", p1);
		Loan l2 = new Loan(new Date(2013, 12, 18, 15, 10), new Date(2013, 12,
				20, 15, 10), t1, " ", p1);
		
		this.loans = new ArrayList<Loan>();
		this.loans.add(l1);
		this.loans.add(l2);
		
		Loan l3 = new Loan(new Date(2013, 12, 18, 15, 10), new Date(2013, 12,
				20, 15, 10), t1, " ", p1);
		this.mstock.setLoans(loans);
		
		ArrayList<Loan> save= this.mstock.saveBadLoan(l3);
		
		for(int i=0;i<save.size();i++){
			assertEquals(save.get(i).equals(loans.get(i)),true);
		}
		Loan l4=new Loan(new Date(2013, 12, 21, 15, 10), new Date(2013, 12,
				25, 15, 10), t1, " ", p1);
		save=this.mstock.saveBadLoan(l4);
		
		assertEquals(save.size(),0);
		
		Headphone hp=new Headphone();
		Loan l5=new Loan(new Date(2013, 12, 21, 15, 10), new Date(2013, 12,
				25, 15, 10), t1, " ", hp);
		save=this.mstock.saveBadLoan(l5);
		
		assertEquals(save.size(),0);

		Loan l6=new Loan(new Date(2013, 12, 10, 15, 10), new Date(2013, 12,
				13, 15, 10), t1, " ", p1);
		save=this.mstock.saveBadLoan(l6);
		
		assertEquals(save.size(),0);

		Loan l7=new Loan(new Date(2013, 12, 15, 15, 10), new Date(2013, 12,
				18, 15, 10), t1, " ", p1);
		save=this.mstock.saveBadLoan(l6);
		
		for(int i=0;i<save.size();i++){
			assertEquals(save.get(i).equals(loans.get(i)),true);
		}
		
		
	}
}
