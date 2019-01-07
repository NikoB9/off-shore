package fr.game.model;

import fr.game.entites.*;
;

import java.util.*;

public class Model {
	private static String[] nom = {"Martin","Bernard","Thomas","Petit","Rober","Richard","Durand","Dubois","Moreau","Laurent","Simon","Michel","Lefebvre","Leroy","Roux","David","Bertrand","Morel","Fournier","Girad"};
	private static String[] prenom = {"Gabriel","Jules","Lucas","Louis","Adam","Hugo","Léo","Raphaël","Ethan","Nathan","Louise","Emma","Jade","Chloé","Manon","Alice","Lina","Léa","Lola","Camille"};
	private static String[] nomSociete = {"ehdsdf","xcvnf"};
	private  static  HashMap<Integer, Pays> LesPays; // key --> IdPays
	private  static  HashMap<Integer, Contribuable> LesContribuable; // key --> IdContribuable
	private  static  HashMap<Integer, Banque> ListeBanque; // key --> IdBanque
	private  static  HashMap<Integer,Societe> ListeSociete; // key --> IdSociete
	private  static  HashMap<Integer,CompteBancaire> ListeCompteFrauduleuxParEnqueteur; // key --> IdEnqueteur
	private  static  HashMap<Integer,CompteBancaire> ListeCompte; // key --> IdCompte

	private  static  ArrayList<CompteBancaire> ListeCompteFrauduleux;
	private  static  ArrayList<Enqeteur> ListeJoueur;
	private  static  ArrayList<Integer> IDsBanque;

	public Model() {
		this.ListeBanque =  new HashMap<Integer,Banque>();
		this.ListeSociete = new HashMap<Integer, Societe>();
		this.ListeCompteFrauduleuxParEnqueteur = new HashMap<Integer,CompteBancaire>();
		this.ListeJoueur = new ArrayList<Enqeteur>();
		this.LesPays = new HashMap<Integer, Pays>();

		this.LesPays.put(0,new Pays("France"));
		this.LesPays.put(1,new Pays("Portugal"));
		this.LesPays.put(2,new Pays("Grande Bretagne"));
		this.LesPays.put(3,new Pays("Espagne"));
		this.LesPays.put(4,new Pays("Italie"));
		this.LesPays.put(5,new Pays("Laos"));
		this.LesPays.put(6,new Pays("Japon"));
		this.LesPays.put(7,new Pays("Mexique"));
		this.LesPays.put(8,new Pays("Suisse"));

	}

	public static void peupler(){
		genererContribuables(50);
		genererSocietes(50);
		AjouterComptes();
	}

	public static HashMap<Integer, Pays> getLesPays() {
		return LesPays;
	}

	public static HashMap<Integer, Contribuable> getLesContribuable() {
		return LesContribuable;
	}

	public static void setLesContribuable(HashMap<Integer, Contribuable> lesContribuable) {
		LesContribuable = lesContribuable;
	}

	public static HashMap<Integer, Banque> getListeBanque() {
		return ListeBanque;
	}

	public static void setListeBanque(HashMap<Integer, Banque> listeBanque) {
		ListeBanque = listeBanque;
	}

	public static HashMap<Integer, Societe> getListeSociete() {
		return ListeSociete;
	}

	public static void setListeSociete(HashMap<Integer, Societe> listeSociete) {
		ListeSociete = listeSociete;
	}

	public static HashMap<Integer, CompteBancaire> getListeCompteFrauduleuxParEnqueteur() {
		return ListeCompteFrauduleuxParEnqueteur;
	}

	public static void setListeCompteFrauduleuxParEnqueteur(HashMap<Integer, CompteBancaire> ListeCompteFrauduleuxParEnqueteur) {
		ListeCompteFrauduleuxParEnqueteur = ListeCompteFrauduleuxParEnqueteur;
	}

	public static HashMap<Integer, CompteBancaire> getListeCompte() {
		return ListeCompte;
	}

	public static void setListeCompte(HashMap<Integer, CompteBancaire> listeCompte) {
		ListeCompte = listeCompte;
	}

	public static ArrayList<CompteBancaire> getListeCompteFrauduleux() {
		return ListeCompteFrauduleux;
	}

