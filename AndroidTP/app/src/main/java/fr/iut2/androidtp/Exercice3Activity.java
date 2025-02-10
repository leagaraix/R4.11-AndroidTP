package fr.iut2.androidtp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut2.androidtp.exercice3Data.Jeu;

public class Exercice3Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView papierOrdinateur, caillouOrdinateur, ciseauxOrdinateur;
    private ImageView papierJoueur, caillouJoueur, ciseauxJoueur;
    private TextView resultat;
    private TextView nombreVictoires, nombreDefaites, nombreEgalites;

    private int victoires = 0;
    private int defaites = 0;
    private int egalites = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice3);

        // Récupération des vues de l'ordinateur
        papierOrdinateur = findViewById(R.id.ordinateur_papier);
        caillouOrdinateur = findViewById(R.id.ordinateur_caillou);
        ciseauxOrdinateur = findViewById(R.id.ordinateur_ciseaux);

        // Récupération des vues du joueur
        papierJoueur = findViewById(R.id.joueur_papier);
        caillouJoueur = findViewById(R.id.joueur_caillou);
        ciseauxJoueur = findViewById(R.id.joueur_ciseaux);

        // Récupération des textes pour les scores et le résultat
        resultat = findViewById(R.id.exercice3_resultat);
        nombreVictoires = findViewById(R.id.exercice3_nombre_victoires);
        nombreDefaites = findViewById(R.id.exercice3_nombre_defaites);
        nombreEgalites = findViewById(R.id.exercice3_nombre_egalites);

        // Ecoute d'un événement sur les images du joueur
        papierJoueur.setOnClickListener(this);
        caillouJoueur.setOnClickListener(this);
        ciseauxJoueur.setOnClickListener(this);

        // On attend que le joueur joue
        // Quand il clique sur une image, on lance un nouveau jeu
        // On set la MainJoueur du nouveau jeu
        // On appelle la méthode egalite() sur le jeu
        // Puis la méthode joueurGagne()

    }

    @Override
    public void onClick(View view) {

        Jeu jeu = new Jeu();

        switch (view.getId()) {

            case R.id.joueur_papier:
                jeu.setMainJoueur(Jeu.PAPIER);

                break;

            case R.id.joueur_caillou:
                jeu.setMainJoueur(Jeu.CAILLOUX);
                break;

            case R.id.joueur_ciseaux:
                jeu.setMainJoueur(Jeu.CISEAUX);
                break;

        }
    }

}
