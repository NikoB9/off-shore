package fr.game.entites;

import fr.game.model.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class CompteBancaire {
	private static int ID;
	private int codeBanque;
	private int idCompte;
	private int idPersonne;
	private double solde;
	private boolean estFraudule;
	
	public CompteBancaire(int codeBanque, double solde, int idPersonne) {
		this.codeBanque = codeBanque;
		this.idCompte = ID++;
		this.solde = solde;
		this.idPersonne = idPersonne;
		estFraudule = false;
	}
	@Override
	public String toString() {
		return "idCompte=" + idCompte + ", solde=" + solde +" ,pays : "+ Model.getListeBanque().get(codeBanque).getPays().getNom();
	}

	/**
	 * retourne l'id du compte instancié
	 * @return
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * retourne lid du possesseur compte
	 * @return
	 */
	public int getIdPersonne() {
		return idPersonne;
	}

	/**
	 * Déclare le compte frauduleux ou non
	 * @param estFraudule
	 */
	public void setEstFraudule(boolean estFraudule) {
		this.estFraudule = estFraudule;
	}

	/**
	 * retourne si le compte est frauduleux ou non
	 * @return
	 */
	public boolean isEstFraudule() {
		return estFraudule;
	}
}
