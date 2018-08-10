package com.example.mirunabudoias.myfirstapplication.about;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mirunabudoias.myfirstapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactActivity extends AppCompatActivity {

    @BindView(R.id.et_contact_email)
    EditText etContactEmail;

    @BindView(R.id.et_contact_description)
    EditText etEmailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnSendEmail = findViewById(R.id.btn_contact_sendEmail);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendEmailIntent = new Intent();
                sendEmailIntent.setAction(Intent.ACTION_SEND);

                sendEmailIntent.setType("message/rfc822");
                sendEmailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{etContactEmail.getText().toString()});
                sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject here");
                sendEmailIntent.putExtra(Intent.EXTRA_TEXT   , etEmailBody.getText().toString());

                if (sendEmailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendEmailIntent);
                }
            }
        });
    }
}

