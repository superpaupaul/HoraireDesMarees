package vue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.* ;
/**
 * Fenetre mere contenant tout les panels nécessaire à l'IHM, elle est centé par défault
 * @author damys
 *
 */
public class FenetreMere extends JFrame {
	PanelMain panelMain;
	public FenetreMere(String parTitre){
		super(parTitre);
		panelMain = new PanelMain();
		setContentPane(panelMain);
		setSize(2000,1500);
		this.pack();
		this.getContentPane().requestFocusInWindow();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(true);
		FenetreMere.centreWindow(this);
	}
	/**
	 * méthode permettant de centrer une frame donné en argument au centre de l'écran
	 * @param frame
	 */
	public static void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	public PanelMain getPanelMain() {
		return panelMain;
	}
	public void setPanelMain(PanelMain panelMain) {
		this.panelMain = panelMain;
	}
	
	
}
