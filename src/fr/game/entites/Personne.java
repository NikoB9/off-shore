package fr.game.entites;

public abstract class Personne {
	protected static int ID = 0;
	protected int idPersonne;
	protected String nom;
	protected Pays pays;
	
	public Personne(String nom, Pays pays) {
		this.idPersonne = ID++;
		this.nom = nom;
		this.pays = pays;
	}
	abstract Personne getPersonne();

	/**
	 * Retourne le pays de la personne instanciée
	 * @return
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * Retourne l'id de la personne instanciée
	 * @return
	 */
	public static int getID() {
		return ID;
	}

	/**
	 * Retourne l'id de la personne instanciée
	 * @return
	 */
	public int getIdPersonne() {
		return idPersonne;
	}
}
