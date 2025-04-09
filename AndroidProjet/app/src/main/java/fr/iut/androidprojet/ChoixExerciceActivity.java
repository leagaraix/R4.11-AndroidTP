package fr.iut.androidprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut.androidprojet.db.User;

public class ChoixExerciceActivity extends AppCompatActivity {

    // Récupérer l'utilisateur sélectionné
    public static final String USER = "USER_KEY";

    // VIEW
    private TextView textBonjour;
    private Button btnAdditions, btnSoustractions, btnMultiplications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_exercice);

        // Récupérer les vues
        textBonjour = findViewById(R.id.choixExercice_textView_bonjour);
        btnAdditions = findViewById(R.id.choixExercice_button_additions);
        btnSoustractions = findViewById(R.id.choixExercice_button_soustractions);
        btnMultiplications = findViewById(R.id.choixExercice_button_multiplications);

        // Saluer l'utilisateur
        User currentUser = getIntent().getParcelableExtra(USER);
        textBonjour.setText(getResources().getString(R.string.choixExercice_textView_bonjour, currentUser.getPrenom()));

        //////////////////////////////////////////////////////////////////
        // EVENEMENTS
        //////////////////////////////////////////////////////////////////

        // Clic sur le bouton "Additions" = ouverture de la page Consignes
        btnAdditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnAdditions = new Intent(ChoixExerciceActivity.this, ConsignesActivity.class);
                intentBtnAdditions.putExtra(ConsignesActivity.USER, currentUser);
                intentBtnAdditions.putExtra(ConsignesActivity.EXERCICE_CHOISI, "+");
                startActivity(intentBtnAdditions);

            }
        });

        // Clic sur le bouton "Soustractions" = ouverture de la page Consignes
        btnSoustractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnSoustractions = new Intent(ChoixExerciceActivity.this, ConsignesActivity.class);
                intentBtnSoustractions.putExtra(ConsignesActivity.USER, currentUser);
                intentBtnSoustractions.putExtra(ConsignesActivity.EXERCICE_CHOISI, "-");
                startActivity(intentBtnSoustractions);

            }
        });

        // Clic sur le bouton "Multiplications" = ouverture de la page Consignes
        btnMultiplications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnMultiplications = new Intent(ChoixExerciceActivity.this, ConsignesActivity.class);
                intentBtnMultiplications.putExtra(ConsignesActivity.USER, currentUser);
                intentBtnMultiplications.putExtra(ConsignesActivity.EXERCICE_CHOISI, "x");
                startActivity(intentBtnMultiplications);

            }
        });

        // Clic sur le bouton "Français" = ouverture de la page Consignes
        btnMultiplications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnMultiplications = new Intent(ChoixExerciceActivity.this, ConsignesActivity.class);
                intentBtnMultiplications.putExtra(ConsignesActivity.USER, currentUser);
                intentBtnMultiplications.putExtra(ConsignesActivity.EXERCICE_CHOISI, "fr");
                startActivity(intentBtnMultiplications);

            }
        });

    }
}