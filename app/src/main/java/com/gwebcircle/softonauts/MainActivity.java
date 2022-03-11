package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button butsign;
private EditText email;
private EditText password;
private TextView textforgpass;
private TextView textsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        textforgpass = findViewById(R.id.forgpass);
        textsignup = findViewById(R.id.signupopt);
        butsign = findViewById(R.id.butnsignin);

        handleEvents();
    }

    private void handleEvents() {

        butsign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (butsign == v) {
            onSignin();
        }
    }

    private void onSignin() {
        butsign.setEnabled(false);

    }
}
