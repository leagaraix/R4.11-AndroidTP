package fr.iut.androidprojet.exercices;

import java.util.ArrayList;

/**
 * Une table de questions-réponses est construite à partir d'un nombre MAX (une constante de la
 * classe TableQuestionReponse) de questions.
 */
public class TableQuestionReponse {

    public static final int NB_QUESTIONS = 10; // Nombre de questions

    // Attributs
    private ArrayList<QuestionReponse> table = new ArrayList<>();

    // Constructeur
    public TableQuestionReponse() {
        setTable();
    }

    // Setters
    public void setTable() {
        for (int i = 1; i <= NB_QUESTIONS ; i++) {
            int idQuestion = 1 + (int)(Math.random() * ((NB_QUESTIONS - 1) + 1));
            table.add(new QuestionReponse(idQuestion));
        }
    }

    // Getters
    public ArrayList<QuestionReponse> getTable() {
        return table;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier toutes les réponses de l'utilisateur
    public int getNbErreurs() {
        int nbErreurs = 0;
        for (QuestionReponse question : table) {
            if (question.isReponseJuste()) {
                nbErreurs++;
            }
        }
        return nbErreurs;
    }

}
