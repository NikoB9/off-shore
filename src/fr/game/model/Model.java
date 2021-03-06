package fr.game.model;

import fr.game.entites.*;
import fr.game.techniques.AlertBox;
;

import java.util.*;

public class Model {
    private static final int nbJoueur=10;
    private static final int nbSociete= 15;
    private static int JoueurCourant = 0;
    private static int debutBanque,finBanque;
	private static String[] nom = {"Martin","Bernard","Thomas","Petit","Rober","Richard","Durand","Dubois","Moreau","Laurent","Simon","Michel","Lefebvre","Leroy","Roux","David","Bertrand","Morel","Fournier","Girad"};
	private static String[] prenom = {"Gabriel","Jules","Lucas","Louis","Adam","Hugo","Léo","Raphaël","Ethan","Nathan","Louise","Emma","Jade","Chloé","Manon","Alice","Lina","Léa","Lola","Camille"};
	private static String[] nomSociete = {"ehdsdf","xcvnf"};
	private  static  HashMap<Integer, Pays> LesPays; // key --> IdPays
	private  static  HashMap<Integer, Contribuable> LesContribuable; // key --> IdContribuable
	private  static  HashMap<Integer, Banque> ListeBanque; // key --> IdBanque
	private  static  HashMap<Integer,Societe> ListeSociete; // key --> IdSociete
	private  static  HashMap<Integer,ArrayList<CompteBancaire>> ListeCompteFrauduleuxParEnqueteur; // key --> IdEnqueteur
	private  static  HashMap<Integer,CompteBancaire> ListeCompte; // key --> IdCompte

	private  static  ArrayList<CompteBancaire> ListeCompteFrauduleux;
	private  static  ArrayList<Enqeteur> ListeJoueur;
	private  static  ArrayList<Integer> IDsBanque;
	private  static  ArrayList<String> HistoriqueDenonciation;
	private  static  ArrayList<String> HistoriqueQuestion;

	public Model() {
		this.ListeBanque =  new HashMap<Integer,Banque>();
		this.ListeSociete = new HashMap<Integer, Societe>();
		this.ListeCompteFrauduleuxParEnqueteur = new HashMap<Integer,ArrayList<CompteBancaire>>();
		this.ListeJoueur = new ArrayList<Enqeteur>();
		this.IDsBanque = new  ArrayList<Integer>();
		this.LesPays = new HashMap<Integer, Pays>();
		this.LesContribuable = new HashMap<Integer, Contribuable>();
		this.ListeCompte = new HashMap<Integer,CompteBancaire>();
		this.ListeCompteFrauduleux = new ArrayList<CompteBancaire>();
		this.HistoriqueDenonciation =new ArrayList<String>();
		this.HistoriqueQuestion =new ArrayList<String>();

		this.LesPays.put(0,new Pays("France"));
		this.LesPays.put(1,new Pays("Portugal"));
		this.LesPays.put(2,new Pays("Grande Bretagne"));
		this.LesPays.put(3,new Pays("Espagne"));
		/*this.LesPays.put(4,new Pays("Italie"));
		this.LesPays.put(5,new Pays("Laos"));
		this.LesPays.put(6,new Pays("Japon"));
		this.LesPays.put(7,new Pays("Mexique"));
		this.LesPays.put(8,new Pays("Suisse"));*/
        peupler();
	}

	/**
	 *
	 * @return JoueurCourant
	 * retourne le joueur courant
	 */
    public static int getJoueurCourant() {
        return JoueurCourant;
    }

	/**
	 *
	 * @param joueurCourant
	 * le joueur a modifier
	 *
	 */
    public static void setJoueurCourant(int joueurCourant) {
        JoueurCourant = joueurCourant % 4;
        if (ListeJoueur.get(JoueurCourant).isRobot()){
			AlertBox.display("INFORMATION", "le robot: " + ListeJoueur.get(JoueurCourant).getPseudo() +" a joué" );
			faireJouerRobot(JoueurCourant);
		}
    }

	public static void peupler(){
		genererContribuables(nbJoueur);
		genererSocietes(nbSociete);
		AjouterComptes();
		creerComptefrauduleux();
	}

	/**
	 *
	 * @return
	 * HashMap contenant les pays
	 */
	public static HashMap<Integer, Pays> getLesPays() {
		return LesPays;
	}

	/**
	 *
	 * @return
	 * HashMap contenant les contribuable
	 */
	public static HashMap<Integer, Contribuable> getLesContribuable() {
		return LesContribuable;
	}

