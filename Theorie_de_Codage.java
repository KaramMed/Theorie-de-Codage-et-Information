package Mathematique;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theorie_de_Codage {
	
	
	
	/* Codage Source [ Compression ] et mesure d'information */
	/* ceci est un codage pour un canal binaire ( lambda = 1 ) */
	
	private static String dict = "Ceci est un texte pour un dictionnaire par defaut";
	
	// methode pour definir votre dictionnaire
	public static void setDict(String t) {
		dict = t;
	}
	
	// methode pour calculer le log2
	public static double log2(double x) {
	    return (Math.log(x) / Math.log(2));
	}
	
	// methode qui calcule l'entropie
	public static double Entropie(Collection<Double> e) {
		Double somme = 0.0;
		for(Double p : e) {
			somme = somme + ( p * log2(p));
		}
		return -somme;
	}
	
	// methode qui analyse un texte et deduit la frequence de chaque lettre qui le compose
	public static Map<String, Double> analyse_frequentiel(String texte) {
		// on va parcourir le texte et stocker chaque lettre , s elle n existe pas et incrementer son compteur
		// s elle exsiste
		Map<String,Integer> lettres = new HashMap<String,Integer>();
		int taille = texte.length();
		char lettre ;
		String lettre_s;
		for(int i=0 ; i<taille ; i++) {
			lettre = texte.charAt(i); // on prends la lettre
			lettre_s = String.valueOf(lettre); // convertir en string
			// on va voir si la lettre existe
			if (lettres.keySet().contains(lettre_s)) {
				// on va parcourir la map et s'arreter a l'endroit de notre lettre
				for( String l : lettres.keySet() ) {
					if ( l.equals(lettre_s) ) {
						lettres.replace(l,lettres.get(l)+1); // on l'incremente
					}
				}
			}
			// sinon on l'ajoute et on lui donne 1
			else {
				lettres.put(lettre_s,1);
			}
		}
		
		// on mtn créer une autre   qui contient les valeurs divisés par la taille
		Map<String,Double> probs = new HashMap<String,Double>();
		for ( String l : lettres.keySet() ) {
			probs.put(l,( double ) lettres.get(l)/taille);
		}
		
		return probs;
	}
	
	// methode qui calcule la longueur moyenne ( prends les codes avec leurs probabilités )
	public static double longueur_moyenne(List<Code> codes) {
		double long_moy = 0.0;
		for ( Code c : codes ) {
			// on calcul la taille du code binaire
			// on multiplie par la probabilité
			long_moy = long_moy + ( c.taille_code() * c.getProbabilite() );
		}
		
		return long_moy;
	}
	
	// methode qui calcule l'incertitude d'un symbole selon le dictionnaire
	public static double incertitude(String s) {
		// on va utiliser l'analyse frequentiel pour recuperer la probabilité du symbole
		Map<String,Double> map = analyse_frequentiel(dict);
		// on recupere la probabilité si le symbole est trouvé
		if (!map.containsKey(s)) {
			return -1.0;
		}
		double p = map.get(s);
		// on calcule la formule
		double lambda = 1 ; // c'est un canal binaire
		double incert = - lambda * log2(p);
		return incert;
	}
	
	// methode qui calcule l'efficacité d'un code
	public static double efficacite(List<Code> codes) {
		// on le calcul selon le dictionnaire donnée ( par defaut c est le dict par defaut )
		// on calcule la formule
		Collection<Double> e = analyse_frequentiel(dict).values();
		return Entropie(e) / longueur_moyenne(codes);
	}
	
	
	
	/* Codage Canal */
	
	// methode qui calcule distance de Hamming entre deux codes
	public static int distance_Hamming(String c1,String c2) {
		// il faut qu'ils soient de meme taille
		if(c1.length()!=c2.length()) {
			return -1;
		}
		int diff = 0;
		// pour chaque digit des deux codes , si c'est different on incremente
		for(int i=0;i<c1.length();i++) {
			if(c1.charAt(i)!=c2.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}
	
	
	// methode qui calcule le poids de Hamming
	public static int poids_Hamming(String c1) {
		// on va voir ou le digit egal a 1
		int p = 0;
		for(int i=0;i<c1.length();i++) {
			if(c1.charAt(i)=='1') {
				p++;
			}
		}
		return p;
	}
	
	
	// methode qui calcule la distance minimal d'un code
	public static int distance_min(ArrayList<String> code) {
		// pour chaque 2 mots de codes , on calcul la distance , et on garde la min
		ArrayList<Integer> dists = new ArrayList<Integer>();
		for ( String c : code ) {
			for (String c1 : code ) {
				// faut pas comparer a lui meme
				if (!c.equals(c1)) dists.add(distance_Hamming(c,c1));
			}
		}
		
		int distmin = dists.get(1);
		for ( int d : dists ) {
			if (distmin>d) {
				distmin = d;
			}
		}
		
		return distmin;
	}
	
	
	// methode qui calcule la longueur d'un code 
	public static int longueur_code(ArrayList<String> code) {
		// les mots de codes doivent etre de meme taille ( code en bloc )
		String c = code.get(0);
		return c.length();
	}
	
	// methode qui calcule la dimention du code
	public static int dimention_code(ArrayList<String> code) {
		return code.size();
	}
	
	// methode qui calcule le taux de code
	public static double taux_code(ArrayList<String> code) {
		return (double) dimention_code(code)/(double) longueur_code(code);
	}
	
	// methode qui determine la capacité de correction du code
	public static double capacite_correction(ArrayList<String> code) {
		return ( ((double) distance_min(code)) - 1)/2; 
	}
	
	// methode qui determine la capacité de detection du code
	public static double capacite_detection(ArrayList<String> code) {
		return ( ((double) distance_min(code)) - 1); 
	}
	
public static void main(String[] args) {
	
	// calculer l'entropie de la langue francaise
	/*
	List<Double> alphabet = new ArrayList<Double>(); // liste des pourcentages
	alphabet.add(8.39);
	alphabet.add(0.77);
	alphabet.add(3.33);
	alphabet.add(4.07);
	alphabet.add(14.5);
	alphabet.add(1.21);
	alphabet.add(0.95);
	alphabet.add(0.80);
	alphabet.add(8.18);
	alphabet.add(0.64);
	alphabet.add(0.06);
	alphabet.add(5.84);
	alphabet.add(2.94);
	alphabet.add(7.56);
	alphabet.add(5.37);
	alphabet.add(3.21);
	alphabet.add(1.26);
	alphabet.add(7.02);
	alphabet.add(8.01);
	alphabet.add(7.48);
	alphabet.add(5.98);
	alphabet.add(1.58);
	alphabet.add(0.01);
	alphabet.add(0.41);
	alphabet.add(0.32);
	alphabet.add(0.12);
	List<Double> probs = new ArrayList<Double>();
	for ( double a : alphabet) {
		probs.add(a/100);
	}
	System.out.println(" l entropie de la langue francaise : "+Entropie(probs)); // = 4.04
	*/
	
	
	
}
}
