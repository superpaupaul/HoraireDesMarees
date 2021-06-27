package modele;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Permet de stocker des HauteursUnJour dans une collection de type ArrayList
 * @author superpaupaul
 *
 */
public class CollectionHauteur implements Serializable{


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
