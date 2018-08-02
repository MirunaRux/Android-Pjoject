package com.example.mirunabudoias.myfirstapplication.signup;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mirunabudoias.myfirstapplication.utils.Constants;
import com.example.mirunabudoias.myfirstapplication.R;
import com.example.mirunabudoias.myfirstapplication.utils.SharedPreferenceManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity {

    @BindView(R.id.et_createAccount_name)
    EditText mEtUser;
    @BindView(R.id.til_createAcccount_name_container)
    TextInputLayout mTilUser;

    @BindView(R.id.et_createAccount_password)
    EditText mEtPassword;
    @BindView(R.id.til_createAcccount_password_container)
    TextInputLayout mTilPassword;

    @BindView(R.id.et_createAccount_rePassword)
    EditText mEtRePassword;
    @BindView(R.id.til_createAcccount_rePassword_container)
    TextInputLayout mTilRePassword;

    @BindView(R.id.spinner_createAccount_gender)
    Spinner mSpinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        mEtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mTilUser.setError(null);
            }
        });

        mSpinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = (String)adapterView.getItemAtPosition(i);
                Log.i("Create Account", getString(R.string.select_gender_placeholder, selected));
                Log.i("Create Account", getResources().getQuantityString(R.plurals.all_position, i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            showDismissDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showDismissDialog();
    }

    private void showDismissDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this).setTitle(R.string.label_createAccount_create)
                .setMessage(getString(R.string.createAccount_dismiss_question))
                .setPositiveButton(R.string.all_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setResult(RESULT_CANCELED);
                        finish();
                    }
                })
                .setNegativeButton(R.string.all_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void doAction(View view) {
        switch (view.getId()) {
            case R.id.btn_createAccount_create:
                if (isInputValid()) {
                    SharedPreferenceManager.saveUsername(this, mEtUser.getText().toString());
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(Constants.EXTRA_KEY_CREATE_ACCOUNT_USER, mEtUser.getText().toString());
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    Constants.showKeyboard(this);
                }
        }

    }

    public boolean isInputValid() {

        if (TextUtils.isEmpty(mEtUser.getText().toString().trim())) {
            mTilUser.setError("Field required");
            mEtUser.requestFocus();
            return false;
        } else if (mEtUser.getText().toString().trim().length() <= 2) {
            mTilUser.setError("Minlength : 3");
            mEtUser.requestFocus();
            return false;
        }

        if(!mEtRePassword.getText().toString().trim().equals(mEtPassword.getText().toString().trim())){
            mTilRePassword.setError("Password not matching");
            mEtRePassword.requestFocus();
            return false;
        }

        return true;
    }
}
