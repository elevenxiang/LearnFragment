package com.htc.eleven.learnfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        TextView tv = (TextView) findViewById(R.id.showArgs);

        Intent intent = getIntent();
        if(intent.getStringExtra("data") != null) {
            System.out.println(" here we got string args");
            tv.setText(intent.getStringExtra("data"));
        } else {
            System.out.println(" here we got Bundle args !");
            Bundle bundle = intent.getExtras();

            tv.setText(String.format("we got name = %s, age = %d !", bundle.getString("name"), bundle.getInt("age")));

        }
    }
}
