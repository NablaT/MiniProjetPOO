package Stock;

import java.util.ArrayList;
import java.util.HashMap;

import sun.misc.Cache;

import Date.Date;
import Living.Borrower;
import Living.Student;
import Living.Teacher;
import Material.Camera;
import Material.Headphone;
import Material.Material;
import Material.OperatingSystem;
import Material.Phone;
import Material.Tablet;

public class DemoStock {

	private StockManagement mstock; 
	private ArrayList<Borrower> borrower; 
	
	public DemoStock(){
		this.mstock=initializeMStock();
		initializeBorrower();
	}
	/**
	 * Methode initializeBorrower. Cette methode permet d'initialiser la liste des borrowers.
	 */
	
	private void initializeBorrower() {
		this.borrower=new ArrayList<Borrower>(); 
		this.borrower.add(new Teacher("Pierre"));
		this.borrower.add(new Student("Quentin"));
		this.borrower.add(new Teacher("Luc"));
	}

	/**
	 * Methode initializeMStock. Cette methode permet d'initialiser le stockManagement.
	 */
	private StockManagement initializeMStock() {
		HashMap<Integer, ArrayList<Material>> stock = new HashMap<Integer, ArrayList<Material>>();
		
		Tablet t1 = new Tablet(OperatingSystem.ANDROID);
		Tablet t2 = new Tablet(OperatingSystem.ANDROID);
		Tablet t3 = new Tablet(OperatingSystem.WINDOWS);
		Tablet t4 = new Tablet(OperatingSystem.IOS);
		
		Phone p1= new Phone(OperatingSystem.ANDROID);
		Phone p2=new Phone(OperatingSystem.IOS);
		Phone p3=new Phone(OperatingSystem.WINDOWS);

		Headphone hp1= new Headphone();
		Headphone hp2= new Headphone();
		Headphone hp3= new Headphone();

		Camera c1= new Camera();
		Camera c2= new Camera();
		Camera c3= new Camera();
		Camera c4= new Camera();
		Camera c5= new Camera();

		ArrayList<Material> lt = new ArrayList<Material>();
		lt.add(t1);
		lt.add(t2);
		lt.add(t3);
		lt.add(t4);
		ArrayList<Material>  lp= new ArrayList<Material>();
		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		ArrayList<Material>  lhp= new ArrayList<Material>();
		lhp.add(hp1);
		lhp.add(hp2);
		lhp.add(hp3);
		ArrayList<Material>  lc= new ArrayList<Material>();
		lc.add(c1);
		lc.add(c2);
		lc.add(c3);
		lc.add(c4);
		lc.add(c5);
	
	
		stock.put(0, lc);
		stock.put(1, lhp);
		stock.put(2, lp);
		stock.put(3, lt);
		
		ArrayList<Loan> loans= new ArrayList<Loan>(); 
		
		Loan l1 = new Loan(new Date(2013, 12, 14, 15, 10), new Date(2013, 12,
				17, 15, 10), this.borrower.get(0), " ", p1);
		
		Loan l2 = new Loan(new Date(2013, 12, 18, 15, 10), new Date(2013, 12,
				20, 15, 10), this.borrower.get(1), " ", t1);
		
		loans.add(l1);
		loans.add(l2);
		
		Stock realStock= new Stock(stock);
		StockManagement mstock= new StockManagement(loans, realStock);
		
		return mstock;
		
	}
}
