package com.example.mirunabudoias.myfirstapplication.user;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mirunabudoias.myfirstapplication.R;

public class AddUserActivity extends AppCompatActivity implements AddUserFragment.OnFragmentInteractionListener {

    public static final String EXTRA_USER = "EXTRA_USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        User currentUser = null;
        if (getIntent() != null && getIntent().hasExtra(EXTRA_USER)) {
            currentUser = (User) getIntent().getSerializableExtra(EXTRA_USER);
        }


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_add_user, AddUserFragment.newInstance(currentUser));
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
