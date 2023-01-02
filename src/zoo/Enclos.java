package zoo;

public class Enclos {

	private String nom;
	private int surface;
	private int nbAnimaux = 0;
	private int nbAnimauxMax;
	private Animal[] tabAnimaux;
	private Soigneur soigneur;
	private Espece espece;

	public Enclos(int surface, String nom, Espece espece) throws IllegalArgumentException {
		if ( surface <= 0 || nom == null) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.surface = surface;
		this.nom = nom;
		this.espece = espece;
		setNbAnimauxMax();
	}

	public String getNom() {
		return nom;
	}

	public Espece getEspece() {
		return espece;
	}

	public void setEspece(Espece espece) throws IllegalArgumentException {
		if ( nbAnimaux != 0) {
			throw new IllegalArgumentException("Impossible de changer l'espèce de l'enclos car il y a encore des animaux de dans !!");
		}
		this.espece = espece;
	}

	public int getSurface() {
		return surface;
	}

	public int getNbAnimaux() {
		return nbAnimaux;
	}

	public int getNbAnimauxMax() {
		return nbAnimauxMax;
	}

	public void setNom(String nom) throws IllegalArgumentException {
		if ( nom == null) {
			throw new IllegalArgumentException("Valeur incorrecte : nom null");
		}
		this.nom = nom;
	}

	public Soigneur getSoigneur() {
		return soigneur;
	}

	public void setSoigneur(Soigneur soigneur) throws IllegalArgumentException{
		if  ( soigneur == null) {
			throw new IllegalArgumentException("Valeur incorrecte : soigneur null");
		}
		this.soigneur = soigneur;
	}
	
	public void enleverSoigneur() {
		this.soigneur = null;
	}

	private void setNbAnimauxMax() {
		nbAnimauxMax = espece.getTailleGroupeMax();
		this.tabAnimaux = new Animal[nbAnimauxMax]; 
	}

	public void ajouterAnimal( Animal animal) throws IllegalArgumentException {
		if  ( nbAnimaux != 0 && animal.getEspece() != tabAnimaux[0].getEspece()) {
			throw new IllegalArgumentException("Une seule espece par enclos !!");
		}
		if ( nbAnimaux >= nbAnimauxMax ) {
			System.out.println("Il y a déja beaucoup d'animaux dans cet enclos !!");
		} else {
			animal.setEnclos(this);
			tabAnimaux[nbAnimaux] = animal;
			nbAnimaux++;
		}
	}
	
	public void enleverAnimal(Animal animal) {
		boolean found = false;
		for ( int i = 0; i <= nbAnimaux-1 && !found; i++) {
			if (tabAnimaux[i].equals(animal) ) {
				tabAnimaux[i].enleverEnclos();
				for ( int j = i; j < tabAnimaux.length-1; j++) {
					tabAnimaux[j] = tabAnimaux[j+1];
				}
				nbAnimaux--;
				found = true;
			} 
		}
		if(!found) {
			System.out.println("Le soigneur ne s'occupe pas de cet enclos");
		}	
	}

	public StringBuilder listeAnimaux() {
		StringBuilder texte = new StringBuilder();
		for ( int i = 0; i < nbAnimaux; i++) {
			texte.append( "\n- " +tabAnimaux[i].toString());
		}
		return texte;
	}

	@Override
	public String toString() {
		return "L'enclos " +getNom() +" à une surface de " +getSurface() +" et abrite " +getNbAnimaux() +"/" +getNbAnimauxMax() +" animaux de l'espèce : " +getEspece();
	}
	
	public String desciptionEnclosFull() {
		return toString() +" : " +listeAnimaux();
	}


	public boolean equals(Enclos enclos) {
		return enclos.nom == nom ;
	}
	
	/* Partie OCamel */
	
	/*public StringBuilder extraireEnclos() {
		StringBuilder texte = new StringBuilder();
		texte.append("let zoo = [ ");
		for ( int i = 0; i < nbAnimaux; i++ ) {
			texte.append("\n" +tabAnimaux[i].getEspece() +" , " +tabAnimaux[i].getNom() +" , " +tabAnimaux[i].getTaille() +" , " +tabAnimaux[i].getPoid() +"/" +tabAnimaux[i].getSexe());
		}
		texte.append("]");
		return texte;
	}*/






}
