package cubes.vaktmester.stanisic.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.SharedPrefs;

public class LoadingActivity extends Activity {
        private Handler handler = new Handler();
        private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        prefs = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (SharedPrefs.isFirstTime(LoadingActivity.this)){
                                Intent intent = new Intent(getApplicationContext(), ChooseLanguageActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },3000);


                // default value je true, jer ako nije setovan jezik
                // izaci ce ekran za biranje jezika



    }
}
