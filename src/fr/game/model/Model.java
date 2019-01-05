package fr.game.model;

import fr.game.entites.Banque;
import fr.game.entites.Pays;
import fr.game.entites.Societe;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	private  static  HashMap<Integer, Pays> LesPays; // key --> IdPays
	private  static  HashMap<Integer, Banque> ListeBanque; // key --> IdBanque
	private  static  HashMap<Integer,Societe> ListeSociete; // key --> IdSociete

	public Model(HashMap<Integer, Pays> lesPays, HashMap<Integer, ArrayList<Societe>> listeSocietes) {
		LesPays = new HashMap<Integer,Pays>();
		ListeBanque =  new HashMap<Integer,Banque>();
		ListeSociete =  new HashMap<Integer, Societe>();
	}

	public static Pays getPay(int idPays) {
		return LesPays.get(idPays);
	}

	public int aQuiEstCeCompte(int idCompte, int idBanque)
	//retourne l'ID du possesseur du compte
	{

		return ListeBanque.get(idBanque).posseurCompte(idCompte);
	}

	public ArrayList<Integer> QuelleSocietesCettePersooneA(int idPersonne, int idPays)
	// retourne la liste des IDs des societes de la personne
	{

		return LesPays.get(idPays).getSocietesPersonne(idPersonne);
	}

	public int QuiPossedeCetteSociete(int idSociete)
	// retourne l'ID du possesseur
	{
		return ListeSociete.get(idSociete).getPossesseur();
	}

	public void AjouterSocietePersonne(int idPersonne, Societe societe, int idPays)
	// Ajoute une societe a une personne
	{
		if (ListeSociete.containsKey(societe.getIdPersonne())) {
			System.out.println("erreur : cette societe est deja a une personne");
		} else {
			ListeSociete.put(societe.getIdPersonne(), societe);
			LesPays.get(idPays).AjouterSocietePersonne(idPersonne, societe.getIdPersonne());
		}
	}
}
