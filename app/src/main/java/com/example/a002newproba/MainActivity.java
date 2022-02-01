package com.example.a002newproba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,ListMessegesFragment.newInstance())
                .commit();

        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_right,ReadMessegeFragment.newInstance(new Messege(0,"test")))
                    .commit();
        }
        }
}