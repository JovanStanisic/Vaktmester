package cubes.vaktmester.stanisic.ui.adapter.spinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.model.Borettslag;

public class BorretslagAdapter extends ArrayAdapter<String> {

    private ArrayList<Borettslag> list;

    public BorretslagAdapter(Context context, ArrayList<Borettslag> list) {
        super(context, R.layout.borretslag_spinner_item);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.borretslag_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewBorretslagName);
        textView.setText(list.get(position).name);

        return row;

    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        View row;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.borretslag_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewBorretslagName);
        textView.setText(list.get(position).name);

        return row;
    }
}
