package fr.iut2.androidtp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.iut2.androidtp.exercice3Data.Jeu;
import fr.iut2.androidtp.exercice3Data.Resultat;

public class Exercice3Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView papierOrdinateur, caillouOrdinateur, ciseauxOrdinateur;
    private ImageView papierJoueur, caillouJoueur, ciseauxJoueur;
    private TextView gagnant;
    private TextView nombreVictoires, nombreDefaites, nombreEgalites;

    // Objet Resultat pour conserver les scores de la partie
    Resultat resultat = new Resultat();

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
        gagnant = findViewById(R.id.exercice3_resultat);
        nombreVictoires = findViewById(R.id.exercice3_nombre_victoires);
        nombreDefaites = findViewById(R.id.exercice3_nombre_defaites);
        nombreEgalites = findViewById(R.id.exercice3_nombre_egalites);

        // Ecoute d'un événement sur les images du joueur
        papierJoueur.setOnClickListener(this);
        caillouJoueur.setOnClickListener(this);
        ciseauxJoueur.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // On lance un jeu, qui détermine la main de l'ordinateur
        Jeu jeu = new Jeu();
        // On réinitialise la visibilité et le fond des images
        papierOrdinateur.setVisibility(View.INVISIBLE);
        caillouOrdinateur.setVisibility(View.INVISIBLE);
        ciseauxOrdinateur.setVisibility(View.INVISIBLE);
        papierJoueur.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));
        caillouJoueur.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));
        ciseauxJoueur.setBackgroundColor(getResources().getColor(R.color.black, getTheme()));

        // Afficher la main choisir par l'ordinateur
        switch (jeu.getMainOrdinateur()) {

            case Jeu.PAPIER:
                papierOrdinateur.setVisibility(View.VISIBLE);
                break;

            case Jeu.CAILLOUX:
                caillouOrdinateur.setVisibility(View.VISIBLE);
                break;

            case Jeu.CISEAUX:
                ciseauxOrdinateur.setVisibility(View.VISIBLE);
                break;
        }

        // Associe la vue a une constante
        int idMain;
        if (view.getId() == R.id.joueur_papier) {
            idMain = Jeu.PAPIER;
        } else if (view.getId() == R.id.joueur_caillou) {
            idMain = Jeu.CAILLOUX;
        } else {
            idMain = Jeu.CISEAUX;
        }

        // Afficher la main du joueur
        switch (idMain) {
            // - Enregistrer le choix du joueur dans l'objet Jeu
            // - Encadrer la main choisie en couleur

            case Jeu.PAPIER:
                jeu.setMainJoueur(Jeu.PAPIER);
                papierJoueur.setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                break;

            case Jeu.CAILLOUX:
                jeu.setMainJoueur(Jeu.CAILLOUX);
                caillouJoueur.setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                break;

            case Jeu.CISEAUX:
                jeu.setMainJoueur(Jeu.CISEAUX);
                ciseauxJoueur.setBackgroundColor(getResources().getColor(R.color.green, getTheme()));
                break;
        }

        // Mettre à jour les scores et indiquer le résultat :
        if (jeu.egalite()) {
            resultat.addEgalite();
            nombreEgalites.setText(String.valueOf(resultat.getNombreEgalite()));
            gagnant.setText(getResources().getText(R.string.exercice3_egalite));
        } else if (jeu.joueurGagne()) {
            resultat.addVictoire();
            nombreVictoires.setText(String.valueOf(resultat.getNombreVictoire()));
            gagnant.setText(getResources().getText(R.string.exercice3_victoire));
        } else {
            resultat.addDefaite();
            nombreDefaites.setText(String.valueOf(resultat.getNombreDefaite()));
            gagnant.setText(getResources().getText(R.string.exercice3_defaite));
        }

    }

}
