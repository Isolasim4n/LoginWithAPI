package id.co.asyst.prasetya.logintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.asyst.prasetya.logintest.Model.User;
import id.co.asyst.prasetya.logintest.Model.UserRequest;
import id.co.asyst.prasetya.logintest.Retrofit.ApiClient;
import id.co.asyst.prasetya.logintest.Retrofit.ApiServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.username_editText)
    EditText username_editText;
    @BindView(R.id.password_editText)
    EditText password_editText;
    @BindView(R.id.login_button)
    Button login_button;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

    }

    private void doLogin() {
        username = username_editText.getText().toString();
        password = password_editText.getText().toString();

        UserRequest userRequest = new UserRequest();
        User user = new User();
        userRequest.setMethod("getProfileInfo");
        user.setUsername(username);
        user.setPassword(password);

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);
        Call<UserRequest> call = apiServices.reqData(userRequest);

        call.enqueue(new Callback<UserRequest>() {
            @Override
            public void onResponse(Call<UserRequest> call, Response<UserRequest> response) {

            }

            @Override
            public void onFailure(Call<UserRequest> call, Throwable t) {

            }
        });
    }
}
