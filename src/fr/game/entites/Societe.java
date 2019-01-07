package fr.game.entites;

import fr.game.entites.Personne;

public class Societe extends Personne {
	private int Possesseur;
	public Societe( String nom, Pays pays, int Possesseur) {
		super( nom, pays);
		this.Possesseur = Possesseur;
	}

	public int getPossesseur() {
		return Possesseur;
	}

	@Override
	public String toString() {
		return   idPersonne +
				", nom=" + nom;
	}

	@Override
	Personne getPersonne() {
		return this;
	}

}
