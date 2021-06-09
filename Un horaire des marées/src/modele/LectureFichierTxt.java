package modele;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class LectureFichierTxt {

	public static CollectionMaree lecture (File fichier ) {
		int minute, heure, coef;
		float hauteur;
		String[] heureTab;
		CollectionMaree collectionMaree = new CollectionMaree();
		MareesUnJour mareeDuJour;
		try { BufferedReader buffer = new BufferedReader (
				new InputStreamReader ( new FileInputStream ( fichier)));
				String ligneLue ; 
				int i = 1 ;
				while ((ligneLue = buffer.readLine()) != null) {
					
						StringTokenizer decoup = new StringTokenizer(ligneLue,"\t");
						String items[] = new String[Constantes.nbItemsParMarée];
						int counter = 0;
						while (decoup.hasMoreTokens()) {
							String token = decoup.nextToken();
							//System.out.print (token + " &&& ");
							// Parsing de la ligne en objet marée
							items[counter] = token;
						}
						
						// parse la date
						String[] dateTab = items[0].split("-",2);
						GregorianCalendar date = new GregorianCalendar(Integer.parseInt(dateTab[0]),Integer.parseInt(dateTab[1]),Integer.parseInt(dateTab[2]));
						
						mareeDuJour = new MareesUnJour(date);
						// parse la première marée de la ligne (PM)
						//		Heure
						heureTab = items[1].split(":",1);
						if(heureTab[0] == "--") { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
							coef = -1;
						}
						else {
							minute = Integer.parseInt(heureTab[0]);
							heure = Integer.parseInt(heureTab[1]);
							//		Hauteur
							hauteur = Float.parseFloat(items[2]);
							//		Coef
							coef = Integer.parseInt(items[3]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur,coef));
						
						// parse la deuxième marée de la ligne (PM)
						heureTab = items[4].split(":",1);
						if(heureTab[0] == "--") { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
							coef = -1;
						}
						else {
							minute = Integer.parseInt(heureTab[0]);
							heure = Integer.parseInt(heureTab[1]);
							//		Hauteur
							hauteur = Float.parseFloat(items[5]);
							//		Coef
							coef = Integer.parseInt(items[6]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur,coef));
						
						// parse la troisième marée de la ligne (BM)
						heureTab = items[7].split(":",1);
						if(heureTab[0] == "--") { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
						}
						else {
							minute = Integer.parseInt(heureTab[0]);
							heure = Integer.parseInt(heureTab[1]);
							//		Hauteur
							hauteur = Float.parseFloat(items[8]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur));
						
						// parse la quatrième marée de la ligne (BM)
						heureTab = items[9].split(":",1);
						if(heureTab[0] == "--") { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
						}
						else {
							minute = Integer.parseInt(heureTab[0]);
							heure = Integer.parseInt(heureTab[1]);
							//		Hauteur
							hauteur = Float.parseFloat(items[10]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur));
						
						// Ajout de la marée du jour à la collection
						collectionMaree.ajout(mareeDuJour);
				}	
		} // try
		catch (IOException parException) { 
				// Traitement de l�erreur 
		}
		return collectionMaree;
	}
}
