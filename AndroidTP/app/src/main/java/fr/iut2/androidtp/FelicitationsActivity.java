package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FelicitationsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button autreTable;
    private Button autreExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitations);

        autreTable = findViewById(R.id.exercice5_choisir_autre_table);
        autreExercice = findViewById(R.id.exercice5_choisir_autre_exercice);

        autreTable.setOnClickListener(this);
        autreExercice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.exercice5_choisir_autre_table) {

            // Fermer les activités précédentes
            // Ouvrir l'activité Exercice5Activity
            Intent autreTableIntent = new Intent(this, Exercice5Activity.class);
            autreTableIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(autreTableIntent);

        } else if (v.getId() == R.id.exercice5_choisir_autre_exercice) {

            // Fermer les activités précédentes
            // Ouvrir l'activité MainActivity
            Intent autreExerciceIntent = new Intent(this, MainActivity.class);
            autreExerciceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(autreExerciceIntent);

        }
    }
}