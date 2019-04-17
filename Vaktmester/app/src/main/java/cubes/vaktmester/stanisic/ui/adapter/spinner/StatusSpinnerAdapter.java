package cubes.vaktmester.stanisic.ui.adapter.spinner;

import android.content.Context;
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

public class StatusSpinnerAdapter extends ArrayAdapter<String> {

    private  ArrayList<SettingsItem> list;
    private  Context context;

    public StatusSpinnerAdapter(Context context, ArrayList<SettingsItem> list) {
        super(context, R.layout.status_spinner_item);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        LayoutInflater inflater = LayoutInflater.from(context);
        row = inflater.inflate(R.layout.status_spinner_item, parent, false);

        TextView textView = row.findViewById(R.id.textViewStatusName);

        String statusColon = textView.getText().toString();
        String statusColored = list.get(position).name;
        String status = new StringBuilder().append(statusColon).append(" ").append(statusColored).toString();

        if (statusColored.equalsIgnoreCase("Feedback")) {
            Spannable spannable = new SpannableString(status);
            spannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.Orange)), statusColon.length(), status.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            textView.setText(spannable, TextView.BufferType.SPANNABLE);
        } else {
            textView.setText(status);
        }
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View row;

        LayoutInflater inflater = LayoutInflater.from(context);
        row = inflater.inflate(R.layout.status_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewStatusName);

        String pom = textView.getText().toString();
        textView.setText(new StringBuilder().append(pom).append(" ").append(list.get(position).name).toString());

        return row;
    }
}
