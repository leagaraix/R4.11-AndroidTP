package fr.iut.androidprojet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fr.iut.androidprojet.db.DatabaseClient;
import fr.iut.androidprojet.db.User;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD = 0;

    // DATA
    private DatabaseClient database;
    private UsersAdapter adapter;
    private User userSelected;


    // VIEW
    private ListView listUsers;
    private Button btnValider, btnAnonyme, btnCreerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupérer le DatabaseClient
        database = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUsers = findViewById(R.id.main_listView);
        btnValider = findViewById(R.id.main_button_valider);
        btnAnonyme = findViewById(R.id.main_button_anonyme);
        btnCreerCompte = findViewById(R.id.main_button_creerCompte);

        // Désactiver le bouton Valider tant qu'aucun utilisateur n'est sélectionné
        btnValider.setEnabled(false);

        // Lier l'adapter au listView
        adapter = new UsersAdapter(this, new ArrayList<>());
        listUsers.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //////////////////////////////////////////////////////////////////
        // EVENEMENTS
        //////////////////////////////////////////////////////////////////

        // Clic sur un utilisateur de la ListView = sélection de l'utilisateur
        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Mettre à jour la position sélectionnée dans l'adapter
                adapter.setSelectedPosition(position);
                // Récupération de l'utilisateur cliqué à l'aide de l'adapter
                userSelected = adapter.getItem(position);
                if (userSelected != null) btnValider.setEnabled(true);

                // TODO (si temps suffisant) :
                // - Pouvoir déselectionné en cliquant de nouveau sur l'utilisateur

            }
        });

        // Clic sur le bouton de validation = ouverture de la page Choix des exercices
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnValidation = new Intent(MainActivity.this, ChoixExerciceActivity.class);
                intentBtnValidation.putExtra(ChoixExerciceActivity.USER, userSelected);
                startActivity(intentBtnValidation);

            }
        });

        // Clic sur le bouton de création de compte = ouverture de la page AddUser
        btnCreerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Ouvrir la page de création d'un compte
                Intent intentBtnCreationCompte = new Intent(MainActivity.this, AddUserActivity.class);
                startActivityForResult(intentBtnCreationCompte, REQUEST_CODE_ADD);

            }
        });

        // Clic sur le bouton pour jouer sans compte = ouverture de la page Choix des exercices
        btnAnonyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentBtnSansCompte = new Intent(MainActivity.this, ChoixExerciceActivity.class);
                startActivity(intentBtnSansCompte);

            }
        });

        // Mise à jour des utilisateurs
        getUsers();

    }


    private void getUsers() {

        // Classe asynchrone permettant de récupérer des utilisateurs,
        // et de mettre à jour la liste d'utilisateurs du ListView
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {

                // Le try-catch permet d'éviter que l'application s'arrête si la  base de données est absente
                try {
                    List<User> userList = database.getAppDatabase()
                            .userDao()
                            .getAll();
                    return userList;
                } catch (Exception e) {
                    Log.e("DEBUG", "Erreur lors de la récupération des utilisateurs", e);
                    return new ArrayList<>();
                }

            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                if (users == null) {
                    users = new ArrayList<>();
                }

                // Mettre à jour l'adapter avec la liste d'utilisateurs
                adapter.clear();
                adapter.addAll(users);
                // Informer l'adapter du changement
                adapter.notifyDataSetChanged();
            }
        }

        // Création d'un objet GetUsers et exécution de la demande asynchrone
        GetUsers gu = new GetUsers();
        gu.execute();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
            // Mise à jour des utilisateurs
            getUsers();
        }
    }

}