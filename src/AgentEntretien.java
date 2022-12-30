
public class AgentEntretien extends Employer{
	
	
	public AgentEntretien(String nom, int id, Zoo zoo) {
		super(nom, id, zoo);
	}
	
	public String nettoyerPark() {
		return "Le park est propre.\n";
	}
	
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		super.parler(" et je suis un agent d'entretien.");
	}
	
	@Override
	public String toString() {
		return "L'agent d'entretien numéro " +getId() +" a pour nom : " +super.getNom() +".";
	}

}
