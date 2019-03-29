package cubes.vaktmester.stanisic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.animations.Animations;
import cubes.vaktmester.stanisic.data.Building;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.ui.adapter.BuildingsAdapter;

public class BuildingListView extends AppCompatActivity {
        private ImageView imageViewBack, imageViewSearch;
        private EditText editTextSearch;
        private ListView listView;
        private ArrayList<Building> buildings;
        private BuildingsAdapter adapter;
        private Handler handler = new Handler();
        public TranslateAnimation animationRight = Animations.animationRight();
        public TranslateAnimation animationLeft = Animations.animationLeft();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_list_view);

        initComp();
        loadData();
        addListener();

        adapter = new BuildingsAdapter(getApplicationContext(),DataContainer.buildings);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                LayoutAnimationController controller = new LayoutAnimationController(animationRight, 0.2f);
                listView.setLayoutAnimation(controller);

                if(controller.isDone()){
                    //post delay da bi se animacija controllera odradila do kraja
                    //ulazim u detail activity po zavrsetku kontrolera
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            try{
                                Intent intent = new Intent(getApplicationContext(), BuildingDetailActivity.class);
                                intent.putExtra("position",position);
                                startActivity(intent);
                            } catch (Exception e){
                                e.printStackTrace();
                            }

                        }
                    },700);
                }
            }
        });

        listView.setAdapter(adapter);
    }

    private void addListener() {

        editTextSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSearch.setCursorVisible(true);
            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadData() {
        DataContainer.buildings = new ArrayList<>();

        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));
        DataContainer.buildings.add(new Building("Building name","Bul. Mihajla Pupina 183, Novi Beograd",2, R.drawable.bitmap));

    }

    private void initComp() {
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewSearch = findViewById(R.id.imageViewSearch);
        editTextSearch = findViewById(R.id.editTextSearch);

        listView = findViewById(R.id.listView);
    }
}
