package fr.iut.androidprojet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.iut.androidprojet.db.User;

public class UsersAdapter extends ArrayAdapter<User> {

    // Permet de garder en mémoire l'utilisateur sélectionné dans la liste
    private int selectedPosition = -1;

    public UsersAdapter(Context mCtxt, List<User> userList) {
        super(mCtxt, R.layout.template_user, userList);
    }

    // Setter pour modifier la position sélectionnée
    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged();
    }

    /**
     * Remplit une ligne de la listView avec les informations de l'utilisateur
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de l'utilisateur
        final User user = getItem(position);
        // Si aucun utilisateur n'est sélectionné, on s'arrête
        if (user == null) { return convertView; }

        // Charge le template
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textPrenomNom = (TextView) rowView.findViewById(R.id.templateUser_text_nomPrenom);
        textPrenomNom.setText(String.format("%s %s", user.getPrenom(), user.getNom()));

        // Vérifier si l'item est sélectionné
        if (position == selectedPosition) {
            rowView.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_purple));
        } else {
            rowView.setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent));
        }

        return rowView;
    }


}
