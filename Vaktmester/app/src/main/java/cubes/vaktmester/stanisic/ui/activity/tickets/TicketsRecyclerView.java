package cubes.vaktmester.stanisic.ui.activity.tickets;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.data.SettingsItem;
import cubes.vaktmester.stanisic.data.Ticket;
import cubes.vaktmester.stanisic.ui.adapter.rv.RecyclerViewAdapterFilters;
import cubes.vaktmester.stanisic.ui.adapter.rv.RecyclerViewAdapterTickets;

public class TicketsRecyclerView extends AppCompatActivity {
        private RecyclerView recyclerViewTickets,recyclerViewFilters;
        private RecyclerView.Adapter ticketAdapter,filterAdapter;
        private RecyclerView.LayoutManager layoutManagerTickets, layoutManagerFilters;
        private FloatingActionButton floatSettings, floatAdd;
        private ArrayList<String> filters;
        private ImageView imageViewBack;
        private TextView activeFilters;
        private boolean isDragged;
        private int result;
        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_tickets_activity);

        loadData();
        initComp();
        addListener();
        }

    private void initComp() {

            imageViewBack = findViewById(R.id.imageViewBack);
        //inicijalizujem rv za tickets
        layoutManagerTickets = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        ticketAdapter = new RecyclerViewAdapterTickets(DataContainer.tickets);

        recyclerViewTickets = findViewById(R.id.recyclerView);
        recyclerViewTickets.setHasFixedSize(true);
        recyclerViewTickets.setLayoutManager(layoutManagerTickets);
        recyclerViewTickets.setAdapter(ticketAdapter);

        floatAdd = findViewById(R.id.floatingAdd);
        floatSettings = findViewById(R.id.floatingSettings);
        activeFilters = findViewById(R.id.activeFilters);

        //inicijalizujem rv za filters
        layoutManagerFilters = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        filterAdapter = new RecyclerViewAdapterFilters(filters,getApplicationContext());

        recyclerViewFilters = findViewById(R.id.recyclerViewFilters);
        recyclerViewFilters.setHasFixedSize(true);
        recyclerViewFilters.setLayoutManager(layoutManagerFilters);
        recyclerViewFilters.setAdapter(filterAdapter);
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

        filters = new ArrayList<>();
        filters.add("Status");
        filters.add("Priority");
        filters.add("Category");

    }
    private void addListener(){
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        floatSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TicketsRecyclerView.this, FiltersActivity.class);
                startActivityForResult(intent,0);
            }
        });

        recyclerViewTickets.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy<0 && !floatAdd.isShown() && !floatSettings.isShown()) {
                    floatAdd.show();
                    floatSettings.show();
                }
                else if (dy > 0 && floatAdd.isShown() && floatSettings.isShown()){
                    floatAdd.hide();
                    floatSettings.hide();
                }
                }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            if(resultCode == Activity.RESULT_OK) {
                Toast.makeText(this,"on activity result",Toast.LENGTH_LONG).show();
                activeFilters.setVisibility(View.VISIBLE);
                recyclerViewFilters.setVisibility(View.VISIBLE);
            }
        }
    }


}




