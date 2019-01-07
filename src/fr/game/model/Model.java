package fr.game.model;

import fr.game.entites.*;
;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	private  static  HashMap<Integer, Pays> LesPays; // key -->
	private  static  HashMap<Integer, Contribuable> LesContribuables; // key --> IdContribuable
	private  static  HashMap<Integer, Banque> ListeBanque; // key --> IdBanque
	private  static  HashMap<Integer,Societe> ListeSociete; // key --> IdSociete
	private  static  HashMap<Integer,CompteBancaire> ListeCompteFrauduleParEnqueteur; // key --> IdEnqueteur

	private  static  ArrayList<CompteBancaire> ListeCompteFrauduleux;
	private  static  ArrayList<Enqeteur> ListeJoueur;

	public Model(HashMap<Integer, Pays> lesPays, HashMap<Integer,Societe> listeSocietes) {
		LesPays = lesPays;
		ListeBanque =  new HashMap<Integer,Banque>();
		ListeSociete =  listeSocietes;
		ListeCompteFrauduleParEnqueteur = new HashMap<Integer,CompteBancaire>();
		ListeJoueur = new ArrayList<Enqeteur>();
	}

	public static void addToListeCompteFrauduleParEnqueteur(CompteBancaire c,Enqeteur e ){
		ListeCompteFrauduleParEnqueteur.put(e.getIdPersonne(), c);
	}

	public static void addToListeBanque(Banque element){
		ListeBanque.put(element.getIdPersonne(), element);
	}
	public static void addToLesContribuable(Contribuable element){
		LesContribuables.put(element.getIdPersonne(), element);
	}
	public static void addToLesPays(Pays element){
		LesPays.put(element.getIdPays(), element);
	}
	public static void addToListeJoueur(Enqeteur e) {
		ListeJoueur.add(e);
	}
	public static void removeToListeJoueur(Enqeteur e) {
		ListeJoueur.remove(e);
	}
	public static void addToListeCompteFraudule(CompteBancaire c){
		c.setEstFraudule(true);
		ListeCompteFrauduleux.add(c);
	}

	public static void removeToListeCompteFraudule(CompteBancaire c){
		ListeCompteFrauduleux.remove(c);
	}

	public static void getEnqueteur(int index){
		ListeJoueur.get(index);
	}

	public static Pays getPay(int idPays) {
		return LesPays.get(idPays);
	}

	public Contribuable aQuiEstCeCompte(int idCompte, int idBanque)
	//retourne l'ID du possesseur du compte
	{
		return LesContribuables.get(ListeBanque.get(idBanque).posseurCompte(idCompte));
	}

	public ArrayList<Societe> QuelleSocietesCettePersonneA(int idPersonne, int idPays)
	// retourne la liste des IDs des societes de la personne
	{
		ArrayList<Societe> retour = new ArrayList<Societe>();
		for (int index : LesPays.get(idPays).getSocietesPersonne(idPersonne)){
			retour.add(ListeSociete.get(index) );
		}
		return retour;
	}

	public Contribuable QuiPossedeCetteSociete(int idSociete)
	// retourne l'ID du possesseur
	{
		return LesContribuables.get(ListeSociete.get(idSociete).getPossesseur());
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
