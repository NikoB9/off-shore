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

	/**
	 *
	 * @return
	 * ID totale
	 */
	public static int getID() {
		return ID;
	}

	/**
	 *
	 * @return
	 * id du pays
	 */
	public int getIdPays() {
		return IdPays;
	}

	/**
	 *
	 * @param idPersone
	 * @param idSociete
	 * @return
	 * possesseur de la societe
	 */
	public boolean PersonnepossedeSociete(int idPersone, int idSociete){
	return ListeSocietes.get(idPersone).contains(idSociete);
	}

	/**
	 *
	 * @param idPersonne
	 * @param idSociete
	 */
	public void AjouterSocietePersonne(int idPersonne, int idSociete)
{
	if (this.ListeSocietes.containsKey(idPersonne)){
		this.ListeSocietes.get(idPersonne).add(idSociete);
	}
	else{

		this.ListeSocietes.put(idPersonne, new ArrayList<Integer>());
		this.ListeSocietes.get(idPersonne).add(idSociete);
	}

}

	/**
	 *
	 * @return
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 *
	 * @param nom
	 */
	public void setNom(String nom) {
		Nom = nom;
	}

	/**
	 *
	 * @param ID
	 */
	public static void setID(int ID) {
		Pays.ID = ID;
	}

	/**
	 *
	 * @param IDPersonne
	 * @return
	 */
	public ArrayList<Integer> getSocietesPersonne(int IDPersonne) {
			return this.ListeSocietes.get(IDPersonne); }

	/**
	 *
	 * @param IDPersonne
	 * @return
	 */
	public boolean paysContientPersonne (int IDPersonne){
		return this.ListeSocietes.containsKey(IDPersonne);
	}
	@Override
	public String toString() {
		return
				"Nom='" + Nom + '\'' +
				", IdPays=" + IdPays ;
	}
}
