package com.e.android_version;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth Auth;
    private EditText username;
    private EditText password;
    private Button login;
    private TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       Auth=FirebaseAuth.getInstance();

        username=findViewById(R.id.etusername);
        password=findViewById(R.id.etpassword);
        login=findViewById(R.id.btnlogin);
        signup=findViewById(R.id.donthaveanaccount);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
               Authenticate(user,pass);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
            }
        });
    }

    void Authenticate(String user,String pass)
    {

        Auth.signInWithEmailAndPassword(user,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {

                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();

                        }else{
                            Log.i( "signInWithEmail:failure", task.getException()+"");
                        }
                    }
                });

    }
}