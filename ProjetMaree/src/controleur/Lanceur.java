package controleur;
import modele.*;
import vue.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Lanceur {

	
	public static void main(String[] args) {
		FenetreMere vue = new FenetreMere("Horaire des marees");
		Controleur controleur = new Controleur(vue);
	}
	
}
