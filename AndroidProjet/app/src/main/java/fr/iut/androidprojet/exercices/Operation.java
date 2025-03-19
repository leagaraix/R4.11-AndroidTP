package fr.iut.androidprojet.exercices;

public class Operation {

    // Attributs
    private int operande1;
    private int operande2;
    private String operateur;
    private int resultat;
    private int reponseJoueur;

    // Constructeur
    public Operation(int operande1, int operande2, String operateur) {
        setOperande1(operande1);
        setOperande2(operande2);
        setOperateur(operateur);
        setResultat();
    }

    // Setters
    private void setOperande1(int operande1) { this.operande1 = operande1; }
    private void setOperande2(int operande2) { this.operande2 = operande2; }
    private void setOperateur(String operateur) { this.operateur = operateur; }
    private void setResultat() {
        if (this.operateur.equals("*")) this.resultat = this.operande1 * operande2;
        if (this.operateur.equals("/")) this.resultat = this.operande1 / operande2; // !!! Est-ce qu'on gère les divisions comme ça ? Ou on demande % ?
        if (this.operateur.equals("+")) this.resultat = this.operande1 + operande2;
        if (this.operateur.equals("-")) this.resultat = this.operande1 - operande2;
    }
    public void setReponseJoueur(int reponse) { this.reponseJoueur = reponse; }

    // Getters
    public int getOperande1() { return operande1; }
    public int getOperande2() { return operande2; }
    public String getOperateur() { return operateur; }
    public int getResultat() { return resultat; }
    public int getReponseJoueur() { return reponseJoueur; }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier une réponse de l'utilisateur
    public boolean reponseJuste() {
        return reponseJoueur != resultat;
    }

}
