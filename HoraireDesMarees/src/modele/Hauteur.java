package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * Classe permettant de stocker des objets de hauteur
 * @author superpaupaul
 *
 */
public class Hauteur implements Serializable{

	private int heure;
	private int minute;
	private float hauteur;
	private GregorianCalendar date;
	
	/**
	 * Constructeur d'un objet hauteur
	 * @param date
	 * @param heure
	 * @param minute
	 * @param hauteur
	 */
	public Hauteur(GregorianCalendar date, int heure, int minute, float hauteur) {
		this.date = date;
		this.heure = heure;
		this.minute = minute;
		this.hauteur = hauteur;
	}
	/**
	 * Convertit une hauteur en String pour faciliter les tests dans le développement
	 */
	public String toString() {
		return "Le " + date.get(Calendar.DAY_OF_MONTH) + " " +  date.get(Calendar.MONTH) + " " + date.get(Calendar.YEAR) + " à " + heure + "h" + minute + " la hauteur est de " + hauteur;
	}
}
