package com.nextnepal.nextNepalPatro.activitySignUp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.nextnepal.nextNepalPatro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpLauncher extends AppCompatActivity {

    @BindView(R.id.button_start)
    Button Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_launcher);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_start)
    void startSignUp() {
        startActivity(new Intent(SignUpLauncher.this, BasicSignUpActivity.class));
    }
}
