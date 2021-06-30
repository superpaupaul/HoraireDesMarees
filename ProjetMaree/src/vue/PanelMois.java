package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import controleur.Controleur;
import modele.*;
import modele.Date;
/**
 * panel chargé de la création des BoutonDate représentant les jours dans le calendrier ainsi que des intitulés des jours situés au dessus de celui ci. Ce panel représente un mois.
 * @author damys
 *
 */
public class PanelMois extends JPanel{
	CalendrierDuMois cal;
	int anneeCourante = new Date().getAnnee();
	int taille;
	Date date;
	BoutonDate[] tabBouton;
	String[] nomSemaine = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
	JLabel[] tabLabel = new JLabel[nomSemaine.length];
	
	public PanelMois(int parMois) {
		cal = new CalendrierDuMois(parMois,anneeCourante);
		taille = cal.getDates().size();
		int ligne=6;
		if(taille>35) {
			ligne =7;
		}
		if(taille<29) {
			ligne = 5;
		}
		tabBouton = new BoutonDate[taille];
		setLayout(new GridLayout(ligne,7));
		for(int i = 0; i<nomSemaine.length;i++) {
			tabLabel[i] = new JLabel(nomSemaine[i]);
			this.add(tabLabel[i],nomSemaine[i]);
		}
		Iterator<Date> dates = cal.getDates().iterator();
		int i=0;
		while(dates.hasNext()) {
			Date it = dates.next();
			tabBouton[i]=new BoutonDate(it);
			if (it.compareTo(new Date())==0) {
				tabBouton[i].setBackground(new Color(180,130,130));
			}
			if(it.getMois()!=parMois) {
				tabBouton[i].setForeground(new Color(0,50,255));
			}
			this.add(tabBouton[i]);
			i++;
			
		}
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	/*@Override
	public void actionPerformed(ActionEvent parEvt) {
		for(int i=0;i<taille-1;i++) {
			if(parEvt.getSource()==tabBouton[i]) {
				date = tabBouton[i].getDate();
				form.setDate(date);
				System.out.println(date);
				}
			}
		}*/

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BoutonDate[] getTabBouton() {
		return tabBouton;
	}

	public void setTabBouton(BoutonDate[] tabBouton) {
		this.tabBouton = tabBouton;
	}
	
		
}

