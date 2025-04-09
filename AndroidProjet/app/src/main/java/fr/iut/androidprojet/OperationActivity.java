package fr.iut.androidprojet;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.iut.androidprojet.db.User;
import fr.iut.androidprojet.exercices.Operation;
import fr.iut.androidprojet.exercices.ResultatsActivity;
import fr.iut.androidprojet.exercices.Table;

public class OperationActivity extends AppCompatActivity {

    // Récupérer l'utilisateur sélectionné
    public static final String USER = "USER_KEY";

    // Récupérer l'objet Table
    public static final String TABLE = "TABLE_KEY";

    // VIEW
    private TextView textCalcul, textNbOperations;
    private EditText editReponse;
    private Button btnSuivant;

    // Parcours des opérations
    private int index = 0;
    private ArrayList<Operation> operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        // Récupérer les vues
        textCalcul = findViewById(R.id.operation_textView_calcul);
        textNbOperations = findViewById(R.id.operation_textView_nbOperations);
        editReponse = findViewById(R.id.operation_editText_reponse);
        btnSuivant = findViewById(R.id.operation_button_suivant);

        // Récupérer l'utilisateur et la table d'opérations
        User currentUser = getIntent().getParcelableExtra(USER);
        Table table = getIntent().getParcelableExtra(TABLE);
        operations = table.getTableOperations();

        // Afficher la première opération
        afficherOperation();

        //////////////////////////////////////////////////////////////////
        // EVENEMENTS
        //////////////////////////////////////////////////////////////////

        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Récupérer la réponse de l'utilisateur
                Operation operation = operations.get(index);
                if (!editReponse.getText().toString().equals("")) {
                    operation.setReponseJoueur(parseInt(editReponse.getText().toString()));
                }

                if (index < operations.size() - 1) {
                    index++;
                    afficherOperation();

                } else {

                    // Ouvrir l'activité suivante
                    Intent intentBtnSuivant = new Intent(OperationActivity.this, ResultatsActivity.class);
                    intentBtnSuivant.putExtra(ResultatsActivity.USER, currentUser);
                    intentBtnSuivant.putExtra(ResultatsActivity.TABLE, table);
                    startActivity(intentBtnSuivant);

                }

            }
        });

        // - Voir pour afficher le clavier automatiquement, et que ce soit un clavier chiffré

    }

    private void afficherOperation() {
        Operation operation = operations.get(index);
        textCalcul.setText(getResources().getString(R.string.operation_textView_calcul, operation.getOperande1(), operation.getOperateur(), operation.getOperande2()));
        textNbOperations.setText(getResources().getString(R.string.operation_textView_nbOperations, index + 1, Table.NB_OPERATIONS));
        editReponse.setText("");
    }

}