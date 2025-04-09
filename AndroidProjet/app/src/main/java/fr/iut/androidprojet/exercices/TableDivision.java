package fr.iut.androidprojet.exercices;

import java.util.ArrayList;

/**
 * Une table de division est construite à partir d'un chiffre choisi par l'utilisateur.
 * Ce chiffre divise les premiers nombres (la limite étant MAX, une constante de la classe
 * TableDivision) dont la division donne un résultat entier.
 */
public class TableDivision {

    public static final String OPERATEUR = "/";
    public static final int MAX = 10;
    public static final String EXERCICE = "Divisions";
    public static final String CONSIGNES = "Calcule la division.";

    // Attributs
    private ArrayList<Operation> table = new ArrayList<>();

    // Constructeur
    public TableDivision(int chiffreChoisi) {
        setTable(chiffreChoisi);
    }

    // Setters
    public void setTable(int chiffreChoisi) {
        int dividende = 0;
        for (int i = 1 ; i <= MAX ; i++) {
            dividende += chiffreChoisi;
            table.add(new Operation(dividende, chiffreChoisi, OPERATEUR));
        }
    }

    // Getters
    public ArrayList<Operation> getTable() {
        return table;
    }
    public String getConsignes() { return CONSIGNES; }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier toutes les réponses de l'utilisateur
    public int getNbErreurs() {
        int nbErreurs = 0;
        for (Operation operation : table) {
            if (operation.isReponseJuste()) {
                nbErreurs++;
            }
        }
        return nbErreurs;
    }

}
