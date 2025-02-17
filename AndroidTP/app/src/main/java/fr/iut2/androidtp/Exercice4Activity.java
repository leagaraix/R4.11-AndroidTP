package fr.iut2.androidtp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Exercice4Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView instructions;
    private EditText entreePrenom;
    private Button valider;

    ActivityResultLauncher<Intent> activityResultLauncher;     // Attribut dédié à l'attente d'un résultat après le lancement d'une autre activité

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice4);         // On charge le XML pour créer l'arbre graphique

        // Récupération des vues
        instructions = findViewById(R.id.exercice4_instructions);
        entreePrenom = findViewById(R.id.exercice4_entree_prenom);
        valider = findViewById(R.id.exercice4_valider);

        // Initialisation de l'ActivityResultLauncher
         activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            instructions.setText(getResources().getString(R.string.exercice4_nouvelles_instructions));
                            entreePrenom.getText().clear();
                        }
                    }
                }
        );

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
        activityResultLauncher.launch(helloActivity);
    }

}
