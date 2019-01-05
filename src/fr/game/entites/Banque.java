package fr.game.entites;

import java.util.HashMap;

public class Banque extends Societe {
private HashMap<Integer,Integer> compte_Client; // idCompte , idPersonne

public Banque(String nom, int idPays, int idPersonne) {
	super(nom, idPays, idPersonne);
	compte_Client = new HashMap<Integer,Integer>();
	// TODO Auto-generated constructor stub
}
public void ajouterCompte(int idCompte, int idPersonne) {
	if( ! compte_Client.containsValue(idPersonne)) compte_Client.put(idCompte, idPersonne);
}
public int posseurCompte (int idCompte) {
	return compte_Client.get(idCompte);
}
	
}