package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.iut2.androidtp.exercice5Data.Multiplication;
import fr.iut2.androidtp.exercice5Data.TableDeMultiplication;

public class TableMultiplicationActivity extends AppCompatActivity implements View.OnClickListener {

    // Clé pour le passage des données au démarrage de l'activité
    public static final String KEY_NOMBRE_CHOISI = "NOMBRE_CHOISI";

    private Button valider;
    private LinearLayout conteneurLignes;
    private TableDeMultiplication tableDeMultiplication;
    private ArrayList<EditText> editTexts;

    // Attendre le résultat s'il y a des erreurs
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {

                    // QUE FAIT-ON AVEC LE RESULTAT DE L'ACTIVITE ?

                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        // Récupération des vues
        valider = findViewById(R.id.exercice5_valider_reponses);
        conteneurLignes = findViewById(R.id.exercice5_lignes);

        // Générer la table de multiplication
        int nombreChoisi = getIntent().getIntExtra(KEY_NOMBRE_CHOISI, 1);
        tableDeMultiplication = new TableDeMultiplication(nombreChoisi);
        ArrayList<Multiplication> table = tableDeMultiplication.getTable();

        // INFLATER DYNAMIQUEMENT LES LIGNES
        LayoutInflater inflater = LayoutInflater.from(this);
        editTexts = new ArrayList<>();
        for (Multiplication multiplication : table) {
            View ligneView = inflater.inflate(R.layout.exercice5_ligne_table_multiplication, conteneurLignes, false);

            // Remplir les valeurs
            TextView operation = ligneView.findViewById(R.id.exercice5_ligne_multiplication);
            EditText reponse = ligneView.findViewById(R.id.exercice5_reponse);
            operation.setText(getResources().getString(R.string.exercice5_multiplication, multiplication.getY(), multiplication.getX()));

            // Enregistrer l'EditText dans une liste pour facilement récupérer sa valeur plus tard
            editTexts.add(reponse); // TOI

            // Ajouter la ligne
            conteneurLignes.addView(ligneView);
        }

        valider.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // Quand on clique sur le bouton VALIDER, je veux :
        // - que les réponses du joueur soient enregistrées dans la table
        // - appeler la prochaine activité selon les résultats du joueur


        // Récupérer la table
        ArrayList<Multiplication> table = tableDeMultiplication.getTable();

        // Pour chaque EditText de la liste, récupérer sa valeur et l'enregistrer dans la multiplication correspondante
        for (int i = 0 ; i < editTexts.size() ; i++) {
            String reponse = editTexts.get(i).getText().toString();
            table.get(i).setReponseJoueur(Integer.parseInt(reponse));
        }

        // Vérifier les réponses
        int nbErreurs = tableDeMultiplication.getNbErreurs();


        if (nbErreurs == 0) {
            // Si elles sont toutes justes (nbErreurs == 0)
            // Création de l'intention "Felicitations"

            Intent felicitationsIntent = new Intent(TableMultiplicationActivity.this, FelicitationsActivity.class);
            startActivity(felicitationsIntent);

        } else {
            // Si elles sont fausses (nbErreurs > 0)
            // Création de l'intention "Erreurs"

            Intent erreursIntent = new Intent(TableMultiplicationActivity.this, ErreursActivity.class);
            erreursIntent.putExtra(ErreursActivity.KEY_NB_ERREURS, nbErreurs);
            activityResultLauncher.launch(erreursIntent);

        }

    }
}