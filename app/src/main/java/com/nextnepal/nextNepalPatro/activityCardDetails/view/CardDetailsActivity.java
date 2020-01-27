package com.nextnepal.nextNepalPatro.activityCardDetails.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.MainActivity;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityCardDetails.contract.UserInfoContract;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.dto.UserInfoEntity;
import com.nextnepal.nextNepalPatro.activitySignUp.view.EmailSignUpActivity;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CardDetailsActivity extends AppCompatActivity implements UserInfoContract.View {

    @BindView(R.id.Organization)
    EditText organization_v;

    @BindView(R.id.Designation)
    EditText designation_v;

    @BindView(R.id.facebookurl)
    EditText facebookUrl_v;

    @BindView(R.id.linkdenUrl)
    EditText linkdenUrl_v;

    @BindView(R.id.twitterUrl)
    EditText twitterUrl_v;

    @BindView(R.id.save)
    Button saveButton;


    @BindView(R.id.linearlayout)
    LinearLayout linearLayout;

    @Inject
    UserInfoContract.Presenter presenter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
    }

    @OnClick(R.id.save)
    void onSaveClicked() {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setCompany(organization_v.getText().toString());
        userInfoEntity.setDesignation(designation_v.getText().toString());
        userInfoEntity.setFacebook(facebookUrl_v.getText().toString());
        userInfoEntity.setLinkedin(linkdenUrl_v.getText().toString());
        userInfoEntity.setTwitter(twitterUrl_v.getText().toString());
        presenter.addDetails(userInfoEntity);
    }


    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(CardDetailsActivity.this);
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

    @Override
    public void transferActivity() {
        startActivity(new Intent(CardDetailsActivity.this, MainActivity.class));
    }
}
