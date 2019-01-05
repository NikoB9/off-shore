import java.util.HashMap;

public class tst {

	public static void main (String[] args) {
		Pays france = new Pays("France");

		Contribuable c = new Contribuable("hugo", "tamberi",france.getIdPays());
		Societe s = new Societe("test",france.getIdPays());
		Societe s2 = new Societe("test2",france.getIdPays());


		Contribuable c2 = new Contribuable("dgrgs", "tamberi",france.getIdPays());
		Societe s22 = new Societe("vsdv",france.getIdPays());
		Societe s222 = new Societe("x x",france.getIdPays());

		france.AjouterSocietePersonne(c.getIdPersonne(),s);
		france.AjouterSocietePersonne(c.getIdPersonne(),s2);

		france.AjouterSocietePersonne(c2.getIdPersonne(),s22);
		france.AjouterSocietePersonne(c2.getIdPersonne(),s222);

		System.out.println(france);

		for (Societe societe : france.getSocietesPersonne(c2.getIdPersonne()))
		{
			System.out.println(societe);
		}
		
	}
}
