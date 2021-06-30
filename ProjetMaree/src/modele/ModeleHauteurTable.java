package modele;

import javax.swing.table.DefaultTableModel;
/**
 * Créé le modèle permettant d'obtenir le tableau des hauteurs heure par heure en prenant en argument les données d'un jour donné.
 * @author damys
 *
 */
public class ModeleHauteurTable extends DefaultTableModel{

	String[] intitules = {"HEURE","HAUTEUR"};
	int nbLignes = 0;
	int nbColonnes = 2;
	public ModeleHauteurTable(HauteursUnJour data) {
		for(Hauteur hauteur : data.getHauteurs()) {
			nbLignes+=1;
		}
		this.setColumnIdentifiers(intitules);
		this.setRowCount(nbLignes);
		for(int i = 0; i < nbLignes; i++) {
			setValueAt(data.getHauteurs().get(i).getHeure() + " : "+data.getHauteurs().get(i).getMinute(),i,0);
			setValueAt(data.getHauteurs().get(i).getHauteur(),i,1);
		}
	}
	public ModeleHauteurTable() {
		this.setColumnIdentifiers(intitules);
	}
}
