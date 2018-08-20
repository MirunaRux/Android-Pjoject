package com.example.mirunabudoias.myfirstapplication.faq;

import android.content.Intent;
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
        Intent intent = new Intent(this, FAQDetailActivity.class);
        intent.putExtra(FAQDetailActivity.EXTRA_FAQ_ID, (int) id);
        startActivity(intent);
    }
}
