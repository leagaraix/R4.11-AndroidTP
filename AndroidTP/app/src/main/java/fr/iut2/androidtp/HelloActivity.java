package fr.iut2.androidtp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelloActivity extends AppCompatActivity {

    public static final String PRENOM = "";

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

        // J'EN SUIS ICIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        // IIIIIIIIIIIIIICCCCIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII


    }
}