	/**
	 *
	 * @return
	 * HashMap contenant les Banques
	 */
	public static HashMap<Integer, Banque> getListeBanque() {
		return ListeBanque;
	}

	/*public static void setListeBanque(HashMap<Integer, Banque> listeBanque) {
		ListeBanque = listeBanque;
	}*/

	/**
	 *
	 * @return
	 * HashMap contenant les societes
	 */
	public static HashMap<Integer, Societe> getListeSociete() {
		return ListeSociete;
	}

	/*public static void setListeSociete(HashMap<Integer, Societe> listeSociete) {
		ListeSociete = listeSociete;
	}*/

	/**
	 *
	 * @return
	 * HashMap contenant les les comptes par enqueteur
	 */
	public static HashMap<Integer, ArrayList<CompteBancaire>> getListeCompteFrauduleuxParEnqueteur() {
		return ListeCompteFrauduleuxParEnqueteur;
	}

	/**
	 *
	 * @return
	 * HashMap contenant les comptes
	 */
	public static HashMap<Integer, CompteBancaire> getListeCompte() {
		return ListeCompte;
	}

	/*public static void setListeCompte(HashMap<Integer, CompteBancaire> listeCompte) {
		ListeCompte = listeCompte;
	}*/

	/**
	 *
	 * @return
	 * ArrayList contenant les compte frauduleux
	 */
	public static ArrayList<CompteBancaire> getListeCompteFrauduleux() {
		return ListeCompteFrauduleux;
	}

/*	public static void setListeCompteFrauduleux(ArrayList<CompteBancaire> ListeCompteFrauduleux) {
		ListeCompteFrauduleux = ListeCompteFrauduleux;
	}*/

	/**
	 *
	 * @return
	 * ArrayList contenant les joueur
	 */
	public static ArrayList<Enqeteur> getListeJoueur() {
		return ListeJoueur;
	}
	/*
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
	public static void addToLesPays(Pays element){
		LesPays.put(element.getIdPays(),element);
	}
		public static void removeToListeJoueur(Enqeteur e) {
		ListeJoueur.remove(e);
	}

		public static void removeToListeCompteFrauduleux(CompteBancaire c){
		ListeCompteFrauduleux.remove(c);
	}

	public static void getEnqueteur(int index){
		ListeJoueur.get(index);
	}
	*/

	/**
	 *
	 * @param element
	 * Le contribuable a ajouter a la liste des contribuables
	 */
	public static void addToLesContribuable(Contribuable element){
		LesContribuable.put(element.getIdPersonne(), element);
	}

	/**
	 *
	 * @param e
	 * L'enqueteur a ajouter a la liste des enqueteurs
	 */
	public static void addToListeJoueur(Enqeteur e) {
		ListeJoueur.add(e);
	}

	/**
	 *
	 * @param c
	 * Le compte a ajouter a la liste des comptes frauduleux
	 */
	public static void addToListeCompteFrauduleux(CompteBancaire c){
		c.setEstFraudule(true);
		ListeCompteFrauduleux.add(c);
	}

	/**
	 *
	 * @param c
	 * Le compte a ajouter a la liste des comptes
	 */
	public static void addToListeCompte(CompteBancaire c){
		ListeCompte.put(c.getIdCompte(),c);
	}

	/**
	 *
	 * @param idPays
	 *
	 * @return
	 * retourne le pays avec l'id en parametre
	 */
	public static Pays getPay(int idPays) {
		return LesPays.get(idPays);
	}

	/**
	 *
	 * @param idCompte
	 * @param idBanque
	 * @return
	 * le compte a idCompte de la baque idBanque
	 */
	public static String aQuiEstCeCompte(int idCompte, int idBanque)
	//retourne l'ID du possesseur du compte
	{
		Model.setJoueurCourant(Model.getJoueurCourant()+1);
		System.out.println(idCompte +" "+idBanque);
		if(ListeBanque.containsKey(idBanque)) {
			HistoriqueQuestion.add("a Qui Est Ce Compte " + idCompte + ", dans la banque : " + idBanque);
			return ListeBanque.get(idBanque).posseurCompte(idCompte);
		}
		else
			return "Cette banque n'existe pas";
	}

