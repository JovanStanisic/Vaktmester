package cubes.vaktmester.stanisic.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.data.SettingsItem;

public class FiltersExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;

    public FiltersExpandableListAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return 3;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        switch (groupPosition){
            case 0:
                if(DataContainer.status == null){
                    return 0;
                }
                return DataContainer.status.size();

            case 1:
                if(DataContainer.priority == null){
                    return 0;
                }
                return DataContainer.priority.size();

            case 2:
                if(DataContainer.category == null){
                    return 0;
                }
                return DataContainer.category.size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        switch (groupPosition){
            case 0:
                return DataContainer.status.get(childPosition);
            case 1:
                return DataContainer.priority.get(childPosition);
            case 2:
                return DataContainer.category.get(childPosition);
        }
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = new Holder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.filters_list_group,parent,false);
            holder.textView = row.findViewById(R.id.listGroupTextView);
            row.setTag(holder);
        }
        else{
            holder = (Holder) row.getTag();
        }



        switch (groupPosition){
            case 0:
                for(int i = 0; i < DataContainer.status.size(); i++ ){
                    if(DataContainer.status.get(i).isSelected){
                        holder.textView.setTextColor(Color.WHITE);
                        break;
                    }
                    else {
                        holder.textView.setTextColor(context.getResources().getColor(R.color.blueGrayish));
                    }
                }
                holder.textView.setText(context.getString(R.string.filter_adapter_status));
                break;
            case 1:
                for(int i = 0; i < DataContainer.priority.size(); i++ ){
                    if(DataContainer.priority.get(i).isSelected){
                        holder.textView.setTextColor(Color.WHITE);
                        break;
                    }
                    else {
                        holder.textView.setTextColor(context.getResources().getColor(R.color.blueGrayish));
                    }
                }

                holder.textView.setText(context.getString(R.string.filter_adapter_priority));
                break;
            case 2:
                for(int i = 0; i < DataContainer.category.size(); i++ ){
                    if(DataContainer.category.get(i).isSelected){
                        holder.textView.setTextColor(Color.WHITE);
                        break;
                    }
                    else {
                        holder.textView.setTextColor(context.getResources().getColor(R.color.blueGrayish));
                    }
                }
                holder.textView.setText(context.getString(R.string.filter_adapter_category));
                break;
        }

        return row;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, final boolean isLastChild, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = new Holder();
        if(row == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.filters_list_item,parent,false);

            holder.textView = row.findViewById(R.id.listItemTextView);
            holder.childCheckBox = row.findViewById(R.id.checkBox);
            row.setTag(holder);
        }
        else {
            holder = (Holder)row.getTag();
        }

        switch (groupPosition){
            case 0:
                holder.textView.setText(DataContainer.status.get(childPosition).name);
                holder.childCheckBox.setChecked(DataContainer.status.get(childPosition).isSelected);
                break;
            case 1:
                holder.textView.setText(DataContainer.priority.get(childPosition).name);
                holder.childCheckBox.setChecked(DataContainer.priority.get(childPosition).isSelected);
                break;
            case 2:
                holder.textView.setText(DataContainer.category.get(childPosition).name);
                holder.childCheckBox.setChecked(DataContainer.category.get(childPosition).isSelected);
                break;
        }

        holder.childCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(groupPosition == 0){
                    DataContainer.status.get(childPosition).isSelected = !DataContainer.status.get(childPosition).isSelected;
                    notifyDataSetChanged();
                }
                else if(groupPosition == 1){
                    DataContainer.priority.get(childPosition).isSelected = !DataContainer.priority.get(childPosition).isSelected;
                    notifyDataSetChanged();
                }
                else if(groupPosition == 2){
                    DataContainer.category.get(childPosition).isSelected = !DataContainer.category.get(childPosition).isSelected;
                    notifyDataSetChanged();
                }
            }
        });
        return row;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public class Holder {
        public TextView textView;
        public CheckBox childCheckBox;
    }

    }

