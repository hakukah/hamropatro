package com.nextnepal.nextNepalPatro.activityLogin.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nextnepal.nextNepalPatro.MainActivity;
import com.nextnepal.nextNepalPatro.activityCardSharing.CardSharingActivity;
import com.nextnepal.nextNepalPatro.activityLogin.contract.LoginActivityContract;
import com.nextnepal.nextNepalPatro.activityLogin.presenter.LoginActivityPresenter;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activitySignUp.view.BasicSignUpActivity;
import com.nextnepal.nextNepalPatro.activitySignUp.view.SignUpLauncher;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.View {

    @BindView(R.id.login_button)
    Button loginButton_v;

    @BindView(R.id.signup_button)
    Button signUpButton_v;

    @BindView(R.id.username_editext)
    EditText username_v;

    @BindView(R.id.password_editext)
    EditText password_v;

    private LoginActivityPresenter loginActivityPresenter_ic;


    private FirebaseAuth mAuth;
//
//    @BindView(R.id.google_button)
//    SignInButton googleSignInButton;

//    private static final String TAG = "AndroidClarified";
//
//    private GoogleSignInClient googleSignInClient;


    @Inject
    LoginActivityContract.Presenter presenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        ButterKnife.bind(this);
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        googleSignInClient = GoogleSignIn.getClient(this, gso);
//
//        googleSignInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent signInIntent = googleSignInClient.getSignInIntent();
//                startActivityForResult(signInIntent, 101);
//            }
//        });

        signUpButton_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, BasicSignUpActivity.class));
            }
        });
    }

    @OnClick(R.id.login_button)
    void onLoginButtonClicked() {
        if (username_v.getText().toString().isEmpty()) {
            username_v.setError(CONST.FIELD_NULL_ERROR);
            username_v.requestFocus();
        } else if (password_v.getText().toString().isEmpty()) {
            password_v.setError(CONST.FIELD_NULL_ERROR);
            password_v.requestFocus();
        } else {
            presenter.login(username_v.getText().toString(), password_v.getText().toString());
        }
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK)
//            switch (requestCode) {
//                case 101:
//                    try {
//                        // The Task returned from this call is always completed, no need to attach
//                        // a listener.
//                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//                        GoogleSignInAccount account = task.getResult(ApiException.class);
//                        //   Toast.makeText(getApplicationContext(), "" + account, Toast.LENGTH_LONG).show();
//                        //onLoggedIn(account);
//                    } catch (ApiException e) {
//                        // The ApiException status code indicates the detailed failure reason.
//                        Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//                    }
//                    break;
//            }
//    }


    public void onLogin() {
        mAuth.createUserWithEmailAndPassword("criraioo7@gmail.com", "User123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Succed", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


    @Override
    protected void onStart() {
        super.onStart();
        //   FirebaseUser firebaseUser=mAuth.getCurrentUser();

    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void transferActivity() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(this);
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
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }

    @Override
    public void onSucess() {
        transferActivity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
