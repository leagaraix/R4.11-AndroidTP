package fr.iut.androidprojet.exercices;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import fr.iut.androidprojet.ChoixExerciceActivity;
import fr.iut.androidprojet.ConsignesActivity;
import fr.iut.androidprojet.OperationActivity;
import fr.iut.androidprojet.R;
import fr.iut.androidprojet.db.User;

public class ResultatsActivity extends AppCompatActivity {

    // Récupérer l'utilisateur sélectionné
    public static final String USER = "USER_KEY";

    // Récupérer l'objet Table
    public static final String TABLE = "TABLE_KEY";

    // VIEW
    private TextView textMessage, textOperation, textReponse;
    private LinearLayout conteneurOperations, conteneurOperation;
    private Button btnRecommencer, btnContinuer, btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        // Récupérer les vues
        textMessage = findViewById(R.id.resultats_textView_message);
        conteneurOperations = findViewById(R.id.resultats_linearLayout_correction);
        btnRecommencer = findViewById(R.id.resultats_button_recommencer);
        btnContinuer = findViewById(R.id.resultats_button_continuerExercice);
        btnChanger = findViewById(R.id.resultats_button_changerExercice);

        // Récupérer l'utilisateur et la table d'opérations
        User currentUser = getIntent().getParcelableExtra(USER);
        Table table = getIntent().getParcelableExtra(TABLE);

        // Afficher les réponses et le résultat
        int nbReponsesJustes = 0;

        for (Operation operation : table.getTableOperations()) {

            // Création des nouvelles vues
            conteneurOperation = new LinearLayout(this);
            textOperation = new TextView(this);
            textReponse = new TextView(this);

            // Mise en page (position, contenu, taille, couleurs)
            conteneurOperation.setGravity(Gravity.CENTER);
            textOperation.setText(getResources().getString(R.string.operation_textView_calcul, operation.getOperande1(), operation.getOperateur(), operation.getOperande2()));
            textReponse.setText(String.valueOf(operation.getReponseJoueur()));
            textOperation.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
            textReponse.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
            if (operation.isReponseJuste()) {
                nbReponsesJustes++;
                textOperation.setTextColor(ContextCompat.getColor(this, R.color.green));
                textReponse.setTextColor(ContextCompat.getColor(this, R.color.green));
            } else {
                textOperation.setTextColor(ContextCompat.getColor(this, R.color.red));
                textReponse.setTextColor(ContextCompat.getColor(this, R.color.red));
            }

            conteneurOperation.addView(textOperation);
            conteneurOperation.addView(textReponse);
            conteneurOperations.addView(conteneurOperation);

        }

        int nbOperations = Table.NB_OPERATIONS;
        if (nbReponsesJustes <= nbOperations/2) {
            textMessage.setText(getResources().getString(R.string.resultats_textView_echec, nbReponsesJustes, nbOperations));
        } else if (nbReponsesJustes >= nbOperations - 2) {
            textMessage.setText(getResources().getString(R.string.resultats_textView_reussite, nbReponsesJustes, nbOperations));
        } else {
            textMessage.setText(getResources().getString(R.string.resultats_textView_pasMal, nbReponsesJustes, nbOperations));
        }

        //////////////////////////////////////////////////////////////////
        // EVENEMENTS
        //////////////////////////////////////////////////////////////////

        // Clic sur le bouton "Recommencer" = ouverture de l'activité Opération, fermeture des activités empilées par-dessus
        btnRecommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnRecommencer = new Intent(ResultatsActivity.this, OperationActivity.class);
                intentBtnRecommencer.putExtra(OperationActivity.USER, currentUser);
                intentBtnRecommencer.putExtra(OperationActivity.TABLE, table);

                // Fermer les activités inutiles
                intentBtnRecommencer.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intentBtnRecommencer);

            }
        });

        // Clic sur le bouton "Continuer" = ouverture de l'activité Consignes, fermeture des activités empilées par-dessus
        btnContinuer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnContinuer = new Intent(ResultatsActivity.this, ConsignesActivity.class);
                intentBtnContinuer.putExtra(ConsignesActivity.USER, currentUser);
                intentBtnContinuer.putExtra(ConsignesActivity.EXERCICE_CHOISI, table.getTypeTable());

                // Fermer les activités inutiles
                intentBtnContinuer.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intentBtnContinuer);

            }
        });

        btnChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnChanger = new Intent(ResultatsActivity.this, ChoixExerciceActivity.class);
                intentBtnChanger.putExtra(ChoixExerciceActivity.USER, currentUser);

                // Fermer les activités inutiles
                intentBtnChanger.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intentBtnChanger);

            }
        });



    }
}