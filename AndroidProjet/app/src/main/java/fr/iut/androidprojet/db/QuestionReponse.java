package fr.iut.androidprojet.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity(tableName = "question_reponse")
public class QuestionReponse implements Parcelable {

    // Attributs
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String typeQuestion;
    private String question;
    Map<String, Boolean> reponses = new HashMap<>();

    // Constructeur
    public QuestionReponse() {
    }

    ///////////////////////////////////////
    // Gestion Parcelable
    protected QuestionReponse(Parcel in) {
        id = in.readLong();
        typeQuestion = in.readString();
        question = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(typeQuestion);
        dest.writeString(question);
    }

    public static final Creator<QuestionReponse> CREATOR = new Creator<QuestionReponse>() {
        @Override
        public QuestionReponse createFromParcel(Parcel in) {
            return new QuestionReponse(in);
        }

        @Override
        public QuestionReponse[] newArray(int size) {
            return new QuestionReponse[size];
        }
    };
    ///////////////////////////////////////

    // Setters

    public void setId(long id) { this.id = id; }

    public void setType(String type) { this.typeQuestion = type; }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponses(Map<String, Boolean> reponses) {
        this.reponses = reponses;
    }

    // Getters

    public long getId() {
        return this.id;
    }

    public String getType() {
        return this.typeQuestion;
    }

    public String getQuestion() {
        return this.question;
    }

    public Map<String, Boolean> getReponses() {
        return this.reponses;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Méthodes
    ///////////////////////////////////////////////////////////////////////////////////////////////

    // Vérifier toutes les réponses de l'utilisateur


}
