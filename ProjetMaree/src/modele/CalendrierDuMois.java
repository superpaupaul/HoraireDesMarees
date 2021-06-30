package modele;
import java.util.TreeSet;
import java.util.Collection;

public class CalendrierDuMois {	
  
  private Collection <Date> treeSetDate;	  
  
  /**
   * Permet de créer un TreeSet contenant toutes les dates d'un mois et d'une année passé en argument tout en gardant un nombre de jour divisible par 7.
   * @param mois
   * @param annee
   */
  public CalendrierDuMois ( int mois, int annee) {			   
	    treeSetDate = new TreeSet <Date> ();
	    Date date = new Date (1,mois,annee);
	    int indiceJour = date.getJourSemaine() ;
	    for (int x = indiceJour ; x!=0 ; x--) {	    	 
	    	treeSetDate.add(date);	    	
	    	date = date.dateDeLaVeille();
	    }	    
	    date = new Date (2,mois,annee);
	    indiceJour = indiceJour % 7 ;
	    while (date.getMois () == mois) {
	      while(indiceJour<7) {
	    	treeSetDate.add(date);
	    	date = date.dateDuLendemain();
	    	indiceJour++ ;
	      } 
	      indiceJour=0;
	    }    
	  }

/**
 * retourne le TreeSet de date obtenu avec le constructeur
 * @return
 */
public Collection <Date> getDates() {	
	return treeSetDate;	
}	

/**
 * retourne le TreeSet sous forme de String
 */
public String toString () {
	return treeSetDate.toString();
}
    
}