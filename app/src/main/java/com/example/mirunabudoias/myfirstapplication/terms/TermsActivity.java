package com.example.mirunabudoias.myfirstapplication.terms;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.mirunabudoias.myfirstapplication.R;
import com.example.mirunabudoias.myfirstapplication.utils.SharedPreferenceManager;

public class TermsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        WebView termsWeb = findViewById(R.id.webView_Terms);
        termsWeb.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        termsWeb.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }

            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });

        termsWeb.loadUrl("http://www.yahoo.com");

    }

    public void doAction(View view) {
        switch (view.getId()) {
            case R.id.btn_terms_accept:
                SharedPreferenceManager.saveApproval(this, true);
                finish();
                break;

            case R.id.btn_terms_denied:
                SharedPreferenceManager.saveApproval(this, false);
                finish();
                break;
        }
    }


}
