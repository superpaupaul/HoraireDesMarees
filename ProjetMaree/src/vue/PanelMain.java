package vue;

import java.awt.*;
import java.io.File;
import java.util.Calendar;

import javax.swing.*;
import controleur.Controleur;
import modele.CollectionHauteur;
import modele.CollectionMaree;
import modele.Date;
import modele.Hauteur;
import modele.HauteursUnJour;
import modele.LectureFichierTxt;
import modele.MareesUnJour;
import modele.ModeleHauteurTable;
import modele.ModeleMareeTable;
/**
 * Panel contenant tout les éléments graphique du projet, il est découpé en 2 grandes parties panelGauche et panelDroit.
 * Le panelGauche contient tout les éléments permettant le bon fonctionnement du calendrier
 * Le panelDroit affiche les données des éléments sélectionnés dans le panelGauche
 * @author damys
 *
 */
public class PanelMain extends JPanel{
	ImageIcon imageHead = new ImageIcon("images/head.jpg");
	JLabel labelHead;
	JLabel labelSelection;
	JPanel panelCentre;
	JPanel panelSelection;
	JPanel panelGauche;
	JPanel panelDroit;
	JPanel panelDonneeHauteur;
	JLabel labelDonneeHauteur;
	JPanel panelDonneeMaree;
	JLabel labelDonneeMaree;
	JPanel panelTableauMaree;
	JPanel panelTableauHauteur;
	JLabel labelNODATA;
	PanelCalendrier panelCalendrier;
	PanelSelecteur panelSelecteur;
	JComboBox<String> comboChoix;
	Color blanc = new Color(255,255,255);
	Color bleu = new Color(99,198,240);
	JButton[] tabBouton;
	JTable tableauMaree;
	JTable tableauHauteur;
	ModeleMareeTable tableauMareeModel;
	ModeleHauteurTable tableauHauteurModel = new ModeleHauteurTable();
	CollectionMaree dataMaree;
	CollectionHauteur dataHauteur;
	final File REPERTOIRE = new File ("data/Marees");
	String [ ] nom_port = REPERTOIRE.list() ;
	public JButton[] getTabBouton() {
		return tabBouton;
	}

