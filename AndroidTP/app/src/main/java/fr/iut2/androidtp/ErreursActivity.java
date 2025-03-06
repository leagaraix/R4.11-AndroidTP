package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ErreursActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_NB_ERREURS = "NB_ERREURS";
    // public static final String KEY_TABLE_DE_MULTIPLICATION = "TABLE_DE_MULTIPLICATION";

    private Button corrigerReponses;
    private Button choisirTable;
    private TextView nbErreursView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreurs);

        corrigerReponses = findViewById(R.id.exercice5_corriger_reponses);
        choisirTable = findViewById((R.id.exercice5_erreurs_choisir_autre_table));
        nbErreursView = findViewById(R.id.exercice5_nombre_erreurs);

        int nbErreurs = getIntent().getIntExtra(KEY_NB_ERREURS, 0);
        nbErreursView.setText(getResources().getString(R.string.exercice5_nombre_erreurs, nbErreurs));

        corrigerReponses.setOnClickListener(this);
        choisirTable.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.exercice5_corriger_reponses) {

            // Retourner à la vue précédente
            // qui doit avoir gardé les mêmes infos (SINON lui renvoyer les infos)
            Intent corrigerReponsesIntent = new Intent();
            setResult(RESULT_OK, corrigerReponsesIntent);
            finish();

        } else if (v.getId() == R.id.exercice5_erreurs_choisir_autre_table) {

            // Fermer les activités précédentes
            // Ouvrir l'activité Exercice5Activity
            Intent autreTableIntent = new Intent(this, Exercice5Activity.class);
            autreTableIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(autreTableIntent);

        }
    }
}