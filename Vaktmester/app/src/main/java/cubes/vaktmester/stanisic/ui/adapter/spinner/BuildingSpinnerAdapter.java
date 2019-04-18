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
import cubes.vaktmester.stanisic.data.model.Building;

public class BuildingSpinnerAdapter extends ArrayAdapter<String> {

    private ArrayList<Building> list;

    public BuildingSpinnerAdapter(Context context, ArrayList<Building> list) {
        super(context, R.layout.building_spinner_item);

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
        row = inflater.inflate(R.layout.building_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewBuildingName);
        textView.setText(list.get(position).buildingName);

        return row;

    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        View row;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.building_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewBuildingName);
        textView.setText(list.get(position).buildingName);

        return row;
    }
}
