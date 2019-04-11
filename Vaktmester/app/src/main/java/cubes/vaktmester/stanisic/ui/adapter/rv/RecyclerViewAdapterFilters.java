package cubes.vaktmester.stanisic.ui.adapter.rv;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.DataContainer;

public class RecyclerViewAdapterFilters extends RecyclerView.Adapter<RecyclerViewAdapterFilters.FilterHolder> {
    private ArrayList<String> filters;
    private String filter;
    private Context context;

    public static class FilterHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public FilterHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            itemView.setTag(textView);
        }
    }

    public RecyclerViewAdapterFilters (ArrayList<String> filters,Context context){
        this.context = context;
        this.filters = filters;}

    @NonNull
    @Override
    public FilterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filter_rv_item,viewGroup,false);
        return new FilterHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterHolder filterHolder, int i) {
        filter = filters.get(i);
        filterHolder.textView.setText(filter);

        if(i==0) {
            if (DataContainer.isChecked(0)) {
                filterHolder.textView.setBackgroundColor(Color.GRAY);
            } else{
                filterHolder.textView.setBackgroundColor(context.getResources().getColor(R.color.Blue));
            }
        }

        if(i==1) {
            if (DataContainer.isChecked(1)) {
                filterHolder.textView.setBackgroundColor(Color.GRAY);
            } else{
                filterHolder.textView.setBackgroundColor(context.getResources().getColor(R.color.Blue));
            }
        }

        if(i==2) {
            if (DataContainer.isChecked(2)) {
                filterHolder.textView.setBackgroundColor(Color.GRAY);
            } else{
                filterHolder.textView.setBackgroundColor(context.getResources().getColor(R.color.Blue));
            }
        }


    }

    @Override
    public int getItemCount() {
        return filters.size();
    }
}
