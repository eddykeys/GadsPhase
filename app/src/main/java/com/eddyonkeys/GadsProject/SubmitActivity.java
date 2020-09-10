package com.eddyonkeys.GadsProject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SubmitActivity extends AppCompatActivity {

    private static final String TAG = "Submit Post";
    Button submitBtn, back;
    EditText firstName, lastName, email, gitH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        back = (Button) findViewById(R.id.backBtn);
        submitBtn=(Button) findViewById(R.id.submitBtn);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.Email);
        gitH = (EditText) findViewById(R.id.gitHub);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: attempting to Submit Task");
                if (!isEmpty(firstName.getText().toString())
                        && !isEmpty(lastName.getText().toString())
                        && !isEmpty(email.getText().toString())
                        && !isEmpty(gitH.getText().toString())){


                }
            }
        });

    }
    private Boolean isEmpty(String string) {
        return string.equals("");
    }
}