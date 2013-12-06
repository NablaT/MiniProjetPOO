package Date;

/**
 * Classe Date. Cette classe définit une date suivant 5 parametres (5 entiers):
 * l'annee, le mois, le jour, l'heure et la minute.
 */

public class Date {

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;

	private static final int yearMin = 2013;

	/**
	 * Constructeur de la classe Date. Une date est creee a partir de 5 entiers
	 * correspondant à l'annee, le mois, le jour, l'heure et la minute.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 */

	public Date(int year, int month, int day, int hour, int minute) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	/**
	 * Methode isACorrectDate. Verifie si la date est correcte.
	 * 
	 * @return
	 */

	public boolean isACorrectDate() {
		return (this.year >= yearMin && monthIsCorrect() && hourIsCorrect()
				&& dayIsCorrect() && minutesAreCorrect());
	}

	/**
	 * Methode minuteAreCorrect. Cette methode verifie si les minutes sont bien
	 * comprises entre 1 et 59 inclus.
	 * 
	 * @return
	 */
	private boolean minutesAreCorrect() {
		return (this.minute >= 0 && this.minute < 60);
	}

	/**
	 * Methode DayIsCorrect. Cette methode verifie si le jour est correct. Le
	 * jour l'est si: January | 31 jours
	 * 
	 * February | 29 jours
	 * 
	 * March | 31 jours
	 * 
	 * April | 30 jours
	 * 
	 * May | 31 jours
	 * 
	 * June | 30 jours
	 * 
	 * July | 31 jours
	 * 
	 * August | 31 jours
	 * 
	 * September | 30 jours
	 * 
	 * October | 31 jours
	 * 
	 * November | 30 jours
	 * 
	 * December | 31 jours
	 * 
	 * @return
	 */
	private boolean dayIsCorrect() {
		if (monthIsCorrect()) {
			if (this.month <= 7) {
				if (this.month == 2)
					return (this.day > 0 && this.day < 30);
				else if (this.month % 2 == 0)
					return (this.day > 0 && this.day < 31);
				else
					return (this.day > 0 && this.day < 32);
			} else {
				if (this.month % 2 == 0)
					return (this.day > 0 && this.day < 32);
				else
					return (this.day > 0 && this.day < 31);
			}
		}
		return true;
	}

	/**
	 * Methode monthIsCorrect. Cette methode retourne true si le mois est bien
	 * compris entre 1 et 12 inclus.
	 * 
	 * @return
	 */

	private boolean monthIsCorrect() {
		return (this.month <= 12 && this.month > 0);
	}

	/**
	 * Methode hourIsCorrect. Cette methode retourne true si l'heure est
	 * comprise entre 1 et 24 inclus.
	 * 
	 * @return
	 */
	private boolean hourIsCorrect() {
		return (this.hour < 25 && this.hour > 0);
	}

	/**
	 * Methode getYear. Cette methode retourne l'entier correspondant à l'annee.
	 * 
	 * @return
	 **/
	public int getYear() {
		return this.year;
	}

	/**
	 * Methode getMonth. Cette methode retourne l'entier correspondant au mois
	 * 
	 * @return
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * Methode getDay. Cette methode retourne l'entier correspondant au jour.
	 * 
	 * @return
	 */

	public int getDay() {
		return this.day;
	}

	/**
	 * Methode getHour. Cette methode retourne l'entier correspondant aux
	 * heures.
	 * 
	 * @return
	 */
	public int getHour() {
		return this.hour;
	}

	/**
	 * Methode getMinutes. Cette methode retourne l'entier correspondant aux
	 * minutes
	 * 
	 * @return
	 */
	public int getMinute() {
		return this.minute;
	}

	/**
	 * Methode setYear. Cette methode remplace l'année par l'annee specifiee en
	 * parametre.
	 * 
	 * @param y
	 */
	public void setYear(int y) {
		this.year = y;
	}

	/**
	 * Methode setMonth. Cette methode remplace le mois de l'annee par l'entier
	 * placé en parametre.
	 * 
	 * @param m
	 */
	public void setMonth(int m) {
		this.month = m;
	}

	/**
	 * Methode setDay. Cette methode remplace le jour par l'entier specifié en
	 * parametre.
	 * 
	 * @param d
	 */
	public void setDay(int d) {
		this.day = d;
	}

	/**
	 * Methode setHour. Cette methode remplace l'heure par l'heure specifiee en
	 * parametre.
	 * 
	 * @param h
	 */

	public void setHour(int h) {
		this.hour = h;
	}

	/**
	 * Methode setMinute. Cette methode remplace les minutes par l'entier
	 * specifie en parametre.
	 * 
	 * @param m
	 */
	public void setMinute(int m) {
		this.minute = m;
	}

	public boolean equals(Date d) {
		return (this.year == d.getYear() && this.month == d.getMonth()
				&& this.day == d.getDay() && this.hour == d.getHour() && this.minute == d
					.getMinute());
	}

	public Date parse(String string) {
		Date date = null;
		if ((string.length()==10) && (string.charAt(2)=='/') && (string.charAt(5)=='/')){
			day=Integer.valueOf(string.substring(0, 2));
			month=Integer.valueOf(string.substring(3,5));
			year=Integer.valueOf(string.substring(6));
			date= new Date(day,month,year, 0,0);			
		}
		return date;
	}

	public boolean before(Date end) {
		boolean isBefore=false;
		if (this.year<end.getYear())
			isBefore = true;
		else if (this.year==end.getYear()){
			if (this.month<end.getMonth())
				isBefore = true;
			else if (this.month==end.getMonth()){
				if (this.day<end.getDay())
					isBefore = true;
				else if (this.day==end.getDay()){
					if (this.hour<end.getHour())
						isBefore = true;
				}
			}
		}
	return isBefore;
	}
	
}
