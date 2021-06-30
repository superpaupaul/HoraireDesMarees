package vue;
import java.awt.*;
import java.io.*;

import javax.swing.*;

import modele.*;
/**
 * panel permettant la création d'un calendrier entier sur plusiers années
 * @author damys
 *
 */
public class PanelCalendrier extends JPanel{
	String[] nomMois = {"janvier", "février","mars","avril","mai","juin","juillet", "août","septembre","octobre","novembre","décembre"};
	PanelMois[] tabPanel= new PanelMois[nomMois.length];
	int i = 0;
	CardLayout cartesLayout = new CardLayout(5,5);
	public PanelCalendrier(){
		setLayout(cartesLayout);
		
		for(int i = 0; i < nomMois.length;i++) {
			tabPanel[i] = new PanelMois(i);
			this.add(tabPanel[i],nomMois[i]);
		}
		cartesLayout.show(this,nomMois[new Date().getMois()]);
		i=new Date().getMois()-1;
	}
		
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public PanelMois[] getTabPanel() {
		return tabPanel;
	}

	public void setTabPanel(PanelMois[] tabPanel) {
		this.tabPanel = tabPanel;
	}

	public CardLayout getCartesLayout() {
		return cartesLayout;
	}

	public void setCartesLayout(CardLayout cartesLayout) {
		this.cartesLayout = cartesLayout;
	}

	public void setPrec() {
		if (i>5) {
			cartesLayout.previous(this);
			i--;
		}
	}
	public void setSuiv() {
		if (i<8) {
			cartesLayout.next(this);
			i++;
		}
	}
	public void setFirst() {
		i=5;
		cartesLayout.first(this);
	}
	public void setLast() {
		i=8;
		cartesLayout.last(this);
	}
	public String getNom() {
		return nomMois[i];
	}
	

}
