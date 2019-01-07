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

	public Pays getPays() {
		return pays;
	}

	public static int getID() {
		return ID;
	}

	public int getIdPersonne() {
		return idPersonne;
	}
}
