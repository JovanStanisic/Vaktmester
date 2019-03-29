package cubes.vaktmester.stanisic.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.DataContainer;

public class BuildingDetailActivity extends Activity {
        private ImageView imageViewBack;
        private RelativeLayout rltvTickets, rltvSupp, rltvDoc;
        private TextView textViewContactName,textViewContactNum, textViewBuildingNameHeader,textViewBuildingNameDetail
                , textViewTasksDetail, textViewNotes, textViewBuildingAdressDetail;

        private int position;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_detail_layout);

        initComp();
        addListener();
        fillData();
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
    }

}

