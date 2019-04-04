package cubes.vaktmester.stanisic.ui.adapter.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;

public class RecyclerViewAdapterFilters extends RecyclerView.Adapter<RecyclerViewAdapterFilters.FilterHolder> {
    private ArrayList<String> filters;
    private String filter;

    public static class FilterHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public FilterHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public RecyclerViewAdapterFilters (ArrayList<String> filters){ this.filters = filters;}

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
    }

    @Override
    public int getItemCount() {
        return filters.size();
    }
}
