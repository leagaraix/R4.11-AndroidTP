package fr.iut2.androidtp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut2.androidtp.db.DatabaseClient;
import fr.iut2.androidtp.db.User;

public class AddUserActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDB;

    // VIEW
    private EditText editTextPrenomView;
    private EditText editTextNomView;
    private Button addUserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Récupération du DatabaseClient
        mDB = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextPrenomView = findViewById(R.id.edit_prenom_user);
        editTextNomView = findViewById(R.id.edit_nom_user);
        addUserView = findViewById(R.id.button_add_user);

        // Associer un événement au bouton Ajouter
        addUserView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { saveUser(); }
        });
    }

    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String sPrenom = editTextPrenomView.getText().toString().trim();
        final String sNom = editTextNomView.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sPrenom.isEmpty()) {
            editTextPrenomView.setError("Champ Prenom requis.");
            editTextPrenomView.requestFocus();
            return;
        }
        if (sNom.isEmpty()) {
            editTextNomView.setError("Champ Nom requis.");
            editTextNomView.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // Créer un utilisateur
                User user = new User();
                user.setPrenom(sPrenom);
                user.setNom(sNom);

                // L'ajouter à la BD
                long id = mDB.getAppDatabase()
                        .userDao()
                        .insert(user);

                // Mettre à jour l'id de l'utilisateur
                // (Nécessaire pour avoir accès à l'id plus tard dans l'activité)
                user.setId(id);

                return user;

            }

            @Override
            protected void onPostExecute (User user) {
                super.onPostExecute(user);

                // Quand l'utilisateur est créé, on arrête l'activité AddUserActivity (on l'enlève de la pile)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Utilisateur sauvegardé", Toast.LENGTH_LONG).show();
            }

        }

        ////////////////////////////
        // Exécuter la demande asynchrone
        SaveUser sU = new SaveUser();
        sU.execute();

    }

}
