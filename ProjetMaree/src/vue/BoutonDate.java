package vue;

import javax.swing.JButton;

import modele.Date;
/**
 * Permet la cr�ation d'objet JButton dans lesquels nous pouvons avoir acc�s � une date donn� en argument lors de la cr�ation
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
