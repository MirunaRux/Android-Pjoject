package com.example.mirunabudoias.myfirstapplication.dashboard.lateralmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mirunabudoias.myfirstapplication.R;
import com.example.mirunabudoias.myfirstapplication.about.AboutActivity;
import com.example.mirunabudoias.myfirstapplication.faq.FAQDetailFragment;
import com.example.mirunabudoias.myfirstapplication.user.AddUserActivity;
import com.example.mirunabudoias.myfirstapplication.faq.FaqActivity;
import com.example.mirunabudoias.myfirstapplication.login.LoginActivity;
import com.example.mirunabudoias.myfirstapplication.user.User;
import com.example.mirunabudoias.myfirstapplication.user.UserListFragment;
import com.example.mirunabudoias.myfirstapplication.user.dummy.DummyContent;
import com.example.mirunabudoias.myfirstapplication.utils.SharedPreferenceManager;

public class LateralMenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, UserListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lateral_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addUserIntent = new Intent(LateralMenuActivity.this, AddUserActivity.class);
                startActivity(addUserIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.lateral_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            SharedPreferenceManager.saveRememberMe(LateralMenuActivity.this, false);
            Intent loginActivityIntent = new Intent(LateralMenuActivity.this, LoginActivity.class);
            startActivity(loginActivityIntent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_users) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container_dashboard, UserListFragment.newInstance(1));
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_about) {
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
        } else if (id == R.id.nav_faq) {
            Intent faqIntent = new Intent(this, FaqActivity.class);
            startActivity(faqIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(User item) {
        Intent editUserIntent = new Intent(this, AddUserActivity.class);
        editUserIntent.putExtra(AddUserActivity.EXTRA_USER, item);
        startActivity(editUserIntent);
    }
}
