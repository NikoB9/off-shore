import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	private  static  HashMap<Integer,Pays> LesPays; // key --> IdPays
	private  static  HashMap<Integer,Banque> ListeBanque; // key --> IdBanque
	private  static  HashMap<Integer,Societe> ListeSociete; // key --> IdSociete

	public Model(HashMap<Integer, Pays> lesPays, HashMap<Integer, ArrayList<Societe>> listeSocietes) {
		LesPays = new HashMap<Integer,Pays>();
		ListeBanque =  new HashMap<Integer,Banque>();
		ListeSociete =  new HashMap<Integer,Societe>();
	}


	public static Pays getPay(int idPays) {
		return LesPays.get(idPays);
	}

	public int aQuiEstCeCompte(int idCompte, int idBanque){

		return ListeBanque.get(idBanque).posseurCompte(idCompte);
	}

	public ArrayList<Societe> QuelleSocietesCettePersooneA(int idPersonne, int idPays){

		return LesPays.get(idPays).getSocietesPersonne(idPersonne);
	}

	public int QuiPossedeCetteSociete(int idSociete)
	{
		return ListeSociete.get(idSociete).getPossesseur();
	}
}
