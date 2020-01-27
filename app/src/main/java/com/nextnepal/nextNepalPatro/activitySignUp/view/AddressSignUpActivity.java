package com.nextnepal.nextNepalPatro.activitySignUp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.nextnepal.nextNepalPatro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressSignUpActivity extends AppCompatActivity {

    @BindView(R.id.saveOrganization_button)
    Button saveOrganization_v;

    @BindView(R.id.designation_text)
    EditText designation_v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.saveOrganization_button)
    void saveOrganization() {
        if (designation_v.getText().toString().isEmpty()) {
            designation_v.setError("Designation or Hobby Required");
            designation_v.requestFocus();
            return;
        }
        startActivity(new Intent(AddressSignUpActivity.this, EmailSignUpActivity.class));
    }
}
