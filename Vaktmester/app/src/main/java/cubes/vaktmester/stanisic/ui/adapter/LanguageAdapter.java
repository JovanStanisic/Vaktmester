package cubes.vaktmester.stanisic.ui.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;

public class LanguageAdapter extends ArrayAdapter<String> {
        private ArrayList<String> list;

    public LanguageAdapter(Context context) {
        super(context, R.layout.spinner_item);

        list = new ArrayList<>();
        list.add("English");
        list.add("Norwegian");
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        //inflejtujem spinner item i podesavam jezik

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textView);
        textView.setText(list.get(position));

        return row;
    }

    @Override
    public View getDropDownView(int position,  View convertView, ViewGroup parent) {

        //inflejtujem spinner item

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.spinner_item,parent,false);

        //podesavam jezik

        TextView textView = row.findViewById(R.id.textView);
        textView.setText(list.get(position));

        //podesavam zastavu

        ImageView imageView = row.findViewById(R.id.imageFlag);

        if(position == 0){
            imageView.setImageResource(R.drawable.drawable_english);
        }
        else{
            imageView.setImageResource(R.drawable.drawable_norway);
        }
        return row;
    }
}
