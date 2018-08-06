package com.example.mirunabudoias.myfirstapplication.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mirunabudoias.myfirstapplication.dashboard.lateralmenu.LateralMenuActivity;
import com.example.mirunabudoias.myfirstapplication.utils.Constants;
import com.example.mirunabudoias.myfirstapplication.signup.CreateAccountActivity;
import com.example.mirunabudoias.myfirstapplication.R;
import com.example.mirunabudoias.myfirstapplication.utils.SharedPreferenceManager;
import com.example.mirunabudoias.myfirstapplication.terms.TermsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_constraint_user)
    EditText mEtUser;
    @BindView(R.id.til_constraint_user)
    TextInputLayout mTilUser;

    public static final String TAG = LoginActivity.class.getSimpleName();
    //public static final String EXTRA_NAME = "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        ButterKnife.bind(this);

        //final String receiveMessage = getIntent().getStringExtra(EXTRA_NAME);

        //Toast.makeText(this, receiveMessage, Toast.LENGTH_SHORT).show();

        Log.i(TAG, "onCreate");

        Button termsConditions = findViewById(R.id.btn_terms_conditions);

        termsConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(LoginActivity.this, "terms click", Toast.LENGTH_SHORT).show();
                Intent termsIntent = new Intent(LoginActivity.this, TermsActivity.class);

                startActivity(termsIntent);
            }
        });

        CheckBox checkBoxRememberMe = findViewById(R.id.checkBox_constraint_remember);
        checkBoxRememberMe.setChecked(SharedPreferenceManager.loadRemember(this));

        checkBoxRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferenceManager.saveRememberMe(LoginActivity.this, b);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

        ImageView imgTermsAccepted = findViewById(R.id.img_termsAccepted);

        imgTermsAccepted.setVisibility(SharedPreferenceManager.loadTermsApproval(this) ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    public void doAction(View view) {
        switch (view.getId()){
            case R.id.btn_login_constraint :
                if(!mEtUser.getText().toString().equals(SharedPreferenceManager.loadUsername(this))){
                    new AlertDialog.Builder(this).setTitle(R.string.login_dialog_title_warning)
                            .setIcon(R.drawable.ic_clear_black_24dp)
                            .setPositiveButton(R.string.all_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    mEtUser.requestFocus();
                                    Constants.showKeyboard(LoginActivity.this);
                                }
                            }).show();
                }else {
                    Intent dashboardIntent = new Intent(LoginActivity.this, LateralMenuActivity.class);
                    startActivity(dashboardIntent);
                    finish();
                }
                break;
            case R.id.btn_signUp_constraint :
                Intent signUpIntent = new Intent(this, CreateAccountActivity.class);
                startActivityForResult(signUpIntent, Constants.REQUEST_CODE_CREATE_ACCOUNT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case Constants.REQUEST_CODE_CREATE_ACCOUNT : {
                if(resultCode == RESULT_OK){
                    mEtUser.setText(data.getStringExtra(Constants.EXTRA_KEY_CREATE_ACCOUNT_USER));
                }
            }
        }
    }
}
