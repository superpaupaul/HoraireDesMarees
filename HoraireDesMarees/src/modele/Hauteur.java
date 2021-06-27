package modele;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hauteur {

	private int heure;
	private int minute;
	private float hauteur;
	private GregorianCalendar date;
	
	public Hauteur(GregorianCalendar date, int heure, int minute, float hauteur) {
		this.date = date;
		this.heure = heure;
		this.minute = minute;
		this.hauteur = hauteur;
	}
	
	public String toString() {
		return "Le " + date.get(Calendar.DAY_OF_MONTH) + " " +  date.get(Calendar.MONTH) + " " + date.get(Calendar.YEAR) + " à " + heure + "h" + minute + " la hauteur est de " + hauteur;
	}
}
