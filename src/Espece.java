
public class Espece {

	private String nomEspece;
	private int tailleM;
	private int poidsM;
	private int tailleGroupeMax;


	public Espece(String nomEspece, int tailleM, int poidsM, int tailleGroupeMax) throws IllegalArgumentException {
		if ( nomEspece == null || tailleM <= 0 || poidsM <= 0 || tailleGroupeMax <= 0) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.nomEspece = nomEspece;
		this.tailleM = tailleM;
		this.poidsM = poidsM;
		this.tailleGroupeMax = tailleGroupeMax;
	}


	public String getNomEspece() {
		return nomEspece;
	}

	public int getTailleM() {
		return tailleM;
	}


	public void setTailleM(int tailleM) throws IllegalArgumentException {
		if ( tailleM <= 0 ) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.tailleM = tailleM;
	}


	public int getPoidsM() {
		return poidsM;
	}


	public void setPoidsM(int poidsM) throws IllegalArgumentException {
		if (poidsM <= 0 ) {
			throw new IllegalArgumentException("Valeur incorrecte : aucune valeur null ou en dessous de 0");
		}
		this.poidsM = poidsM;
	}


	public int getTailleGroupeMax() {
		return tailleGroupeMax;
	}








}
