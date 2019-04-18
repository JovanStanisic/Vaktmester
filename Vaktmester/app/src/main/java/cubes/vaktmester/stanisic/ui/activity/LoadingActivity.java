package cubes.vaktmester.stanisic.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.SharedPrefs;
import cubes.vaktmester.stanisic.data.model.Token;
import cubes.vaktmester.stanisic.data.response.LoginModel;
import cubes.vaktmester.stanisic.networking.RetrofitHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);



        //proveravam da li je jezik vec izabran
        // ako jeste, preskace se ekran za biranje jezika i ide se pravo na login ekran
        if (SharedPrefs.isFirstTime(LoadingActivity.this)){
            Intent intent = new Intent(getApplicationContext(), ChooseLanguageActivity.class);
            startActivity(intent);
            finish();
        }
        else if(SharedPrefs.getToken(getApplicationContext()).api_token != null){
            //refreshuj token
            Token token = SharedPrefs.getToken(getApplicationContext());
            RetrofitHttpClient.getApiClient().refreshToken(token.api_token,token.refresh_token).enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    if(response.body().success){
                        SharedPrefs.saveToken(getApplicationContext(),response.body().data);

                        //idem na main ekran(HomeActivity)
                        startActivity(new Intent(LoadingActivity.this,HomeActivity.class));
                        finish();
                    }
                    else{
                        SharedPrefs.deleteToken(getApplicationContext());
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {
                    SharedPrefs.deleteToken(getApplicationContext());
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
            });
        }
        else{

            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }

    }
}
