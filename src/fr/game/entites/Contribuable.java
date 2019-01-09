package fr.game.entites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Contribuable extends Personne {
	private String prenom;

    /**
     * crrer une instance de contribuable
     * @param nom
     * @param prenom
     * @param pays
     */
	public Contribuable(String nom, String prenom, Pays pays) {
		super( nom, pays);
		this.prenom = prenom;
	}

    /**
     *
     * @return
     * retourne l'obljet personne
     */
	@Override
	Personne getPersonne() {
		return this;
	}

    /**
     *
     * @return
     * redefini l'affichage pour Contribualble
     */
	@Override
	public String toString() {
		return this.getIdPersonne()+" prenom : " + prenom +  " , nom : " +this.nom + "pays : " + this.pays.getNom();
	}

	
}
