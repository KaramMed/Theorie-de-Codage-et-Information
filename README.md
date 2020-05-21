# Theorie-de-Codage-et-Information
Des methodes pour faire des calculs dans ce qui rentre en domaine de Theorie de Codage et d'Informaton

# Codage Source 

setdit : permet de definir votre dictionnaire d'alphabet sous forme de texte , sinon celui par defaut est utilisé

Entropie : prends une liste de probabilités , et retourne l'entropie ( c est la moyenne d'informations par message )

analyse_frequentiel : prends un texte , et renvoie une Map contenant pour chaque sympbole/lettre sa probabilité d'apaprition

longueur_moyenne : prends un ensemble de mots de codes binaires , et renvoie leurs longueur moyenne

incertitude : prends une lettre/symbole et renvoie son incertitude ( la quantité d'information gagné en recevant cette lettre selon le dictionnaire )

efficacite : prends une liste de mots de codes et renvoie son efficacité ( entropie / longueur moyenne , compri entre 0 et 1 )

# Codage Canal

distance_Hamming : prends deux mots de codes binaires sous format String et renvoie la distance de Hamming entre eux

poids_Hamming : prends un mot de code binaire sous format String et renvoie son poids de Hamming

distance_minimal : prends une liste de mots de codes en String , et renvoie leurs distances minimale ( c'est la minimum de distances de Hamming entre chaque 2 mots de codes )

longueur_code : prends une liste de mots de codes en String , et renvoie leurs longueurs ( il s'agit ici d'un code en bloc c-a-d que tous les mots de codes sont de meme taille )

dimention_code : prends une liste de mots de codes en String , et renvoie sa taille 

taux_code : prends une liste de mots de codes en String , et renvoie le taux de code ( c'est la dimention du code divisé par la longueur du code )

capacite_correction : prends une liste de mots de codes en String , et renvoie le maximum d'erreurs qu'il peut corriger 

capacité_detection : prends une liste de mots de codes en String , et renvoie le maximum d'erreurs qu'on peut detecter

-----------------------------------------------------------------------------------------------------------------------------

# Coding-and-Information-Theory
Methods for making calculations in what falls within the domain of Coding Theory and Informaton

# Source Coding ( Compression )

setdit: allows you to define your alphabet dictionary as text, otherwise the default one is used

Entropy: take a list of probabilities, and return the entropy (this is the average information per message)

analyze_frequentiel: take a text, and return a Map containing for each symbol / letter its probability of appearance

longueure_moyenne : take a set of binary code words, and return their average length

incertitude : take a letter / symbol and return its uncertainty (the amount of information gained by receiving this letter according to the dictionary)

efficacite : take a list of code words and return its efficiency (entropy / average length, between 0 and 1)

# Channel coding

distance_Hamming: take two binary code words in String format and return the Hamming distance between them

poids_Hamming : take a binary codeword in String format and return its Hamming weight

distance_minimal : take a list of code words in String, and return their minimum distances (this is the minimum Hamming distance between each 2 code words)

longueur_code : take a list of code words in String, and return their lengths (this is a block code, ie all code words are the same size)

dimention_code: take a list of code words in String, and return its size

taux_code: take a list of code words in String, and return the rate of code (this is the dimension of the code divided by the length of the code)

capacite_correction: take a list of code words in String, and return the maximum number of errors it can correct

capacité_detection : take a list of code words in String, and return the maximum number of errors that can be detected

