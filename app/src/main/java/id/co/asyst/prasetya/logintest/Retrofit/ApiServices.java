package id.co.asyst.prasetya.logintest.Retrofit;

import id.co.asyst.prasetya.logintest.Model.TaskRequest;
import id.co.asyst.prasetya.logintest.Model.TaskResponse;
import id.co.asyst.prasetya.logintest.Model.UserRequest;
import id.co.asyst.prasetya.logintest.Model.UserResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("Login/getProfileInfo")
    Call<UserResponse> reqData(@Body UserRequest userRequest);

    @POST("Task/getAllTask")
    Call<TaskResponse> reqTask(@Body TaskRequest taskRequest);
}
