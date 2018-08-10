package com.example.mirunabudoias.myfirstapplication.faq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mirunabudoias.myfirstapplication.R;

public class FaqActivity extends AppCompatActivity implements FaqFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onItemClick(long id) {
        Toast.makeText(this, "bla bla " + id, Toast.LENGTH_SHORT).show();
    }
}