	public void setTabBouton(BoutonDate[] tabBouton) {
		this.tabBouton = tabBouton;
	}
	public PanelMain() {
		setLayout(new BorderLayout());
		//LabelHead
		labelHead = new JLabel(imageHead);
		labelHead.setPreferredSize(new Dimension(1476,164));
		add(labelHead,BorderLayout.NORTH);
		//PanelCentre
		panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(1,2));
		add(panelCentre,BorderLayout.CENTER);
		panelCentre.setBackground(blanc);
		panelCentre.setPreferredSize(new Dimension(1476,733));
		//PanelCentre/panelGauche
		panelGauche = new JPanel();
		panelCentre.add(panelGauche);
		panelGauche.setLayout(new BorderLayout());
		panelSelection = new JPanel();
		panelSelection.setPreferredSize(new Dimension(738,72));
		panelSelection.setBackground(bleu);
		panelSelection.setLayout(new GridBagLayout());
		labelSelection = new JLabel("SELECTIONNEZ UN PORT :                   ");
		labelSelection.setForeground(blanc);
		panelSelection.add(labelSelection, new GridBagConstraints());
		comboChoix = new JComboBox<>();
		comboChoix.setModel(new DefaultComboBoxModel<>(nom_port));
		comboChoix.setSelectedItem("SAINT-MALO");
        panelSelection.add(comboChoix, new GridBagConstraints());
		panelGauche.add(panelSelection,BorderLayout.NORTH);
		panelCalendrier = new PanelCalendrier();
		panelGauche.add(panelCalendrier,BorderLayout.CENTER);
		panelSelecteur = new PanelSelecteur(panelCalendrier);
		panelGauche.add(panelSelecteur,BorderLayout.SOUTH);
		//PanelCentre/panelDroit
		panelDroit = new JPanel();
		panelDroit.setLayout(new GridBagLayout());
		panelCentre.add(panelDroit);
		//PanelCentre/panelDroit/DonneMaree
		panelDonneeMaree = new JPanel();
		panelDonneeMaree.setPreferredSize(new Dimension(738,72));
		panelDonneeMaree.setBackground(bleu);
		panelDonneeMaree.setLayout(new GridBagLayout());
		labelDonneeMaree = new JLabel("Donnée Marée :");
		labelDonneeMaree.setHorizontalAlignment(SwingConstants.CENTER);
		labelDonneeMaree.setForeground(blanc);
		panelDonneeMaree.add(labelDonneeMaree, new GridBagConstraints());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		panelDroit.add(panelDonneeMaree,c);
		tableauMaree = new JTable();
 		tableauMaree.setSelectionBackground(new Color(64, 2, 53));
 		tableauMaree.setSelectionForeground(new Color(255,255,255));
 		tableauMaree.getTableHeader().setReorderingAllowed(false);
 		String mois;
 		if(new Date().getMois()>9) {
 			mois = ""+new Date().getMois();
 		}
 		else {
 			mois = "0"+new Date().getMois();
 		}
 		File fichier = new File("data/Marees/SAINT-MALO/"+mois+"-SAINT-MALO_2021_legal/"+mois+"-SAINT-MALO_2021_legal.txt");
 		dataMaree = LectureFichierTxt.lectureMaree(fichier);
 		for(MareesUnJour mareesJour : dataMaree.getListe()) {
 			if(mareesJour.getDate().get(Calendar.DAY_OF_MONTH)==new Date().getJour()) {
 				tableauMareeModel = new ModeleMareeTable(mareesJour);
 			}
 		}
		JScrollPane scroll = new JScrollPane(tableauMaree,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tableauMaree.setModel(tableauMareeModel);
		panelTableauMaree = new JPanel();
		panelTableauMaree.setLayout(new BorderLayout());
		panelTableauMaree.setPreferredSize(new Dimension(738,295));
		panelTableauMaree.add(scroll,BorderLayout.CENTER);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
	    panelDroit.add(panelTableauMaree, c);
	    //PanelCentre/panelDroit/DonneeHauteur
		panelDonneeHauteur = new JPanel();
		panelDonneeHauteur.setPreferredSize(new Dimension(738,72));
		panelDonneeHauteur.setBackground(bleu);
		panelDonneeHauteur.setLayout(new GridBagLayout());
		labelDonneeHauteur = new JLabel("Hauteur heure par heure :");
		labelDonneeHauteur.setHorizontalAlignment(SwingConstants.CENTER);
		labelDonneeHauteur.setForeground(blanc);
		panelDonneeHauteur.add(labelDonneeHauteur, new GridBagConstraints());
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		panelDroit.add(panelDonneeHauteur,c);
		
		labelNODATA = new JLabel("PAS DE DONNEE DISPONIBLE A CETTE DATE");
		labelNODATA.setForeground(new Color(214,36,4));
		labelNODATA.setHorizontalAlignment(SwingConstants.CENTER);
		labelNODATA.setPreferredSize(new Dimension(738,294));
		labelNODATA.setVisible(false);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		panelDroit.add(labelNODATA,c);
		
		tableauHauteur = new JTable();
 		tableauHauteur.setSelectionBackground(new Color(64, 2, 53));
 		tableauHauteur.setSelectionForeground(new Color(255,255,255));
 		tableauHauteur.getTableHeader().setReorderingAllowed(false);
 		File fichier2 = new File("data/HeureParHeure/maregraphie/SAINT-MALO.txt");
 		dataHauteur = LectureFichierTxt.lectureHauteur(fichier2);
 		panelTableauHauteur = new JPanel();
 		for(HauteursUnJour hauteursJour : dataHauteur.getListe()) {
 			int isHere = 0;
			if(hauteursJour.getDate().get(Calendar.DAY_OF_MONTH) == new Date().getJour()) {
				tableauHauteurModel = new ModeleHauteurTable(hauteursJour);
				isHere = 1;
			}
			if(isHere == 0) {
				panelTableauHauteur.setVisible(false);
				labelNODATA.setVisible(true);
			}
			
		}
		JScrollPane scroll2 = new JScrollPane(tableauHauteur,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tableauHauteur.setModel(tableauHauteurModel);
		panelTableauHauteur.setPreferredSize(new Dimension(738,294));
		panelTableauHauteur.setLayout(new BorderLayout());
		panelTableauHauteur.add(scroll2,BorderLayout.CENTER);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
	    panelDroit.add(panelTableauHauteur, c);
		
		tabBouton=panelSelecteur.getTabBouton();
		
	}
	public JPanel getPanelTableauHauteur() {
		return panelTableauHauteur;
	}

	public JLabel getLabelNODATA() {
		return labelNODATA;
	}

	public void setLabelNODATA(JLabel labelNODATA) {
		this.labelNODATA = labelNODATA;
	}
/**
 * permet de mettre à l'écoute le controleur mit en argument des éléments voulus.
 * @param parControleur
 */
	public void enregistreEcouteur(Controleur parControleur) {
		for(PanelMois panel : panelCalendrier.getTabPanel()) {
			for(BoutonDate bouton: panel.getTabBouton()) {
				bouton.addActionListener(parControleur);
			}
		}
		for(JButton bouton : panelSelecteur.getTabBouton()) {
			bouton.addActionListener(parControleur);
			
		}
		comboChoix.addActionListener(parControleur);
		
		
		
	}
	/**
	 * permet d'actualiser le tableau des marées avec le modèle pris en argument
	 * @param tableauMareeModel
	 */
	public void setDataMaree(ModeleMareeTable tableauMareeModel){
		tableauMaree.setModel(tableauMareeModel);
	}
	
	/**
	 * permet d'actualiser le tableau des hauteurs heure par heure avec le modèle pris en argument
	 * @param tableauHauteurModel
	 */
	public void setDataHauteur(ModeleHauteurTable tableauHauteurModel){
		tableauHauteur.setModel(tableauHauteurModel);
	}

	public PanelCalendrier getPanelCalendrier() {
		return panelCalendrier;
	}

	public void setPanelCalendrier(PanelCalendrier panelCalendrier) {
		this.panelCalendrier = panelCalendrier;
	}

	public JComboBox<String> getComboChoix() {
		return comboChoix;
	}

	public void setComboChoix(JComboBox<String> comboChoix) {
		this.comboChoix = comboChoix;
	}

	public PanelSelecteur getPanelSelecteur() {
		return panelSelecteur;
	}

	public void setPanelSelecteur(PanelSelecteur panelSelecteur) {
		this.panelSelecteur = panelSelecteur;
	}
}
