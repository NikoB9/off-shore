package fr.game.entites;

import fr.game.entites.Personne;

public class Societe extends Personne {
	private int Possesseur;
	public Societe( String nom, Pays pays, int Possesseur) {
		super( nom, pays);
		this.Possesseur = Possesseur;
	}

	/**
	 * Retourne le possesseur de la societe
	 * @return
	 */
	public int getPossesseur() {
		return Possesseur;
	}

	@Override
	public String toString() {
		return  "id de la societe : " + idPersonne +
				", nom de la Societe : " + nom +" ,pays : "+ this.pays.getNom();
	}

	@Override
	Personne getPersonne() {
		return this;
	}

}
