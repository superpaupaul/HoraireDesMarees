package controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;

import javax.swing.JButton;

import modele.CollectionHauteur;
import modele.CollectionMaree;
import modele.Date;
import modele.HauteursUnJour;
import modele.LectureFichierTxt;
import modele.MareesUnJour;
import modele.ModeleHauteurTable;
import modele.ModeleMareeTable;
import vue.*;

public class Controleur implements ActionListener {
	PanelMain panelMain;
	PanelCalendrier panelCalendrier;
	FenetreMere vue;
	JButton[] tabBouton;
	BoutonDate boutonDate = new BoutonDate(new Date());
	Date dateSelec = new Date();
	String moisAncien = "06";
	String moisNouveau;
	File fichier = new File("data/Marees/SAINT-MALO/"+moisAncien+"-SAINT-MALO_2021_legal/"+moisAncien+"-SAINT-MALO_2021_legal.txt");
	CollectionMaree dataMaree = LectureFichierTxt.lectureMaree(fichier);
	CollectionHauteur dataHauteur;
	String portSelect = "SAINT-MALO";
	ModeleMareeTable tableauMareeModel;
	ModeleHauteurTable tableauHauteurModel;
	/**
	 * Constructeur du Controleur prenant en argument la fenetre mere afin de l'utiliser dans la classe, c'est aussi dans le constructeur que la methode 
	 * enregistreEcouteur est utilisé afin d'écouter les actions effectuer sur le panel main
	 * @param parVue
	 */
	public Controleur(FenetreMere parVue) {
		vue = parVue;
		panelMain = vue.getPanelMain();
		panelMain.enregistreEcouteur(this);
		tabBouton=panelMain.getTabBouton();
	}
	@Override
	/**
	 * Cette méthode va nous permettre de réagir aux actions effectuer sur le panel main. Elle vérifie l'origine des sources afin d'executer les actions nécessaires,
	 * on a tout d'abord les boutons permettant de naviguer entre les différents mois, ensuite la combobox qui nous permet d'actualiser les tableaux à chaque fois
	 * que sa valeur est changer. Enfin si l'événement ne correspond à aucune des sources précèdente c'est un bouton date que l'on peut récupérer et ducoup actualiser les tableaux
	 */
	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getSource()== tabBouton[0]) {
			panelMain.getPanelCalendrier().setPrec();
			panelMain.getPanelSelecteur().getEtiquette().setText(panelMain.getPanelCalendrier().getNom());
		}
		else if (parEvt.getSource()== tabBouton[1]) {
			panelMain.getPanelCalendrier().setSuiv();
			panelMain.getPanelSelecteur().getEtiquette().setText(panelMain.getPanelCalendrier().getNom());
		}
		else if(parEvt.getSource() == panelMain.getComboChoix()) {
			portSelect = (String) panelMain.getComboChoix().getSelectedItem();
			fichier = new File("data/Marees/"+portSelect+"/"+moisAncien+"-"+portSelect+"_2021_legal/"+moisAncien+"-"+portSelect+"_2021_legal.txt");
			dataMaree = LectureFichierTxt.lectureMaree(fichier);
			for(MareesUnJour mareesJour : dataMaree.getListe()) {
	 			if(mareesJour.getDate().get(Calendar.DAY_OF_MONTH)==dateSelec.getJour()) {
	 				tableauMareeModel = new ModeleMareeTable(mareesJour);
	 				panelMain.setDataMaree(tableauMareeModel);
	 			}
			}
			File fichier2 = new File("data/HeureParHeure/maregraphie/"+portSelect+".txt");
			if(fichier2.isFile()==false) {
				panelMain.getPanelTableauHauteur().setVisible(false);
				panelMain.getLabelNODATA().setVisible(true);
			}
	 		dataHauteur = LectureFichierTxt.lectureHauteur(fichier2);
	 		int isHere = 0;
	 		for(HauteursUnJour hauteursJour : dataHauteur.getListe()) {
	 			if(hauteursJour.getDate().get(Calendar.DAY_OF_MONTH)==dateSelec.getJour()) {
	 				tableauHauteurModel = new ModeleHauteurTable(hauteursJour);
	 				panelMain.setDataHauteur(tableauHauteurModel);
	 				panelMain.getPanelTableauHauteur().setVisible(true);
					panelMain.getLabelNODATA().setVisible(false);
	 				isHere =1;
	 			}
	 			if(isHere == 0) {
					panelMain.getPanelTableauHauteur().setVisible(false);
					panelMain.getLabelNODATA().setVisible(true);
				}
	 		}
		}
		else{
			if(boutonDate.getDate().compareTo(new Date())==0) {
				boutonDate.setBackground(new Color(180,130,130));
			}
			else
				boutonDate.setBackground(null);
			boutonDate=(BoutonDate) parEvt.getSource();
			boutonDate.setBackground(new Color(224,140,61));
			dateSelec = boutonDate.getDate();
			if(dateSelec.getMois()>9) {
				moisNouveau = ""+dateSelec.getMois();
			}
			else {
				moisNouveau = "0"+dateSelec.getMois();
			}
			if(moisNouveau != moisAncien) {
				fichier = new File("data/Marees/"+portSelect+"/"+moisNouveau+"-"+portSelect+"_2021_legal/"+moisNouveau+"-"+portSelect+"_2021_legal.txt");
				if(fichier.exists()) {
					dataMaree = LectureFichierTxt.lectureMaree(fichier);
					moisAncien = moisNouveau;
				}
				
			}
			for(MareesUnJour mareesJour : dataMaree.getListe()) {
	 			if(mareesJour.getDate().get(Calendar.DAY_OF_MONTH)==dateSelec.getJour()) {
	 				tableauMareeModel = new ModeleMareeTable(mareesJour);
	 				panelMain.setDataMaree(tableauMareeModel);
	 			}
	 		}
			File fichier2 = new File("data/HeureParHeure/maregraphie/"+portSelect+".txt");
			if(fichier2.isFile()==false) {
				panelMain.getPanelTableauHauteur().setVisible(false);
				panelMain.getLabelNODATA().setVisible(true);
			}
	 		dataHauteur = LectureFichierTxt.lectureHauteur(fichier2);
	 		int isHere = 0;
	 		for(HauteursUnJour hauteursJour : dataHauteur.getListe()) {
	 			if(hauteursJour.getDate().get(Calendar.DAY_OF_MONTH)==dateSelec.getJour()) {
	 				tableauHauteurModel = new ModeleHauteurTable(hauteursJour);
	 				panelMain.setDataHauteur(tableauHauteurModel);
	 				panelMain.getPanelTableauHauteur().setVisible(true);
					panelMain.getLabelNODATA().setVisible(false);
	 				isHere =1;
	 			}
	 			if(isHere == 0) {
					panelMain.getPanelTableauHauteur().setVisible(false);
					panelMain.getLabelNODATA().setVisible(true);
				}
	 		}
			}
		
	}
}
