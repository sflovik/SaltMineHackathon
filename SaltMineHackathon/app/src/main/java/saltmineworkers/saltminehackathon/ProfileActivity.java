package saltmineworkers.saltminehackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profil");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addTextToProfile();
    }

    public void addTextToProfile(){
        UserModel userModel = new UserModel("Salt Mine", "Worker", "SaltMineWorker", "saltmine@worker.com", 11223344, 24);

        TextView textViewName = (TextView) findViewById(R.id.profile_name_view);
        TextView textViewUserName = (TextView) findViewById(R.id.profile_username);
        TextView textViewEmail = (TextView) findViewById(R.id.profile_email);
        TextView textViewPhoneNumber = (TextView) findViewById(R.id.profile_phone);
        TextView textViewAge = (TextView) findViewById(R.id.profile_age);

        textViewName.setText(userModel.getFirstName() + " " + userModel.getSurName());
        textViewUserName.setText(userModel.getUsername());
        textViewEmail.setText(userModel.getEmail());

        Integer userPhoneNumber = new Integer(userModel.getPhoneNr());
        Integer userAge = new Integer(userModel.getAge());

        textViewPhoneNumber.setText(userPhoneNumber.toString());
        textViewAge.setText(userAge.toString());
    }

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
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent (ProfileActivity.this, MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_profile) {
            Intent i = new Intent (ProfileActivity.this, ProfileActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(ProfileActivity.this, PreferenceActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_faq) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
