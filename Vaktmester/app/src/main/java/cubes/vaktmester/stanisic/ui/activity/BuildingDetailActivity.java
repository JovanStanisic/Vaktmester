package cubes.vaktmester.stanisic.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.utils.animations.Animations;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.ui.activity.tickets.TicketsRecyclerView;

public class BuildingDetailActivity extends Activity {
        private ImageView imageViewBack;
        private RelativeLayout rltvTickets, rltvSupp, rltvDoc;
        private LinearLayout linearLayout1,linearLayout2, linearFooter;
        private TextView textViewContactName,textViewContactNum, textViewBuildingNameHeader,textViewBuildingNameDetail
                , textViewTasksDetail, textViewNotes, textViewBuildingAdressDetail;
        private FrameLayout viewMap;

        private int position;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_detail_layout);

        initComp();
        addListener();
        fillData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAnimations();
    }

    private void fillData() {
        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);

        textViewContactName.setText(DataContainer.buildings.get(position).contactName);
        textViewContactNum.setText(DataContainer.buildings.get(position).contactPhone);
        textViewBuildingAdressDetail.setText(DataContainer.buildings.get(position).adress);
        textViewBuildingNameHeader.setText(DataContainer.buildings.get(position).buildingName);
        textViewBuildingNameDetail.setText(DataContainer.buildings.get(position).buildingName);
        textViewNotes.setText(DataContainer.buildings.get(position).notes);
        textViewTasksDetail.setText(String.valueOf(DataContainer.buildings.get(position).tasksCount) + " tasks");
    }

    private void addListener() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuildingMapActivity.class);
                startActivity(intent);
            }
        });

        rltvTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuildingDetailActivity.this, TicketsRecyclerView.class));
            }
        });
    }

    private void initComp() {
        imageViewBack = findViewById(R.id.imageViewBack);
        rltvTickets = findViewById(R.id.rltvTickets);
        rltvSupp = findViewById(R.id.rltvSupplier);
        rltvDoc = findViewById(R.id.rltvDocuments);
        textViewContactName = findViewById(R.id.textViewContactName);
        textViewContactNum =findViewById(R.id.textViewContactNum);
        textViewBuildingNameHeader = findViewById(R.id.textViewHeader);
        textViewBuildingNameDetail = findViewById(R.id.textViewBuildingNameDetail);
        textViewTasksDetail = findViewById(R.id.textViewTasksDetail);
        textViewNotes = findViewById(R.id.textViewNotes);
        textViewBuildingAdressDetail = findViewById(R.id.textViewBuildingAdressDetail);

        viewMap = findViewById(R.id.frameViewMap);


        //lejautovi za animacije
        linearLayout1 = findViewById(R.id.linearLayout1);
        linearFooter = findViewById(R.id.linearFooter);
        linearLayout2 = findViewById(R.id.linearLayout2);
    }

    private void setAnimations(){
        //animacije za lejautove

        LayoutAnimationController controller = new LayoutAnimationController(Animations.animationLeft(), 0.2f);

        linearLayout1.setLayoutAnimation(controller);
        linearFooter.setLayoutAnimation(controller);
        linearLayout2.setLayoutAnimation(controller);
    }

}

