package fr.game.entites;

import java.util.HashMap;

public class Banque extends Societe {
private HashMap<Integer,Integer> compte_Client; // idCompte , idPersonne

public Banque(String nom, Pays pays, int idPersonne) {
	super(nom, pays, idPersonne);
	compte_Client = new HashMap<Integer,Integer>();
	// TODO Auto-generated constructor stub
}
public void ajouterCompte(int idCompte, int idPersonne) {
	if( ! compte_Client.containsValue(idPersonne)) compte_Client.put(idCompte, idPersonne);
}
public String posseurCompte (int idCompte) {
	if (compte_Client.containsKey(idCompte))
		return "id du possesseur du compte : "+Integer.toString(compte_Client.get(idCompte));
	else
		return "Pas de compte pour cette personne";
}
	
}
