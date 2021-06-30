package modele;

import javax.swing.table.DefaultTableModel;
/**
 * Créé le modèle permettant d'obtenir le tableau des marées en prenant en argument les données d'un jour donné.
 * @author damys
 *
 */
public class ModeleMareeTable extends DefaultTableModel{

	String[] intitules = {"TYPE","HEURE","HAUTEUR","COEFFICIENT"};
	int nbLignes = 0;
	int nbColonnes = 4;
	public ModeleMareeTable(MareesUnJour data) {
		for(Maree maree : data.getMarees()) {
			nbLignes+=1;
		}
		this.setColumnIdentifiers(intitules);
		this.setRowCount(nbLignes);
		for(int i = 0; i < nbLignes; i++) {
			setValueAt(data.getMarees()[i].getType(),i,0);
			setValueAt(data.getMarees()[i].getHeure()+" : "+data.getMarees()[i].getMinute(),i,1);
			setValueAt(data.getMarees()[i].getHauteur(),i,2);
			setValueAt(data.getMarees()[i].getCoef(),i,3);
		}
	}
}
