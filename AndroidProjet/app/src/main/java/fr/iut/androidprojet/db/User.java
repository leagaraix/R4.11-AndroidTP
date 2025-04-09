package fr.iut.androidprojet.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String prenom;
    private String nom;

    public User() {
    }

    ///////////////////////////////////////
    // Gestion Parcelable

    protected User(Parcel in) {
        id = in.readLong();
        prenom = in.readString();
        nom = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(prenom);
        dest.writeString(nom);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    ///////////////////////////////////////


    /**
     * Getters et setters
     */

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
