package fr.iut2.androidtp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice1Activity extends AppCompatActivity {

    private TextView helloView;
    private EditText prenomView;
    private Button boutonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Chargement du XML (pour créer l'arbre graphique)
        setContentView(R.layout.activity_exercice1);

        // Récupération des vues (des briques graphiques)
        helloView = findViewById(R.id.exercice1_hello); // Texte à modifier
        prenomView = findViewById(R.id.exercice1_prenom); // Input
        boutonView = findViewById(R.id.exercice1_valider); // Bouton

        // Association des événements

        // Affichage du prénom
        boutonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(prenomView.getText())) {
                    helloView.setText("Hello " + prenomView.getText() + " !");
                }
            }
        });

    }

}
