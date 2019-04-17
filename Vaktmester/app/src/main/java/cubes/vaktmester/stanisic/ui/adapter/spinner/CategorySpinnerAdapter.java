package cubes.vaktmester.stanisic.ui.adapter.spinner;

import android.annotation.SuppressLint;
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

public class CategorySpinnerAdapter extends ArrayAdapter<String> {

    private ArrayList<SettingsItem> list;
    private Context context;

    public CategorySpinnerAdapter(Context context, ArrayList<SettingsItem> list) {
        super(context, R.layout.category_spinner_item);
        this.list = list;
        this.context = context;
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
        row = inflater.inflate(R.layout.category_spinner_item,parent,false);

        TextView textView = row.findViewById(R.id.textViewCategoryName);


        String categoryColon = textView.getText().toString();
        String categoryColored = list.get(position).name;
        String category = new StringBuilder().append(categoryColon).append(" ").append(categoryColored).toString();

        if(categoryColored.equalsIgnoreCase("Category 3")){
            Spannable spannable = new SpannableString(category);
            spannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.Orange)),categoryColon.length(),category.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            textView.setText(spannable, TextView.BufferType.SPANNABLE);
        }
        else{
            textView.setText(category);
        }
        return row;

    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        View row;

        LayoutInflater inflater = LayoutInflater.from(getContext());
        row = inflater.inflate(R.layout.category_spinner_item,parent,false);

        String pom;

        TextView textView = row.findViewById(R.id.textViewCategoryName);
        pom = textView.getText().toString();
        textView.setText(new StringBuilder().append(pom).append(" ").append(list.get(position).name).toString());

        return row;
    }
}
