package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelloActivity extends AppCompatActivity implements View.OnClickListener {

    // Définition d'une clé
    public static final String PRENOM = "PRENOM";

    private Button changerPrenom, changerExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hello);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Récupérer le prénom passé par l'intention
        String prenom = getIntent().getStringExtra(PRENOM);
        // Récupération et mise à jour de la vue
        TextView helloPrenom = findViewById(R.id.exercice4_hello_texte);
        helloPrenom.setText(getResources().getString(R.string.exercice4_hello_texte, prenom));

        // Récupération des vues
        changerPrenom = findViewById(R.id.exercice4_changer_prenom);
        changerExercice = findViewById(R.id.exercice4_changer_exercice);

        // Ecoute des événements
        //changerPrenom.setOnClickListener(view -> finish());
        changerPrenom.setOnClickListener(this);
        changerExercice.setOnClickListener(this);

        // En cas de clic sur le bouton retour
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Toast.makeText(HelloActivity.this, "Bouton back", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.exercice4_changer_prenom) {
            Intent retourChangementPrenom = new Intent();
            setResult(RESULT_OK, retourChangementPrenom);
            finish();
        } else if (view.getId() == R.id.exercice4_changer_exercice) {
            // Demande d'intention pour l'activité MainActivity
            Intent retourChangementExercice = new Intent(HelloActivity.this, MainActivity.class);
            retourChangementExercice.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(retourChangementExercice);
        }
    }
}