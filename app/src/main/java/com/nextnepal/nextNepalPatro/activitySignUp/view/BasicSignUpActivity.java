package com.nextnepal.nextNepalPatro.activitySignUp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasicSignUpActivity extends AppCompatActivity {

    @BindView(R.id.firstname_text)
    EditText firstname_v;

    @BindView(R.id.lastname_text)
    EditText lastname_v;

    @BindView(R.id.savebasic_button)
    Button saveBasic;

    @BindView(R.id.username_text)
    EditText username_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.savebasic_button)
    void saveBasic() {
        if (firstname_v.getText().toString().isEmpty()) {
            firstname_v.setError(CONST.FIELD_NULL_ERROR);
            firstname_v.requestFocus();
            return;
        }
        if (lastname_v.getText().toString().isEmpty()) {
            lastname_v.setError(CONST.FIELD_NULL_ERROR);
            lastname_v.requestFocus();
            return;
        }
        if (username_v.getText().toString().isEmpty()) {
            username_v.setError(CONST.FIELD_NULL_ERROR);
            username_v.requestFocus();
            return;
        }
        Intent intent = new Intent(BasicSignUpActivity.this, EmailSignUpActivity.class);
        intent.putExtra("firstName", firstname_v.getText().toString());
        intent.putExtra("lastName", lastname_v.getText().toString());
        intent.putExtra("userName", username_v.getText().toString());
        startActivity(intent);
    }
}
