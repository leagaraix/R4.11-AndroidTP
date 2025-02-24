package fr.iut2.androidtp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fr.iut2.androidtp.exercice5Data.Multiplication;
import fr.iut2.androidtp.exercice5Data.TableDeMultiplication;

public class TableMultiplicationActivity extends AppCompatActivity implements View.OnClickListener {

    // Clé pour le passage des données au démarrage de l'activité
    public static final String KEY_NOMBRE_CHOISI = "NOMBRE_CHOISI";

    private Button valider;
    private LinearLayout conteneurLignes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);

        // Récupération des vues
        valider = findViewById(R.id.exercice5_valider_reponses);
        conteneurLignes = findViewById(R.id.exercice5_lignes);

        // Générer la table de multiplication
        int nombreChoisi = getIntent().getIntExtra(KEY_NOMBRE_CHOISI, 1);
        TableDeMultiplication tableDeMultiplication = new TableDeMultiplication(nombreChoisi);
        ArrayList<Multiplication> table = tableDeMultiplication.getTable();

        // INFLATER DYNAMIQUEMENT LES LIGNES
        LayoutInflater inflater = LayoutInflater.from(this);
        for (Multiplication multiplication : table) {
            View ligneView = inflater.inflate(R.layout.exercice5_ligne_table_multiplication, conteneurLignes, false);

            // Remplir les valeurs
            TextView operation = ligneView.findViewById(R.id.exercice5_ligne_multiplication);
            EditText reponse = ligneView.findViewById(R.id.exercice5_reponse);
            operation.setText(getResources().getString(R.string.exercice5_multiplication, multiplication.getX(), multiplication.getY()));

            // Ajouter la ligne
            conteneurLignes.addView(ligneView);
        }

        valider.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // Vérifier les réponses

        // Si elles sont justes
        // Création de l'intention "Felicitations"

        //
    }
}