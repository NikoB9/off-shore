import java.util.ArrayList;
import java.util.HashMap;

public class Pays {
private static int  ID;
private String Nom;
private int IdPays;
private HashMap<Integer,ArrayList<Societe>> ListeSocietes; // key  --> idPersonne (proprietaire)private HashMap<Integer,ArrayList<Societe>> ListeSocietes;
public Pays(String nom) {
	Nom = nom;
	IdPays = ID++;
	ListeSocietes = new HashMap<Integer,ArrayList<Societe>>();
}

	public int getIdPays() {
		return IdPays;
	}

	public void AjouterSocietePersonne(int IDPersonne, Societe s)
{
	if (this.ListeSocietes.containsKey(IDPersonne)){
		this.ListeSocietes.get(IDPersonne).add(s);
	}
	else{
		ArrayList<Societe> temp = new ArrayList<Societe>();
		temp.add(s);
		this.ListeSocietes.put(IDPersonne, temp);
	}

}

public ArrayList<Societe> getSocietesPersonne(int IDPersonne)
{
	return this.ListeSocietes.get(IDPersonne);
}

	@Override
	public String toString() {
		return "Pays{" +
				"Nom='" + Nom + '\'' +
				", IdPays=" + IdPays +
				", ListeSocietes=" + ListeSocietes +
				'}';
	}
}
