package fr.iut2.androidtp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice2Activity extends AppCompatActivity {

    private RadioButton bonneReponse;
    private Button valider;
    private TextView texte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice2);

        // Récupération des vues
        bonneReponse = findViewById(R.id.exercice2_bonne_reponse); // Bouton radio de la bonne réponse
        valider = findViewById(R.id.exercice2_valider); // Bouton de validation
        texte = findViewById(R.id.exercice2_reponse); // Texte à mettre à jour selon la réponse

        // Association des événements

        // ! J'en suis ici

    }
}
