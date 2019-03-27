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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            //proveravam da li je jezik vec izabran
                            // ako jeste, preskace se ekran za biranje jezika i ide se pravo na login ekran

                            if (SharedPrefs.isFirstTime(LoadingActivity.this)){
                                Intent intent = new Intent(getApplicationContext(), ChooseLanguageActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                finish();
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },1000);
    }
}
