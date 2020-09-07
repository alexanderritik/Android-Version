package com.e.android_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

   // private FirebaseAuth Auth;
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // Auth=FirebaseAuth.getInstance();

        username=findViewById(R.id.etusername);
        password=findViewById(R.id.etpassword);
        String user= username.getText().toString();
        String pass=password.getText().toString();

        if(user == "mayank" && pass=="mayank") {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
        }


    }
}