package vue;

import javax.swing.JButton;

import modele.Date;
/**
 * Permet la création d'objet JButton dans lesquels nous pouvons avoir accès à une date donné en argument lors de la création
 * @author damys
 *
 */
public class BoutonDate extends JButton {

	private Date date;
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date= date;
	}

	

	public Date getDate() {		 
		return date;
	}

}
