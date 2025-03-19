package fr.iut.androidprojet.exercices;

import java.util.ArrayList;

/**
 * Une table de multiplication est construite à partir d'un chiffre choisi par l'utilisateur.
 * Ce chiffre est multiplié de 1 à MAX (qui est une constante de la classe TableMultiplication).
 */
public class TableMultiplication {

    public static final String OPERATEUR = "*";
    public static final int MAX = 10;

    // Attributs
    private ArrayList<Operation> table = new ArrayList<>();

    // Constructeur
    public TableMultiplication(int chiffreChoisi) {
        setTable(chiffreChoisi);
    }

    // Setters
    public void setTable(int chiffreChoisi) {
        for (int i = 1 ; i <= MAX ; i++) {
            table.add(new Operation(i, chiffreChoisi, OPERATEUR));
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
