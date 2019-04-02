package cubes.vaktmester.stanisic.ui.activity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.animations.Animations;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.data.Ticket;
import cubes.vaktmester.stanisic.ui.adapter.RecyclerViewAdapter;

public class BuildingTicketsActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;
        private FloatingActionButton floatSettings, floatAdd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_tickets_activity);

        loadData();
        initComp();

    }

    @Override
    protected void onResume() {
        super.onResume();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState > 0){
                    floatSettings.startAnimation(Animations.animationDown());
                    floatAdd.startAnimation(Animations.animationDown());
                }
                else{
                    floatSettings.startAnimation(Animations.animationUp());
                    floatAdd.startAnimation(Animations.animationUp());
                }

            }
        });
    }

    private void initComp() {

        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerViewAdapter(DataContainer.tickets);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        floatAdd = findViewById(R.id.floatingAdd);
        floatSettings = findViewById(R.id.floatingSettings);
    }

    private void loadData() {
        DataContainer.tickets = new ArrayList<>();
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
        DataContainer.tickets.add(new Ticket());
    }
}