	public static void setListeCompteFrauduleux(ArrayList<CompteBancaire> ListeCompteFrauduleux) {
		ListeCompteFrauduleux = ListeCompteFrauduleux;
	}

	public static ArrayList<Enqeteur> getListeJoueur() {
		return ListeJoueur;
	}

	public static void setListeJoueur(ArrayList<Enqeteur> listeJoueur) {
		ListeJoueur = listeJoueur;
	}

	public static ArrayList<Integer> getIDsBanque() {
		return IDsBanque;
	}

	public static void setIDsBanque(ArrayList<Integer> IDsBanque) {
		Model.IDsBanque = IDsBanque;
	}

	public static void addToListeCompteFrauduleuxParEnqueteur(CompteBancaire c, Enqeteur e ){
		ListeCompteFrauduleuxParEnqueteur.put(e.getIdPersonne(), c);
	}

	public static void addToListeBanque(Banque element){
		ListeBanque.put(element.getIdPersonne(), element);
	}
	public static void addToLesContribuable(Contribuable element){
		LesContribuable.put(element.getIdPersonne(), element);
	}
	public static void addToLesPays(Pays element){
		LesPays.put(element.getIdPays(),element);
	}
	public static void addToListeJoueur(Enqeteur e) {
		ListeJoueur.add(e);
	}
	public static void removeToListeJoueur(Enqeteur e) {
		ListeJoueur.remove(e);
	}
	public static void addToListeCompteFrauduleux(CompteBancaire c){
		c.setEstFraudule(true);
		ListeCompteFrauduleux.add(c);
	}
	public static void addToListeCompte(CompteBancaire c){
		ListeCompte.put(c.getIdCompte(),c);
	}
	public static void removeToListeCompteFrauduleux(CompteBancaire c){
		ListeCompteFrauduleux.remove(c);
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

	public static void genererContribuables(int nb){
		for (int i = 0; i < nb; i ++){
			addToLesContribuable(new Contribuable(nom[(int) Math.random() * ( nom.length - 0 )],prenom[(int) Math.random() * ( prenom.length - 0 )],LesPays.get((int) Math.random() * ( LesPays.size() - 0 ))));
		}
	}

	public static void genererSocietes(int nb){
		for (Map.Entry<Integer, Contribuable> entry : LesContribuable.entrySet()) {
			Integer k = entry.getKey();
			Contribuable v = entry.getValue();
			AjouterSocietePersonne(v.getIdPersonne(), new Societe(nomSociete[(int) Math.random() * (nom.length - 0)], v.getPays(), v.getIdPersonne()), v.getPays().getIdPays());
		}

		for (int i = 0; i < nb; i ++){
			int random = (int) Math.random() * ( Personne.getID() - 0 );
			if (ListeSociete.containsKey(random))
			{
				AjouterSocietePersonne(ListeSociete.get(random).getIdPersonne(),new Societe(nomSociete[(int) Math.random() * ( nom.length - 0 )], ListeSociete.get(random).getPays(),ListeSociete.get(random).getIdPersonne()),ListeSociete.get(random).getPays().getIdPays());
			}
			else i--;
		}

		for (int j = 0; j < nb/4; j ++){
			int random = (int) Math.random() * ( Personne.getID() - 0 );
			if (ListeSociete.containsKey(random))
			{
				Banque b = new Banque(nomSociete[(int) Math.random() * ( nom.length - 0 )], ListeSociete.get(random).getPays(),ListeSociete.get(random).getIdPersonne());
				IDsBanque.add(b.getIdPersonne());
				AjouterSocieteBanquePersonne(ListeSociete.get(random).getIdPersonne(),b,ListeSociete.get(random).getPays().getIdPays());
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
		}
	}
	public static Integer getIdPaysByname(String nom){

		for (Map.Entry<Integer, Pays> entry : Model.getLesPays().entrySet()) {
			Integer key = entry.getKey();
			Pays pays = entry.getValue();
			if (pays.getNom() == nom){
				return pays.getIdPays();
			}
		}
		return null;
	}

	/*public static void main (String... args){
		Model m = new Model();
		for (Map.Entry<Integer, Pays> entry : Model.getLesPays().entrySet()) {
			Integer key = entry.getKey();
			Pays pays = entry.getValue();
			System.out.println(pays.getNom());
		}
	}*/
}
