package com.rtx14.ticketbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GetStarted extends AppCompatActivity {
    Button keLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        keLogin = findViewById(R.id.buttonGetStarted);

        mAuth = FirebaseAuth.getInstance();

        keLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent keLogin = new Intent(GetStarted.this, Login.class);
                startActivity(keLogin);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(this, "Yeay, kamu sudah masuk sebagai: "+currentUser.getEmail()+".", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(GetStarted.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}