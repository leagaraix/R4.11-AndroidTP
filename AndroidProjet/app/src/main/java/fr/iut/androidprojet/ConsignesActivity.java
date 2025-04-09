package fr.iut.androidprojet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut.androidprojet.db.User;
import fr.iut.androidprojet.exercices.Table;

public class ConsignesActivity extends AppCompatActivity {

    // Récupérer l'utilisateur sélectionné
    public static final String USER = "USER_KEY";

    // Récupérer l'exercice sélectionné
    public static final String EXERCICE_CHOISI = "EXERCICE_KEY";
    String exercice;

    // VIEW
    TextView textNomExercice, textConsignes;
    Button btnCommencer;
    LinearLayout conteneurNumberPicker;
    NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consignes);

        // Récupérer les vues
        textNomExercice = findViewById(R.id.consignes_textView_nomExercice);
        textConsignes = findViewById(R.id.consignes_textView_consigne);
        btnCommencer = findViewById(R.id.consignes_button_commencer);
        conteneurNumberPicker = findViewById(R.id.consignes_linearLayout_conteneurNumberPicker);

        // Récupérer l'utilisateur
        User currentUser = getIntent().getParcelableExtra(USER);

        //////////////////////////////////////////////////////////////////
        // RÉCUPÉRATION DU CHOIX DE L'EXERCICE + EVENEMENTS ASSOCIÉS
        //////////////////////////////////////////////////////////////////

        exercice = getIntent().getStringExtra(EXERCICE_CHOISI);
        Table table = new Table(exercice);

        textNomExercice.setText(table.getNomExercice());
        textConsignes.setText(table.getConsignes());

        if (exercice.equals("x")) {
            numberPicker = new NumberPicker(this);
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue(10);
            conteneurNumberPicker.addView(numberPicker);
        }

        btnCommencer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Si multiplication, on actualise la table avec la valeur choisie par l'utilisateur
                if (exercice.equals("x")) { table.setTableMultiplication(numberPicker.getValue()); }

                Intent intentBtnCommencer = new Intent(ConsignesActivity.this, OperationActivity.class);
                intentBtnCommencer.putExtra(OperationActivity.USER, currentUser);
                intentBtnCommencer.putExtra(OperationActivity.TABLE, table);
                startActivity(intentBtnCommencer);

            }
        });

    }
}