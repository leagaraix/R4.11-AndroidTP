package fr.iut.androidprojet.exercices;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Operation implements Parcelable {

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

    ///////////////////////////////////////
    // Gestion Parcelable
    protected Operation(Parcel in) {
        operande1 = in.readInt();
        operande2 = in.readInt();
        operateur = in.readString();
        resultat = in.readInt();
        reponseJoueur = in.readInt();
    }

    public static final Creator<Operation> CREATOR = new Creator<Operation>() {
        @Override
        public Operation createFromParcel(Parcel in) {
            return new Operation(in);
        }

        @Override
        public Operation[] newArray(int size) {
            return new Operation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(operande1);
        dest.writeInt(operande2);
        dest.writeString(operateur);
        dest.writeInt(resultat);
        dest.writeInt(reponseJoueur);
    }
    ///////////////////////////////////////

    // Setters
    private void setOperande1(int operande1) { this.operande1 = operande1; }
    private void setOperande2(int operande2) { this.operande2 = operande2; }
    private void setOperateur(String operateur) { this.operateur = operateur; }
    private void setResultat() {
        if (this.operateur.equals("x")) this.resultat = this.operande1 * operande2;
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
    public boolean isReponseJuste() {
        return reponseJoueur == resultat;
    }

}
