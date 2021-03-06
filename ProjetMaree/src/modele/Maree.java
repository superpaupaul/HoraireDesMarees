package modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Classe permettant de stocker un objet marée
 * @author pvallee
 *
 */
public class Maree implements Serializable{
	private GregorianCalendar date;
	private int typeHauteur; // null = -1, BM = 0, PM = 1
	private int heure;
	private int minute;
	private float hauteur;
	private int coef;
	/**
	 * Constructeur de marée, initialise une marée en pleine mer
	 * @param date
	 * @param typeHauteur
	 * @param heure
	 * @param minute
	 * @param hauteur
	 * @param coef
	 */
	public Maree(GregorianCalendar date, int heure, int minute, float hauteur, int coef) {
		this.date = date;
		this.typeHauteur = 1;
		this.heure = heure;
		this.minute = minute;
		this.hauteur = hauteur;
		this.coef = coef;
		if(heure == -1) {
			typeHauteur = -1;
		}
	}
	/**
	 * Constructeur de marée, initialise une marée basse mer
	 * @param heure
	 * @param minute
	 * @param hauteur
	 */
	public Maree(GregorianCalendar date, int heure, int minute, float hauteur) {
		this.date = date;
		this.typeHauteur = 0;
		this.heure = heure;
		this.minute = minute;
		this.hauteur = hauteur;
		if(heure == -1) {
			typeHauteur = -1;
		}
	}
	/**
	 * Affiche les marées d'une manière lisible pour aider aux tests durant le développement
	 */
	public String toString() {
		if(typeHauteur == 1) {
			return "Marée haute le " + date.get(Calendar.DAY_OF_MONTH) + " " +  date.get(Calendar.MONTH) + " " + date.get(Calendar.YEAR) + " à " + heure + ":"+ minute + " avec une hauteur de "+ hauteur +" et un coefficient de " + coef;
		}
		else if(typeHauteur == 0){
			return "Marée basse le " + date.get(Calendar.DAY_OF_MONTH) + " " +  date.get(Calendar.MONTH) + " " + date.get(Calendar.YEAR) + " à " + heure + ":"+ minute + " avec une hauteur de "+ hauteur;
		}
		else {
			return "Marée inexistante";
		}
	}
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	public int getTypeHauteur() {
		return typeHauteur;
	}
	public void setTypeHauteur(int typeHauteur) {
		this.typeHauteur = typeHauteur;
	}
	public String getType() {
		if(typeHauteur ==1) {
			return "Maree haute";
		}
		else {
			return "Maree basse";
		}
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
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	
	
	}
