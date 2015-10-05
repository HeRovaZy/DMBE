package nl.dmbe.infoapp;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.parse.ParseAnalytics;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public MenuItem item;
    private static int pagenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMain2, new MyFragment())
                    .commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        try{getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff8b29a0));}
        catch (NullPointerException n) {
        }

        colorNavbar();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        this.item = item;
        Intent intent;


        if (id == R.id.nav_home) {
            // Handle the camera action
            pagenumber = 0;
        } else if (id == R.id.nav_contact) {
            pagenumber = 1;
//            intent = new Intent(this, OnderdelenActivity.class);
//            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Er is op contact geklikt!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_agenda) {
            pagenumber = 3;
        } else if (id == R.id.nav_tamtam) {

        } else if (id == R.id.nav_band) {

        } else if (id == R.id.nav_scouting) {

        } else if (id == R.id.nav_oosterbloaskapel) {

        } else if (id == R.id.nav_stageband) {

        } else if (id == R.id.nav_jeugdorkest) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @TargetApi(21)
    private void colorNavbar(){
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(0xff621b71);
    }

    public class MyFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup,
                                 Bundle savedInstanceState) {

            View rootView;
            switch (pagenumber) {
                case 1:
                    rootView = inflater.inflate(R.layout.content_home, parentViewGroup, false);
                    break;
                case 2:
                    rootView = inflater.inflate(R.layout.content_main, parentViewGroup, false);
                    break;
                default:
                    rootView = inflater.inflate(R.layout.content_main, parentViewGroup, false);
                    break;
            }
            return rootView;


        }


    }

}
