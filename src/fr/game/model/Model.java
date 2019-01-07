package fr.game.model;

import fr.game.entites.*;
;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
	private static String[] nom = {"Martin","Bernard","Thomas","Petit","Rober","Richard","Durand","Dubois","Moreau","Laurent","Simon","Michel","Lefebvre","Leroy","Roux","David","Bertrand","Morel","Fournier","Girad"};
	private static String[] prenom = {"Gabriel","Jules","Lucas","Louis","Adam","Hugo","Léo","Raphaël","Ethan","Nathan","Louise","Emma","Jade","Chloé","Manon","Alice","Lina","Léa","Lola","Camille"};
	private static String[] nomSociete = {"ehdsdf","xcvnf"};
	private  static  HashMap<Integer, Pays> LesPays; // key -->
	private  static  HashMap<Integer, Contribuable> LesContribuable; // key --> IdContribuable
	private  static  HashMap<Integer, Banque> ListeBanque; // key --> IdBanque
	private  static  HashMap<Integer,Societe> ListeSociete; // key --> IdSociete
	private  static  HashMap<Integer,CompteBancaire> ListeCompteFrauduleParEnqueteur; // key --> IdEnqueteur
	private  static  HashMap<Integer,CompteBancaire> ListeCompte; // key --> IdCompte

	private  static  ArrayList<CompteBancaire> ListeCompteFraudule;
	private  static  ArrayList<Enqeteur> ListeJoueur;
	private  static  ArrayList<Integer> IDsBanque;

	public Model(HashMap<Integer, Pays> lesPays, HashMap<Integer, ArrayList<Societe>> listeSocietes) {
		LesPays = new HashMap<Integer,Pays>();
		ListeBanque =  new HashMap<Integer,Banque>();
		ListeSociete =  new HashMap<Integer, Societe>();
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
		LesContribuable.put(element.getIdPersonne(), element);
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
		ListeCompteFraudule.add(c);
	}
	public static void addToListeCompte(CompteBancaire c){
		ListeCompte.put(c.getIdCompte(),c);
	}
	public static void removeToListeCompteFraudule(CompteBancaire c){
		ListeCompteFraudule.remove(c);
	}

	public static void getEnqueteur(int index){
		ListeJoueur.get(index);
	}

	public static Pays getPay(int idPays) {
		return LesPays.get(idPays);
	}

	public static Contribuable aQuiEstCeCompte(int idCompte, int idBanque)
	//retourne l'ID du possesseur du compte
	{
		return LesContribuable.get(ListeBanque.get(idBanque).posseurCompte(idCompte));
	}

	public static ArrayList<Societe> QuelleSocietesCettePersooneA(int idPersonne, int idPays)
	// retourne la liste des IDs des societes de la personne
	{
		ArrayList<Societe> retour = new ArrayList<Societe>();
		for (int index : LesPays.get(idPays).getSocietesPersonne(idPersonne)){
			retour.add(ListeSociete.get(index) );
		}
		return retour;
	}

	public static Contribuable QuiPossedeCetteSociete(int idSociete)
	// retourne l'ID du possesseur
	{
		return LesContribuable.get(ListeSociete.get(idSociete).getPossesseur());
	}

	public static void AjouterSocietePersonne(int idPersonne, Societe societe, int idPays)
	// Ajoute une societe a une personne
	{
		if (ListeSociete.containsKey(societe.getIdPersonne())) {
			System.out.println("erreur : cette societe est deja a une personne");
		} else {
			ListeSociete.put(societe.getIdPersonne(), societe);
			LesPays.get(idPays).AjouterSocietePersonne(idPersonne, societe.getIdPersonne());
		}
	}

	public static void AjouterSocieteBanquePersonne(int idPersonne, Banque banque, int idPays)
	// Ajoute une societe a une personne
	{
		if (ListeBanque.containsKey(banque.getIdPersonne())) {
			System.out.println("erreur : cette societe est deja a une personne");
		} else {
			ListeBanque.put(banque.getIdPersonne(), banque);
			LesPays.get(idPays).AjouterSocietePersonne(idPersonne, banque.getIdPersonne());
		}
	}

	public static void genrerContribuable (int nb){
		for (int i = 0; i < nb; i ++){
			addToLesContribuable(new Contribuable(nom[(int) Math.random() * ( nom.length - 0 )],prenom[(int) Math.random() * ( prenom.length - 0 )],nb % Pays.getID()));
		}
	}

	public static void genrerSociete(int nb){
		for (Map.Entry<Integer, Contribuable> entry : LesContribuable.entrySet()) {
			Integer k = entry.getKey();
			Contribuable v = entry.getValue();
			AjouterSocietePersonne(v.getIdPersonne(), new Societe(nomSociete[(int) Math.random() * (nom.length - 0)], v.getIdPays(), v.getIdPersonne()), v.getIdPays());
		}

		for (int i = 0; i < nb; i ++){
			int random = (int) Math.random() * ( Personne.getID() - 0 );
			if (ListeSociete.containsKey(random))
			{
				AjouterSocietePersonne(ListeSociete.get(random).getIdPersonne(),new Societe(nomSociete[(int) Math.random() * ( nom.length - 0 )], ListeSociete.get(random).getIdPays(),ListeSociete.get(random).getIdPersonne()),ListeSociete.get(random).getIdPays());
			}
			else i--;
		}

		for (int j = 0; j < nb/4; j ++){
			int random = (int) Math.random() * ( Personne.getID() - 0 );
			if (ListeSociete.containsKey(random))
			{
				Banque b = new Banque(nomSociete[(int) Math.random() * ( nom.length - 0 )], ListeSociete.get(random).getIdPays(),ListeSociete.get(random).getIdPersonne());
				IDsBanque.add(b.getIdPersonne());
				AjouterSocieteBanquePersonne(ListeSociete.get(random).getIdPersonne(),b,ListeSociete.get(random).getIdPays());
			}
			else j--;
		}
	}
	public static void AjouterComptes(){
		int codeBanque = 0;

		for (Map.Entry<Integer, Societe> entry : ListeSociete.entrySet()) {
			codeBanque = IDsBanque.get((int) Math.random() * ( IDsBanque.size() - 0 ));
			Integer k = entry.getKey();
			Societe v = entry.getValue();
			CompteBancaire c = new CompteBancaire(codeBanque, (int) Math.random() * ( 1000000 - 0 ), v.getIdPersonne());
			addToListeCompte(c);
			ListeBanque.get(codeBanque).ajouterCompte(c.getIdCompte(),v.getIdPersonne());
		}

		for (Map.Entry<Integer, Contribuable> entry : LesContribuable.entrySet()) {
			codeBanque = IDsBanque.get((int) Math.random() * ( IDsBanque.size() - 0 ));
			Integer k = entry.getKey();
			Contribuable v = entry.getValue();
			CompteBancaire c = new CompteBancaire(codeBanque, (int) Math.random() * ( 1000000 - 0 ), v.getIdPersonne());
			addToListeCompte(c);
			ListeBanque.get(codeBanque).ajouterCompte(c.getIdCompte(),v.getIdPersonne());
		};
	}
}
