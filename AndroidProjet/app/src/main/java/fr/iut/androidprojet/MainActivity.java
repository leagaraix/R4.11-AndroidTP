package fr.iut.androidprojet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fr.iut.androidprojet.db.User;

public class MainActivity extends AppCompatActivity {

    private SearchView searchUser;
    private ListView listUsers;
    private Button btnValider, btnAnonyme, btnCreerCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupérer les vues
        searchUser.findViewById(R.id.main_searchView);
        listUsers.findViewById(R.id.main_listView);
        btnValider.findViewById(R.id.main_button_valider);
        btnAnonyme.findViewById(R.id.main_button_anonyme);
        btnCreerCompte.findViewById(R.id.main_button_creerCompte);

        // Récupérer la recherche


    }


    private void getUsers() {

        // Classe asynchrone permettant de récupérer des tâches et de mettre à jour la liste d'utilisateurs du ListView
        class getUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void voids) {

            }

        }

    }



}