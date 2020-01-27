package com.nextnepal.nextNepalPatro.activitySignUp.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.MainActivity;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activitySignUp.contract.ActivitySignUpContract;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmailSignUpActivity extends AppCompatActivity implements ActivitySignUpContract.View {

    @BindView(R.id.saveEmail_button)
    Button saveEmail_v;

    @BindView(R.id.email_text)
    EditText email_v;

    @BindView(R.id.password_text)
    EditText password_v;

    @BindView(R.id.relative)
    RelativeLayout relativeLayout_v;

    @BindView(R.id.phone_input)
    EditText phone_v;

    private String firstName_V;
    private String lastName_V;
    private String userName_V;

    @Inject
    ActivitySignUpContract.Presenter presenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            firstName_V = bundle.getString("firstName");
            lastName_V = bundle.getString("lastName");
            userName_V = bundle.getString("userName");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @OnClick(R.id.saveEmail_button)
    void saveEmail() {
        if (password_v.getText().toString().isEmpty()) {
            password_v.setError(CONST.FIELD_NULL_ERROR);
        }
        if (email_v.getText().toString().isEmpty()) {
            email_v.setError(CONST.FIELD_NULL_ERROR);
            email_v.requestFocus();
            return;
        }
        if (!isValidEmail(email_v.getText().toString())) {
            email_v.setError(CONST.FIELD_NULL_ERROR);
            email_v.requestFocus();
            return;
        }
        if (password_v.getText().toString().isEmpty()) {
            password_v.setError(CONST.FIELD_NULL_ERROR);
            password_v.requestFocus();
            return;
        }
        Toast.makeText(getApplicationContext(), "" + email_v.getText().toString(), Toast.LENGTH_LONG).show();
        presenter.saveUsers(firstName_V, lastName_V, userName_V, email_v.getText().toString(), phone_v.getText().toString(), password_v.getText().toString(), password_v.getText().toString());
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public void validate() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void transferActivity() {
        startActivity(new Intent(EmailSignUpActivity.this, MainActivity.class));
    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(EmailSignUpActivity.this);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onError(String message) {
    }

    @Override
    public void onSucess() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }


}
