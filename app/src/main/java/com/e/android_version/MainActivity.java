package com.e.android_version;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        login=findViewById(R.id.tvLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mAuth.getCurrentUser()!=null)
                {
                    Toast.makeText(MainActivity.this, "Already logged in", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}