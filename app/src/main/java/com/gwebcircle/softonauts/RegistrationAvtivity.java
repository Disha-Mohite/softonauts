package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.gwebcircle.softonauts.model.User;
import com.gwebcircle.softonauts.retrofit.APIInterface;
import com.gwebcircle.softonauts.retrofit.RetrofitClient;
import com.gwebcircle.softonauts.retrofit.SrvRes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationAvtivity extends AppCompatActivity implements View.OnClickListener {

    private EditText fname;
    private EditText mname;
    private EditText lname;
    private EditText email;
    private EditText paaswd;
    private EditText dob;
    private EditText contactno;
    private EditText ssn;
    private EditText adresone;
    private EditText adrstwo;
    private EditText city;
    private EditText state;
    private EditText zipcode;
    private RadioButton radio1, radio2, radio3;
    private Button buttonsignup;
    private TextView textsignin;
    private String currentGender = "";
    private static final String GENDER_MALE = "Male";
    private static final String GENDER_FEMALE = "Female";
    private static final String GENDER_NOT_DISCLOSED = "Gender Not Disclosed";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_avtivity);

        fname = findViewById(R.id.fname);
        mname = findViewById(R.id.mname);
        lname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        paaswd = findViewById(R.id.passwd);
        dob = findViewById(R.id.bodd);
        contactno = findViewById(R.id.contactno);
        ssn = findViewById(R.id.ssn);
        adresone = findViewById(R.id.adrson);
        adrstwo = findViewById(R.id.adrstw);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        zipcode = findViewById(R.id.zipcod);
        radio1 = findViewById(R.id.radio_item);
        radio2 = findViewById(R.id.radio_item2);
        radio3 = findViewById(R.id.radio_item3);

        buttonsignup= findViewById(R.id.signup);
        textsignin = findViewById(R.id.signinopt);


        handleEvennts();


    }

    private void handleEvennts() {
        buttonsignup.setOnClickListener(this);
        textsignin.setOnClickListener(this);
        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
        radio3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (buttonsignup == v) {

            onSignUP();
        }

        if (textsignin == v) {
            startActivity(new Intent(RegistrationAvtivity.this, SignInActivity.class));

        }
        if (radio1 == v){
            currentGender = GENDER_MALE;
            radio2.setChecked(false);
            radio3.setChecked(false);
            return;
        }
        if (radio2 == v){
            currentGender = GENDER_FEMALE;
            radio1.setChecked(false);
            radio3.setChecked(false);
            return;
        }
        if (radio3 == v){
            currentGender = GENDER_NOT_DISCLOSED;
            radio1.setChecked(false);
            radio2.setChecked(false);

            return;
        }
    }


    private void onSignUP() {

        String fnam = fname.getText().toString();
        String mnam = mname.getText().toString();
        String lnam = lname.getText().toString();
        String emaill = email.getText().toString();
        String paswd = paaswd.getText().toString();
        String bodd = dob.getText().toString();
        String contact = contactno.getText().toString();
        String ssnn = ssn.getText().toString();
        String adrson = adresone.getText().toString();
        String adrstww = adrstwo.getText().toString();
        String cityy = city.getText().toString();
        String statee = state.getText().toString();
        String zipcdd = zipcode.getText().toString();



            if (fnam.isEmpty()){
                fname.setError("Field Mandatory");
                return;
            }


            if (mnam.isEmpty()) {
                mname.setError("Field Mandatory");
                return;
            }



            if (lnam.isEmpty()) {
                lname.setError("Field Mandatory");
                return;
            }



            if (emaill.isEmpty()) {
                email.setError("Field Mandatory");
                return;
            }


        if (paswd.isEmpty()) {
            paaswd.setError("Field Mandatory");
            return;
        }

        if (bodd.isEmpty()) {
            dob.setError("Field Mandatory");
            return;
        }


        if (contact.isEmpty()) {
            contactno.setError("Field Mandatory");
            return;
        }


        if (ssnn.isEmpty()) {
            ssn.setError("Field Mandatory");
            return;
        }

        if (adrson.isEmpty()) {
            adresone.setError("Field Mandatory");
            return;
        }



        if (cityy.isEmpty()) {
            city.setError("Field Mandatory");
            return;
        }

        if (statee.isEmpty()) {
            state.setError("Field Mandatory");
            return;
        }

        if (zipcdd.isEmpty()) {
            zipcode.setError("Field Mandatory");
            return;
        }
        registerUSer(fnam, mnam, lnam, emaill, paswd,bodd, contact,ssnn, adrson, adrstww,
                cityy, statee, zipcdd,currentGender);
    }

    private void registerUSer(String fnam, String mnam, String lnam, String emaill,
                              String paswd, String bodd, String contact, String ssnn, String adrson, String adrstww, String cityy, String statee, String zipcdd, String currentGender) {

        int ssndig = Integer.parseInt(ssnn);
        int zipcod = Integer.parseInt(zipcdd);

        try{
            Call<Void> call = RetrofitClient.getInterface().registerUser(APIInterface.AUTHORIZE_KEY,
                    fnam, mnam, lnam,bodd,currentGender, contact, emaill , adrson, adrstww,
                    cityy,statee, zipcod, paswd , "internal" , ssndig);
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.isSuccessful()) {


                        startActivity(new Intent(RegistrationAvtivity.this, MainActivity.class));
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(),"API Error",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                    Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    t.printStackTrace();
                }
            });

        }catch(Exception e){
            Toast.makeText(getApplicationContext(), String.valueOf(e.toString()),Toast.LENGTH_LONG).show();

            e.printStackTrace();
        }

    }
}