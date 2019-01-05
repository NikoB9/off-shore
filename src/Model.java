import java.util.HashMap;

public class Model {
	private static HashMap<Integer,Pays> LesPays; // key --> IdPays

	public static Pays getPay(int idPays) {
		return LesPays.get(idPays);
	}
	
}
