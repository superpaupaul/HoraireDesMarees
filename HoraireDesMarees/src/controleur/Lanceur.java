package controleur;
import modele.*;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Lanceur {

	
	public static void main(String[] args) {
		/*// TESTER LA LECTURE DE FICHIER MAREES
		File fichier = new File("data/Marees/07-SAINT-MALO_2021_legal/07-SAINT-MALO_2021_legal.txt");
		CollectionMaree collect = modele.LectureFichierTxt.lectureMaree(fichier);
		
		for(MareesUnJour mareesJour : collect.getListe()) {
			GregorianCalendar dateMaree = mareesJour.getDate();
			System.out.println(dateMaree.get(Calendar.DAY_OF_MONTH) + " " +  dateMaree.get(Calendar.MONTH) + " " + dateMaree.get(Calendar.YEAR));
			for(Maree maree : mareesJour.getMarees()) {
				System.out.println(maree);
			}
		}
		*/
		File fichier = new File("data/HeureParHeure/maregraphie/arcachon.txt");
		CollectionHauteur collect = modele.LectureFichierTxt.lectureHauteur(fichier);
		for(HauteursUnJour hauteursJour : collect.getListe()) {
			GregorianCalendar dateHauteurs = hauteursJour.getDate();
			System.out.println(dateHauteurs.get(Calendar.DAY_OF_MONTH) + " " +  dateHauteurs.get(Calendar.MONTH) + " " + dateHauteurs.get(Calendar.YEAR));
			for(Hauteur hauteur : hauteursJour.getHauteurs()) {
				System.out.println(hauteur);
			}
		}
	}
	
}
