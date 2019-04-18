package cubes.vaktmester.stanisic.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cubes.vaktmester.stanisic.data.Const;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHttpClient {

    private static RetroHttpClientInterface instance;

    private static Retrofit getRemoteHttpClient(){

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    public static RetroHttpClientInterface getApiClient(){
        if(instance == null){
            instance = getRemoteHttpClient().create(RetroHttpClientInterface.class);
        }
        return instance;
    }
}
