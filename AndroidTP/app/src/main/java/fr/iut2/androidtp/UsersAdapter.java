package fr.iut2.androidtp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.iut2.androidtp.db.User;

public class UsersAdapter extends ArrayAdapter<User> {

    public UsersAdapter(Context mCtx, List<User> userList) {
        super(mCtx, R.layout.template_user, userList);
    }

    /**
     * Remplit une ligne de la listView avec les informations
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération
        final User user = getItem(position);

        // Chargement du template
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewPrenom = (TextView) rowView.findViewById(R.id.text_prenom);
        TextView textViewNom = (TextView) rowView.findViewById(R.id.text_nom);

        textViewPrenom.setText(user.getPrenom());
        textViewNom.setText(user.getNom());

        return rowView;

    }

}
