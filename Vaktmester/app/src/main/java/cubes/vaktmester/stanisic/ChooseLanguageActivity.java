package cubes.vaktmester.stanisic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ChooseLanguageActivity extends AppCompatActivity {
        private TextView textViewChooseLanguage;
        private Spinner spinner;
        private ArrayAdapter<CharSequence> spinnerAdapter;

        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language_layout);

        initComp();
        
        initSpinner();
    }

    private void initSpinner() {
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.SpinnerLanguages,R.layout.spinner_item);
        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    private void initComp() {
        spinner = findViewById(R.id.languageSpinner);
        textViewChooseLanguage = findViewById(R.id.textViewChoose);
    }
}
