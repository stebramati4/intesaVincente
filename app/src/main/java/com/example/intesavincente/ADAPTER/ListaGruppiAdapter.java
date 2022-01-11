package com.example.intesavincente.ADAPTER;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.intesavincente.MODEL.Gruppo;
import com.example.intesavincente.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * * Custom Adapter that extends ArrayAdapter to show the groups in a ListView.
 */
public class ListaGruppiAdapter extends ArrayAdapter<Gruppo> {

    private static final String TAG ="ListaGruppiAdapter" ;

    private ArrayList<Gruppo> mArrayGruppi;
    private int mLayout;


    public ListaGruppiAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Gruppo> objects) {
        super(context, resource, objects);
        this.mArrayGruppi = objects;
        this.mLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mLayout, parent, false);
        }

        TextView textViewNomeGruppo = convertView.findViewById(R.id.nome_gruppo);
        textViewNomeGruppo.setText(mArrayGruppi.get(position).getNome());
        Log.d(TAG, "Componenti : "+mArrayGruppi.get(position).getComponenti());
        Log.d(TAG, "Tipo : "+mArrayGruppi.getClass());
        TextView textViewComponenti = convertView.findViewById(R.id.componenti);
        textViewNomeGruppo.setText(mArrayGruppi.get(position).stampaNomeComponenti());

        return convertView;
    }
}

