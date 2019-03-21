package cubes.vaktmester.stanisic.ui.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;

public class LanguageAdapter extends ArrayAdapter<String> {
        private ArrayList<String> list;

    public LanguageAdapter(Context context) {
        super(context, R.layout.spinner_item);

        list = new ArrayList<>();
        list.add("English");
        list.add("Serbian");
        list.add("Norwegian");
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);

        View row = convertView;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.spinner_item,parent,false);

        return row;

    }

    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }
}
