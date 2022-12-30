public class Animal {

	private String nom;
	private int taille;
	private Enclos enclos;
	private String sexe;
	private Espece espece;
	private int poid;

	public Animal(Espece espece, String nom, int taille, int poid, String sexe) throws IllegalArgumentException{
		if ( espece == null || nom == null || taille <= 0 || sexe == null) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.espece = espece;
		this.nom = nom;
		this.taille = taille;
		this.poid = poid;
		this.sexe = sexe;
	}

	public Espece getEspece() {
		return espece;
	}

	public String getNom() {
		return nom;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) throws IllegalArgumentException {
		if ( taille <= 0) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.taille = taille;
	}

	public int getPoid() {
		return poid;
	}

	public void setPoid(int poid) {
		this.poid = poid;
	}

	public Enclos getEnclos() {
		return enclos;
	}

	public void setEnclos(Enclos enclos) throws IllegalArgumentException{
		if ( enclos == null) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.enclos = enclos;
	}
	
	public void enleverEnclos() {
		this.enclos = null;
	}

	public String getSexe() {
		return sexe;
	}

	public String getSoigneurAnimal() {
		return "C'est le soigneur " +this.getEnclos().getSoigneur().getNom() +" (" +this.getEnclos().getSoigneur().getId() +") qui s'occupe de l'enclos ou est " +nom;
	}

	@Override
	public String toString() {
		return "Je m'appel "+ nom + ", je fais " + taille +"cm, je suis un " +sexe +" et je suis dans l'enclos : " + enclos.getNom();
	}

	public boolean equals(Animal animal) {
		return animal.nom == nom && animal.taille == taille && animal.sexe == sexe && animal.espece == espece;
	}
	





}
