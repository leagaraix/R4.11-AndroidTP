package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice4Activity extends AppCompatActivity implements View.OnClickListener {

    private Button valider;
    private EditText entreePrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice4);

        // Récupération des vues
        valider = findViewById(R.id.exercice4_valider);
        entreePrenom = findViewById(R.id.exercice4_entree_prenom);

        // Ecoute des événements
        valider.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Création de l'intention
        Intent helloActivity = new Intent(Exercice4Activity.this, HelloActivity.class);

        // Passage des données
        helloActivity.putExtra(HelloActivity.PRENOM, entreePrenom.getText().toString());

        // Lancement de la demande de changement d'activité
        startActivity(helloActivity);
    }

}
