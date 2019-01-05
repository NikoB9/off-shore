import java.util.ArrayList;

public class Societe extends Personne {
	private int Possesseur;
	public Societe( String nom, int idPays, int Possesseur) {
		super( nom, idPays);
		this.Possesseur = Possesseur;
	}

	public int getPossesseur() {
		return Possesseur;
	}

	@Override
	public String toString() {
		return "Societe{" +
				"idPersonne=" + idPersonne +
				", nom='" + nom + '\'' +
				", idPays=" + idPays +
				'}';
	}

	@Override
	Personne getPersonne() {
		return this;
	}
}
