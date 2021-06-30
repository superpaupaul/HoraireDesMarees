package modele;

import javax.swing.table.DefaultTableModel;
/**
 * Cr�� le mod�le permettant d'obtenir le tableau des mar�es en prenant en argument les donn�es d'un jour donn�.
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