	/**
	 *
	 * @param idPersonne
	 * @param idPays
	 * @return
	 * Les societes qu'une personne dans un pays possede
	 */
	public static String QuelleSocietesCettePersooneA(int idPersonne, int idPays)
	// retourne la liste des IDs des societes de la personne
	{
		Model.setJoueurCourant(Model.getJoueurCourant()+1);
		if(LesPays.containsKey(idPays)){
			if (LesPays.get(idPays).paysContientPersonne(idPersonne)){
				String retour="";
				for (int index : LesPays.get(idPays).getSocietesPersonne(idPersonne)){
					retour += "ID Societe : " + ListeSociete.get(index)+"\n" ;
				}
				HistoriqueQuestion.add("Quelle Societes le contribualble : "+idPersonne+", dans le pays : "+idPays+" A");
				return retour;
			}
			else
				return "cette personne n'a pas de societe dans ce pays";

		}
		else
			return "ce pays n'existe pas";

	}

	/**
	 *
	 * @param idSociete
	 * @return
	 * le possessuer de la Societe en parametre
	 */
	public static String QuiPossedeCetteSociete(int idSociete)
	// retourne l'ID du possesseur
	{
		Model.setJoueurCourant(Model.getJoueurCourant()+1);
		String retour ="Cette societe n'existe pas";
		if (ListeSociete.containsKey(idSociete)){
			HistoriqueQuestion.add("Qui Possede Cette Societe : "+idSociete);
			if (LesContribuable.containsKey(ListeSociete.get(idSociete).getPossesseur()))
            {
                retour =LesContribuable.get(ListeSociete.get(idSociete).getPossesseur()).toString() ;
            }
			else if  (ListeSociete.containsKey(ListeSociete.get(idSociete).getPossesseur())){
                retour =ListeSociete.get(ListeSociete.get(idSociete).getPossesseur()).toString() ;
            }
		}

		return retour;
	}

	/**
	 *  Ajoute une societe a une personne
	 * @param idPersonne
	 * @param societe
	 * @param idPays
	 */
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

	/**
	 * Ajoute une Banque a une personne
	 * @param idPersonne
	 * @param banque
	 * @param idPays
	 */
	public static void AjouterSocieteBanquePersonne(int idPersonne, Banque banque, int idPays)
	//
	{
		if (ListeBanque.containsKey(banque.getIdPersonne())) {
			System.out.println("erreur : cette societe est deja a une personne");
		} else {
			ListeBanque.put(banque.getIdPersonne(), banque);
			LesPays.get(idPays).AjouterSocietePersonne(idPersonne, banque.getIdPersonne());
		}
	}

	/**
	 *
	 * @param nb
	 * genere nb contribuable
	 */
	public static void genererContribuables(int nb){
		for (int i = 0; i < nb; i ++){

			addToLesContribuable(new Contribuable(nom[(int) (Math.random() * ( nom.length - 0 ))],prenom[(int) (Math.random() * ( prenom.length - 0 ))],LesPays.get((int) (Math.random() * ( LesPays.size() - 0 )))));
		}
	}

	/**
	 *
	 * @param nb
	 * genere nb + nbContribuable Societes
	 */
	public static void genererSocietes(int nb){
		for (Map.Entry<Integer, Contribuable> entry : LesContribuable.entrySet()) {
			Integer k = entry.getKey();
			Contribuable v = entry.getValue();
			AjouterSocietePersonne(v.getIdPersonne(), new Societe(nomSociete[(int) (Math.random() * (nomSociete.length - 0))], v.getPays(), v.getIdPersonne()), v.getPays().getIdPays());
		}
		for (int i = 0; i < nb; i ++){
			int random = (int) (Math.random() * ( Personne.getID() - 0 ));
			if (ListeSociete.containsKey(random))
			{
				AjouterSocietePersonne(ListeSociete.get(random).getIdPersonne(),new Societe(nomSociete[(int) (Math.random() * ( nomSociete.length - 0 ))], ListeSociete.get(random).getPays(),ListeSociete.get(random).getIdPersonne()),ListeSociete.get(random).getPays().getIdPays());
			}
			else i--;
		}
		debutBanque = Personne.getID();
		for (int j = 0; j < nb/2; j ++){
			int random = (int) (Math.random() * ( Personne.getID() - 0 ));
			if (ListeSociete.containsKey(random))
			{
				Banque b = new Banque(nomSociete[(int) (Math.random() * ( nomSociete.length - 0 ))], ListeSociete.get(random).getPays(),ListeSociete.get(random).getIdPersonne());
				IDsBanque.add(b.getIdPersonne());
				System.out.println(b.getIdPersonne());
				AjouterSocieteBanquePersonne(ListeSociete.get(random).getIdPersonne(),b,ListeSociete.get(random).getPays().getIdPays());
			}
			else j--;
		}
		finBanque = Personne.getID() - 1;
	}

