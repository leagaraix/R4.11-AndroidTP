package fr.iut.androidprojet.exercices;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import java.util.ArrayList;

import fr.iut.androidprojet.db.DatabaseClient;
import fr.iut.androidprojet.db.QuestionReponse;
import fr.iut.androidprojet.db.QuestionReponseDao;

public class Table implements Parcelable {

    public static final int NB_OPERATIONS = 10; // Nombre d'opérations ou de questions
    public static final int OPERANDE_MIN_ADD_SOUS = 1; // Nombre minmum autorisé dans les opérations d'addition et de soustraction
    public static final int OPERANDE_MAX_ADD_SOUS = 50; // Nombre maximum autorisé dans les opérations d'addition et de soustraction


    // Attributs
    private String typeTable;
    private ArrayList<Operation> tableOperations = new ArrayList<>();
    private ArrayList<QuestionReponse> tableQR = new ArrayList<>();
    private String nomExercice;
    private String consignes;

    // Constructeur
    public Table(String typeTable) {
        setTable(typeTable);
    }

    ///////////////////////////////////////
    // Gestion Parcelable
    protected Table(Parcel in) {
        typeTable = in.readString();
        tableOperations = in.createTypedArrayList(Operation.CREATOR);
        tableQR = in.createTypedArrayList(QuestionReponse.CREATOR);
        nomExercice = in.readString();
        consignes = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(typeTable);
        dest.writeTypedList(tableOperations);
        dest.writeTypedList(tableQR);
        dest.writeString(nomExercice);
        dest.writeString(consignes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Table> CREATOR = new Creator<Table>() {
        @Override
        public Table createFromParcel(Parcel in) {
            return new Table(in);
        }

        @Override
        public Table[] newArray(int size) {
            return new Table[size];
        }
    };
    ///////////////////////////////////////

    // Setters

    // Créer une table d'opérations en fonction du choix d'opérateur
    public void setTable(String typeTable) {

        // ADDITION
        if (typeTable.equals("+")) {
            setTypeTable(typeTable);
            setNomExercice("Additions");
            setConsignes("Calcule les " + NB_OPERATIONS + " additions.");

            for (int i = 1; i <= NB_OPERATIONS ; i++) {
                int operande1 = OPERANDE_MIN_ADD_SOUS + (int)(Math.random() * ((OPERANDE_MAX_ADD_SOUS - OPERANDE_MIN_ADD_SOUS) + 1));
                int operande2 = OPERANDE_MIN_ADD_SOUS + (int)(Math.random() * ((OPERANDE_MAX_ADD_SOUS - OPERANDE_MIN_ADD_SOUS) + 1));
                this.tableOperations.add(new Operation(operande1, operande2, typeTable));
            }
        }

        // SOUSTRACTION
        else if (typeTable.equals("-")) {
            setTypeTable(typeTable);
            setNomExercice("Soustractions");
            setConsignes("Calcule les " + NB_OPERATIONS + " soustractions.");

            for (int i = 1; i <= NB_OPERATIONS; i++) {
                int operande1 = OPERANDE_MIN_ADD_SOUS + (int) (Math.random() * ((OPERANDE_MAX_ADD_SOUS - OPERANDE_MIN_ADD_SOUS) + 1));
                int operande2 = OPERANDE_MIN_ADD_SOUS + (int) (Math.random() * ((operande1 - OPERANDE_MIN_ADD_SOUS) + 1));
                this.tableOperations.add(new Operation(operande1, operande2, typeTable));
            }

        // MULTIPLICATION : penser à utiliser setTableMultiplication pour créer l'ArrayList d'opérations
        } else if (typeTable.equals("x")) {
            setTypeTable(typeTable);
            setNomExercice("Multiplications");
            setConsignes("Calcule les " + NB_OPERATIONS + " multiplications. Choisis d'abord un nombre à multiplier :");

        // FRANCAIS
        } else if (typeTable.equals("fr")) {

            setTypeTable("fr");
            setNomExercice("Français");
            setConsignes("Coche la bonne réponse.");

            DatabaseClient database = DatabaseClient.getInstance();


            this.tableQR = database.getAppDatabase().questionReponseDao().getQuestions(typeTable, NB_OPERATIONS);
            // Créer une liste de QuestionReponse : donc on fait un appel
            // à la BD pour récupérer 10 QuestionReponse

        } else {
            // TODO : GERER LES EXCEPTIONS
        }

    }

    public void setTableMultiplication(int chiffreChoisi) {
        for (int i = 1 ; i <= NB_OPERATIONS ; i++) {
            tableOperations.add(new Operation(i, chiffreChoisi, typeTable));
        }
    }

    private void setTypeTable(String typeTable) { this.typeTable = typeTable; }
    private void setNomExercice(String nomExercice) { this.nomExercice = nomExercice; }
    private void setConsignes(String consignes) { this.consignes = consignes; }

    // Getters

    public ArrayList<Operation> getTableOperations() { return this.tableOperations; }
    public ArrayList<QuestionReponse> getTableQR() { return this.tableQR; }
    public String getTypeTable() { return this.typeTable; }
    public String getNomExercice() { return this.nomExercice; }
    public String getConsignes() { return this.consignes; }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier toutes les réponses de l'utilisateur dans les opérations
    public int getNbErreurs() {
        int nbErreurs = 0;
        for (Operation operation : this.tableOperations) {
            if (operation.isReponseJuste()) {
                nbErreurs++;
            }
        }
        return nbErreurs;
    }

}