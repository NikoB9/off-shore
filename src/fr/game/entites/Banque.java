package fr.game.entites;

import java.util.HashMap;

public class Banque extends Societe {
private HashMap<Integer,Integer> compte_Client; // idCompte , idPersonne

public Banque(String nom, Pays pays, int idPersonne) {
	super(nom, pays, idPersonne);
	compte_Client = new HashMap<Integer,Integer>();
	// TODO Auto-generated constructor stub
}

	/**
	 * Permet d'ajouter un compte à un client s'il existe
	 * @param idCompte
	 * @param idPersonne
	 */
	public void ajouterCompte(int idCompte, int idPersonne) {
	if( ! compte_Client.containsValue(idPersonne)) compte_Client.put(idCompte, idPersonne);
}

	/**
	 * Retourne un message avec l'id et un message d'erreur le cas échéant
	 * @param idCompte
	 * @return
	 */
	public String posseurCompte (int idCompte) {
	if (compte_Client.containsKey(idCompte))
		return "id du possesseur du compte : "+Integer.toString(compte_Client.get(idCompte));
	else
		return "Pas de compte pour cette personne";
}

	/**
	 * Si le compte existe bien on retourne l'id de son possesseur. Null le cas échéant
	 * @param idCompte
	 * @return
	 */
	public Integer IDpossesseurCompte (int idCompte) {
	if (compte_Client.containsKey(idCompte))
		return compte_Client.get(idCompte);
	else
		return null;
	}
	
}
