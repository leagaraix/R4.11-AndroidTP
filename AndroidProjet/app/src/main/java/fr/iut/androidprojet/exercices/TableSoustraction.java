package fr.iut.androidprojet.exercices;

import java.util.ArrayList;

/**
 * Une table de soustraction est construite à partir de deux opérandes aléatoires (la deuxième étant
 * inférieure à la première), dans les limites de MIN et MAX (des constantes de la classe
 * TableSoustraction).
 */
public class TableSoustraction {

    public static final String OPERATEUR = "-";
    public static final int MAX = 10; // Nombre d'opérations
    public static final int OPERANDE_MIN = 1; // Nombre minmum autorisé dans les opérations
    public static final int OPERANDE_MAX = 50; // Nombre maximum autorisé dans les opérations

    // Attributs
    private ArrayList<Operation> table = new ArrayList<>();

    // Constructeur
    public TableSoustraction() {
        setTable();
    }

    // Setters
    public void setTable() {
        int operande1 = OPERANDE_MIN + (int)(Math.random() * ((OPERANDE_MAX - OPERANDE_MIN) + 1));
        int operande2 = OPERANDE_MIN + (int)(Math.random() * ((operande1 - OPERANDE_MIN) + 1));
        for (int i = 1; i <= MAX ; i++) {
            table.add(new Operation(operande1, operande2, OPERATEUR));
        }
    }

    // Getters
    public ArrayList<Operation> getTable() {
        return table;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier toutes les réponses de l'utilisateur
    public int getNbErreurs() {
        int nbErreurs = 0;
        for (Operation operation : table) {
            if (operation.reponseJuste()) {
                nbErreurs++;
            }
        }
        return nbErreurs;
    }

}
