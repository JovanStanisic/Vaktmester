package cubes.vaktmester.stanisic.ui.activity.tickets;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.model.Borettslag;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.data.model.SettingsItem;
import cubes.vaktmester.stanisic.fragment.DatePickerFragment;
import cubes.vaktmester.stanisic.ui.adapter.spinner.BorretslagAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.BuildingSpinnerAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.CategorySpinnerAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.PrioritySpinnerAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.StatusSpinnerAdapter;

public class EditTicketActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText editTextTaskName,editTextDescription,editTextCreatedBy,editTextUpdatedBy,editTextEstimated;
    private Spinner spinnerBorretslag,spinnerBuilding, spinnerPriority, spinnerCategory,spinnerStatus;
    private ImageView imageBack;
    private TextView textViewDateAdded,textViewDateEnded,textViewDateCreated;
    private FrameLayout frameLayoutDateAdded,frameLayoutDateEnded,frameLayoutDateCreated;
    private boolean addedIsClicked,endedIsClicked,createdIsClicked;
    private ScrollView scrollView;
    private FloatingActionButton fabSave,fabCancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ticket_activity);


        loadData();
        initComp();
        addListener();
    }

    private void loadData() {
        DataContainer.borettslags = new ArrayList<>();
        DataContainer.borettslags.add(new Borettslag("Borretslag name 1"));
        DataContainer.borettslags.add(new Borettslag("Borretslag name 2"));
        DataContainer.borettslags.add(new Borettslag("Borretslag name 3"));
        DataContainer.borettslags.add(new Borettslag("Borretslag name 4"));
        DataContainer.borettslags.add(new Borettslag("Borretslag name 5"));

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

    private void initComp() {
        imageBack = findViewById(R.id.imageViewBack);
        editTextTaskName = findViewById(R.id.editTextTaskName);
        editTextDescription = findViewById(R.id.editTextTaskDesc);

        fabSave = findViewById(R.id.fabSave);
        fabCancel = findViewById(R.id.fabCancel);

        scrollView = findViewById(R.id.scrollable);

        textViewDateAdded = findViewById(R.id.textViewDateAdded);
        textViewDateEnded = findViewById(R.id.textViewDateEnded);
        textViewDateCreated = findViewById(R.id.textViewDateCreated);

        frameLayoutDateAdded = findViewById(R.id.frameLayoutDateAdded);
        frameLayoutDateEnded = findViewById(R.id.frameLayoutDateEnded);
        frameLayoutDateCreated = findViewById(R.id.frameLayoutDateCreated);

        spinnerBorretslag = findViewById(R.id.spinnerBorretslag);
        spinnerBorretslag.setAdapter(new BorretslagAdapter(getApplicationContext(),DataContainer.borettslags));

        spinnerBuilding = findViewById(R.id.spinnerBuilding);
        spinnerBuilding.setAdapter(new BuildingSpinnerAdapter(getApplicationContext(),DataContainer.buildings));

        spinnerPriority = findViewById(R.id.spinnerPriority);
        spinnerPriority.setAdapter( new PrioritySpinnerAdapter(getApplicationContext(),DataContainer.priority));

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerCategory.setAdapter(new CategorySpinnerAdapter(getApplicationContext(),DataContainer.category));

        spinnerStatus = findViewById(R.id.spinnerStatus);
        spinnerStatus.setAdapter(new StatusSpinnerAdapter(getApplicationContext(),DataContainer.status));

        editTextCreatedBy = findViewById(R.id.editTextCreatedBy);
                editTextUpdatedBy = findViewById(R.id.editTextUpdatedBy);
        editTextEstimated = findViewById(R.id.editTextEstimatedTime);
    }

    private void addListener(){
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        frameLayoutDateAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dateAddedPicker = new DatePickerFragment();
                dateAddedPicker.show(getSupportFragmentManager(), "date added picker");
                addedIsClicked = true;
                endedIsClicked = false;
                createdIsClicked = false;
            }
        });

        frameLayoutDateEnded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dateEndedPicker = new DatePickerFragment();
                dateEndedPicker.show(getSupportFragmentManager(), "date ended picker");
                addedIsClicked = false;
                endedIsClicked = true;
                createdIsClicked = false;
            }
        });

        frameLayoutDateCreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dateCreatedPicker = new DatePickerFragment();
                dateCreatedPicker.show(getSupportFragmentManager(), "date created picker");
                addedIsClicked = false;
                endedIsClicked = false;
                createdIsClicked = true;
            }
        });

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int y = scrollView.getScrollY();

                if(y < 0 && !fabSave.isShown() && !fabCancel.isShown()){
                    fabCancel.show();
                    fabSave.show();
                } else if(y > 0 && fabSave.isShown() && fabCancel.isShown()){
                    fabSave.hide();
                    fabCancel.hide();
                }
            }
        });
    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        if(addedIsClicked) {

            String dateAdded = DateFormat.getDateInstance().format(c.getTime());
            String dateAddedColon = textViewDateAdded.getText().toString();
            int splitPointAdded = dateAddedColon.indexOf(":");

            textViewDateAdded.setText(new StringBuilder().append(dateAddedColon.substring(0, splitPointAdded + 1)).append(" ").append(dateAdded).toString());
        }
        else if(endedIsClicked){

            String dateEnded = DateFormat.getDateInstance().format(c.getTime());
            String dateEndedColon = textViewDateEnded.getText().toString();
            int splitPointEnded = dateEndedColon.indexOf(":");
            textViewDateEnded.setText(new StringBuilder().append(dateEndedColon.substring(0,splitPointEnded+1)).append(" ").append(dateEnded));
        }
        else if(createdIsClicked){
            String dateCreated = DateFormat.getDateInstance().format(c.getTime());
            String dateCreatedColon = textViewDateCreated.getText().toString();
            int splitPointCreated = dateCreatedColon.indexOf(":");
            textViewDateCreated.setText(new StringBuilder().append(dateCreatedColon.substring(0,splitPointCreated + 1)).append(" ").append(dateCreated));

        }
    }



}
