package com.rtx14.ticketbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    Button keRegister, btnLogin;
    EditText ed_email1, ed_password1;
    final String TAG = "Login";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        keRegister = findViewById(R.id.btnRegister_1);
        btnLogin = findViewById(R.id.btnLogin);
        ed_email1 = findViewById(R.id.edEmailLogin);
        ed_password1 = findViewById(R.id.edPasswordLogin);

        mAuth = FirebaseAuth.getInstance();

        keRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_email1.getText().toString().isEmpty() || ed_password1.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "Email dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }else {
                    signIn(ed_email1.getText().toString(), ed_password1.getText().toString());
                }
            }
        });
    }

    private void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success.
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(Login.this, "Yeay, berhasil masuk sebagai: "+user.getEmail()+".", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(Login.this, "Yah gagal, coba lagi yuk.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            Toast.makeText(this, "Yeay, kamu sudah masuk sebagai: "+currentUser.getEmail()+".", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }
    }
}