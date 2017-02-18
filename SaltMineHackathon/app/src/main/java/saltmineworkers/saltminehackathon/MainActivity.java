package saltmineworkers.saltminehackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //The different categories a user can choose after login
    private static boolean culture = true;
    private static boolean sport = true;
    private static boolean recreation = true;

    /**
     * Startup method for main page
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Customizing the action bar
        getSupportActionBar().setTitle("Hjem");

        // Making the navigation bar (menu)
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // The different buttons that links to different map viewings
        // This is to change with future development, but illustrates the purpose of the app
        Button btnCulture = (Button) findViewById(R.id.btnCulture);
        Button btnSports = (Button) findViewById(R.id.btnSports);
        Button btnRecreation = (Button) findViewById(R.id.btnRecreation);

        // Button listeners, changes boolean values to customize map views based on category chosen

        btnCulture.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v){
                setCulture(true);
                setSport(false);
                setRecreation(false);
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });
        btnSports.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCulture(false);
                setSport(true);
                setRecreation(false);
                Intent i = new Intent (MainActivity.this, MapsActivity.class);
                startActivity(i);
                }

        });
        btnRecreation.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                setCulture(false);
                setSport(false);
                setRecreation(true);
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

    }

    // Back button/menu configuration
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // The different menu items that are accessible from the app. Help and FAQ is postponed
    // until a future version.
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent (MainActivity.this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_profile) {
            Intent i = new Intent (MainActivity.this, ProfileActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(MainActivity.this, PreferenceActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_faq) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Checkers and setters for the categories

    public boolean isCulture() {
        return culture;
    }

    public void setCulture(boolean culture) {
        this.culture = culture;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public boolean isRecreation() {
        return recreation;
    }

    public void setRecreation(boolean recreation) {
        this.recreation = recreation;
    }
}
