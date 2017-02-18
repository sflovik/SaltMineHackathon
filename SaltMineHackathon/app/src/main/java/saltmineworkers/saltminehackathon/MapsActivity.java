package saltmineworkers.saltminehackathon;

import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import static saltmineworkers.saltminehackathon.R.id.map;
import static saltmineworkers.saltminehackathon.R.id.test;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;





    private String category;

    private Marker testMarker;
    private static String lookingFor = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbarMap);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Finn noe");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(map);

        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        MapFragment mapFrag = (MapFragment) getFragmentManager().findFragmentById(map);
        MainActivity mainActivity = new MainActivity();
        boolean sport = mainActivity.isSport();
        boolean culture = mainActivity.isCulture();
        boolean recreation = mainActivity.isRecreation();
        if (mainActivity.isSport()) {
            try {
                KmlLayer layer = new KmlLayer(mMap, R.raw.idrett, this);
                layer.addLayerToMap();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        else if (mainActivity.isCulture()) {
            try {
                KmlLayer layer = new KmlLayer(mMap, R.raw.kultur, this);
                layer.addLayerToMap();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

        } else if (mainActivity.isRecreation()) {
            try {
                KmlLayer layer = new KmlLayer(mMap, R.raw.rekreasjon, this);
                layer.addLayerToMap();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }



        LatLng sydney = new LatLng(-34, 151);
        testMarker = googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney")
                .snippet("My crib")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);


    }

    public boolean onMarkerClick(final Marker marker) {
        if (marker.equals(testMarker)) {
            createPopup();
            return true;
        }
        return false;
    }

    public void createPopup() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final TextView et = new TextView(this);
        alertDialogBuilder.setView(et);
        et.setText("You found Sidney");
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}