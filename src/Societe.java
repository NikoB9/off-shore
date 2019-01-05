import java.util.ArrayList;

public class Societe extends Personne {

	public Societe( String nom, int idPays) {
		super( nom, idPays);
		
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
