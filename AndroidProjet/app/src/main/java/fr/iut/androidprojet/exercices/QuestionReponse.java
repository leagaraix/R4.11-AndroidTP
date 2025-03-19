package fr.iut.androidprojet.exercices;

public class QuestionReponse {

    // Attributs
    private String question;
    private String reponseJuste;
    private String mauvaiseReponse1;
    private String mauvaiseReponse2;
    private String reponseJoueur;

    // Constructeur
    public QuestionReponse(int idQuestion) {
        // Récupérer la question dans la base de données ?
        setQuestion();
    }

    // Setters
    private void setQuestion(String question) {
        this.question = question;
    }
    public void setReponseJuste(String reponseJuste) {
        this.reponseJuste = reponseJuste;
    }
    public void setMauvaiseReponse1(String mauvaiseReponse1) {
        this.mauvaiseReponse1 = mauvaiseReponse1;
    }
    public void setMauvaiseReponse2(String mauvaiseReponse2) {
        this.mauvaiseReponse2 = mauvaiseReponse2;
    }
    public void setReponseJoueur(String reponseJoueur) {
        this.reponseJoueur = reponseJoueur;
    }

    // Getters
    public String getQuestion() {
        return question;
    }
    public String getReponseJuste() {
        return reponseJuste;
    }
    public String getMauvaiseReponse1() {
        return mauvaiseReponse1;
    }
    public String getMauvaiseReponse2() {
        return mauvaiseReponse2;
    }
    public String getReponseJoueur() {
        return reponseJoueur;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier une réponse de l'utilisateur
    public boolean reponseJuste() {
        return reponseJoueur.equals(reponseJuste);
    }

}
