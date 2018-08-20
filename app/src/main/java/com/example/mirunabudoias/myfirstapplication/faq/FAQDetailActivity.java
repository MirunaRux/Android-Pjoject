package com.example.mirunabudoias.myfirstapplication.faq;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mirunabudoias.myfirstapplication.R;

public class FAQDetailActivity extends AppCompatActivity {
    public static final String EXTRA_FAQ_ID = "EXTRA_FAQ_ID";
    private int currentId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqdetail);

        currentId = getIntent().getIntExtra(EXTRA_FAQ_ID, -1);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_faq_detail, FAQDetailFragment.newInstance(currentId));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
