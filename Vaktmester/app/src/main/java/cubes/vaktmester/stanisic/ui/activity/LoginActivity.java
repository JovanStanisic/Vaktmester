package cubes.vaktmester.stanisic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.SharedPrefs;
import cubes.vaktmester.stanisic.data.response.LoginModel;
import cubes.vaktmester.stanisic.networking.RetrofitHttpClient;
import cubes.vaktmester.stanisic.utils.animations.DepthTransformation;
import cubes.vaktmester.stanisic.ui.adapter.IntroPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
        private ViewPager viewPager;
        private EditText editTextUser, editTextPass;
        private ImageView fullOval1,fullOval2,fullOval3;
        private Button buttonLogin;
        private TextView forgotPass;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initComp();
        addListener();
        viewPager.setPageTransformer(true, new DepthTransformation());
    }

    private void addListener() {

        editTextUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUser.setCursorVisible(true);
            }
        });

        editTextPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextPass.setCursorVisible(true);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RetrofitHttpClient.getApiClient().login(editTextUser.getText().toString(),editTextPass.getText().toString()).enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        if(response.body().success){
                            SharedPrefs.saveToken(getApplicationContext(),response.body().data);
                            //idem na mejn
                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),response.body().message,Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {

                    }
                });

            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPassActivity.class));
                finish();
            }
        });

        //changelistener koji menja kruzice kad se stranica promeni

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

                switch (i){
                    case 0:
                        fullOval1.setVisibility(View.VISIBLE);
                        fullOval2.setVisibility(View.INVISIBLE);
                        fullOval3.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        fullOval2.setVisibility(View.VISIBLE);
                        fullOval1.setVisibility(View.INVISIBLE);
                        fullOval3.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        fullOval3.setVisibility(View.VISIBLE);
                        fullOval1.setVisibility(View.INVISIBLE);
                        fullOval2.setVisibility(View.INVISIBLE);
                        break;
                }

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initComp() {
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new IntroPagerAdapter(getSupportFragmentManager()));
        editTextUser = findViewById(R.id.editTextUser);
        editTextPass = findViewById(R.id.editTextPass);
        fullOval1 = findViewById(R.id.fullOval1);
        fullOval2 = findViewById(R.id.fullOval2);
        fullOval3 = findViewById(R.id.fullOval3);
        buttonLogin = findViewById(R.id.buttonLogin);
        forgotPass = findViewById(R.id.forgotPassword);

    }
}
