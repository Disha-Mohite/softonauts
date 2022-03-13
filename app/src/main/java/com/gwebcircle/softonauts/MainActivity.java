package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.gwebcircle.softonauts.adapter.DropInNavAdapter;
import com.gwebcircle.softonauts.model.DropInNavigator;
import com.gwebcircle.softonauts.model.DropInNavigatorTwo;
import com.gwebcircle.softonauts.retrofit.APIInterface;
import com.gwebcircle.softonauts.retrofit.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements DropInNavAdapter.DropInNavigatorListener{

    private ArrayList<DropInNavigatorTwo> dropnavlist = new ArrayList<com.gwebcircle.softonauts.model.DropInNavigatorTwo>();
    private DropInNavAdapter dropnavAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu);
            getSupportActionBar().setTitle("");
        }

        recyclerView = findViewById(R.id.recycler_view);


        dropnavAdapter = new DropInNavAdapter(MainActivity.this, dropnavlist,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(dropnavAdapter);

        getDropInNAvList();
    }

    private void getDropInNAvList() {

        Call<DropInNavigator> call = RetrofitClient.getInterface().getDropInList(APIInterface.AUTHORIZE_KEY,"96");
        call.enqueue(new Callback<DropInNavigator>() {
            @Override
            public void onResponse(Call<DropInNavigator> call, Response<DropInNavigator> response) {
                if (response.isSuccessful()) {
                 //  DropInNavigator dropnav = response.body().getData().get(response.body().getData().size());
                   dropnavlist.addAll(response.body().dropinlist);

                    dropnavAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(getApplicationContext(),"API Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DropInNavigator> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                t.printStackTrace();

            }
        });
    }


    @Override
    public void onClickCard(DropInNavigatorTwo dropinnav) {
      String dronavname = dropinnav.navigatorname;



   startActivity(new Intent(MainActivity.this, NavigatorDetailsActivity.class)
           .putExtra(NavigatorDetailsActivity.PASS_DROPIN_PARCEL, (Parcelable) dropinnav));



    }
}
