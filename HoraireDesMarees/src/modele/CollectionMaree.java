package modele;

import java.util.ArrayList;

public class CollectionMaree {

	ArrayList<MareesUnJour> liste;
	
	public CollectionMaree() {
		liste = new ArrayList<MareesUnJour>();
	}
	
	public void ajout(MareesUnJour mareeDuJour) {
		liste.add(mareeDuJour);
	}
}
