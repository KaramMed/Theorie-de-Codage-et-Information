# Theorie-de-Codage_et_Information
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

