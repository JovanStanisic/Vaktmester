package cubes.vaktmester.stanisic;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {
        private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Intent intent = new Intent(getApplicationContext(), ChooseLanguageActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },3000);

    }
}
