package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gwebcircle.softonauts.adapter.SlotsAdapter;
import com.gwebcircle.softonauts.model.DropInNavigatorTwo;
import com.gwebcircle.softonauts.model.Slots;
import com.gwebcircle.softonauts.model.TimeSlots;
import com.gwebcircle.softonauts.retrofit.APIInterface;
import com.gwebcircle.softonauts.retrofit.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigatorDetailsActivity extends AppCompatActivity
        implements SlotsAdapter.SlotsAdapterListener{
    private GridView gridview;
    public static final String PASS_DROPIN_PARCEL = NavigatorDetailsActivity.class.getSimpleName() + ".dropin";
    private  DropInNavigatorTwo dropInNavigatorTwo;
    private RecyclerView recyclerslots;
    private ArrayList<Slots> slotslist = new ArrayList<>();
    private  SlotsAdapter slosAdapter;
    private TextView pnamee;
    private TextView adrs;
    private RequestQueue mRequestQueue;

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

        mRequestQueue = Volley.newRequestQueue(this);

        dropInNavigatorTwo = getIntent().getParcelableExtra(PASS_DROPIN_PARCEL);

        pnamee = findViewById(R.id.pname);
        adrs = findViewById(R.id.padrs);

        pnamee.setText(dropInNavigatorTwo.navigatorname);
        adrs.setText(dropInNavigatorTwo.getNavigatorlocation().get(0).toString());

        recyclerslots = findViewById(R.id.recycler_slots);

        slosAdapter = new SlotsAdapter(NavigatorDetailsActivity.this,slotslist, this);
      LinearLayoutManager llm = new LinearLayoutManager(NavigatorDetailsActivity.this, LinearLayoutManager.HORIZONTAL, true);
       recyclerslots.setLayoutManager(llm);
        recyclerslots.setAdapter(slosAdapter);
        recyclerslots.setHasFixedSize(true);
        gridview = (GridView) findViewById(R.id.gridview);
      //  gridview.setAdapter(new SlotTwoAdapter(this));
        getTimeSlots();

    }

    private void getTimeSlots() {

        String tag_string_req = "get-time-slots";
        String url = RetrofitClient.BASE_URL + "Android/get-time-slots";

        Log.i("gettimeslots",url);

        StringRequest strReq = new StringRequest(Request.Method.POST,
                url, response -> {

                    try {
                        JSONObject jObj = new JSONObject(response);
                        String flag = jObj.getString("message");

                        if (flag.equalsIgnoreCase("success")) {

                            JSONArray resultAray = jObj.getJSONArray("timeslots");
                            for (int i = 0; i < resultAray.length(); i++) {

                                JSONObject resultArayDetail = resultAray.getJSONObject(i);

                                String showdate = resultArayDetail.getString("show_date");
                                String curentdate = resultArayDetail.getString("current_date");
                                String day = resultArayDetail.getString("day");
                                String sloti = resultArayDetail.getString("slotes");


                                TimeSlots timeslots = new TimeSlots();
                                List<String> morningslts = new ArrayList<>();
                                List<String> noonslts = new ArrayList<>();
                                List<String> evngslts = new ArrayList<>();
                                List<String> nightslts = new ArrayList<>();



                                if(!sloti.equals("null")){
                                    JSONObject slotesArray = resultArayDetail.getJSONObject("slotes");
                                    JSONArray mornarrr = slotesArray.getJSONArray("morning");
                                    if(mornarrr.length()>0){
                                        for (int b = 0; b < mornarrr.length(); b++) {

                                            String prodid = mornarrr.getString(b);

                                            morningslts.add(prodid);


                                        }
                                        timeslots.setMorning(morningslts);
                                    }



                                        JSONArray noonArray = slotesArray.getJSONArray("afternoon");
                                        for (int d = 0; d < noonArray.length(); d++) {
                                            String prodid = noonArray.getString(d);

                                            noonslts.add(prodid);
                                        }
                                        timeslots.setNoonlist(noonslts);

                                        JSONArray eveningArray = slotesArray.getJSONArray("evening");
                                        for (int e = 0; e < eveningArray.length(); e++) {
                                            String prodid = eveningArray.getString(e);

                                            evngslts.add(prodid);

                                        }

                                        timeslots.setEveninglist(evngslts);

                                        JSONArray nightArray = slotesArray.getJSONArray("night");
                                        for (int f = 0; f < nightArray.length(); f++) {
                                            String prodid = nightArray.getString(f);

                                            nightslts.add(prodid);
                                        }

                                        timeslots.setNightlist(nightslts);

                                }

                                int count = resultArayDetail.getInt("count");

                                 List<String> booklst = new ArrayList<>();
                                JSONArray bookedArray = resultArayDetail.getJSONArray("booked");
                                if(bookedArray.length()>0){
                                    for (int g = 0; g < bookedArray.length(); g++) {
                                        JSONObject nightDetail = bookedArray.getJSONObject(g);
                                        String prodid = nightDetail.toString();
                                        booklst.add(prodid);

                                    }
                                }

                               String nxavl  = null;
                                String nxsrch = null;


                                if(!resultArayDetail.isNull("next_availability")){
                                    nxavl = resultArayDetail.getString("next_availability");
                                }else{
                                    nxavl = "";
                                }
                                if(!resultArayDetail.isNull("next_availability_search")){
                                    nxsrch = resultArayDetail.getString("next_availability_search");
                                }else{
                                    nxsrch = "";
                                }
                                ArrayList<TimeSlots> tmslotss = new ArrayList<>();
                                tmslotss.add(timeslots);

                                slotslist.add(new Slots(showdate,curentdate, day, tmslotss,count,booklst,nxavl, nxsrch));
                                slosAdapter.notifyDataSetChanged();

                            }

                        } else {
                            Toast.makeText(NavigatorDetailsActivity.this, "error", Toast.LENGTH_SHORT).show();

                            // SomethingWrongTost(errorMsg);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //handle the error
                    Toast.makeText(NavigatorDetailsActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        }) {    //this is the part, that adds the header to the request
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", APIInterface.AUTHORIZE_KEY);
                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("location_id", "16");
                return params;
            }
        };


        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    @Override
    public void onClickslot(Slots slots) {
        startActivity(new Intent(NavigatorDetailsActivity.this, NavigatorDetailsTwoActivity.class)
                .putExtra(NavigatorDetailsTwoActivity.PASS_SLOT_PARCEL, (Parcelable) slots)
                .putExtra(NavigatorDetailsTwoActivity.PASS_DROPIN_PARCEL, (Parcelable)dropInNavigatorTwo));

    }
}