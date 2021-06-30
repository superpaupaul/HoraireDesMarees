package vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * panel contenant les boutons permettant de naviguer entre les mois dans le calendrier
 * @author damys
 *
 */
public class PanelSelecteur extends JPanel{
	String[] nomBouton = {"Précédent","Suivant"};
	JButton[] tabBouton = new JButton[nomBouton.length];
	PanelCalendrier panelCalendrier;
	JLabel etiquette;
	public PanelSelecteur(PanelCalendrier parPanel) {
		panelCalendrier = parPanel;
		for(int i = 0; i < nomBouton.length;i++) {
			JButton bouton = new JButton(nomBouton[i]);
			tabBouton[i] = bouton;
			add(bouton);
		}
		etiquette = new JLabel(panelCalendrier.getNom());
		add(etiquette);
	}
	public JButton[] getTabBouton() {
		return tabBouton;
	}
	public void setTabBouton(JButton[] tabBouton) {
		this.tabBouton = tabBouton;
	}
	public JLabel getEtiquette() {
		return etiquette;
	}
	public void setEtiquette(JLabel etiquette) {
		this.etiquette = etiquette;
	}
	
	
}