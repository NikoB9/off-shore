import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.processing.SupportedSourceVersion;

public class Banque extends Societe {
private HashMap<Integer,Integer> compte_Client; // idCompte , idPersonne

public Banque(String nom, int idPays) {
	super(nom, idPays);
	compte_Client = new HashMap<Integer,Integer>();
	// TODO Auto-generated constructor stub
}
public void ajouterCompte(int idCompte, int idPersonne) {
	if( ! compte_Client.containsValue(idPersonne)) compte_Client.put(idCompte, idPersonne);
}
public int posseurCompte (int idCompte) {
	return compte_Client.get(idCompte);
}
	
}