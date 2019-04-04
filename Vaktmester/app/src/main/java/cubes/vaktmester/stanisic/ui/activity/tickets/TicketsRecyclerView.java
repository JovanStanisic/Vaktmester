package cubes.vaktmester.stanisic.ui.activity.tickets;

import android.os.Bundle;
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
import cubes.vaktmester.stanisic.ui.adapter.rv.RecyclerViewAdapterFilters;
import cubes.vaktmester.stanisic.ui.adapter.rv.RecyclerViewAdapterTickets;

public class TicketsRecyclerView extends AppCompatActivity {
        private RecyclerView recyclerViewTickets,recyclerViewFilters;
        private RecyclerView.Adapter ticketAdapter,filterAdapter;
        private RecyclerView.LayoutManager layoutManagerTickets, layoutManagerFilters;
        private FloatingActionButton floatSettings, floatAdd;
        private ArrayList<String> filters;
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

        recyclerViewTickets.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0){
                    floatSettings.startAnimation(Animations.animationDown());
                    floatAdd.startAnimation(Animations.animationDown());
                }
                else {
                    floatSettings.startAnimation(Animations.animationUp());
                    floatAdd.startAnimation(Animations.animationUp());
                }
            }
        });
    }

    private void initComp() {
        //inicijalizujem rv za tickets
        layoutManagerTickets = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        ticketAdapter = new RecyclerViewAdapterTickets(DataContainer.tickets);

        recyclerViewTickets = findViewById(R.id.recyclerView);
        recyclerViewTickets.setHasFixedSize(true);
        recyclerViewTickets.setLayoutManager(layoutManagerTickets);
        recyclerViewTickets.setAdapter(ticketAdapter);

        floatAdd = findViewById(R.id.floatingAdd);
        floatSettings = findViewById(R.id.floatingSettings);

        //inicijalizujem rv za filters
        layoutManagerFilters = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        filterAdapter = new RecyclerViewAdapterFilters(filters);

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
        filters.add("Janitor");
        filters.add("Status");
        filters.add("Category");
        filters.add("Priority");

    }
}

//recyclerViewTickets.addOnScrollListener(new RecyclerView.OnScrollListener() {
//@Override
//public void onScrollStateChanged(@NonNull RecyclerView recyclerViewTickets, int newState) {
//        super.onScrollStateChanged(recyclerViewTickets, newState);
//
//
//        if(newState == recyclerViewTickets.SCROLL_STATE_IDLE){
//        floatSettings.startAnimation(Animations.animationUp());
//        floatAdd.startAnimation(Animations.animationUp());
//        }
//        else if(newState == recyclerViewTickets.SCROLL_STATE_DRAGGING){
//        floatSettings.startAnimation(Animations.animationDown());
//        floatAdd.startAnimation(Animations.animationDown());
//        }
//
//        }
//
//        });
