package cubes.vaktmester.stanisic.ui.adapter.spinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.SettingsItem;

public class PrioritySpinnerAdapter extends ArrayAdapter<String> {

    private ArrayList<SettingsItem> list;
    private Context context;

    public PrioritySpinnerAdapter(Context context, ArrayList<SettingsItem> list) {
        super(context, R.layout.priority_spinner_item);
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
        row = inflater.inflate(R.layout.priority_spinner_item,parent,false);

        String setPom;
        setPom = list.get(position).name;
        if(setPom.equalsIgnoreCase("High")){
            Spannable spann = new SpannableString(setPom);
            spann.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFF592C")),0,setPom.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        String pom;
        TextView textView = row.findViewById(R.id.textViewPriority);
        pom = textView.getText().toString();

        textView.setText(new StringBuilder().append(pom).append(list.get(position).name).toString(), TextView.BufferType.SPANNABLE);

        return row;
    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        View row;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.priority_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewPriority);
        textView.setText(list.get(position).name);

        return row;
    }
}
