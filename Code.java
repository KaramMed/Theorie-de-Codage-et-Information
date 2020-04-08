package Mathematique;

public class Code {
	
	// la classe code contient chaque symbole , son code avec sa probabilité
	
	String symbole;
	String code;
	double probabilite;
	
	public Code() {}
	
	public Code(String a,double b) {
		code = a;
		probabilite = b;
	}
	
	public Code(String a,String b,double c) {
		symbole = a;
		code = b;
		probabilite = c;
	}
	
	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getProbabilite() {
		return probabilite;
	}
	public void setProbabilite(double probabilite) {
		this.probabilite = probabilite;
	}
	
	// methode qui retourne la taille du code
	public int taille_code() {
		return code.length();
	}
	
	

}
