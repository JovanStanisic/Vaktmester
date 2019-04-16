package cubes.vaktmester.stanisic.ui.activity.tickets;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.Borettslag;
import cubes.vaktmester.stanisic.data.DataContainer;
import cubes.vaktmester.stanisic.data.SettingsItem;
import cubes.vaktmester.stanisic.ui.adapter.spinner.BorretslagAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.BuildingSpinnerAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.CategorySpinnerAdapter;
import cubes.vaktmester.stanisic.ui.adapter.spinner.PrioritySpinnerAdapter;

public class EditTicketActivity extends AppCompatActivity {

    private EditText editTextTaskName;
    private EditText editTextDescription;
    private Spinner spinnerBorretslag,spinnerBuilding, spinnerPriority, spinnerCategory;
    private ImageView imageBack;
    private  Calendar calendar;
    private TextView textViewDateAdded;
    private FrameLayout frameLayoutDateAdded;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_ticket_activity);


        loadData();
        initComp();
        initDate();
        addListener();
    }

    private void initDate() {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                // TODO Auto-generated method stub
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        frameLayoutDateAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditTicketActivity.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        textViewDateAdded.setText(sdf.format(calendar.getTime()));

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
        textViewDateAdded = findViewById(R.id.textViewDateAdded);
        frameLayoutDateAdded = findViewById(R.id.frameLayoutDateAdded);

        calendar = Calendar.getInstance();


        spinnerBorretslag = findViewById(R.id.spinnerBorretslag);
        spinnerBorretslag.setAdapter(new BorretslagAdapter(getApplicationContext(),DataContainer.borettslags));

        spinnerBuilding = findViewById(R.id.spinnerBuilding);
        spinnerBuilding.setAdapter(new BuildingSpinnerAdapter(getApplicationContext(),DataContainer.buildings));

        spinnerPriority = findViewById(R.id.spinnerPriority);
        spinnerPriority.setAdapter( new PrioritySpinnerAdapter(getApplicationContext(),DataContainer.priority));

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerCategory.setAdapter(new CategorySpinnerAdapter(getApplicationContext(),DataContainer.category));
    }

    private void addListener(){
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
