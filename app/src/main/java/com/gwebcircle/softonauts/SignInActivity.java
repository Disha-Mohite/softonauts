package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gwebcircle.softonauts.model.User;
import com.gwebcircle.softonauts.retrofit.APIInterface;
import com.gwebcircle.softonauts.retrofit.RetrofitClient;
import com.gwebcircle.softonauts.retrofit.SrvRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butsign;
    private EditText email;
    private EditText password;
    private TextView textforgpass;
    private TextView textsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        textforgpass = findViewById(R.id.forgpass);
        textsignup = findViewById(R.id.signupopt);
        butsign = findViewById(R.id.butnsignin);

        handleEvents();
    }


    private void handleEvents() {

        butsign.setOnClickListener(this);
        textsignup.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (butsign == v) {
            onSignin();
        }

        if (textsignup == v) {
            startActivity(new Intent(SignInActivity.this, RegistrationAvtivity.class));

        }
    }

    private void onSignin() {
        String username = email.getText().toString();
        String passwd = password.getText().toString();
        if (username.isEmpty()){
            email.setError("Field Mandatory");
            return;
        }


        if (passwd.isEmpty()) {
            password.setError("Field Mandatory");
            return;
        }
        signinn();

    }

    private void signinn() {
        butsign.setEnabled(false);

        String username = email.getText().toString();
        String passwd = password.getText().toString();
        String fcmid = "";
        Call<SrvRes<User>> call = RetrofitClient.getInterface().loginUser(APIInterface.AUTHORIZE_KEY,username, passwd, fcmid);
        call.enqueue(new Callback<SrvRes<User>>() {
            @Override
            public void onResponse(Call<SrvRes<User>> call, Response<SrvRes<User>> response) {
                if (response.isSuccessful()) {

                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(),"API Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<SrvRes<User>> call, Throwable t) {

                t.printStackTrace();
                startActivity(new Intent(SignInActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}