package cubes.vaktmester.stanisic.ui.activity.tickets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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
        private FiltersExpandableListAdapter adapter;
        private FloatingActionButton fabSave;
        private int result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        initComp();
        loadData();
        addListener();
        adapter = new FiltersExpandableListAdapter(getApplicationContext());
        expListView.setAdapter(adapter);
        returnIntent();
    }

    private void addListener() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED,returnIntent);
                finish();
            }
        });
        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("checklist", DataContainer.checkedList());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    private void initComp() {
        expListView = findViewById(R.id.expandableListView);
        imageViewBack = findViewById(R.id.imageViewBack);
        fabSave = findViewById(R.id.fabSave);
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

    private void returnIntent(){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("checklist", DataContainer.checkedList());
        setResult(Activity.RESULT_OK,returnIntent);
    }

    }

