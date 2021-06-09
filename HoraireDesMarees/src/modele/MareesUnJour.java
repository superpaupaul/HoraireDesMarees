package modele;

import java.util.Date;
import java.util.GregorianCalendar;

public class MareesUnJour {

	private GregorianCalendar date;
	private Maree[] marees;
	int counter = 0;
	
	public MareesUnJour(GregorianCalendar date, Maree[] marees) {
		this.date = date;
		this.marees = marees;
		counter = 3;
	}
	
	public MareesUnJour(GregorianCalendar date) {
		counter = 0;
	}
	
	public void addMaree(Maree maree) {
		if(counter >= Constantes.nbMareesParJour) {
			try {
				throw new Exception("Impossible d'avoir plus de " + Constantes.nbMareesParJour +  " marées par jour");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		marees[counter] = maree;
		counter++;
	}
	
	
}