	public static void AjouterComptes(){
		int codeBanque = 0;

		for (Map.Entry<Integer, Societe> entry : ListeSociete.entrySet()) {
			codeBanque = IDsBanque.get((int) (Math.random() * ( IDsBanque.size() - 0 )));
			Integer k = entry.getKey();
			Societe v = entry.getValue();
			CompteBancaire c = new CompteBancaire(codeBanque, (int) (Math.random() * ( 1000000 - 0 )), v.getIdPersonne());
			addToListeCompte(c);
			ListeBanque.get(codeBanque).ajouterCompte(c.getIdCompte(),v.getIdPersonne());
		}

		for (Map.Entry<Integer, Contribuable> entry : LesContribuable.entrySet()) {
			codeBanque = IDsBanque.get((int) (Math.random() * ( IDsBanque.size() - 0 )));
			Integer k = entry.getKey();
			Contribuable v = entry.getValue();
			CompteBancaire c = new CompteBancaire(codeBanque, (int) (Math.random() * ( 1000000 - 0 )), v.getIdPersonne());
			addToListeCompte(c);
			ListeBanque.get(codeBanque).ajouterCompte(c.getIdCompte(),v.getIdPersonne());
		}
	}

	/**
	 *
	 * @param nom
	 * @return
	 * retourne l'id d'un pays par son nom
	 */
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

	/**
	 *
	 * @param idPays
	 * @param idPersonne
	 * @param idBanque
	 * @param idCompte
	 * @param idJouer
	 * @return
	 * permet de dononcer une fraude
	 */
	public static String denoncer(int idPays, int idPersonne, int idBanque, int idCompte, int idJouer){
	try {
		Model.setJoueurCourant(Model.getJoueurCourant() + 1);
		if (!(LesPays.containsKey(idPays) || LesContribuable.containsKey(idPersonne) || ListeBanque.containsKey(idBanque) || ListeCompte.containsKey(idCompte))) {
			return "Un des champs au moins est erroné";
		}
		if (!ListeCompteFrauduleux.contains(ListeCompte.get(idCompte))) {
			return "ce compte n'est pas frauduleux ou a déjà été dénoncé";
		}
		if (ListeBanque.containsKey(idBanque)) {
			if (ListeBanque.get(idBanque).getPays().getIdPays() == idPays) {
				System.out.println(ListeCompte.get(idCompte).getIdPersonne());
				if (LesPays.get(idPays).paysContientPersonne(ListeCompte.get(idCompte).getIdPersonne())) {
					HistoriqueDenonciation.add("Dans le pays : " + idPays + ", le contribualble : " + idPersonne + ", numro de compte : " + idCompte);
					ListeCompteFrauduleux.remove(ListeCompte.get(idCompte));
					if (!ListeCompteFrauduleuxParEnqueteur.containsKey(idJouer)) {
						ListeCompteFrauduleuxParEnqueteur.put(idJouer, new ArrayList<CompteBancaire>());
					}
					ListeCompteFrauduleuxParEnqueteur.get(idJouer).add(ListeCompte.get(idCompte));
					if (Model.ListeCompteFrauduleux.size() == 0) {
						return " partie terminé !!";
					}

					return "Denonciation effectué !!";
				}
				return "debug";
			}
		}
		return "Ce compte n'appartient pas a cette personne ou n'est pas dans cette banque";
	} catch (Exception e){
		System.out.println("bug");
		return "Un des champs au moins est erroné";
	}
	}

	public static void creerComptefrauduleux(){
		for (int i = 0; i < ListeCompte.size()/2  ; i++){
			System.out.println(ListeCompte.get(i).getIdCompte());
			addToListeCompteFrauduleux(ListeCompte.get(i));
		}
	}
	public static void faireJouerRobot(int id){
        denoncer((int) (Math.random() * ( LesPays.size() -1 - 0 )), (int) (Math.random() * ( (nbJoueur - 1) - 0 )), debutBanque + (int) (Math.random() * (finBanque - debutBanque)), (int) (Math.random() * ( ListeCompte.size()-1 - 0 )), id);
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
