package controleur;
import modele.*;
import java.io.File;
public class Lanceur {

	
	public static void main(String[] args) {
		File fichier = new File("data/06-SAINT-MALO_2021_legal/06-SAINT-MALO_2021_legal.txt");
		modele.LectureFichierTxt.lecture(fichier);
	}
	
}
