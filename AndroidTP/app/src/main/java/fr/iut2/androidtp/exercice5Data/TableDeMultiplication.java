package fr.iut2.androidtp.exercice5Data;

import java.util.ArrayList;

/* Une TableDeMultiplication est composée d'un tableau de Multiplication*/
public class TableDeMultiplication {

    private ArrayList<Multiplication> table = new ArrayList<>();

    public TableDeMultiplication(int chiffreChoisi) {
        setTable(chiffreChoisi);
    }

    // Setter
    public void setTable(int chiffreChoisi) {
        for (int i = 1 ; i <= Multiplication.MAX ; i++) {
            table.add(new Multiplication(i, chiffreChoisi));
        }
    }

    // Getter
    public ArrayList<Multiplication> getTable() {
        return table;
    }

}
