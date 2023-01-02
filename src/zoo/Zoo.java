package zoo;
public class Zoo {
	
	private String nomZoo;
	private static final int NBENCLOSMAXZOO = 100;
	private int nbEnclos = 0;
	private Enclos[] tabEnclosZoo = new Enclos[NBENCLOSMAXZOO];

	public Zoo(String nomZoo) throws IllegalArgumentException {
		if ( nomZoo == null ) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.nomZoo = nomZoo;
	}

	public String getNomZoo() {
		return nomZoo;
	}
	
	public void ajouterEnclos( Enclos enclosPlus) {
		if ( nbEnclos >= NBENCLOSMAXZOO ) {
			System.out.println("Le nombre d'enclos maximum du zoo a était atteind.");
		} else {
			tabEnclosZoo[nbEnclos] = enclosPlus;
			nbEnclos++;
		}
	}

	@Override
	public String toString() {
		return "Bonjour, nous somme le zoo : " +getNomZoo() +". Bienvenue a toi. Nous avons " +nbEnclos +" enclos dans notre zoo que tu vas pouvoir découvrir.";
	}
	
	
	/*public StringBuilder extraireZoo() {
		StringBuilder texte = new StringBuilder();
		texte.append("let zoo = [ ");
		for ( int i = 0; i < nbEnclos; i++ ) {
			texte.append("\n" +tabEnclosZoo[i].getNom() +" , " +tabEnclosZoo[i].getSurface() +" , " +tabEnclosZoo[i].getNbAnimaux() +"/" +tabEnclosZoo[i].getNbAnimauxMax());
		}
		texte.append("]");
		return texte;
	}*/
	
	
	
}
