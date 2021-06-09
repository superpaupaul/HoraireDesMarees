package modele;

import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Classe permettant de stocker un objet marée
 * @author pvallee
 *
 */
public class Maree {
	private GregorianCalendar date;
	private int typeHauteur; // BM = 0, PM = 1
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
		
	}
	
	
	}
