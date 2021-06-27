package modele;

import java.util.ArrayList;

public class CollectionHauteur {


		ArrayList<HauteursUnJour> liste;
		
		public ArrayList<HauteursUnJour> getListe() {
			return liste;
		}

		public CollectionHauteur() {
			liste = new ArrayList<HauteursUnJour>();
		}
		
		public void ajout(HauteursUnJour hauteur) {
			liste.add(hauteur);
		}

}
