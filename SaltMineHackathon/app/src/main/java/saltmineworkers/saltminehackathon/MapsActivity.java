package saltmineworkers.saltminehackathon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.data.kml.KmlLayer;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import static saltmineworkers.saltminehackathon.R.id.map;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;





    private String category;



    private static String property;
    private Marker testMarker;
    private static String lookingFor = "";

    /**
     * Startup method for the maps activity
     * @param savedInstanceState
     */
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

    /**
     * Class implementing Google Maps through the Google Maps API.
     * The method checks which activity the user chose and shows the relevant markers in the map
     * based on the dataset provided by "Kristiansand Kommune". The data sets are converted to files
     * with more preferable geographical coordinates than UTM. With a converter, we passed a
     * JSON file with UTM coordinates and got a KLM file with Lon/Lat coordinate format which
     * suited our app perfectly.
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        MapFragment mapFrag = (MapFragment) getFragmentManager().findFragmentById(map);
        MainActivity mainActivity = new MainActivity();

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
                layer.getPlacemarks();
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



      //  LatLng kristiansand = new LatLng(8.08265662771951,58.142915837605301);
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(kristiansand));
        mMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);



    }

    public boolean onMarkerClick(final Marker marker) {
        MainActivity mainActivity = new MainActivity();

        if (mainActivity.isSport()) {
            setProperty("Idrett");
        }
        else if (mainActivity.isCulture()) {
            setProperty("Kultur");

        } else if (mainActivity.isRecreation()) {
            setProperty("Rekreasjon");
        }
            createPopup();
            return true;


    }

    public void createPopup() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final TextView et = new TextView(this);
        alertDialogBuilder.setView(et);
        String s = getProperty();
        et.setText(s);
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
    public static String getProperty() {
        return property;
    }

    public static void setProperty(String property) {
        MapsActivity.property = property;
    }
}