package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut2.androidtp.exercice5Data.Multiplication;

public class Exercice5Activity extends AppCompatActivity implements View.OnClickListener {

    private NumberPicker numberPicker;
    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice5);

        // Récupération des vues
        numberPicker = findViewById(R.id.exercice5_number_picker);
        valider = findViewById(R.id.exercice5_valider_choix_chiffre)

        // Choisir les valeurs min et max du NumberPicker
        numberPicker.setMinValue(Multiplication.MIN);
        numberPicker.setMaxValue(Multiplication.MAX);

        // Ecoute des événements
        valider.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // Création de l'intention
        Intent exercice5ActivityIntent = new Intent(Exercice5Activity.this, TableMultiplicationActivity.class);

        // Passage de données
        exercice5ActivityIntent.putExtra()

        // Lancement de la demande de changement d'activité
        startActivity(exercice5ActivityIntent);
    }

}
