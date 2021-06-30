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
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public float getHauteur() {
		return hauteur;
	}
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
}
