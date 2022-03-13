package com.gwebcircle.softonauts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gwebcircle.softonauts.model.DropInNavigatorTwo;
import com.gwebcircle.softonauts.model.Slots;

import org.w3c.dom.Text;

public class NavigatorDetailsTwoActivity extends AppCompatActivity {

    public static final String PASS_SLOT_PARCEL = NavigatorDetailsTwoActivity.class.getSimpleName() + ".slot";
    public static final String PASS_DROPIN_PARCEL = NavigatorDetailsTwoActivity.class.getSimpleName() + ".dropin";
    private DropInNavigatorTwo dropInNavigatorTwo;
    private Slots slot;
    private EditText edittext;
    private Button butsubmit;
    private TextView textname;
    private TextView texadrs;
    private TextView textdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator_details_two);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarv);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu);
            getSupportActionBar().setTitle("");
        }
        slot = getIntent().getParcelableExtra(PASS_SLOT_PARCEL);
        dropInNavigatorTwo = getIntent().getParcelableExtra(PASS_DROPIN_PARCEL);

        textname = findViewById(R.id.pnamenv);
        texadrs = findViewById(R.id.padrsnv);
        textdate = findViewById(R.id.timedat);

        textname.setText(dropInNavigatorTwo.navigatorname);
        texadrs.setText(dropInNavigatorTwo.getNavigatorlocation().get(0).toString());
        textdate.setText(slot.getShowdate());


        butsubmit = findViewById(R.id.sublit);
        edittext = findViewById(R.id.appointype);




    }
}