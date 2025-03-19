package fr.iut.androidprojet.exercices;

import java.util.ArrayList;

/**
 * Une table de questions-réponses est construite à partir d'un nombre MAX (une constante de la
 * classe TableQuestionReponse) de questions.
 */
public class TableQuestionReponse {

    public static final int MAX = 10; // Nombre de questions -> devrait être tiré de la base de données : combien de questions sont dispo ?

    // Attributs
    private ArrayList<QuestionReponse> table = new ArrayList<>();

    // Constructeur
    public TableQuestionReponse() {
        setTable();
    }


    // COMMENT ACCEDER A LA BASE DE DONNEES A PARTIR D'ICI ?
    // EST-CE QUE TOUT SE PASSE DANS LES ACTIVITES ?
    // EST-CE QU'ON FAIT LES APPELS DANS LE MODELE ?


    // Setters
    public void setTable() {
        for (int i = 1; i <= MAX ; i++) {
            int idQuestion = 1 + (int)(Math.random() * ((MAX - 1) + 1));
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
            if (question.reponseJuste()) {
                nbErreurs++;
            }
        }
        return nbErreurs;
    }

}
