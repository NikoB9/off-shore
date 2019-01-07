package fr.game.entites;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pays {
private static int  ID;
private String Nom;
private int IdPays;
private HashMap<Integer,ArrayList<Integer>> ListeSocietes; // key  --> idPersonne (Possesseur)
public Pays(String nom) {
	Nom = nom;
	IdPays = ID++;
	ListeSocietes = new HashMap<Integer,ArrayList<Integer>>();
}

	public static int getID() {
		return ID;
	}

	public int getIdPays() {
		return IdPays;
	}
	public boolean PersonnepossedeSociete(int idPersone, int idSociete){
	return ListeSocietes.get(idPersone).contains(idSociete);
	}

	public void AjouterSocietePersonne(int idPersonne, int idSociete)
{
	if (this.ListeSocietes.containsKey(idPersonne)){
		this.ListeSocietes.get(idPersonne).add(idSociete);
	}
	else{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(idSociete);
		this.ListeSocietes.put(idPersonne, temp);
	}

}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public static void setID(int ID) {
		Pays.ID = ID;
	}

	public ArrayList<Integer> getSocietesPersonne(int IDPersonne) {
			return this.ListeSocietes.get(IDPersonne); }

	public boolean paysContientPersonne (int IDPersonne){
		return this.ListeSocietes.containsKey(IDPersonne);
	}
	@Override
	public String toString() {
		return "fr.game.entites.Pays{" +
				"Nom='" + Nom + '\'' +
				", IdPays=" + IdPays +
				", ListeSocietes=" + ListeSocietes +
				'}';
	}
}
