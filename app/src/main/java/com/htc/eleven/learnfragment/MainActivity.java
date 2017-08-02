package com.htc.eleven.learnfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.main_context, new MainFragment()).commit();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_context, new MainFragment())
                    .commit();
        }
    }
}
