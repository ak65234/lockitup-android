package com.example.cj.lockscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText nameView = (EditText) findViewById(R.id.signup_input_name);
        EditText emailView = (EditText) findViewById(R.id.signup_input_email);
        EditText passwordView = (EditText) findViewById(R.id.signup_input_password);
        final EditText lockCodeView = (EditText) findViewById(R.id.signup_input_code);
        final CheckBox ownerCheckBoxView = (CheckBox) findViewById(R.id.owner_check_box);
        Button signUpView = (Button) findViewById(R.id.btn_signup);

        lockCodeView.setVisibility(View.INVISIBLE);
        ownerCheckBoxView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ownerCheckBoxView.isChecked())
                    lockCodeView.setVisibility(View.VISIBLE);
                else
                    lockCodeView.setVisibility(View.INVISIBLE);
            }
        });

    }
}
