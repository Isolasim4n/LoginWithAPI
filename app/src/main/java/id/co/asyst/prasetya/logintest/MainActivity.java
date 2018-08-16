package id.co.asyst.prasetya.logintest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.asyst.prasetya.logintest.Model.User;
import id.co.asyst.prasetya.logintest.Model.UserData;
import id.co.asyst.prasetya.logintest.Model.UserRequest;
import id.co.asyst.prasetya.logintest.Model.UserResponse;
import id.co.asyst.prasetya.logintest.Retrofit.ApiClient;
import id.co.asyst.prasetya.logintest.Retrofit.ApiServices;
import id.co.asyst.prasetya.logintest.Utility.SessionUtil;
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
    SessionUtil sessionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        sessionUtil = new SessionUtil(this);

        checkLogin();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                doLogin();
            }
        });
    }

    private void checkLogin() {

        if (!sessionUtil.loadName().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "Welcome " + sessionUtil.loadName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Please Login", Toast.LENGTH_SHORT).show();
        }
    }

    private void doLogin() {
        username = username_editText.getText().toString();
        password = password_editText.getText().toString();

        UserRequest userRequest = new UserRequest();
        final User user = new User();
        userRequest.setMethod("getProfileInfo");
        user.setUsername(username);
        user.setPassword(password);
        userRequest.setUserAndPass(user);

        ApiServices apiServices = ApiClient.newInstance(getApplicationContext()).create(ApiServices.class);
        Call<UserResponse> call = apiServices.reqData(userRequest);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.body().getStatus().equalsIgnoreCase("success")) {
                    UserData userData = response.body().getData_user();
                    Toast.makeText(getApplicationContext(), "Welcome " + userData.getStaff_name(), Toast.LENGTH_SHORT).show();
                    //Save to session
                    sessionUtil.saveName(userData.getUsername(), userData.getStaff_name());
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Login Gagal !!!", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

    }
}
