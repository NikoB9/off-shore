import java.util.ArrayList;

public abstract class Personne {
	protected static int ID = 0;
	protected int idPersonne;
	protected String nom;
	protected int idPays;
	
	public Personne(String nom, int idPays) {
		this.idPersonne = ID++;
		this.nom = nom;
		this.idPays = idPays;
	}
	abstract Personne getPersonne();
	
	public int getIdPersonne() {
		return idPersonne;
	}
}
