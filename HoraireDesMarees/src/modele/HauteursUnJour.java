package modele;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class HauteursUnJour {

	private GregorianCalendar date;
	private ArrayList<Hauteur> hauteurs;
	
	public HauteursUnJour(GregorianCalendar date, ArrayList<Hauteur> hauteurs) {
		this.date = date;
		this.hauteurs = hauteurs;
	}
	
	public HauteursUnJour(GregorianCalendar date) {
		this.date = date;
		hauteurs = new ArrayList<Hauteur>();
	}
	
	public GregorianCalendar getDate() {
		return date;
	}

	public ArrayList<Hauteur> getHauteurs() {
		return hauteurs;
	}

	public void addHauteur(Hauteur hauteur) {
		hauteurs.add(hauteur);
	}
}
