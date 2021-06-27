package modele;

import java.util.ArrayList;

public class CollectionMaree {

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
