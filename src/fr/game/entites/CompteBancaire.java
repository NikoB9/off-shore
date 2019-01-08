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
	public int getIdCompte() {
		return idCompte;
	}
	
	public int getIdPersonne() {
		return idPersonne;
	}

	public void setEstFraudule(boolean estFraudule) {
		this.estFraudule = estFraudule;
	}

	public boolean isEstFraudule() {
		return estFraudule;
	}
}
