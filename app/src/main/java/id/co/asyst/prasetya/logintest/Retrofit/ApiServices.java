package id.co.asyst.prasetya.logintest.Retrofit;

import id.co.asyst.prasetya.logintest.Model.UserRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("Login/getProfileInfo")
    Call<UserRequest> reqData(@Body UserRequest userRequest);

}
