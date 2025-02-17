package fr.iut2.androidtp.exercice5Data;

/*Une Multiplication est composée de deux chiffres et du résultat de leur multiplication */
public class Multiplication {

    // Constantes de classe
    public static final int MIN = 1;
    public static final int MAX = 10;

    // Attributs
    private int x;
    private int y;
    private int resultat;
    private int reponseJoueur;

    // Constructeur
    public Multiplication(int x, int y) {
        setX(x);
        setY(y);
        setResultat(x, y);
    }

    // Setters
    private void setX(int x) { this.x = x; }
    private void setY(int y) { this.y = y; }
    private void setResultat(int x, int y) { this.resultat = x * y; }
    // Ajouter un setter pour reponseJoueur ?

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getResultat() { return resultat; }
    public int getReponseJoueur() { return reponseJoueur; }

    // Méthodes

    // Vérifier la réponse de l'utilisateur
    public boolean reponseJuste(int reponse) {
        return reponse == resultat; // Utiliser reponseJoueur
    }

}
