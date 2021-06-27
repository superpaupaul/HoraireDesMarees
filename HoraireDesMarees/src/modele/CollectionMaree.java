package modele;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Permet de stocker des maréesUnJour dans une collection de type ArrayList
 * @author superpaupaul
 *
 */
public class CollectionMaree implements Serializable{

	ArrayList<MareesUnJour> liste;
	
	public ArrayList<MareesUnJour> getListe() {
		return liste;
	}

	public CollectionMaree() {
		liste = new ArrayList<MareesUnJour>();
	}
	
	public void ajout(MareesUnJour mareeDuJour) {
		liste.add(mareeDuJour);
	}
}
