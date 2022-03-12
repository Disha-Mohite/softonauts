package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.gwebcircle.softonauts.adapter.SlotTwoAdapter;
import com.gwebcircle.softonauts.adapter.SlotsAdapter;
import com.gwebcircle.softonauts.model.DropInNavigator;
import com.gwebcircle.softonauts.model.DropInNavigatorTwo;
import com.gwebcircle.softonauts.model.Slots;
import com.gwebcircle.softonauts.model.TimeSlots;
import com.gwebcircle.softonauts.retrofit.APIInterface;
import com.gwebcircle.softonauts.retrofit.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavigatorDetailsActivity extends AppCompatActivity
        implements SlotsAdapter.SlotsAdapterListener{
    private GridView gridview;
    public static final String PASS_REST_PARCEL = NavigatorDetailsActivity.class.getSimpleName() + ".dropin";
    private  DropInNavigatorTwo dropInNavigatorTwo;
    private RecyclerView recyclerslots;
    private ArrayList<TimeSlots> timeSlotslist = new ArrayList<>();
    private  SlotsAdapter slosAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarr);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu);
            getSupportActionBar().setTitle("");
        }

        dropInNavigatorTwo = getIntent().getParcelableExtra(PASS_REST_PARCEL);

        recyclerslots = findViewById(R.id.recycler_slots);

        slosAdapter = new SlotsAdapter(NavigatorDetailsActivity.this,timeSlotslist, this);
         gridview = (GridView) findViewById(R.id.gridview);
      //  gridview.setAdapter(new SlotTwoAdapter(this));

        getTimeSlots();
    }

    private void getTimeSlots() {

        Call<Slots> call = RetrofitClient.getInterface().getTimeSlots(APIInterface.AUTHORIZE_KEY,"16");
        call.enqueue(new Callback<Slots>() {
            @Override
            public void onResponse(Call<Slots> call, Response<Slots> response) {
                if (response.isSuccessful()) {
                    timeSlotslist.addAll(response.body().timeslotslist);

                    slosAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(getApplicationContext(),"API Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Slots> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                t.printStackTrace();

            }
        });
    }

    @Override
    public void onClickslot() {

    }
}