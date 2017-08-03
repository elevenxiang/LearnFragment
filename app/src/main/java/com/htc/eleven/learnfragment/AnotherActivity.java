package com.htc.eleven.learnfragment;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private Button back;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);


        TextView tv = (TextView) findViewById(R.id.showArgs);

        Intent intent = getIntent();
        if(intent.getStringExtra("data") != null) {
            System.out.println(" here we got string args");
            tv.setText(intent.getStringExtra("data"));
//        } else if ((Bundle)intent.getExtras() != null){
//
//            Bundle bundle = intent.getExtras();
//            System.out.println(" here we got Bundle args !" + bundle.getString("name"));
//
//            tv.setText(String.format("we got name = %s, age = %d !", bundle.getString("name"), bundle.getInt("age")));

        } else {
            UserData data = (UserData) intent.getParcelableExtra("bundle_data");
            if (data != null) {
                System.out.println(" here we got Parcelable data !");
                tv.setText(String.format("we got user (name = %s, sex = %s, age = %d)", data.getName(), data.getSex(), data.getAge()));
            }
        }


        editText = (EditText) findViewById(R.id.editText);

        back = (Button) findViewById(R.id.btnSendBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("back_data", editText.getText().toString());

                setResult(0,i);
                finish();
            }
        });
    }
}
