package zoo;

public class Soigneur extends Employer {

	private final int nbEnclosMax = 5;
	private int nbEnclos = 0;
	private Enclos[] tabEnclos = new Enclos[nbEnclosMax];

	public Soigneur(String nom, int id, Zoo zoo) {
		super(nom, id, zoo);
	}

	public int getNbEnclosMax() {
		return nbEnclosMax;
	}

	public int getNbEnclos() {
		return nbEnclos;
	}

	public void ajouterEnclosAGerer( Enclos enclosPlus) {
		if ( nbEnclos >= nbEnclosMax ) {
			System.out.println("Le soigneur s'occupe déja de beaucoup d'enclos.");
		} else {
			enclosPlus.setSoigneur(this);
			tabEnclos[nbEnclos] = enclosPlus;
			nbEnclos++;
		}
	}

	public void enleverEnclos(Enclos enclos) {
		boolean found = false;
		for ( int i = 0; i <= nbEnclos-1 && !found; i++) {
			if (tabEnclos[i].equals(enclos) ) {
				tabEnclos[i].enleverSoigneur();
				for ( int j = i; j < nbEnclos; j++) {
					tabEnclos[j] = tabEnclos[j+1];
				}
				nbEnclos--;
				found = true;
			}
		}
		if(!found) {
			System.out.println("Le soigneur ne s'occupe pas de cet enclos");
		}		
	}

	public StringBuilder listeEnclos() {
		StringBuilder texte = new StringBuilder();
		for ( int i = 0; i < nbEnclos; i++) {
			texte.append( "\n- " +tabEnclos[i].toString());
		}
		return texte;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		super.parler(" et je suis un soigneur.");
	}

	@Override
	public String toString() {
		return "Le soigneur numéro " +getId() +" a pour nom : " +super.getNom() +". Il s'occupde de " +getNbEnclos() +"/" +getNbEnclosMax()
		+" enclos";
	}
	
	public String desciptionSoigneurFull() {
		return toString() +" : " +listeEnclos();
	}
	
	
	/*public StringBuilder extraireSoigneur() {
		StringBuilder texte = new StringBuilder();
		texte.append("let soigneur = [ ");
		for ( int i = 0; i < nbEnclos; i++ ) {
			texte.append("\n" +tabEnclos[i].getNom() +" , " +tabEnclos[i].getSurface() +" , " +tabEnclos[i].getNbAnimaux() +"/" +tabEnclos[i].getNbAnimauxMax());
		}
		texte.append("]");
		return texte;
		
	}*/


}
