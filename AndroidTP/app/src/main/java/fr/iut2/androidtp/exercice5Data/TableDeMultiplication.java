package fr.iut2.androidtp.exercice5Data;

import java.lang.reflect.Array;

/* Une TableDeMultiplication est composée d'un tableau de Multiplication*/
public class TableDeMultiplication {

    private Multiplication[] table;

    public TableDeMultiplication(int chiffreChoisi) {
        setTable(chiffreChoisi);
    }

    // Setter
    public void setTable(int chiffreChoisi) {
        for (int i = 1 ; i <= Multiplication.MAX ; i++) {
            this.table[i - 1] = new Multiplication(i, chiffreChoisi);
        }
    }

    // Getter
    public Multiplication[] getTable() {
        return table;
    }

}
