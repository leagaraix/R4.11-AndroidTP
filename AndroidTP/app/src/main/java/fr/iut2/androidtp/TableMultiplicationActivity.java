package fr.iut2.androidtp;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fr.iut2.androidtp.exercice5Data.Multiplication;

public class TableMultiplicationActivity extends AppCompatActivity {

    // Clé pour le passage des données au démarrage de l'activité
    public static final String

    private Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_table_multiplication);

        // Afficher les lignes de la table de multiplication
        for (Multiplication multiplication : ta)

        // Récupération des vues
        valider = findViewById(R.id.exercice5_valider_reponses);



    }
}