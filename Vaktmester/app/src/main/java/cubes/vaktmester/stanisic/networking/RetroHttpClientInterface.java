package cubes.vaktmester.stanisic.networking;

import cubes.vaktmester.stanisic.data.Const;
import cubes.vaktmester.stanisic.data.response.LoginModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetroHttpClientInterface {

    @POST(Const.URL_LOGIN)
    Call<LoginModel> login(@Query("email") String email, @Query("password") String password);

    @POST(Const.URL_REFRESH_TOKEN)
    Call<LoginModel> refreshToken(@Query("api_token") String token, @Query("refresh_token") String refreshToken);
}
