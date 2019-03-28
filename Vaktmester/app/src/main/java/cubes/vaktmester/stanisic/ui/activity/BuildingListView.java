package cubes.vaktmester.stanisic.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.data.Building;
import cubes.vaktmester.stanisic.ui.adapter.BuildingsAdapter;

public class BuildingListView extends AppCompatActivity {
        private ImageView imageViewBack, imageViewSearch;
        private EditText editTextSearch;
        private ListView listView;
        private ArrayList<Building> buildingsList;
        private BuildingsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_list_view);


        initComp();
        loadData();

        adapter = new BuildingsAdapter(getApplicationContext(),buildingsList);
        listView.setAdapter(adapter);
    }

    private ArrayList<Building> loadData() {
        buildingsList = new ArrayList<>();

        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        buildingsList.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));


        return buildingsList;

    }

    private void initComp() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewSearch = findViewById(R.id.imageViewSearch);
        editTextSearch = findViewById(R.id.editTextSearch);

        listView = findViewById(R.id.listView);
    }
}
