package cubes.vaktmester.stanisic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cubes.vaktmester.stanisic.R;

public class ForgotPassActivity extends AppCompatActivity {
        private EditText editTextEmail;
        private Button buttonConfirm;
        private TextView textViewSet;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass_layout);

        initComp();
    }

    private void initComp() {
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        textViewSet = findViewById(R.id.textViewAllSet);

        textViewSet.setText("Just go to your email inbox, look out for \n the email, and click on the confirmation link. \n \n Then you're all set!");
    }
}
