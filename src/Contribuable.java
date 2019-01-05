import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Contribuable extends Personne {
	private String prenom;
	
	public Contribuable(String nom, String prenom, int idPays) {
		super( nom, idPays);
		this.prenom = prenom;
	}

	@Override
	Personne getPersonne() {
		return this;
	}

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom +  "]";
	}

	
}
