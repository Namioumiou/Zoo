package zoo;

public class Employer {

	private String nom;
	private int id;
	private Zoo zoo;

	public Employer(String nom, int id, Zoo zoo) throws IllegalArgumentException {
		if ( nom == null || id <= 0 || zoo == null) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.nom = nom;
		this.id = id;
		this.zoo = zoo;
	}

	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public void parler(String texte) {
		System.out.println(this.getNom() +" (" +this.getId() +") : " +texte);
	}

	public void direBonjour() {
		this.parler("Je suis un employer du zoo : " +zoo.getNomZoo());
	}
	
	

}
