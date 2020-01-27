package com.nextnepal.nextNepalPatro.introActivity.view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.nextnepal.nextNepalPatro.MainActivity;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.introActivity.view.fragments.FifthScreen;
import com.nextnepal.nextNepalPatro.introActivity.view.fragments.FirstScreen;
import com.nextnepal.nextNepalPatro.introActivity.view.fragments.FourthScreen;
import com.nextnepal.nextNepalPatro.introActivity.view.fragments.SecondScreen;
import com.nextnepal.nextNepalPatro.introActivity.view.fragments.ThirdScreen;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new FirstScreen());
        addSlide(new SecondScreen());
        addSlide(new ThirdScreen());
        addSlide(new FourthScreen());
        addSlide(new FifthScreen());
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(IntroActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setFadeAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        Toast.makeText(getApplicationContext(), "Please go through the tour", Toast.LENGTH_LONG).show();
    }
}
