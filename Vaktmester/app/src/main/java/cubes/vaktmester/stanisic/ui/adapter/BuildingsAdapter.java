package cubes.vaktmester.stanisic.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.model.Building;

public class BuildingsAdapter extends BaseAdapter {
    private Context context;
    public ArrayList<Building> list;

    public BuildingsAdapter(Context context, ArrayList<Building> buildings) {
        this.context = context;
        list = buildings;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = new Holder();

        if(row == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(R.layout.list_view_item,parent,false);

            holder.imageViewBuilding = row.findViewById(R.id.listItemImageView);
            holder.textViewTask = row.findViewById(R.id.textViewTasks);
            holder.textViewName = row.findViewById(R.id.textViewBuildingName);
            holder.textViewAdress = row.findViewById(R.id.textViewBuildingAdress);

            row.setTag(holder);
        }

        else {
            holder = (Holder)row.getTag();

            holder.imageViewBuilding.setImageResource(list.get(position).image);
            holder.textViewName.setText(list.get(position).buildingName);
            holder.textViewAdress.setText(list.get(position).adress);
            holder.textViewTask.setText(list.get(position).tasksCount + " tasks");

        }

        return row;
    }

    public class Holder {
        public ImageView imageViewBuilding;
        public TextView textViewTask, textViewName, textViewAdress;
    }
}
