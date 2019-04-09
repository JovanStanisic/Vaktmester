package cubes.vaktmester.stanisic.ui.activity.tickets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.data.SettingsItem;
import cubes.vaktmester.stanisic.ui.adapter.FiltersExpandableListAdapter;

public class FiltersActivity extends AppCompatActivity {
        private ExpandableListView expListView;
        private ImageView imageViewBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        initComp();
        loadData();
        addListener();
        expListView.setAdapter(new FiltersExpandableListAdapter(getApplicationContext()));

    }

    private void addListener() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initComp() {
        expListView = findViewById(R.id.expandableListView);
        imageViewBack = findViewById(R.id.imageViewBack);
    }

    private void loadData() {
        DataContainer.status = new ArrayList<>();
        DataContainer.priority = new ArrayList<>();
        DataContainer.category = new ArrayList<>();

        DataContainer.status.add(new SettingsItem("0", "New",false));
        DataContainer.status.add(new SettingsItem("1", "Approved",false));
        DataContainer.status.add(new SettingsItem("2", "In Progress",false));
        DataContainer.status.add(new SettingsItem("3", "Resolved",false));
        DataContainer.status.add(new SettingsItem("4", "Closed",false));
        DataContainer.status.add(new SettingsItem("5", "Feedback",false));

        DataContainer.priority.add(new SettingsItem("6", "Low",false));
        DataContainer.priority.add(new SettingsItem("7", "Normal",false));
        DataContainer.priority.add(new SettingsItem("8", "High",false));

        DataContainer.category.add(new SettingsItem("9", "Category 1",false));
        DataContainer.category.add(new SettingsItem("10", "Category 2",false));
        DataContainer.category.add(new SettingsItem("11", "Category 3",false));

    }
}
