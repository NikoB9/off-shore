package fr.game.entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Contribuable extends Personne {
	private String prenom;
	
	public Contribuable(String nom, String prenom, Pays pays) {
		super( nom, pays);
		this.prenom = prenom;
	}

	@Override
	Personne getPersonne() {
		return this;
	}

	@Override
	public String toString() {
		return this.getIdPersonne()+" prenom : " + prenom +  " , nom : " +this.nom + "pays : " + this.pays.getNom();
	}

	
}
