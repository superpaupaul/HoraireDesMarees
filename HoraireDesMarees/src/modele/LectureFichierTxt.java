package modele;


import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
/**
 * Classe permettant de lire des fichiers de marées avec la fonction lectureMaree ou des fichiers de hauteurs heure par heure 
 * et renvoyer des collections d'objets java marée / hauteur
 * @author superpaupaul
 *
 */
public class LectureFichierTxt {

	/**
	 * Vérifie si le fichier n'a pas déjà été lu, si c'est le cas on reprend la collection enregistrée, sinon on parcoure le
	 * fichier .txt et enregistre toutes les maréesUnJour dans une CollectionMaree, puis on écris le fichier java sur le système en
	 * utilisant le même nom avec un .java à la fin.
	 * @param fichier
	 * @return
	 */
	public static CollectionMaree lectureMaree (File fichier ) {
		File fichierPotentiellementInexistant = new File(fichier.getPath() + ".java");
		if(fichierPotentiellementInexistant.exists()) {
			return (CollectionMaree) lectureFichierEnregistre(fichierPotentiellementInexistant);
		}
		int minute, heure, coef;
		float hauteur;
		String[] heureTab;
		CollectionMaree collectionMaree = new CollectionMaree();
		MareesUnJour mareeDuJour;
		try { BufferedReader buffer = new BufferedReader (
				new InputStreamReader ( new FileInputStream ( fichier)));
				String ligneLue ; 
				int i = 0 ;
				while ((ligneLue = buffer.readLine()) != null) {
						if(i < 4) {
							i++;
							continue;
						}
						StringTokenizer decoup = new StringTokenizer(ligneLue,"\t");
						String items[] = new String[Constantes.nbItemsParMarée];
						int counter = 0;
						while (decoup.hasMoreTokens()) {
							String token = decoup.nextToken();
							//System.out.print (token + " &&& ");
							// Parsing de la ligne en objet marée
							items[counter] = token;
							counter++;
						}
						
						// parse la date
						String[] dateTab = items[0].split("-");
						GregorianCalendar date = new GregorianCalendar(Integer.parseInt(dateTab[0]),Integer.parseInt(dateTab[1]),Integer.parseInt(dateTab[2]));
						mareeDuJour = new MareesUnJour(date);
						// parse la première marée de la ligne (PM)
						//		Heure
						heureTab = items[1].split(":");
						if(heureTab[0] == "--") { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
							coef = -1;
						}
						else {
							heure = Integer.parseInt(heureTab[0]);
							minute = Integer.parseInt(heureTab[1]);
							//		Hauteur
							hauteur = Float.parseFloat(items[2]);
							//		Coef
							coef = Integer.parseInt(items[3]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur,coef));
						
						// parse la deuxième marée de la ligne (PM)
						heureTab = items[4].split(":",2);
						if(!isNumeric(heureTab[0])) { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
							coef = -1;
						}
						else {
							heure = Integer.parseInt(heureTab[0]);
							minute = Integer.parseInt(heureTab[1]);
							//		Hauteur
							hauteur = Float.parseFloat(items[5]);
							//		Coef
							coef = Integer.parseInt(items[6]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur,coef));
						
						// parse la troisième marée de la ligne (BM)
						heureTab = items[7].split(":",2);
						if(!isNumeric(heureTab[0])) { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
						}
						else {
							heure = Integer.parseInt(heureTab[0]);
							minute = Integer.parseInt(heureTab[1]);
							hauteur = Float.parseFloat(items[8]);
						}
						
						// Création et ajout de la marée
						mareeDuJour.addMaree(new Maree(date,heure,minute,hauteur));
						
						// parse la quatrième marée de la ligne (BM)
						heureTab = items[9].split(":",2);
						if(!isNumeric(heureTab[0])) { // cas où la marée n'existe pas
							minute = -1;
							heure = -1;
							hauteur = -1;
						}
						else {
							heure = Integer.parseInt(heureTab[0]);
							minute = Integer.parseInt(heureTab[1]);
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
			System.out.println("Fichier introuvable");
		}
		File nouveauFichier = new File(fichier.getPath()+".java");
		ecriture(nouveauFichier,collectionMaree);
		return collectionMaree;
	}
	
	/**
	 * Renvoie true si la String en paramètre est transformable en type numérique, et false inversement
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	/**
	 * Vérifie si le fichier n'a pas déjà été lu, si c'est le cas on reprend la collection enregistrée, sinon on parcoure le
	 * fichier .txt et enregistre toutes les hauteursUnJour dans une CollectionHauteur, puis on écris le fichier java sur le système en
	 * utilisant le même nom avec un .java à la fin.
	 * @param fichier
	 * @return
	 */
	public static CollectionHauteur lectureHauteur(File fichier) {
		File fichierPotentiellementInexistant = new File(fichier.getPath() + ".java");
		if(fichierPotentiellementInexistant.exists()) {
			return (CollectionHauteur) lectureFichierEnregistre(fichierPotentiellementInexistant);
		}
		CollectionHauteur res = new CollectionHauteur();
		int jourDavant = -1;
		HauteursUnJour hauteursUnJour = null;
		try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
		    String line;
		    int i = 0;
		    while ((line = br.readLine()) != null) {
		    	if(line.charAt(0) == '#') {
		    	   continue;
		        }
	    		String[] items = line.split(";");
	    		String[] timeTab = items[0].split(" ");
	    		String[] dateTab = timeTab[0].split("/");
	    		String[] heureTab = timeTab[1].split(":");
	    		GregorianCalendar date = new GregorianCalendar(Integer.parseInt(dateTab[2]),Integer.parseInt(dateTab[1]),Integer.parseInt(dateTab[0]));
	    		int heure = Integer.parseInt(heureTab[0]);
	    		int minute = Integer.parseInt(heureTab[1]);
	    		float hauteurVal = Float.parseFloat(items[1]);
	    		Hauteur hauteur = new Hauteur(date,heure,minute,hauteurVal);
		    	if(i == 0) {
		    		hauteursUnJour = new HauteursUnJour(date);
		    		hauteursUnJour.addHauteur(hauteur);
		    	}
		    	else {
		    		if(date.get(Calendar.DAY_OF_MONTH) != jourDavant) {
		    			res.ajout(hauteursUnJour);
		    			hauteursUnJour = new HauteursUnJour(date);
		    			hauteursUnJour.addHauteur(hauteur);
		    		}
		    		else if(minute == 0) {
		    			hauteursUnJour.addHauteur(hauteur);
		    		}
		    	}
		    	i++;
		    	jourDavant = date.get(Calendar.DAY_OF_MONTH);
		    }
		    System.out.println();
		}
		catch (IOException parException) { 
				System.out.println("Fichier introuvable");
		}
		File nouveauFichier = new File(fichier.getPath()+".java");
		ecriture(nouveauFichier,res);
		return res;
	}
	
	/**
	 * Fonction permettant d'écrire un objet java sur un fichier dans le système
	 * @param parFichier
	 * @param parObjet
	 */
	public static void ecriture (File parFichier, Object parObjet)  {
		ObjectOutputStream flux = null;
		// Ouverture du fichier en mode écriture
		try {
			flux = new ObjectOutputStream (new FileOutputStream (parFichier));
			flux.writeObject (parObjet);
			flux.flush ();
			flux.close ();
			}
		catch (IOException parException)  {
			System.err.println ("Probleme a l’ecriture\n" + parException.toString ());
			System.exit (1);
			}
		}
	
	/**
	 * Fonction permettant de lire un objet java dans un fichier système.
	 * @param parFichier
	 * @return
	 */
	public static Object lectureFichierEnregistre (File parFichier) {
		ObjectInputStream flux ;
		Object objetLu = null;
		// Ouverture du fichier en mode lecture
		try {
			flux = new ObjectInputStream(new FileInputStream (parFichier));
			objetLu = (Object)flux.readObject ();
			flux.close ();
			}
		catch (ClassNotFoundException parException) {
			System.err.println (parException.toString ());
			System.exit (1);
			}
		catch (IOException parException)  {
			System.err.println ("Erreur lecture du fichier " + parException.toString ());
			System.exit (1);}return objetLu ;}
	
}
