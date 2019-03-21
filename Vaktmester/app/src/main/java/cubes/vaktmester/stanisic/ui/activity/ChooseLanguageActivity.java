package cubes.vaktmester.stanisic.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.SharedPrefs;

public class ChooseLanguageActivity extends Activity {
        private TextView textViewChooseLanguage;
        private Spinner spinner;
        private ArrayAdapter<CharSequence> spinnerAdapter;
        private Button confirmButton;

        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);

        initComp();
        addListener();
        
        initSpinner();
    }

    private void addListener() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(ChooseLanguageActivity.this,LoginActivity.class));
               finish();
                SharedPrefs.setFirstTime(ChooseLanguageActivity.this);
            }
        });
    }



    private void initSpinner() {

            // inicijalizujem spinner za odabir jezika

        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.SpinnerLanguages,R.layout.spinner_item);
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void initComp() {
        spinner = findViewById(R.id.languageSpinner);
        textViewChooseLanguage = findViewById(R.id.textViewChoose);
        confirmButton = findViewById(R.id.buttonConfirm);
    }
}
